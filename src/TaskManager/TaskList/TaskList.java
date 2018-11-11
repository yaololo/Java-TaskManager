package taskManager.taskList;
import taskManager.inputEvaluator.InputValidator;
import taskManager.exceptions.InvalidInputException;
import taskManager.parser.Parser;
import taskManager.taskList.Tasks.*;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;
    private List<Deadline> reminderList;
    private int idCounter;

    public TaskList(){
        tasks = new ArrayList<>();
        reminderList = new ArrayList<>();
        idCounter= 1;
    }

    public void addTodo(String input)throws InvalidInputException {
        try {
            new InputValidator().validateTodo(input);
            tasks.add(new Todo(input.substring("todo".length()).trim(), idCounter));
            idCounter++;

        } catch (InvalidInputException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }

    public void addDeadline(String input) throws InvalidInputException {
        try {
            InputValidator.validateDeadline(input);

            String taskDescription = Parser.getTaskDescription(input);
            String deadline = new Parser().getTaskDeadline(input);
            Deadline temp = new Deadline(taskDescription, deadline, idCounter);
            tasks.add(temp);
            idCounter++;

            if(temp.getReminderStatus()){
//                reminderList.add(tasks.get(tasks.size()-1));
            }

        } catch (InvalidInputException e){
            throw new InvalidInputException(e.getMessage());
        }
    }

    public void markAsDone(String line){
        int index = Integer.parseInt(line.substring("done".length()).trim());
        tasks.get(index - 1).setStatus(true);
    }

    public int getTotalNumberOfTask(){ return tasks.size(); }

    public List<Task> getTaskList(){ return tasks; }

    public List<Deadline> getReminderList(){ return reminderList;}

    public int getTotalNumberOfReminderTasks(){ return reminderList.size(); }

}
