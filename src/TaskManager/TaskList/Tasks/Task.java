package  TaskManager.TaskList.Tasks;

public abstract class Task {
    private String description;
    private Boolean status;

    public Task(String task){
        addTask(task);
        status = false;
    }

    public void addTask(String task){
        description = task;
    }

    public String getDescription(){
        return description;
    }

    public abstract String getDetails();

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }
}
