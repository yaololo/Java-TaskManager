package taskManager.ui;
import java.util.List;
import java.util.Scanner;
import taskManager.taskList.Tasks.Task;

public class Ui {

    private Scanner in;
    private static String commands = "--print  \tto print all tasks\n" +
                                    "--todo descriptions \tto create a new todo task with keywords todo, e.g. ‘todo attend an online course\n" +
                                    "--deadline description / deadline \tto create a new deadline task with deadline as keyword. e.g deadline buy milk / Friday evening\n" +
                                    "--done task number’ \tto mark which deadline tasks as done with keyword done e.g ‘done 3’\n";

    public Ui() {
        in = new Scanner(System.in);
    }

    public String readUserCommand() {
        System.out.print("Your task? ");
        return in.nextLine().trim();
    }

    public static void printWelcome(){
        System.out.println("Welcome to taskManager!\n");
    }

    public static void printNumberOfTasks(int count){
        System.out.printf("Number of task you have is %d, please enter your command: \n", count);
    }

    public static void printMessage(String msg){
        System.out.println(msg);
    }

    public static void printError(String errMsg) {
        System.out.println(errMsg);
    }

    public static void exit() {
        System.out.println("Bye Bye!");
    }

    public void printTasks(List<Task> tasks){
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + tasks.get(i).getDetails().trim());
        }
    }

    public static void printCommands(){
        System.out.println(commands);
    }
}
