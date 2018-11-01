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

    public static boolean validateTodo(String todoTask){
        String description = todoTask.substring("todo".length()).trim();
        if (description.isEmpty()){
            return false;
        }
        return true;
    }


    public static void deadlineDateEvluation(String inputDate){
        if(inputDate == null){
            System.out.println("invalid input");
            return;
        }

        inputDate = inputDate.substring("date".length()).trim();
        SimpleDateFormat dataFormatValidator = new SimpleDateFormat("yyyy-MM-dd");
        dataFormatValidator.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = dataFormatValidator.parse(inputDate);
            System.out.println(dataFormatValidator.format(date));

        } catch (ParseException e) {

//            e.printStackTrace();
            System.out.println("\n" + ANSI_YELLOW+ "Warning: Wrong date format" + ANSI_RESET + "\n");
        }

//        return true;
    }

}
