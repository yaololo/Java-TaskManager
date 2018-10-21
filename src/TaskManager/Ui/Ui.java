package TaskManager.Ui;
import java.util.Scanner;

public class Ui {

    private Scanner in;

    public Ui() {
        in = new Scanner(System.in);
    }

    public String readUserCommand() {
        System.out.print("Your task? ");
        return in.nextLine().trim();
    }





    public void printWelcome(){
        System.out.println("Welcome to TaskManager!\n");
    }

    public void printError(String errMsg) {
        System.out.println(errMsg);
    }


    public void exit(String exitMsg) {
        System.out.println("Bye Bye!");
    }

}
