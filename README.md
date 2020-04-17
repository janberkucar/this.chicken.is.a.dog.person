# FlyingChickenGame-JavaCourseAssign

<a href="https://imgbb.com/"><img src="https://i.ibb.co/xGrhvdb/asdasdadasda.png" alt="asdasdadasda" border="0"></a>

# INTRODUCTION
This is the game that we assigned to do in 21.05.2019 and due date is 28.05.2019.
Our scenario was like this: This is a simple 2-D game will be played by keyboard. A chicken will fall vertically while trying to avoid cats randomly waiting on its path with an open mouth. During this journey, the chicken aimsto hittargets appearing left and right sides of its path randomly by using itsgoldeneggs. The eggswill be launched byits mouth. Once a target is hit, the player will get points according to the size of the target.

# Design
We decided right of the start that the game itself doesn’t have to move. The chicken will be played on 2 parts on the screen top and bottom and the basket would be the target. Eggs would be the shooting parts and enemies are cats. 

# Creating the Environment
My coding process happened in VSCode. Which I really like to use but there were no easy way to figure out IDE part of the application. VSCode is basically a normal text editor but I had to find out the extensions to work on JDK and Java Environments. I’ve heavily used the comments and attributes on Java itself to make my code more readable. Also I studied Clean Code and Design Patterns just before I began to these projects, and that helped.use github efficiently yet.

# GAMEPLAY
```sh
  WASD and Arrow keys to move.
  
  Like Flappy Bird, gravity activates the move itself.
  
  Through Level 1-3 there’s only 1 enemy cat type.
  
  After the levels go through; cat enemy 2 and 3 spawn. 
  
  Difference between enemy 2 and 3 is only the speed as well as normal enemy cat.
  
  Space key shoots egg and when egg get collision with basket.
  
  Level goes up when score reaches the volumes of 200
  
  Health consist 120 and every collision takes away 5 health.
  
  When health reaches 0, in the end game screen you can either choose play again or exit the game.

```
