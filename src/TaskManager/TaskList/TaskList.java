package taskManager.taskList;
import taskManager.inputEvaluator.InputValidator;
import taskManager.inputEvaluator.InvalidInputException;
import taskManager.taskList.Tasks.*;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public void addTodo(String line)throws InvalidInputException {
        try {
            new InputValidator().validateTodo(line);
            tasks.add(new Todo(line.substring("todo".length()).trim()));

        } catch (InvalidInputException e) {
            throw new InvalidInputException(e.getMessage());

        }
    }

    public void addDeadline(String line) throws InvalidInputException {
        try {
            new InputValidator().validateDeadline(line);

            //
            String task = line.substring("deadline".length(), line.indexOf('/')).trim();
            String deadline = line.substring(line.indexOf('/')+ 1);

            tasks.add(new Deadline(task, deadline));
        } catch (InvalidInputException e){
            throw new InvalidInputException(e.getMessage());
        }
//        if (!line.contains("/") || line.substring(line.indexOf("/")+1).trim().isEmpty()){
//            throw new TaskManagerException("Empty deadline for Deadline task");
//        }
//
//        String task = line.substring("deadline".length(), line.indexOf('/')).trim();
//
//        if (task.isEmpty()){
//            throw new TaskManagerException("Empty description for TODO");
//        }

        String deadline = line.substring(line.indexOf('/')+ 1);

//        tasks.add(new Deadline(task, deadline));
    }

    public void markAsDone(String line){
        int index = Integer.parseInt(line.substring("done".length()).trim());
        tasks.get(index - 1).setStatus(true);
//        System.out.println("Tasks in the list: " + tasks.size());
    }

    public int getTotalNumberOfTask(){
        return tasks.size();
    }

    public List<Task> getTaskList(){
        return tasks;
    }

}
