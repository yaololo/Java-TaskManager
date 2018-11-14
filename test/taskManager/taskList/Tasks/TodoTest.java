package taskManager.taskList.Tasks;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TodoTest {

    String testDetails = "this is a test";
    Todo testTodo = new Todo(testDetails);

    @Test
    public void getDetails() {
        Assert.assertEquals("this is a test\n\tIs done? No", testTodo.getDetails());
    }

    @Test
    public void getTaskType() {
        Assert.assertEquals( "todo", testTodo.getTaskType());
    }

    @Test
    public void getDescription(){
        Assert.assertEquals( testDetails, testTodo.getDescription());
    }

    @Test
    public void setStatus(){
        testTodo.setStatus(true);
        Assert.assertTrue(testTodo.getStatus());

        testTodo.setStatus(false);
        Assert.assertFalse(testTodo.getStatus());
    }

//    @Test
//    public void setStatus(){
//        testTodo.setStatus(true);
//        Assert.assertTrue(testTodo.getStatus());
//
//        testTodo.setStatus(false);
//        Assert.assertFalse(testTodo.getStatus());
//    }
}
