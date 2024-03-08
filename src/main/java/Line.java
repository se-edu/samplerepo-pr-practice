public class Line extends Task {
    protected String by;
    public Line(String taskDescription, String by) {
        super(taskDescription);
        this.by = by;
    }
    public String getBy() {
        return this.by;
    }
    public void setBy(String by) {
        this.by = by;
    }
    @Override
    public String toString() {
        return " [D]" + super.toString() + "(by: " + this.by + ")";
    }
    public String taskDescription() {
        return " [D]" + super.toString() + "(by: " + this.by + ")";
    }
}
