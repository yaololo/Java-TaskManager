package utils;

public class Message {

    public Message(){
    }

    static public void printError(String errMsg) {
        System.out.println(errMsg);
    }

    static public void printWelcome(String welcomeMsg) {
        System.out.println(welcomeMsg);
    }

    static public void exit(String exitMsg) {
        System.out.println(exitMsg);
    }
}
