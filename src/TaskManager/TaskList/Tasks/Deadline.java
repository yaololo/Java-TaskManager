package TaskManager.TaskList.Tasks;

public class Deadline extends Task {
    private String deadline;

    public Deadline(String task, String deadline){
        super(task);
        this.setStatus(false);
        setDeadline(deadline);
    }

    public void setDeadline(String deadline){
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }


    public String getDetails(){
        return getDescription() + "\n\tIt done? " + (getStatus()? "Yes" : "No") + "\n\t" + getDeadline();
    }
}
