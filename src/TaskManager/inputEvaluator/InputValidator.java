package taskManager.inputEvaluator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputValidator {
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLACK = "\u001B[30m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_CYAN = "\u001B[36m";
    static final String ANSI_WHITE = "\u001B[37m";

    static final int MAX_YEAR = 4000;

    private String input;


//    public InputEvaluator(String inputData){
//
//    }
//
//
//

    public static void validateTodo(String todoTask) throws InvalidInputException{
        String description = todoTask.substring("todo".length()).trim();
        if (description.isEmpty()){
            throw new InvalidInputException("Empty description for TODO");
        }
    }

    public static void validateDeadline(String deadlineTask) throws InvalidInputException{
        String task = deadlineTask.substring("deadline".length(), deadlineTask.indexOf('/')).trim();
        if (task.isEmpty()){
            throw new InvalidInputException("Empty description for deadline task");
        }

        String dateOfDeadline = deadlineTask.substring(deadlineTask.indexOf("/")+1).trim();
        if (!deadlineTask.contains("/") || dateOfDeadline.isEmpty()){
            throw new InvalidInputException("Empty deadline for Deadline task");
        }


        if(!validateDateOfDeadline(dateOfDeadline)){
            throw new InvalidInputException("Invalid date format");
        }

    }


    private static boolean validateDateOfDeadline(String inputDate) throws InvalidInputException{
        SimpleDateFormat dataFormatValidator = new SimpleDateFormat("yyyy-MM-dd");

        // @setLenient(false) is enforcing input to strictly match pattern e.g 2008-10-20 is valid, 2008/10/20 is invalid
        dataFormatValidator.setLenient(false);
        try {
            //if not valid, it will throw ParseException
            dataFormatValidator.parse(inputDate);
        } catch (ParseException e) {

            return false;
        }

        return true;

    }

}
