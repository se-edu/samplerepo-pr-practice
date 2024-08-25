import java.util.*;

import static java.lang.Integer.parseInt;

public class Nah {
    private LinkedList<Task> task = new LinkedList<Task>();

    private enum Command {BYE, TODO, DEADLINE, EVENT, LIST, DELETE, MARK, UNMARK, UNKNOWN};
    private int taskCount = 0;
    static String greetLine = "____________________________________________________________ \n"
            + " Hello! I'm NAH \n"
            + " What can I do for you? \n"
            + "____________________________________________________________ \n";
    static String byeLine = " Bye. Hope to see you again soon! \n";

    Command getCommand(String input) {
        String[] cmd = input.split(" ", 2);
        switch (cmd[0]) {
            case "bye" : {
                return Command.BYE;
            }
            case "todo" : {
                return Command.TODO;
            }
            case "deadline" : {
                return Command.DEADLINE;
            }
            case "event" : {
                return Command.EVENT;
            }
            case "list" : {
                return Command.LIST;
            }
            case "mark" : {
                return Command.MARK;
            }
            case "unmark" : {
                return Command.UNMARK;
            }
            case "delete" : {
                return Command.DELETE;
            }
            default:
                return Command.UNKNOWN;
        }
    }

    void greet() {
        System.out.println(greetLine);
    }

    void exit() {
        System.out.println(byeLine);
    }

    String taskNum() {
        return " Now you have " + taskCount + " tasks in the list\n";
    }

    void add(Task newTask) {
        task.add(newTask);
        taskCount ++;
        System.out.println(" Got it. I 've added this task:\n"
                            + "   " + newTask.toString() + "\n"
                            + taskNum());
    }

    void readTask() {
        int i = 1;
        for (Task t : task) {
            System.out.println(" " + i + ". " + t.toString() + "\n");
            i ++;
        }
    }

    void mark(int i) throws InvalidTaskNumber{
        if (i > taskCount) {
            throw new InvalidTaskNumber(i);
        }
        task.get(i - 1).mark();
        System.out.println(" Nice! I've marked this task as done:\n"
                        + "   " + task.get(i - 1).toString());
    }

    void unMark(int i) throws InvalidTaskNumber{
        if (i > taskCount) {
            throw new InvalidTaskNumber(i);
        }
        task.get(i - 1).unMark();
        System.out.println(" OK, I've marked this task as not done yet:\n"
                + "   " + task.get(i - 1).toString());
    }

    void delete(int i) throws InvalidTaskNumber{
        if (i > taskCount || i <= 0) {
            throw new InvalidTaskNumber(i);
        }

        taskCount --;
        System.out.println(" Noted. I've removed this task:\n"
                        + "   " +  task.get(i - 1).toString() + "\n"
                        + taskNum());
        task.remove(i - 1);

    }

    public static void main(String[] args) {
        String logo = "| \\   | |      /\\      | |  | | \n"
                + "| |\\  | |     / /\\     | |==| | \n"
                + "| | \\ | |    / /__\\    | |  | | \n"
                + "| |  \\  |   / /    \\   | |  | | \n";



        System.out.println("Hello from\n" + logo);

        Nah nah = new Nah();

        nah.greet();

        Scanner scanner = new Scanner(System.in);
        String input;

        while(true) {
            input = scanner.nextLine();
            System.out.println("____________________________________________________________ \n");
            Command cmd = nah.getCommand(input);
            String[] command = input.split(" ", 2);
            try {
                switch(cmd) {
                    case BYE :{
                        nah.exit();
                        scanner.close();
                        return;
                    }

                    case LIST : {
                        nah.readTask();
                        break;
                    }

                    case MARK: {
                        if (command.length < 2 || command[1].trim().isEmpty()) {
                            throw new LackDescription("NAH!!! The ordinal number of a task cannot be empty.\"");
                        }
                        int i = parseInt(command[1]);
                        nah.mark(i);
                        break;
                    }

                    case UNMARK: {
                        if (command.length < 2 || command[1].trim().isEmpty()) {
                            throw new LackDescription("NAH!!! The ordinal number of a task cannot be empty.\"");
                        }
                        int i = parseInt(command[1]);
                        nah.unMark(i);
                        break;
                    }

                    case DELETE: {
                        int i = parseInt(command[1]);
                        nah.delete(i);
                        break;
                    }

                    case TODO: {
                        if (command.length < 2 || command[1].trim().isEmpty()) {
                            throw new LackDescription(" NAH!!! The description of a todo cannot be empty.");
                        }
                        nah.add(new ToDos(command[1].trim()));
                        break;
                    }

                    case DEADLINE: {
                        if (command.length < 2 || command[1].trim().isEmpty()) {
                            throw new LackDescription(" NAH!!! The description of a deadline cannot be empty.");
                        }

                        String[] content = command[1].split("/", 2);
                        if (content.length < 2 || content[1].trim().isEmpty()) {
                            throw new LackDescription(" NAH!!! The due date of a deadline cannot be empty.");
                        }

                        nah.add(new Deadlines(content[0].trim(), content[1].trim()));
                        break;
                    }

                    case EVENT: {
                        if (command.length < 2 || command[1].trim().isEmpty()) {
                            throw new LackDescription(" NAH!!! The description of an event cannot be empty.");
                        }

                        String[] content = command[1].split("/", 2);
                        if (content.length < 2 || content[1].trim().isEmpty()) {
                            throw new LackDescription(" NAH!!! The due date of an event cannot be empty.");
                        }

                        nah.add(new Events(content[0].trim(), content[1].trim()));
                        break;
                    }

                    case UNKNOWN: {
                        throw (new UnknownCommand(" NAH!!! I'm sorry, but I don't know what that means.\n" +
                                " Please give me valid command. eg: mark, unmark, list, ...\n"));
                    }
                }
            } catch (LackDescription e) {
                System.out.println(e.getMessage());
            } catch (UnknownCommand e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(" NAH!!! Please give me a valid ordinal number for the task");
            } catch (InvalidTaskNumber e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("____________________________________________________________ \n");
            }









        }



    }
}
