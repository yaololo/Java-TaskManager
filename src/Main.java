import taskManager.TaskManager;

public class Main {

    public static void main(String[] args) {
//        assert args.length>0 : "No arguments";
        new TaskManager("/Users/yongming/personal/school/java_se/taskManager/src/taskManager/data/tasks.txt").run();
    }
}
