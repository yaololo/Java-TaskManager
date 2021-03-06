package taskManager.taskList.Tasks;

public class Todo extends Task {
    private String type = "todo";

    public Todo(String todo){
        super(todo);
    }

    public String getDetails(){
        return getDescription() + "\n\tIs done? " + (getStatus()? "Yes" : "No");
    }

    public String getTaskType(){
        return type;
    }

}
