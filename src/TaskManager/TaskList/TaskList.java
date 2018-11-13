package taskManager.taskList;
import taskManager.inputEvaluator.InputValidator;
import taskManager.exceptions.InvalidInputException;
import taskManager.parser.Parser;
import taskManager.taskList.Tasks.*;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;
    private List<Task> reminderList;
    private int idCounter;
    public TaskList(){
        tasks = new ArrayList<>();
        reminderList = new ArrayList<>();
        idCounter= 1;
    }

    public void addTodo(String input)throws InvalidInputException {
        try {
            InputValidator.validateTodo(input);
            tasks.add(new Todo(input.substring("todo".length()).trim(), idCounter));
            idCounter++;

        } catch (InvalidInputException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }

    public void addDeadline(String input, Integer newReminderTime, boolean updateReminderTIme) throws InvalidInputException {
        try {
            InputValidator.validateDeadline(input);

            String taskDescription = Parser.getTaskDescriptionFromUserInput(input);
            String deadline = Parser.getTaskDeadline(input);
            Deadline buffer = new Deadline(taskDescription, deadline, idCounter);
            idCounter++;

            if(updateReminderTIme) buffer.setTimeToRemindInMin(newReminderTime);

            tasks.add(buffer);
            if(buffer.getReminderStatus()){
                reminderList.add(tasks.get(tasks.size()-1));
            }

        } catch (InvalidInputException e){
            throw new InvalidInputException(e.getMessage());
        }
    }

    public void markAsDone(String input) throws InvalidInputException{
        try {
            InputValidator.validateInputFormat(input);
            InputValidator.validateTaskId(input, tasks.size());

            int index = Integer.parseInt(input.substring(input.indexOf("/") + 1).trim());
            tasks.get(index - 1).setStatus(true);
        }catch (InvalidInputException  e){
            throw new InvalidInputException(e.getMessage());
        } catch (NumberFormatException e){
            throw new InvalidInputException("Parse to number error: " + e.getMessage());
        }
    }

    public void updateTaskDescription(String userInput) throws InvalidInputException{
        try {
            InputValidator.validateInputFormat(userInput);
            InputValidator.validateTaskId(userInput, tasks.size());

            int index = Integer.parseInt(userInput.substring(userInput.lastIndexOf("/") + 1).trim());
            String newDescription = userInput.substring("description".length(), userInput.lastIndexOf("/")).trim();
            tasks.get(index - 1).updateDescription(newDescription);

        }catch (InvalidInputException  e){
            throw new InvalidInputException(e.getMessage());
        } catch (NumberFormatException e){
            throw new InvalidInputException("Parse to number error: " + e.getMessage());
        }
    }

    public void updateReminderTime(String userInput) throws InvalidInputException{
        try {
            InputValidator.validateInputFormat(userInput);
            InputValidator.validateTaskId(userInput, tasks.size());

            int index = Integer.parseInt(userInput.substring(userInput.lastIndexOf("/") + 1).trim());
            if(tasks.get(index - 1).getTaskType() != "deadline")
                throw new InvalidInputException("Selected task is not deadline type tasks");

            int newReminderTime =
                    Integer.parseInt(userInput.substring("reminder".length(), userInput.lastIndexOf("/")).trim());

            System.out.println(userInput.substring("reminder".length(), userInput.lastIndexOf("/")).trim());

            Deadline buffer = (Deadline) tasks.get(index - 1);
            buffer.setTimeToRemindInMin(newReminderTime);

            if (buffer.getReminderStatus()) {
                if (!reminderList.contains(tasks.get(index - 1))) {
                    reminderList.add(tasks.get(index - 1));
                }
            } else {
                if (reminderList.contains(tasks.get(index - 1))) {
                    reminderList.remove(tasks.get(index - 1));
                }
            }
        } catch (InvalidInputException  e){
            throw new InvalidInputException(e.getMessage());
        } catch (NumberFormatException e){
            throw new InvalidInputException("Parse to number error: " + e.getMessage());
        }
    }

    public int getTotalNumberOfTask(){ return tasks.size(); }

    public void updateDeadlineTime(String userInput) throws InvalidInputException{
        try {
            InputValidator.validateInputFormat(userInput);
            InputValidator.validateTaskId(userInput, tasks.size());

            int index = Integer.parseInt(userInput.substring(userInput.lastIndexOf("/") + 1).trim());
            if (tasks.get(index - 1).getTaskType() != "deadline")
                throw new InvalidInputException("Selected task is not deadline type tasks");

            String date = userInput.substring("date".length(), userInput.lastIndexOf("/")).trim();
            InputValidator.validateDateOfDeadline(date);

            Deadline buffer = (Deadline) tasks.get(index - 1);
            buffer.setDeadline(date);

            if (buffer.getReminderStatus()) {
                if (!reminderList.contains(tasks.get(index - 1))) {
                    reminderList.add(tasks.get(index - 1));
                }
            } else {
                if (reminderList.contains(tasks.get(index - 1))) {
                    reminderList.remove(tasks.get(index - 1));
                }
            }

        }  catch (InvalidInputException  e){
            throw new InvalidInputException(e.getMessage());
        } catch (NumberFormatException e){
            throw new InvalidInputException("Parse to number error: " + e.getMessage());
        }
    }

    public List<Task> getTaskList(){ return tasks; }

    public List<Task> getReminderList(){ return reminderList;}

    public int getTotalNumberOfReminderTasks(){ return reminderList.size(); }

}
