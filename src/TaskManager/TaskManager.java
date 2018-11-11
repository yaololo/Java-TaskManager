package taskManager;
import taskManager.exceptions.InvalidInputException;
import taskManager.parser.Parser;
import taskManager.taskList.TaskList;
import taskManager.ui.Ui;
import taskManager.fileManager.FileManager;

import java.io.IOException;

public class TaskManager {

    private FileManager fileManager;
    private TaskList tasks;
    private Ui ui;

    public TaskManager(String filePath){
        ui = new Ui();
        fileManager = new FileManager(filePath);
        tasks = new TaskList();
    }

    public void run() {
        ui.printWelcome();
        try {
            fileManager.loadFile(tasks);
            boolean isExit = false;

            while (!isExit) {
                try {
                    ui.printNumberOfTasks(tasks.getTotalNumberOfTask(), tasks.getTotalNumberOfReminderTasks());

                    String userInputCommand = ui.readUserCommand();
                    String commandKeyWord = new Parser().getCommandWord(userInputCommand);

                    switch (commandKeyWord) {
                        case "exit":
                        case "":
                            isExit = true;
                            break;
                        case "command-help":
                            ui.printCommands();
                            break;
                        case "date":
//                        new InputEvaluator().deadlineDateEvluation(userInputCommand);
                            break;
                        case "todo":
                            tasks.addTodo(userInputCommand);
                            break;
                        case "deadline":
                            tasks.addDeadline(userInputCommand);
                            break;
                        case "print":
                            ui.printALlTasks(tasks.getTaskList());
                            break;
                        case "done":
                            tasks.markAsDone(userInputCommand);
                            break;
                        default:
                            ui.printError("Unknown command! please try again ");
                            break;
                    }
                } catch (InvalidInputException e) {
                    ui.printError(e.getMessage());
                }
              }
            fileManager.saveToFile(tasks);

        } catch (IOException e) {
            ui.printError(e.getMessage());
        }
        ui.exit();
    }
}
