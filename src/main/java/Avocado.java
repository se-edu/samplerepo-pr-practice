import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Avocado {
    public static ArrayList<Task> list = new ArrayList<>();
    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.showWelcomeMessage();
        TaskList tasklist = new TaskList(list);
    }
}