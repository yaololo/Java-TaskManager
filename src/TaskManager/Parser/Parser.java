package TaskManager.Parser;

public class Parser {

    public Parser(){}

    public static String getCommandWord(String fullCommand){
        return fullCommand.split(" ")[0].toLowerCase();
    }

//    public static String parseUserInputToFileFormat(String input ){
//
//    }

    public static String parseFileFormatToUserInput(String line){
        if(line.startsWith("T")){
            return line.split("\\|")[0].trim() + " " + line.split("\\|")[2].trim();
        }

        return line.split("\\|")[0].trim() + " " + line.split("\\|")[2].trim()
                + " / " + line.split("\\|")[3].trim();
    }

}
