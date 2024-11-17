## SOL∀R
# SwanHacks2024

Space is huge. Textbooks fail to show the sheer extent of our solar system's size, being constrained to tiny pages. SOL∀R helps give perspective in a unique and interactive way - using VR simulation.

-------------------------------------------------------------------------------------------------------------------------------

## Inspiration

Computer graphics simulations have always interested our group. One time, one of our members tried creating a full-scale model of the solar system in Unity. Quickly being met with render errors and floating-point precision issues - this was their 'aha!' moment. This sparked the realization of just how sheerly massive our world and beyond truly is, and a desire to spread this often-overlooked fact of life.

## What it does

SOL∀R is an app that aims to be a practical application of VR in education. The app consists of three scenes: a menu scene, and two activities for the user to complete. Within the two activities, the user will go through a simulated environment where they will try to approximate the size of every planet in the solar system in a hypothetical case where the Sun is shrunk down to 10m in diameter, followed by a scenario where the user must estimate the distance of each planet to the sun given it has been shrunken down even further to a minuscule 1 cm in diameter. Percent errors are reported for each, and algorithms are run to display the discrepancies in an intuitive way. For scale, the algorithm put the correctly sized planets above each of the user's guesses, while for distance an algorithm places the correct distance along the exact same unit vector direction as the guess in order to accurately show how far off their guesses were.

The web client aims to provide teachers with a platform to compare and review their student's results within the app. Allowing teachers to create classrooms using their students' usernames and being able to review their students' stats and progress as they try to get more and more accurate results. 

## How we built it

The application was made using the Unity game engine. MRTK3 (Mixed Reality Toolkit 3) was employed to rapidly implement hand tracking/input, object manipulation, and user interfaces, while staying lightweight and optimized, something very crucial for a mobile platform with limited computing power.

The web client was built using SpringBoot with the front-end HTML implementing ThymeLeaf to more seamlessly keep track of data within the client. 


## Challenges we ran into

Figuring out communication and data parsing between the Unity app and the web client was a challenge that took a sizable amount of time to figure out. Unity is very specific in how it serializes JSON, which resulted in a lot of time spent trying to get the web client to read data from Unity either correctly or at all.
We were also unable to implement that backend to it's full potential using an external SQL server. We attempted to using Oracle Cloud but ran into issues where we were not able to remotely query the SQL database even with opening ports on the virtual network and opening firewall rules on our Ubuntu server. We also attempted using a Debian Virtual Box server to host the database but opted to focus more on the functionality of the rest of the code rather than spend time debugging and figuring out why we weren't able to remotely access the database.

## Accomplishments that we're proud of

Thanks to setting time aside at the start of the project to outline how we're going to properly set up our JSON, posts and get requests gave us a good framework and understanding of how we should be building our code base (on the web client side and the VR app side) and allowed us to have a much smoother integration at the end. Having everyone's parts of the project that were mostly independent eventually mesh together to make a single cohesive work was something that had everyone feeling really excited and motivated us to see the project through to completion. 

## What we learned

It was very important to maintain solid communication between group members for this project to be successful. From the conceptualization stage, where everyone decides what tasks they will carry out to 
the small changes to the codebase that can potentially lead to hours of saved time debugging when a configuration setting isn't as expected.

## What's next for SOL∀R

Increasing the number of activities in the app would only add to the experience. Additionally, figuring out more uses for the data stored within the web client, perhaps even sending the data back to the app to log within Unity. 

We also want to expand our web client to support more features, such as grading students and leaderboards for accuracy within the VR app.