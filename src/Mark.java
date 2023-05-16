// obj Mark, contained in obj Course
// has name, value

import java.io.Serializable;

public class Mark implements Serializable {

    private static final long serialVersionUID = 1L;
    String name;
    double value;

    public Mark(String name, double value) {
        this.name = name;
        this.value = value;
    }

    // getters and setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
