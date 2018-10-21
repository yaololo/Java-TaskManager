package TaskManager.TaskList;
import TaskManager.Parser.Parser;
import TaskManager.TaskList.Tasks.*;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<Task> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public void printTasks(){
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + tasks.get(i).getDetails().trim());
        }
    }


    public void addTodo(String line)throws TaskManagerException {
        String description = line.substring("todo".length()).trim();
        if (description.isEmpty()){
            throw new TaskManagerException("Empty description for TODO");
        }
        this.tasks.add(new Todo(line.substring("todo".length()).trim()));
        System.out.println("Tasks in the list: " + tasks.size());
    }

    public void addDeadline(String line) throws TaskManagerException {
        if (!line.contains("/") || line.substring(line.indexOf("/")+1).trim().isEmpty()){
            throw new TaskManagerException("Empty deadline for Deadline task");
        }

        String task = line.substring("deadline".length(), line.indexOf('/')).trim();

        if (task.isEmpty()){
            throw new TaskManagerException("Empty description for TODO");
        }

        String deadline = line.substring(line.indexOf('/')+ 1);

        tasks.add(new Deadline(task, deadline));
        System.out.println("Tasks in the list: " + tasks.size());
    }

    public void markAsDone(String line){
        int index = Integer.parseInt(line.substring("done".length()).trim());
        tasks.get(index - 1).setStatus(true);
        System.out.println("Tasks in the list: " + tasks.size());
    }

}
