package taskManager.ui;
import java.util.List;
import java.util.Scanner;

import taskManager.inputEvaluator.InputValidator;
import taskManager.taskList.Tasks.Task;

public class Ui {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    private Scanner in;
    private static String commands = "\n\nprint  \t--to print all tasks\n" +
                                    "todo descriptions \t--to create a new todo task with keywords todo, e.g. ‘todo attend an online course\n" +
                                    "deadline description / deadline \t--to create a new deadline task with deadline as keyword. e.g deadline buy milk / 2018-02-1\n" +
                                    "done task number’ \t--to mark which deadline tasks as done with keyword done e.g ‘done 3’\n";

    public Ui() { in = new Scanner(System.in); }

    public String readUserCommand() { return in.nextLine().trim(); }

    public static void printWelcome(){ System.out.println(BLUE + "\nWelcome to taskManager!\n" + RESET); }

    public static void printNumberOfTasks(int count, int reminders){
        System.out.printf(YELLOW + "You have %d of tasks that will overdue soon!\n" + RESET, reminders );
        System.out.printf(GREEN + "Total number of task you have is %d, please enter your command: \n" +RESET, count);
    }

    public static void printError(String errMsg) {
        System.out.println( RED +"\n" + errMsg + "\n" + RESET);
    }

    public static void exit() {
        System.out.println(PURPLE + "\nBye Bye!" + RESET);
    }

    public static void printALlTasks(List<Task> tasks, String userInput){
        if(!InputValidator.validatePrintCommand(userInput)){
            printError("Invalid print command ");
        }else{
            System.out.println("Tasks:");
            String instruction = userInput.substring("print".length()).trim();

            for (int i = 0; i < tasks.size(); i++) {
                boolean status =  tasks.get(i).getStatus();
                String type = tasks.get(i).getTaskType();

                if(instruction.equals("all")) {
                    System.out.println("[" + tasks.get(i).getId() + "] " + tasks.get(i).getDetails().trim() + "\n");
                } else if(instruction.equals("done") && status == true){
                    System.out.println("[" + tasks.get(i).getId() + "] " + tasks.get(i).getDetails().trim() + "\n");
                } else if(instruction.equals("incomplete") && status == false){
                    System.out.println("[" + tasks.get(i).getId() + "] " + tasks.get(i).getDetails().trim() + "\n");
                } else if(instruction.equals(type)) {
                    System.out.println("[" + tasks.get(i).getId() + "] " + tasks.get(i).getDetails().trim() + "\n");
                }
            }
        }
    }

    public static void printCommands(){ System.out.println(GREEN + commands + RESET); }

    public void printReminderTasks(List<Task> tasks){
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Tasks:");
            System.out.println("[" + tasks.get(i).getId() + "] " + YELLOW +
                    tasks.get(i).getDetails().trim() + "\n" + RESET );
        }
    }
}
