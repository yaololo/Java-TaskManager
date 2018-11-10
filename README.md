# User Guide
TaskManager is a program that helps user to manage and keep track of the tasks that he needs to do. It is a console application. User will not see any graphical interface, all activities is done through terminal with appropriate commands.

## Starting the program

#### Open the project with InteliJ
  1. Find the project in the Project Explorer (usually located at the left side).
      - If the Project Explorer is not visible, press ALT+1 for Windows/Linux, CMD+1 for macOS to open the Project Explorer tab.
  2. Expend `src` folder and locate the `Main.java` file
  3. Right click on the file and select `Run Main.main()`
  4. The program should run and the `console terminal` should appear and it is usually on located at the bottom potion of InteliJ
  5. If the program runs successfully, you should see a welcome message `Welcome to taskManager!` and followed by a message of number of task you have. E.g. `Number of task you have is 9, please enter your command: `
  6. Now, you can type the command to interact with the program
---

## Commands/Functionalities
#### Helper command: `command-help`
Type `command-help` to show all available commands and functionality description for each command

<br>

#### View all tasks: `print`
type `print` command in the terminal to show all tasks you have currently.

<br>

#### Add new tasks: `todo` or `deadline`
TaksManager is able to keep track two type of tasks(`todo` and `deadline`).

`todo` type of taks is a normal task that does not require a deadline. Command to create a `todo` task starts a keyword `todo` followed by a `description`. E.g  `todo attend an online course`, this will generate a `attend an online course` todo task.

`deadline` type of taks is more important as it require a specifc deadline to the tasks which reminds the user that he/she has to finish the task by due date. Command to create a `deadline` tasks starts with a keyword `deadline` and followed by description with a `/` to indicate the deadline date. E.g `deadline buy milk / 2018-10-20`

<br>

#### Mark the taks as done: `done`
TaskManager will also track the status of the task, user can use `done` keyworkd to mark the task as done.
E.g `done 4` is to mask task number 4 in the list as done.

<br>


