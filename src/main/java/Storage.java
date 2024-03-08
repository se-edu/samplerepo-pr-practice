import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Storage {
public static void newFile(ArrayList<Task> tasks) {
    File f = new File("./data/avocado.txt");
    if (!f.exists()) {
        return;
    }
    try {
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            Task task = null;
            String line = s.nextLine();
            String[] p = line.split(" \\| ");
            boolean isDone = p[1].trim().equals("1");
            String description = p[2].trim();
            switch (p[0].trim()) {
                case "T":
                    task = new ToDo(description);
                    break;
                case "D":
                    task = new Line(description, p[3].trim());
                    break;
                case "E":
                    task = new Event(description, p[3].trim(), p[4].trim());
                    break;
            }
            if (isDone) {
                task.setDone();
            }
            tasks.add(task);

        }
        s.close();
    } catch (IOException e) {
        System.out.println("file error");
    }
}

public static void saveTasks(ArrayList<Task> tasks) {
    File f = new File("./data/avocado.txt");
    if (!f.exists()) {
        f.getParentFile().mkdirs();
    }
    try {
        PrintWriter fw = new PrintWriter(f);
        for (Task task : tasks) {
            fw.println(format(task));
        }
        fw.close();
    } catch (FileNotFoundException e) {
        System.out.println("saving error");
    }
}

private static String format(Task task) {
    if (task instanceof ToDo) {
        return "T | " + (task.isDone() ? "1" : "0") + " | " + task.getDescription();
    } else if (task instanceof Line) {
        return "D | " + (task.isDone() ? "1" : "0") + " | " + task.getDescription() +
                " | " + ((Line) task).getBy();
    } else if (task instanceof Event) {
        return "E | " + (task.isDone() ? "1" : "0") + " | " + task.getDescription() +
                " | " + ((Event) task).getFrom() + " | " + ((Event) task).getTo();
    } else {
        throw new IllegalArgumentException("");
    }
}
}
