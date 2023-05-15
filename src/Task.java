// task obj, will contain name of task and details

public class Task {
    String task;
    String details;

    public Task(String task) {
        this.task = task;
        this.details = null;
    }

    public Task(String task, String details) {
        this.task = task;
        this.details = details;
    }

}
