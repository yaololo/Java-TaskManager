package  taskManager.taskList.Tasks;

public abstract class Task {
    private String description;
    private Boolean status;

    public Task(String task){
        updateDescription(task);
        status = false;
    }

    public void updateDescription(String task){ description = task; }

    public String getDescription(){ return description; }

    public abstract String getDetails();

    public abstract String getTaskType();

    public void setStatus(boolean status){ this.status = status; }

    public boolean getStatus() { return this.status; }

}
