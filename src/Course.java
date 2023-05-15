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

    public void addMark (Mark mark) {
        marks.add(mark);
    }

    public Mark getMarkInfo (int index) {
        return marks.get(index);
    }
}
