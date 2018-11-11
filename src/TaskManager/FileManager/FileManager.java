package taskManager.fileManager;
import taskManager.exceptions.InvalidInputException;
import taskManager.taskList.TaskList;
import taskManager.taskList.Tasks.Deadline;
import taskManager.taskList.Tasks.Task;
import taskManager.ui.Ui;
import taskManager.parser.Parser;

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

    public void loadFile(TaskList taskList) throws IOException{
        try {
            Scanner input = new Scanner(file);

            while(input.hasNext()){
                String line = input.nextLine();
                addTask(line, taskList);
            }

            input.close();

        }catch (FileNotFoundException e){
            throw new IOException("problem encountered while opening file: " + e.getMessage());
        }
    }

    public void saveToFile(TaskList taskList)throws IOException{
        try {
            PrintWriter output = new PrintWriter(file);

            List<Task> tasks = taskList.getTaskList();

            for (int i = 0; i < tasks.size(); i++) {
                String taskDetails = tasks.get(i).getDetails().trim();

                int status = 0;
                if(tasks.get(i).getStatus()) status = 1;

                Deadline temp = (Deadline) tasks.get(i);
                if(taskDetails.split("\\n").length > 2){
                    output.println("Deadline | "
                            + Integer.toString(status) + " | "
                            + tasks.get(i).getDescription().trim()
                            + " | " + (taskDetails.split("\\n")[2]).trim()
                            + " | " + temp.getTimeToRemindInMin() );
                } else{
                    output.println("Todo | "+ Integer.toString(status) + " | " + tasks.get(i).getDescription().trim());
                }
            }
            output.close();

        }catch (IOException e){
            throw new IOException("problem encountered while writing data to file: " + e.getMessage());
        }
    }

    private void addTask(String input, TaskList taskList){
        try {
            String formattedString = Parser.parseFileFormatToUserInput(input);

            if (formattedString.startsWith("D")) {
                taskList.addDeadline(formattedString);

                int timeToRemind = Parser.getTaskReminderTime(input);
                if(timeToRemind != 30){
                    int size = taskList.getTaskList().size();
                    Deadline temp = (Deadline)taskList.getTaskList().get(size - 1);
                    temp.setTimeToRemindInMin(timeToRemind);
                }

            } else taskList.addTodo(formattedString);

            if (Integer.parseInt(input.split("\\|")[1].trim()) == 1) {
                // @ get current task from the tasklist and set the status to true
                taskList.getTaskList().get(taskList.getTaskList().size() -1).setStatus(true);
            }
        } catch (InvalidInputException e){
            // need to thrown error
            Ui.printError("Something wrong during adding task to taskList: " + e.getMessage());
        }
    }
}
