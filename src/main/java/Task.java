public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    public boolean isDone() {
        return isDone;
    }

    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return getStatusIcon() + " " + getDescription();
    }
    public String taskDescription() {
        return " [ ]" + getStatusIcon() + " " + getDescription();
    }
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    public Boolean changeStatus() {
        return this.isDone;
    }
    public void setDone() {
        this.isDone = true;
    }
    public void setNotDone() {
        this.isDone = false;
    }
}