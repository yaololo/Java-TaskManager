package TaskManager.Ui;
import java.util.List;
import java.util.Scanner;
import TaskManager.TaskList.Tasks.Task;

public class Ui {

    private Scanner in;

    public Ui() {
        in = new Scanner(System.in);
    }

    public String readUserCommand() {
        System.out.print("Your task? ");
        return in.nextLine().trim();
    }

    public static void printWelcome(){
        System.out.println("Welcome to TaskManager!\n");
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

}
