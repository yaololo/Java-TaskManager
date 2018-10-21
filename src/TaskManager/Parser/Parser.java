package TaskManager.Parser;

public class Parser {

    public Parser(){}

    public static String getCommandWord(String fullCommand){
        return fullCommand.split(" ")[0].toLowerCase();
    }

}
