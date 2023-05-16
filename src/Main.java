import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        Scene scene = new Scene(root);

        Course course = new Course("Math", "MHF");
        ObservableList<Course> courses = FXCollections.observableArrayList();

        courses.add(course);
        courses.get(0).addMark(new Mark("CPT", 90.8));

        Course monk = new Course("English", "ENG");

        courses.add(monk);
        courses.get(1).addMark(new Mark("CPT", 92.8));

        FileIO.exportCourses(courses);



        stage.setTitle("Course Manager");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}