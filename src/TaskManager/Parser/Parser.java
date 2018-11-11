package taskManager.parser;
import taskManager.exceptions.InvalidInputException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

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

    public static String getTaskDescriptionFromUserInput(String task){
        String keyWord = getCommandWord(task);
        String description;

        if (keyWord.startsWith("d")) {
            description = task.substring("deadline".length(), task.indexOf('/')).trim();

        } else {
            description = task.substring("todo".length()).trim();
        }
        return description;
    }

    public static int getTaskReminderTime (String fileInput){
        return Integer.parseInt(fileInput.split("\\|")[4].trim());
    }

    public static String getTaskDeadline(String task){
        String dateOfDeadline = task.substring(task.indexOf("/")+1).trim();
        return dateOfDeadline;
    }

    public static Date parseToDate(String dateString){
        try{
            Date deadline= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
            return deadline;
        }catch(ParseException e){
            return null;
        }
    }
}
