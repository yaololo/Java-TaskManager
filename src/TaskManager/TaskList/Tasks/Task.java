package TaskManager.TaskList.Tasks;

public class Task {
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

    public String getDetails(){
        return getDescription() + "\n\tIt done? " + (getStatus()? "Yes" : "No");
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }
}
