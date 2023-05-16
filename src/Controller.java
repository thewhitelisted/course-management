import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView<Course> courseSelectListView;

    @FXML
    private TextField courseNameField;

    @FXML
    private TextField courseCodeField;

    @FXML
    private Button createCourseButton;

    @FXML
    private Label courseLabel;

    @FXML
    private Label courseCodeLabel;

    @FXML
    private ListView<Task> taskListView;

    @FXML
    private TextField taskNameField;

    @FXML
    private TextField taskDetailsField;

    @FXML
    private Button createTaskButton;

    @FXML
    private ListView<Mark> markListView;

    @FXML
    private TextField markNameField;

    @FXML
    private TextField markMarkField;

    @FXML
    private Button addMarkButton;

    @FXML
    private Label markNameLabel;

    @FXML
    private Label markValueLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            ObservableList<Course> courseList = createCourseList();
            courseSelectListView.getItems().addAll(courseList);

            courseSelectListView.setCellFactory(new Callback<ListView<Course>, ListCell<Course>>() {
                @Override
                public ListCell<Course> call(ListView<Course> courseListView) {
                    return new ListCell<Course>() {
                        @Override
                        protected void updateItem(Course item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty || item == null) {
                                setText(null);
                            } else {
                                setText(item.getName());
                            }
                        }
                    };
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public ObservableList<Course> createCourseList() {
        return FileIO.importCourses();
    }
}
