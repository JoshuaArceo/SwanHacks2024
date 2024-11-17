package com.swanhack.swan.controllers;

import com.swanhack.swan.unitydata.Unitydata;
import com.swanhack.swan.unitydata.UnitydataRepository;
import com.swanhack.swan.users.Classroom;
import com.swanhack.swan.users.ClassroomRepository;
import com.swanhack.swan.users.User;
import com.swanhack.swan.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private UnitydataRepository unitydataRepository;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @GetMapping("/login")
    public String showLogInForm(Model model) {
        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping("/registerNew")
    public String register(User user) {
        if(userRepo.findByUsername(user.getUsername()) != null) {
            return "redirect:register?error=User+already+exists";
        }
        user.setUserType(User.UserType.TEACHER);
        userRepo.save(user);
        return "redirect:manageclasses?username=" + user.getUsername();
    }

    @PostMapping("/loginCheck")
    public String loginCheck(String username, String password){
        User user = userRepo.findByUsername(username);
        if(user == null || !user.getPassword().equals(password)){
            return "redirect:login?error=Invalid+username+or+password";
        }
        return "redirect:manageclasses?username=" + username;
    }

    @GetMapping("/teacher")
    public String teacherPage(String username, Model model){
//        model.addAttribute("classes", classroomRepository.findAllByUsername(username));
        return "teacher";
    }

    @GetMapping("/manageclasses")
    public String manageClasses(String username, Model model){
        model.addAttribute("username", username);
        model.addAttribute("classes", classroomRepository.findByMembersContaining(userRepo.findByUsername(username)));
        return "manageclasses";
    }

    @PostMapping("/createUser")
    public User createUser(String username) {
        User user = new User();
        user.setUsername(username);
        userRepo.save(user);
        return user;
    }

    @PostMapping("/addUser")
    public String addUserToClassroom(String userToAdd, int classId, String username) {
        User user = userRepo.findByUsername(userToAdd);
        Classroom classroom = classroomRepository.findById(classId);
        if (classroom != null) {
            if(user == null) {
                user = createUser(
                        userToAdd
                );
            }
            classroom.addMember(user);
            classroomRepository.save(classroom);
        }
        return "redirect:/manageclasses?username=" + username;
    }

    @PostMapping("/createClass")
    public String createClassroom(String classname, String username) {
        User user = userRepo.findByUsername(username);
        Classroom classroom = new Classroom();
        classroom.addMember(user);
        classroom.setName(classname);
        classroomRepository.save(classroom);
        return "redirect:manageclasses?username=" + username;
    }

    @PostMapping("/deleteClassroom")
    public String deleteClassroom(int classId, String username) {
        classroomRepository.deleteById(classId);
        return "redirect:/manageclasses?username=" + username;
    }

    @PostMapping("/deleteUser")
    public String deleteUserFromClassroom(String usernameToDelete, int classId, String username) {
        User userToDelete = userRepo.findByUsername(usernameToDelete);
        Classroom classroom = classroomRepository.findById(classId);

        if (userToDelete != null && classroom != null) {
            classroom.removeMember(userToDelete);
            classroomRepository.save(classroom);
        }

        return "redirect:/manageclasses?username=" + username;
    }

    @GetMapping("/viewuserstats")
    public String userStats(String username, String userstat, Model model) {
        List<Unitydata> userStats = unitydataRepository.findAllByUser(userRepo.findByUsername(username));
        model.addAttribute("userStats", userStats);
        model.addAttribute("username", username);
        model.addAttribute("userToInspect", userstat);
        return "userstats";
    }



//    @PostMapping("/classrooms")
//    public String updateSelectedClassroom(int classroomId, Model model) {
//        Classroom classroom = classroomRepository.findById(classroomId);
//        List<User> students = userRepo.findAllByClassroom(classroom);
//        model.addAttribute("selectedClassroomStudents", students);
//        return "classroomTemplate";
//    }



}