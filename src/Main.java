import utils.Message;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Scanner in = new Scanner(System.in);
    static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {

        new Message().printWelcome("Welcome to TaskManager!\n");
        FileOperation fileManipulation = new FileOperation("/Users/yongming/personal/school/java_se/TaskManager/src/data/tasks.txt");

        tasks = fileManipulation.loadedTasks();

        TaskHandler taskHandler = new TaskHandler(tasks);

        String line;
        boolean isExit = false;

        while (!isExit) {
            try {
                line = getInput();
                String command = line.split(" ")[0];
                switch (command) {
                    case "exit":
                    case "":
                        isExit = true;
                        break;
                    case "todo":
                        taskHandler.addTodo(line);
                        break;
                    case "deadline":
                        taskHandler.addDeadline(line);
                        break;
                    case "print":
                        taskHandler.printTasks();
                        break;
                    case "done":
                        taskHandler. markAsDone(line);
                        break;
                    default:
                        new Message().printError("Unknown command! please try again ");
                        break;
                }
            } catch (TaskManagerException e) {
                System.out.println(e.getMessage());
            }
        }

        fileManipulation.updateFile(tasks);

        new Message().exit("Bye Bye!!");
    }

    private static String getInput(){
        System.out.printf("Number of task you have is %d, please enter your task: \n", tasks.size());
        return in.nextLine();
    }
}