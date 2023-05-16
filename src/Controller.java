import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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

    }
}
