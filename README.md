# User Guide
TaskManager is a program that helps user to manage and keep track of the tasks that he needs to do. It is a console application. User will not see any graphical interface; all activities is done through terminal with appropriate commands.

It allows user to input task and print out the input tasks. User input data will be saved to local hard drive. Tasks are classified into two categories which are Todo and Deadline. Todo is normal todo task which is not urgent and does not require a deadline. On the other hand, Deadline type of task tends to be more urgent and important as it requires a specific deadline to complete the task.

## Starting the program

#### Open the project with InteliJ
  1. Find the project in the Project Explorer (usually located at the left side).
      - If the Project Explorer is not visible, press ALT+1 for Windows/Linux, CMD+1 for macOS to open the Project Explorer tab.
  2. Expend `src` folder and locate the `Main.java` file
  3. Right click on the file and select `Run Main.main()`
  4. The program should run and the `console terminal` should appear and it is usually on located at the bottom potion of InteliJ
  5. If the program runs successfully, you should see a welcome message `Welcome to taskManager!` and followed by a message of number of task you have. E.g. `Number of task you have is 9, please enter your command: `. This indicates that the program has running normally.
  6. Now, you can type the command to interact with the program

## Commands/Functionalities
#### Helper command: _`command-help`_
Type `command-help` to show all available commands and functionality description for each command

#### Printing statement: _`print`_
It start with keyword `print` command in the terminal to allow user to filter which kind of tasks he/she would like to view.

##### _`print all`_
_`print all`_ will print all tasks.

##### _`print todo`_
_`print todo`_ will only print out todo type of tasks.

##### _`print deadline`_
_`print deadline`_ will only print out deadline type of tasks.

##### _`print done`_
_`print done`_ will only print out the tasks that has been done.

##### _`print incomplete`_
_`print incomplete`_ will only print out tasks that are not done yet.

##### _`print-reminder`_
_`print-reminder`_ will only print out tasks that are going to overdue soon.

#### Add new tasks: _`todo`_ or _`deadline`_
TaskManager is able to keep track two type of tasks(`todo` and `deadline`).

`todo` type of task is a normal task that does not require a deadline. Command to create a `todo` task starts a keyword `todo` followed by a `description`. E.g  `todo attend an online course`, this will generate a `attend an online course` todo task.

`deadline` type of task is more important as it require a specific deadline to the tasks which reminds the user that he/she has to finish the task by due date. Command to create a `deadline` tasks starts with a keyword `deadline` and followed by description with a `/` to indicate the deadline date. E.g `deadline buy milk / 2018-10-20`

#### Mark the task as done: _`done`_
TaskManager will also track the status of the task, user can use `done` keyword to mark the task as done.
E.g `done / 4` is to mask task number 4 in the list as done.

#### Update task description: _`description`_
TaskManager allows user to update each individual task description, keyword _`description`_ is used.
E.g `description random description / 4` it update task `Number 4` description to `random description`

#### Update Deadline task deadline: _`date`_
TaskManager allows user to update Deadline type of tasks deadline, keyword _`date`_ is used.
E.g `date 2018-13-05 15:30:00 / 4` it update task `Number 4` deadline to `2018-13-05 15:30:00`

#### Update Deadline task deadline: _`reminder`_
TaskManager allows user to update reminder time of Deadline type of tasks, keyword _`reminder`_ is used.
E.g `reminder 40 / 4` it update task `Number 4` reminder time to `40 mins`. It will reminds the user 40 mins prior to the deadline

#### Delete specific task: _`delete`_
TaskManager allows user to delete a specific tasks, keyword _`delete`_ is used.
E.g `delete / 4` it will delete task `Number 4`

#### Delete all tasks: _`clear`_
TaskManager allows user to delete all tasks, keyword _`clear`_ is used.
E.g `clear` it will delete all tasks

#### Exiting the program : _`exit`_
Enter `exit` command will quit the program and a `Bye Bye` message will be shown to user to indicate the program has stopped.

#### Saving the data
All user input tasks will be saved in a text file on local disk automatically after the user quite the program. Next time when user run the program again, it will load the file to retrieve all the tasks.

## Latest Update
- _`Assertion`_ is used in Parser, Deadline, FileManager classes to kill the program when unexpected scenario happens.
- jUnit is added in the project to. Unit tests is created in the project under test folder. User can right click on it and run all test to check the test result.
- Jar file is created under out/artifacts/TaskManager_jar

