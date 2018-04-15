package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddNewTaskController {

    @FXML public TextField titleField;
    @FXML public ChoiceBox<String> importantTask;
    @FXML public DatePicker datePicker;
    @FXML public TextArea descriptionTextArea;

    private Task task;
    private Stage dialogStage;
    private boolean okClicked = false;
    //CHOICEBOX
    ObservableList< String > listImportantTask = FXCollections.observableArrayList("LOW", "MEDIUM", "HIGH");

    @FXML
    public void initialize() {
        importantTask.setItems(listImportantTask);
    }

    @FXML
    private void handleOk() {
        task.setTitle(titleField.getText());
        task.setText(descriptionTextArea.getText());
        task.setPriority(importantTask.getValue());
        task.setDate(datePicker.getValue());

        okClicked = true;
        dialogStage.close();
    }

    public void setTask(Task task) {
        this.task = task;
        titleField.setText(task.getTitle());
        descriptionTextArea.setText(task.getText());
        importantTask.setValue(task.getPriority());
        datePicker.setValue(task.getDate());
    }
    public void setDialogStage(Stage dialogStage) {

        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {

        return okClicked;
    }

}
