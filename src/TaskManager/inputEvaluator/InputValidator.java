package taskManager.inputEvaluator;
import taskManager.exceptions.InvalidInputException;
import taskManager.parser.Parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputValidator {
    public static void validateTodo(String todoTask) throws InvalidInputException {
        String description = Parser.getTaskDescriptionFromUserInput(todoTask);
        if (description.isEmpty()){
            throw new InvalidInputException("Empty description for TODO");
        }
    }

    public static void validateDeadline(String deadlineTask) throws InvalidInputException{

        if (!deadlineTask.contains("/")){
            throw new InvalidInputException("Missing '/' to indicate deadline");
        }

        String dateOfDeadline = Parser.getTaskDeadline(deadlineTask);
        if(dateOfDeadline.isEmpty()){
            throw new InvalidInputException("Empty deadline for Deadline task");
        }

        if(!validateDateOfDeadline(dateOfDeadline)){
            throw new InvalidInputException("Invalid date format");
        }

        String taskDescription = Parser.getTaskDescriptionFromUserInput(deadlineTask);
        if (taskDescription.isEmpty()){
            throw new InvalidInputException("Empty description for deadline task");
        }
    }

    public static boolean validateDateOfDeadline(String inputDate){
        String [] newArray = inputDate.split(" ");
        String [] dateFormat = newArray[0].split("-");
        String [] timeFormat = newArray[1].split(":");
        SimpleDateFormat dataFormatValidator = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if(dateFormat[0].length() == 4 && dateFormat[1].length() == 2 && dateFormat[2].length() == 2 ){
            if(timeFormat[0].length() == 2 && timeFormat[1].length() == 2 && timeFormat[2].length() == 2){

                // @setLenient(false) is enforcing input to strictly match pattern e.g 2008-10-20 is valid, 2008/10/20 is invalid
                dataFormatValidator.setLenient(false);

                try {
                    //if not valid, it will throw ParseException
                    dataFormatValidator.parse(inputDate);
                    return true;
                } catch (ParseException e) {
                    return false;
                }
            }
        }

        return false;
    }

    public static void validateInputFormat(String userInput)throws InvalidInputException {

        if (!userInput.contains("/")) throw new InvalidInputException("Empty task number");

        if(userInput.startsWith("description")){
            if(userInput.substring("description".length(), userInput.lastIndexOf("/")).trim() == "" )
                throw new InvalidInputException("Invalid input format or description is empty");

        } else if(userInput.startsWith("reminder")){
            if(userInput.substring("reminder".length(), userInput.lastIndexOf("/")).trim() == "" )
                throw new InvalidInputException("Invalid input format or time value is empty");

        }else if(userInput.startsWith("date")){
            if(userInput.substring("date".length(), userInput.lastIndexOf("/")).trim() == "" ){
                throw new InvalidInputException("Invalid input format or time value is empty");
            }

        } else if(userInput.split("/")[0].split(" ").length > 1)
            throw new InvalidInputException("Invalid input format");
    }

    public static void validateTaskId(String input, int upperBound) throws InvalidInputException {
        int index = Integer.parseInt(input.substring(input.indexOf("/") + 1).trim());
        if(index > upperBound || index <= 0) throw new InvalidInputException("Invalid task index");
    }

    public static void validatePrintCommand(String userInput) throws InvalidInputException{
        String instruction = userInput.substring("print".length()).trim();

        if(instruction.equals("deadline") || instruction.equals("todo") ||
                instruction.equals("all") || instruction.equals("done") ||
                instruction.equals("incomplete")){

        }else{
            throw new InvalidInputException("Invalid input format");
        }
    }
}
