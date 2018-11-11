package  taskManager.taskList.Tasks;
        import java.text.SimpleDateFormat;
        import java.util.Date;

public abstract class Task {
    private String description;
    private Boolean status;
    private String createDate;
    private int id;

    public Task(String task, int id){
        setDescription(task);
        status = false;
        createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        setId(id);
    }

    public void setDescription(String task){ description = task; }

    public String getDescription(){ return description; }

    public abstract String getDetails();
    public abstract String getTaskType();

    public void setStatus(boolean status){ this.status = status; }

    public boolean getStatus() { return this.status; }

    public int getId(){ return id; }

    public void setId(int taskId){ id = taskId; }

    public String getCreateDate(){ return createDate; }
}
