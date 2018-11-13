package taskManager.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {

    public static String getCommandWord(String fullCommand){
        return fullCommand.split(" ")[0].toLowerCase();
    }

    public static String parseFileFormatToUserInput(String fileInput){
        if(fileInput.startsWith("T")){
            return fileInput.split("\\|")[0].trim() + " " + fileInput.split("\\|")[2].trim();
        }

        return fileInput.split("\\|")[0].trim() + " " + fileInput.split("\\|")[2].trim()
                + " / " + fileInput.split("\\|")[3].trim();
    }

    public static String getTaskDescriptionFromUserInput(String task){
        String keyWord = getCommandWord(task);
        String description;

        if (keyWord.startsWith("d")) {
            description = task.substring("deadline".length(), task.lastIndexOf('/')).trim();

        } else {
            description = task.substring("todo".length()).trim();
        }
        return description;
    }

    public static int  getTaskReminderTime (String fileInput){
        return Integer.parseInt(fileInput.split("\\|")[4].trim());
    }

    public static String getTaskDeadline(String task){
        String dateOfDeadline = task.substring(task.lastIndexOf("/")+1).trim();
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

    public static String getPrintInstruction(String userInput){
        String instruction = userInput.substring("print".length()).trim();
        return instruction;
    }

    public static String parseUserInputFormatToFileFormat(String taskDetails, String description, int status, Integer reminderTime){
        if(taskDetails.split("\\n").length > 2){
            return "Deadline | "
                    + status + " | "
                    + description
                    + " | " + (taskDetails.split("\\n")[2]).trim()
                    + " | " + reminderTime;
        } else{
            return "Todo | "+ status + " | " + description;
        }
    }
}
