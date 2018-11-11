package taskManager.taskList.Tasks;
import taskManager.parser.Parser;

import java.util.concurrent.TimeUnit;
import java.util.Date;

public class Deadline extends Task {
    private String deadline;
    private int timeToRemindInMin;
    private boolean idOverDue;
    private boolean reminderStatus;
    private String type= "deadline";
    private long timeBeforeDeadline;

    public Deadline(String task, String deadline, int id){
        super(task, id);
        this.setStatus(false);
        setDeadline(deadline);
        timeToRemindInMin = 30;
        updateReminderStatus();
        reminderStatus= false;

    }

    public void setDeadline(String deadline){
        this.deadline = deadline;
    }

    public void setTimeToRemindInMin(int newTime){
        timeToRemindInMin = newTime;
        updateReminderStatus();
    }

    public String getDeadline() { return deadline; }

    public String getDetails(){
        return getDescription() + "\n\tIt done? " + (getStatus()? "Yes" : "No") + "\n\t" + getDeadline() + "\n\t"
                + (idOverDue? "" : getDurationBeforeDeadline() + "until deadline\n\t") + "Current setting for reminder is "
                + timeToRemindInMin + " minutes before deadline)";
    }

    private void updateReminderStatus(){
        Date dueDate = new Parser().parseToDate(deadline);
        //assert
        Date now = new Date();
        long diffInMilisecond = dueDate.getTime() - now.getTime();

        if(diffInMilisecond <= 0){
            System.out.println(diffInMilisecond);
            idOverDue = true;
            reminderStatus = false;
        } else{
            idOverDue = false;
            long diffInMinute = TimeUnit.MILLISECONDS.toMinutes(diffInMilisecond);
            timeBeforeDeadline = diffInMinute;

            if(diffInMinute < timeToRemindInMin){
                reminderStatus = true;
            }
            reminderStatus = false;
        }
    }

    public boolean getReminderStatus(){ return reminderStatus; }

    public String getTaskType(){ return type; }

    public String getDurationBeforeDeadline(){
        //assert timebeforedeadlin is not negative
        long diffInMinutes = timeBeforeDeadline;

        int years = (int)(diffInMinutes / 525600);
        diffInMinutes %= 525600;
        long days = (long) (diffInMinutes / 60 / 24);
        diffInMinutes %= 1440;
        long hours = (long) (diffInMinutes/ 60);
        diffInMinutes %= 60;

        String year, day, hour, min;

        if(years == 0) year = "";
        else year = String.valueOf(years) + " year(s) ";

        if(days == 0 ) day = "";
        else day = String.valueOf(days) + " day(s) ";

        if(hours == 0) hour = "";
        else hour = String.valueOf(hours) + " hour(s) ";

        return year + day + hour + diffInMinutes + " minutes ";

    }
}
