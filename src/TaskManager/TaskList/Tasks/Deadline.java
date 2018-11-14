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

    public Deadline(String task, String deadline){
      super(task);
        this.setStatus(false);
        setDeadline(deadline);
        timeToRemindInMin = 30;
    }

    public void setDeadline(String deadline){
        this.deadline = deadline;
        updateReminderStatus();
    }

    public void setTimeToRemindInMin(int newTime){
        timeToRemindInMin = newTime;
        updateReminderStatus();
    }

    public int getTimeToRemindInMin(){ return timeToRemindInMin; }

    public String getDeadline() { return deadline; }

    public String getDetails(){
        return getDescription() + "\n\tIs done? " + (getStatus()? "Yes" : "No") + "\n\t" + getDeadline() + "\n\t"
                + (idOverDue? "" : getTimeFromNowToDeadline() + "until deadline\n\t") + "Current setting for reminder is "
                + timeToRemindInMin + " minutes before deadline";
    }

    private void updateReminderStatus(){
        Date dueDate = Parser.parseToDate(deadline);

        // assume parseToDate will never return null as there is previous validation
        // to ensure deadline in correct date format
        assert dueDate != null : "due date is null, something wrong";

        Date now = new Date();
        long diffInMilisecond = dueDate.getTime() - now.getTime();

        if(diffInMilisecond <= 0){
            idOverDue = true;
            reminderStatus = false;
        } else{
            idOverDue = false;
            long diffInMinute = TimeUnit.MILLISECONDS.toMinutes(diffInMilisecond);
            timeBeforeDeadline = diffInMinute;
            if(diffInMinute <= timeToRemindInMin){
                reminderStatus = true;
             }else {
                reminderStatus = false;
            }
        }
    }

    public boolean getReminderStatus(){ return this.reminderStatus; }

    public String getTaskType(){ return type; }

    private String getTimeFromNowToDeadline(){

        updateReminderStatus();

        // assume timeBeforeDeadline can never be negative as it is never assigned to negative value
        assert timeBeforeDeadline >= 0 : "Something wrong, timeBeforeDeadline should not be negative";

        long diffInMinutes = timeBeforeDeadline;

        int years = (int)(diffInMinutes / 525600);
        diffInMinutes %= 525600;
        long days = (diffInMinutes / 60 / 24);
        diffInMinutes %= 1440;
        long hours = (diffInMinutes/ 60);
        diffInMinutes %= 60;

        String year, day, hour;

        if(years == 0) year = "";
        else year = String.valueOf(years) + " year(s) ";

        if(days == 0 ) day = "";
        else day = String.valueOf(days) + " day(s) ";

        if(hours == 0) hour = "";
        else hour = String.valueOf(hours) + " hour(s) ";

        return year + day + hour + diffInMinutes + " minutes ";
    }
}
