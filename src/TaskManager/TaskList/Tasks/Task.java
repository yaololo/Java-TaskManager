package  taskManager.taskList.Tasks;
        import java.text.SimpleDateFormat;
        import java.util.Date;

public abstract class Task {
    private String description;
    private Boolean status;
    private String createDate;

    public Task(String task){
        addTask(task);
        status = false;
        createDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
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

    public String getCreateDate(){
        return createDate;
    }
}
