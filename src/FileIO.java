import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static List<Course> importCourses (){
        List<Course> courses= new ArrayList<>();
        try {
            FileReader fr = new FileReader("courseList.txt");
            BufferedReader br = new BufferedReader(fr);
            List<String> courseList = store();

            for (int i = 0; i < courseList.size(); i++) {
                courses.add(loadCourse(br.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public static Course loadCourse(String name) {
        try (FileInputStream fis = new FileInputStream(name+".dat")) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            return (Course) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static List<String> store() throws IOException {
        FileReader fr = new FileReader("courseList.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        List<String> passwordList = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            passwordList.add(line);
        }
        fr.close();
        br.close();
        return passwordList;
    }
}
