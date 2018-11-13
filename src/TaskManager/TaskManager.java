package taskManager;
import taskManager.exceptions.InvalidInputException;
import taskManager.inputEvaluator.InputValidator;
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
                    String commandKeyWord = Parser.getCommandWord(userInputCommand);

                    switch (commandKeyWord) {
                        case "exit":
                            isExit = true;
                            break;
                        case "command-help":
                            ui.printCommands();
                            break;
                        case "todo":
                            tasks.addTodo(userInputCommand);
                            break;
                        case "deadline":
                            tasks.addDeadline(userInputCommand, null, false);
                            break;
                        case "date":
                            tasks.updateDeadlineTime(userInputCommand);
                            break;
                        case "print-reminder":
                            ui.printReminderTasks(tasks.getReminderList());
                            break;
                        case "print":
                            InputValidator.validatePrintCommand(userInputCommand);
                            String instruction = Parser.getPrintInstruction(userInputCommand);
                            ui.printALlTasks(tasks.getTaskList(), instruction);
                            break;
                        case "done":
                            tasks.markAsDone(userInputCommand);
                            break;
                        case "description":
                            tasks.updateTaskDescription(userInputCommand);
                            break;
                        case "reminder":
                            tasks.updateReminderTime(userInputCommand);
                            break;
                        case "delete":
                            tasks.deleteTask(userInputCommand);
                            break;
                        case "clear":
                            tasks.deleteAllTasks(userInputCommand);
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

        } catch (InvalidInputException | IOException e) {
            ui.printError(e.getMessage());
        }
        ui.exit();
    }
}
