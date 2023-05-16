// obj Course
// has name, code, and a list of marks

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
    String name;
    String code;
    List<Mark> marks = new ArrayList<>();
    List<Task> tasks = new ArrayList<>();

    //default serialVersion id
    private static final long serialVersionUID = 1L;

    public Course (String name, String code) {
        this.name = name;
        this.code = code;
    }

    // func addMark, returns void, param Mark named mark. Adds mark to the list of marks
    public void addMark (Mark mark) {
        marks.add(mark);
    }

    // func getMarkInfo, returns Mark, param index. Returns obj Mark based on index in List
    public Mark getMarkInfo (int index) {
        return marks.get(index);
    }

    // func addTask, returns void, param Task. adds task to list of tasks
    public void addTask (Task task) {
        tasks.add(task);
    }

    // func getTaskInfo, returns Task, param index. returns obj Task based on index in List
    public Task getTaskInfo (int index) {
        return tasks.get(index);
    }


    // getters and setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Mark> getMarks() {
        return this.marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
