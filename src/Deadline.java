public class Deadline extends Todo{
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

    //@override
    public String getDetails(){
        return getDescription() + "\n\tIt done? " + (getStatus()? "Yes" : "No") + "\n\t" + getDeadline();
    }
}
