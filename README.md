# User Guide
TaskManager is a program that helps user to manage and keep track of the tasks that he needs to do. It is a console application. User will not see any graphical interface, all activities is done through terminal with appropriate commands.

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
`_print all_` will print all tasks.

##### _`print todo`_
`_print todo_` will only print out todo type of tasks.

##### _`print deadline`_
`_print deadline_` will only print out deadline type of tasks.

##### _`print done`_
`_print done_` will only print out the tasks that has been done.

##### `_print incomplete`_
`_print incomplete_` will only print out tasks that are not done yet.

##### _`print-reminder`_
`_print-reminder_` will only print out tasks that are going to overdue soon.

#### Add new tasks: _`todo`_ or _`deadline`_
TaskManager is able to keep track two type of tasks(`todo` and `deadline`).

`todo` type of task is a normal task that does not require a deadline. Command to create a `todo` task starts a keyword `todo` followed by a `description`. E.g  `todo attend an online course`, this will generate a `attend an online course` todo task.

`deadline` type of task is more important as it require a specific deadline to the tasks which reminds the user that he/she has to finish the task by due date. Command to create a `deadline` tasks starts with a keyword `deadline` and followed by description with a `/` to indicate the deadline date. E.g `deadline buy milk / 2018-10-20`

#### Mark the task as done: `_done_`
TaskManager will also track the status of the task, user can use `done` keyword to mark the task as done.
E.g `done / 4` is to mask task number 4 in the list as done.

#### Update task description: _`description`_
TaskManager allows user to update each individual task description, keyword `_description_` is used.
E.g `description random description / 4` it update task `Number 4` description to `random description`

#### Update Deadline task deadline: _`date`_
TaskManager allows user to update Deadline type of tasks deadline, keyword `_date_` is used.
E.g `date 2018-13-05 15:30:00 / 4` it update task `Number 4` deadline to `2018-13-05 15:30:00`

#### Update Deadline task deadline: _`reminder`_
TaskManager allows user to update reminder time of Deadline type of tasks, keyword `_reminder_` is used.
E.g `reminder 40 / 4` it update task `Number 4` reminder time to `40 mins`. It will reminds the user 40 mins prior to the deadline

#### Exiting the program : _`exit`_
Enter `exit` command will quit the program and a `Bye Bye` message will be shown to user to indicate the program has stopped.

#### Saving the data
All user input tasks will be saved in a text file on local disk automatically after the user quite the program. Next time when user run the program again, it will load the file to retrieve all the tasks.
