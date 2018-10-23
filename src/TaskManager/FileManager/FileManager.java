package TaskManager.Storage;
import TaskManager.TaskList.Tasks.Deadline;
import TaskManager.TaskList.Tasks.Task;
import TaskManager.TaskList.Tasks.Todo;
import utils.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    private List<Task> taskList;
    private File file;

    public Storage(String path){
        file = new File(path);
    }

    public List<Task> loadedTasks(){
        taskList = new ArrayList<>();
        List<String> lines = getLines(this.file);
        for (String line : lines) {
            // ignore empty lines
            if (line.trim().isEmpty()) continue;
            taskList.add(createTask(line)); //convert the line to a task and add to the list
        }
        return taskList;
    }

    public void updateFile(List<Task> taskList){
        try {
            PrintWriter output = new PrintWriter(file);
            for (int i = 0; i < taskList.size(); i++) {
                String taskDetails = taskList.get(i).getDetails().trim();

                int status = 0;
                if(taskList.get(i).getStatus()) status = 1;

                if(taskDetails.split("\\n").length > 2){
                    output.println("Deadline | "+ Integer.toString(status) + " | " + taskList.get(i).getDescription().trim() + " | " + (taskDetails.split("\\n")[2]).trim());
                } else{
                    output.println("Todo | "+ Integer.toString(status) + " | " + taskList.get(i).getDescription().trim());
                }
            }
            output.close();

        }catch (IOException e){
            new Message().printError("problem encountered while writing data to file: " + e.getMessage());
        }
    }

    private Task createTask(String input){
        boolean status = false;
        String taskDetails = input.split("\\|")[2].trim();
        Task task = new Todo(taskDetails);
        task.setStatus(status);

        if(Integer.parseInt(input.split("\\|")[1].trim()) == 1){
            status = true;
            task.setStatus(status);
        }

        if(input.startsWith("D")){
            String deadline = input.split("\\|")[3].trim();
            task = new Deadline(taskDetails, deadline);
        }


        return task;
    }

    private List<String> getLines(File file){

        List<String> tasks = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);

            while(input.hasNext()){
                String line = input.nextLine();
                tasks.add(line);
            }

            input.close();

        }catch (FileNotFoundException e){
            new Message().printError("problem encountered while opening file: " + e.getMessage());
        }
        return tasks;
    }
}
