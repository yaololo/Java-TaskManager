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

    public void addDeadline(String input) throws InvalidInputException {
        try {
            InputValidator.validateDeadline(input);

            String taskDescription = Parser.getTaskDescriptionFromUserInput(input);
            String deadline = Parser.getTaskDeadline(input);
            Deadline buffer = new Deadline(taskDescription, deadline, idCounter);
            tasks.add(buffer);
            idCounter++;

            if(buffer.getReminderStatus()){
                reminderList.add(tasks.get(tasks.size()-1));
            }

        } catch (InvalidInputException e){
            throw new InvalidInputException(e.getMessage());
        }
    }

    public void markAsDone(String input){
        int index = Integer.parseInt(input.substring("/".length()).trim());
        tasks.get(index - 1).setStatus(true);
    }

    public void updateTaskDescription(String userInput){
        int index = Integer.parseInt(userInput.substring("/".length()).trim());
        String newDescription = userInput.substring("description".length(), index).trim();
        tasks.get(index - 1).updateDescription(newDescription);
    }

    public void updateReminderTime(String userInput){
        int index = Integer.parseInt(userInput.substring("/".length()).trim());
        int newReminderTime = Integer.parseInt(userInput.substring("reminder".length(), index).trim());

        Deadline buffer = (Deadline)tasks.get(index - 1);
        buffer.setTimeToRemindInMin(newReminderTime);

        if(buffer.getReminderStatus()){
            if(!reminderList.contains(tasks.get(index - 1))){
                reminderList.add(tasks.get(index - 1));
            }
        } else {
            if (reminderList.contains(tasks.get(index - 1))) {
                reminderList.remove(tasks.get(index - 1));
            }
        }
    }

    public int getTotalNumberOfTask(){ return tasks.size(); }

    public List<Task> getTaskList(){ return tasks; }

    public List<Task> getReminderList(){ return reminderList;}

    public int getTotalNumberOfReminderTasks(){ return reminderList.size(); }

}
