import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
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

            // change the ui to fit the Course selected
            courseSelectListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>() {
                @Override
                public void changed(ObservableValue<? extends Course> observableValue, Course course, Course t1) {
                    Course currentCourse = courseSelectListView.getSelectionModel().getSelectedItem();
                    courseLabel.setText("Course: " + currentCourse.name);
                    courseCodeLabel.setText("Course Code: " + currentCourse.code);

                    System.out.println(currentCourse.marks);
                    ObservableList<Mark> markList = createMarkList(currentCourse);
                    markListView.getItems().addAll(markList);
                    System.out.println(markList);
                    markListView.setCellFactory(new Callback<ListView<Mark>, ListCell<Mark>>() {
                        @Override
                        public ListCell<Mark> call(ListView<Mark> markListView) {
                            return new ListCell<Mark>() {
                                @Override
                                protected void updateItem(Mark item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (empty || item == null) {
                                        setText(null);
                                    } else {
                                        setText(item.name);
                                    }
                                }
                            };
                        }
                    });

                    markListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Mark>() {
                        @Override
                        public void changed(ObservableValue<? extends Mark> observableValue, Mark mark, Mark t1) {
                            Mark currentMark = markListView.getSelectionModel().getSelectedItem();
                            markNameLabel.setText("Mark Name: " + currentMark.name);
                            markValueLabel.setText("Value: " + currentMark.value);
                        }
                    });
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

    @FXML
    public ObservableList<Mark> createMarkList(Course course) {
        ObservableList<Mark> marks= FXCollections.observableArrayList();;
        for (int i = 0; i < course.marks.size(); i++) {
            marks.add(course.marks.get(i));
            System.out.println(course.marks.get(i));
        }
        return marks;
    }
}
