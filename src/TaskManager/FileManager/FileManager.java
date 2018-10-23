package TaskManager.FileManager;
import TaskManager.TaskList.TaskList;
import TaskManager.TaskList.TaskManagerException;
import TaskManager.TaskList.Tasks.Task;
import TaskManager.Ui.Ui;
import TaskManager.Parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private File file;

    public FileManager(String path){
        file = new File(path);
    }

    public void loadFile(TaskList taskList){
        try {
            Scanner input = new Scanner(file);

            while(input.hasNext()){
                String line = input.nextLine();
                addTask(line, taskList);
            }

            input.close();

        }catch (FileNotFoundException e){
            new Ui().printError("problem encountered while opening file: " + e.getMessage());
        }
    }

    public void saveToFile(TaskList taskList){
        try {
            PrintWriter output = new PrintWriter(file);

            List<Task> tasks = taskList.getTaskList();

            for (int i = 0; i < tasks.size(); i++) {
                String taskDetails = tasks.get(i).getDetails().trim();

                int status = 0;
                if(tasks.get(i).getStatus()) status = 1;

                if(taskDetails.split("\\n").length > 2){
                    output.println("Deadline | "
                            + Integer.toString(status) + " | "
                            + tasks.get(i).getDescription().trim()
                            + " | " + (taskDetails.split("\\n")[2]).trim());
                } else{
                    output.println("Todo | "+ Integer.toString(status) + " | " + tasks.get(i).getDescription().trim());
                }
            }
            output.close();

        }catch (IOException e){
            new Ui().printError("problem encountered while writing data to file: " + e.getMessage());
        }
    }

    private void addTask(String input, TaskList taskList){
        try {
            String formattedString = new Parser().parseFileFormatToUserInput(input);

            if (formattedString.startsWith("D")) {

                taskList.addDeadline(formattedString);
            } else {
                taskList.addTodo(formattedString);
            }

            if (Integer.parseInt(input.split("\\|")[1].trim()) == 1) {
                taskList.getTaskList().get(taskList.getTaskList().size() -1).setStatus(true);
        }

        } catch (TaskManagerException e){
            new Ui().printError("Something wrong during adding task to taskList: " + e.getMessage());
        }

    }

}
