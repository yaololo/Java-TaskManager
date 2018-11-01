package taskManager.taskList.Tasks;

public class Todo extends Task {

    public Todo(String todo){
        super(todo);
    }

    public String getDetails(){
        return getDescription() + "\n\tIt done? " + (getStatus()? "Yes" : "No");
    }

}
