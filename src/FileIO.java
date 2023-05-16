// IO stuff, handling loading in files and data from fs
// also used to reset cache etc. WHICH I NEED TO ADD

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    // func exportCourses, returns void, param list of courses. exports all courses to a .dat file
    public static void exportCourses(List<Course> courses){
        try (FileOutputStream fs = new FileOutputStream("courseList.txt")){
            List<String> courseList = store();

            for (Course course : courses) {
                fs.write(course.name.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Course course : courses) {
            try (FileOutputStream fos = new FileOutputStream(course.name + ".dat")) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(course);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // func importCourses, returns a list of Courses that can be loaded into the listView
    public static List<Course> importCourses (){
        // create new obj for return statement
        List<Course> courses= new ArrayList<>();
        try {
            // creates a list that stores the names of all the courses.name from courseList.txt
            List<String> courseList = store();

            // for every value in courseList, load the course
            for (String s : courseList) {
                courses.add(loadCourse(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return statement
        return courses;
    }

    // func loadCourse, returns Course, param String name
    public static Course loadCourse(String name) {
        // checks if there is a file with the name: name.dat
        try (FileInputStream fis = new FileInputStream(name+".dat")) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            // returns the obj read from the file
            return (Course) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // func store, returns List<String>. returns list of names in courseList.txt
    public static List<String> store() throws IOException {
        // setup for buffered reader
        FileReader fr = new FileReader("courseList.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        List<String> courseList = new ArrayList<>();

        // while there are lines to be read, read and add to list
        while ((line = br.readLine()) != null) {
            courseList.add(line);
        }
        fr.close();
        br.close();
        // return statement
        return courseList;
    }
}
