package taskManager.taskList.Tasks;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class DeadlineTest {

    @Test
    public void getDeadline() {
        String description1 = "this is a test";
        String deadline1 = "1901-02-02 12:00:00";
        Deadline deadlineTest1 = new Deadline(description1, deadline1);
        Assert.assertEquals(deadline1, deadlineTest1.getDeadline());
    }

    @Test
    public void getTimeToRemindInMin() {
        String description2 = "this is a test";
        String deadline2 = "1901-02-02 12:00:00";
        Deadline deadlineTest2 = new Deadline(description2, deadline2);

        // 30 is the default reminder time
        Assert.assertEquals(30, deadlineTest2.getTimeToRemindInMin());
    }


    @Test
    public void getDetailsWhenTaskIsOverdue() {
        String description3 = "this is a test";
        String deadline3 = "1901-02-02 12:00:00";
        Deadline deadlineTest3 = new Deadline(description3, deadline3);

        String expectDescription = "this is a test\n\tIs done? No" + "\n\t1901-02-02 12:00:00" +
                "\n\tCurrent setting for reminder is " +
                "30 minutes before deadline";

        Assert.assertEquals(expectDescription, deadlineTest3.getDetails());
    }

    @Test
    public void getDetailsWhenTaskIsNotOverdue() {
        String description4 = "this is a test";
        Date expectDeadline = new Date(System.currentTimeMillis() + 3600 * 1000);
        String deadline4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(expectDeadline);

        Deadline deadlineTest4 = new Deadline(description4, deadline4);

        String expectDescription = "this is a test\n\tIs done? No" + "\n\t" + deadline4 +
                "\n\t59 minutes until deadline"+
                "\n\tCurrent setting for reminder is " +
                "30 minutes before deadline";

        Assert.assertEquals(expectDescription, deadlineTest4.getDetails());
    }

    @Test
    // when duration from now until deadline is bigger than timeToRemindInMin
    public void getReminderStatusReturnFalse() {
        String description5 = "this is a test";
        Date expectDeadline = new Date(System.currentTimeMillis() + 3600 * 1000);
        String deadline5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(expectDeadline);
        Deadline deadlineTest5 = new Deadline(description5, deadline5);

        Assert.assertEquals(false, deadlineTest5.getReminderStatus());
    }

    @Test
    // when duration from now until deadline is lesser than timeToRemindInMin
    public void getReminderStatusReturnTrue() {
        String description6 = "this is a test";
        Date expectDeadline = new Date(System.currentTimeMillis() + 1000 * 1000);
        String deadline6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(expectDeadline);
        Deadline deadlineTest6 = new Deadline(description6, deadline6);

        Assert.assertEquals(true, deadlineTest6.getReminderStatus());
    }


    String description = "this is a test";
    String deadline = "1900-02-02 12:00:00";
    Deadline deadlineTest = new Deadline(description, deadline);

    @Test
    public void getTaskType() {
        Assert.assertEquals("deadline", deadlineTest.getTaskType());
    }

    @Test
    public void setDeadline() {
        String newDeadline = "1900-01-01 12:00:00";
        deadlineTest.setDeadline(newDeadline);
        Assert.assertEquals(newDeadline, deadlineTest.getDeadline());
    }

    @Test
    public void setTimeToRemindInMin() {
        int reminderTime = 50;
        deadlineTest.setTimeToRemindInMin(50);
        Assert.assertEquals(reminderTime, deadlineTest.getTimeToRemindInMin());
    }
}