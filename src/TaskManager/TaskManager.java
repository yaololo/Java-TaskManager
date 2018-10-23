package TaskManager;import TaskManager.Parser.Parser;import TaskManager.TaskList.TaskList;import TaskManager.TaskList.TaskManagerException;import TaskManager.Ui.Ui;import TaskManager.FileManager.FileManager;public class TaskManager {    private FileManager fileManager;    private TaskList tasks;    private Ui ui;    public TaskManager(String filePath){        ui = new Ui();        fileManager = new FileManager(filePath);        tasks = new TaskList();    }    public void run() {        ui.printWelcome();        fileManager.loadFile(tasks);//        ui.printMessage("Start loading tasks.");        boolean isExit = false;        while (!isExit) {            ui.printNumberOfTasks(tasks.getTotalNumberOfTask());            String userInputCommand = ui.readUserCommand();            String commandKeyWord = new Parser().getCommandWord(userInputCommand);            try {                switch (commandKeyWord) {                    case "exit":                    case "":                        isExit = true;                        break;                    case "todo":                        tasks.addTodo(userInputCommand);                        break;                    case "deadline":                        tasks.addDeadline(userInputCommand);                        break;                    case "print":                        ui.printTasks(tasks.getTaskList());                        break;                    case "done":                        tasks.markAsDone(userInputCommand);                        break;                    default:                        ui.printError("Unknown command! please try again ");                        break;                }            } catch (TaskManagerException e) {                System.out.println(e.getMessage());            }        }        fileManager.saveToFile(tasks);        ui.exit();    }}