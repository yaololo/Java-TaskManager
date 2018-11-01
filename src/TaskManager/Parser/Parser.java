package taskManager.parser;

public class Parser {

    public Parser(){}

    public static String getCommandWord(String fullCommand){
        return fullCommand.split(" ")[0].toLowerCase();
    }

    public static String parseFileFormatToUserInput(String line){
        if(line.startsWith("T")){
            return line.split("\\|")[0].trim() + " " + line.split("\\|")[2].trim();
        }

        return line.split("\\|")[0].trim() + " " + line.split("\\|")[2].trim()
                + " / " + line.split("\\|")[3].trim();
    }

    public static String getTaskDescription(String task){
        String keyWord = getCommandWord(task);
        String description;

        if (keyWord.startsWith("d")) {
            description = task.substring("deadline".length(), task.indexOf('/')).trim();

        } else {
            description = task.substring("todo".length()).trim();
        }

        return description;
    }

    public static String getTaskDeadline(String task){
        String dateOfDeadline = task.substring(task.indexOf("/")+1).trim();
        return dateOfDeadline;
    }
}
