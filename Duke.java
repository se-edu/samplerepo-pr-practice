package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke{

    static void checkLineEmpty(String line)throws DukeCheckLineEmptyException{
        if (line.equals("")){
            throw new DukeCheckLineEmptyException();
        }
    }

    static void checkWord(String line)throws DukeCheckLineException{
        String keyword = line.split(" ")[0].toLowerCase();

        if (!keyword.equals("list") && !keyword.equals("bye")
        && !keyword.equals("todo") && !keyword.equals("done")
        && !keyword.equals("event") && !keyword.equals("deadline")){
            throw new DukeCheckLineException();
        }
    }

    static void checkDescription(String line)throws DukeException{
        String keyword = line.split(" ")[0].toLowerCase();

        if (keyword.equals("todo") && line.split(" ").length == 1){
            throw new DukeException();
        }

        if (keyword.equals("event") && line.split(" ").length == 1){
            throw new DukeException();
        }

        if (keyword.equals("deadline") && line.split(" ").length == 1){
            throw new DukeException();
        }

        if (keyword.equals("done") && line.split(" ").length == 1){
            throw new DukeException();
        }
    }

    public static void main(String[] args){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        printWithLine(List.of("Hello from\n" + logo));
        printWithLine(List.of("Hello! I'm Duke", "What can I do for you?"));

        String line;
        Scanner in = new Scanner(System.in);
        List<Task> items = new ArrayList<>();

        do{
            line = in.nextLine();
            String keyword = line.split(" ")[0].toLowerCase();

            try {
                checkLineEmpty(line);
                checkWord(line);
                checkDescription(line);

                if (line.equalsIgnoreCase("list")){
                    printWithLine(List.of());
                    List<String> messages = new ArrayList<>();
                    System.out.println("   Here are the tasks in your list: ");
                    for (int i = 0; i < items.size(); i++) {
                        messages.add(i + 1 + "." + items.get(i));
                    }
                    printWithLine(messages);

                } else if (line.split(" ")[0].equalsIgnoreCase("done")){
                    printWithLine(List.of());
                    Task markItem = items.get(Integer.parseInt(line.substring(5)) - 1);
                    markItem.markAsDone();
                    printWithLine(List.of("Nice! I've marked this task as done: ", " " + markItem));

                } else if (line.split(" ")[0].equalsIgnoreCase("todo")){
                    printWithLine(List.of());
                    Task todoTask = new Todo(line.replace(line.split(" ")[0] + " ", ""));
                    items.add(todoTask);
                    printWithLine((List.of("Got it. I've added this task: ", todoTask.toString(), "Now you have " + items.size() + " task in the list. ")));

                } else if (line.split(" ")[0].equalsIgnoreCase("deadline")){
                    printWithLine(List.of());
                    int position = line.indexOf("/");
                    String time = line.split("/")[1].replace("by ", "");
                    Task deadlineTask = new Deadline(line.substring(9, position - 1), time);
                    items.add(deadlineTask);
                    printWithLine((List.of("Got it. I've added this task: ", deadlineTask.toString(), "Now you have " + items.size() + " task in the list. ")));

                } else if (line.split(" ")[0].equalsIgnoreCase("event")){
                    printWithLine(List.of());
                    int position = line.indexOf("/");
                    String time = line.split("/")[1].replace("at ", "");
                    Task eventTask = new Event(line.substring(6, position - 1), time);
                    items.add(eventTask);
                    printWithLine((List.of("Got it. I've added this task: ", eventTask.toString(), "Now you have " + items.size() + " task in the list. ")));

                } else if (line.equalsIgnoreCase("bye")){
                    printWithLine(List.of());
                    printWithLine(List.of("Bye. Hope to see you again soon!"));

                }
            }
            catch (DukeCheckLineException e){
                printWithLine(List.of());
                printWithLine(List.of("☹ OOPS!!! I'm sorry, but I don't know what that means :-("));
            }
            catch (DukeCheckLineEmptyException e){
                printWithLine(List.of());
                printWithLine(List.of("☹ OOPS!!! Please enter somethings."));
            }
            catch (DukeException e){
                printWithLine(List.of());
                printWithLine((List.of("☹ OOPS!!! The description of a " + keyword + " cannot be empty.")));
            }

        }while(!line.equals("bye"));
    }

    private static void printWithLine(List<String> messages){
		
        for (String message : messages){
            System.out.println("   " + message);
        }
        System.out.println("   _____________________________________");
    }
}
