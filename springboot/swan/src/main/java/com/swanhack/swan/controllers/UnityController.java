package com.swanhack.swan.controllers;

import com.swanhack.swan.unitydata.PlanetValues;
import com.swanhack.swan.unitydata.Unitydata;
import com.swanhack.swan.unitydata.UnitydataRepository;
import com.swanhack.swan.users.User;
import com.swanhack.swan.users.UserRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
public class UnityController {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UnitydataRepository unitydataRepository;

	@PostMapping("/Unity/Data")
	public ResponseEntity<String> createData(@RequestBody String data) throws NoSuchAlgorithmException {
		JSONParser parser = new JSONParser(data);

		LinkedHashMap<Object, Object> dataJson;

		try{
			dataJson = (LinkedHashMap<Object, Object>) parser.parse();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Invalid JSON");
		}

		String username = (String) dataJson.get("username");

		if (Objects.isNull(username)) {
			return ResponseEntity.badRequest().body("Invalid JSON");
		}

		Integer attempt = (Integer) dataJson.get("attempt");

		Character grade = ((String) dataJson.get("grade")).charAt(0);

		Unitydata.ActivityType activityType = Unitydata.ActivityType.valueOf((String) dataJson.get("activityType"));

		List<PlanetValues> planetValues = (List<PlanetValues>) dataJson.get("planetValues");

		User user = userRepo.findByUsername(username);

		Unitydata unitydata = new Unitydata(user, attempt, grade, activityType, planetValues);

		unitydataRepository.save(unitydata);

		return new ResponseEntity<>("Data saved", HttpStatus.CREATED);

	}

	@PostMapping("/Unity/Data1")
	public ResponseEntity<String> createUnityData1(@RequestBody String requestBody) {
		try {
			// Parse the JSON request
			JSONParser parse = new JSONParser(requestBody);

			LinkedHashMap<Object, Object> dataJSON = (LinkedHashMap<Object, Object>) parse.parse();
			System.out.println(dataJSON.toString());
			// Extract username and validate
			String username = (String) dataJSON.get("username");
			if (username == null) {
				return ResponseEntity.badRequest().body("Username is required");
			}

			// Fetch the user
			User user = userRepo.findByUsername(username);
			if (user == null) {
				return ResponseEntity.badRequest().body("User not found");
			}

			// Create a Unitydata instance and set fields
			Unitydata unitydata = new Unitydata();
			unitydata.setUser(user);
			unitydata.setGrade(dataJSON.get("grade").toString().charAt(0));
			unitydata.setActivityType(Unitydata.ActivityType.valueOf((String) dataJSON.get("activityType")));
			unitydata.setAttempt(1); // Set attempt to default (or fetch max if needed)

			// Parse the planetValues array
			List<?> planetValuesArray = (List<?>) dataJSON.get("planetValues");
			List<PlanetValues> planetValuesList = new ArrayList<>();

			for (Object obj : planetValuesArray) {
				Map<?, ?> planetValueJSON = (Map<?, ?>) obj;

				PlanetValues planetValue = new PlanetValues();
				planetValue.setPlanetName((String) planetValueJSON.get("planetName"));
				planetValue.setPercentError(Float.parseFloat(planetValueJSON.get("percentError").toString()));

				// Parse the vector as a string
				String vectorString = (String) planetValueJSON.get("vector");
				planetValue.setVector(vectorString); // Keep it as a single string

				planetValuesList.add(planetValue);
			}

			unitydata.setPlanetValues(planetValuesList);

			for(PlanetValues p : unitydata.getPlanetValues()){
				System.out.println(p.getPlanetName());
			}

			// Save the Unitydata entity
			unitydataRepository.save(unitydata);

			return new ResponseEntity<>("Data saved successfully", HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred while processing the request: " + e.getMessage());
		}
	}


}


