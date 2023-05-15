// obj Course
// has name, code, and a list of marks

import java.util.ArrayList;
import java.util.List;

public class Course {
    String name;
    String code;
    List<Mark> marks = new ArrayList<>();

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
}
