package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.tools.Tool;
import java.io.IOException;


public class Controller extends AddNewTaskController{

    private Main main;
    private Stage dialogStage;

    //zadeklarowanie tablic
    @FXML  public TableView<Task> toDoTable;
    @FXML  public TableView<Task> progressTable;
    @FXML  public TableView<Task> doneTable;

    //zadeklarowanie kolumn
    @FXML public TableColumn<Task,String> firstTable;
    @FXML private TableColumn<Task,String> secondTable;
    @FXML private TableColumn<Task,String> thirdTable;

    //usuwanie wybranego zadania z danej tablicy
    @FXML public void deleteTaskToDo() {
        int selectedTask = toDoTable.getSelectionModel().getSelectedIndex();
        toDoTable.getItems().remove(selectedTask);
    }
    @FXML public void deleteTaskProgress() {
        int selectedTask = progressTable.getSelectionModel().getSelectedIndex();
        progressTable.getItems().remove(selectedTask);
    }
    @FXML public void deleteTaskDone() {
        int selectedTask = doneTable.getSelectionModel().getSelectedIndex();
        doneTable.getItems().remove(selectedTask);
    }



    //edytowanie wybranego zadania z danej tablicy
    @FXML public void editTaskToDo() {
        Task selectedPerson = toDoTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = showAddTask(selectedPerson);
            if (okClicked) {
                showAddTask(selectedPerson);
                initialize();
            }
        }
    }
    @FXML public void editTaskProgress() {
        Task selectedPerson = progressTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = showAddTask(selectedPerson);
            if (okClicked) {
                showAddTask(selectedPerson);
                initialize();
            }
        }
    }
    @FXML public void editTaskDone() {
        Task selectedPerson = doneTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = showAddTask(selectedPerson);
            if (okClicked) {
                showAddTask(selectedPerson);
                initialize();
            }
        }
    }

    //przenoszenie zadan miedzy tablicami
    public void sendToDoListProgressList(){
        sendTask(toDoTable,progressTable);
    }
    public void sendProgressListToDoList(){
        sendTask(progressTable,toDoTable);
    }
    public void sendProgressListDoneList(){
        sendTask(progressTable,doneTable);
    }
    public void sendDoneListProgressList(){
        sendTask(doneTable,progressTable);
    }

    private void sendTask(TableView<Task>tableRemove, TableView<Task>tableAdd){
        Task task=tableRemove.getSelectionModel().getSelectedItem();
        if(task!=null) {
            tableRemove.getItems().remove(task);
            tableAdd.getItems().add(task);
        }
    }


    @FXML private void information(){
       Dialogs.dialogAboutTask();
    }


    // pozwala na wyswietlanie zadan w danej tablicy
    @FXML public void initialize() {

        firstTable.setCellValueFactory(cellData -> cellData.getValue().firstTableProperty());
        secondTable.setCellValueFactory(cellData -> cellData.getValue().firstTableProperty());
        thirdTable.setCellValueFactory(cellData -> cellData.getValue().firstTableProperty());


    //WYSWIETLANIE W TOOLTIP'IE TRESCI ZADANIA W TABELI
     toDoTable.setRowFactory(taskTableView -> new TableRow<Task>() {
            @Override
            public void updateItem(Task task, boolean empty) {
                final Tooltip tooltip = new Tooltip();
                super.updateItem(task, empty);
                if (task == null) {
                    setTooltip(null);
                } else {
                    tooltip.setText(task.getText());
                    setTooltip(tooltip);
                }
            }
        });

        progressTable.setRowFactory(taskTableView -> new TableRow<Task>() {
            @Override
            public void updateItem(Task task, boolean empty) {
                final Tooltip tooltip = new Tooltip();
                super.updateItem(task, empty);
                if (task == null) {
                    setTooltip(null);
                } else {
                    tooltip.setText(task.getText());
                    setTooltip(tooltip);
                }
            }
        });

        doneTable.setRowFactory(taskTableView -> new TableRow<Task>() {
            @Override
            public void updateItem(Task task, boolean empty) {
                final Tooltip tooltip = new Tooltip();
                super.updateItem(task, empty);
                if (task == null) {
                    setTooltip(null);
                } else {
                    tooltip.setText(task.getText());
                    setTooltip(tooltip);
                }
            }
        });


//KOLOR TŁA ZA :LOW,MEDIUM,HIGH

        firstTable.setCellFactory((TableColumn<Task, String> column) -> {
            return new TableCell<Task, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    setText(empty ? "" : getItem().toString());
                    setGraphic(null);
                    TableRow<Task> currentRow = getTableRow();

                    if (currentRow.getItem() != null ) {
                        if (currentRow.getItem().getPriority().equals("LOW")) {
                            currentRow.setStyle("-fx-background-color:green");
                        } else if (currentRow.getItem().getPriority().equals("MEDIUM")) {
                            currentRow.setStyle("-fx-background-color:yellow");
                        } else if (currentRow.getItem().getPriority().equals("HIGH")) {
                            currentRow.setStyle("-fx-background-color:red");
                        }
                    } else {currentRow.setStyle(null);}
                }
            };
        });

        secondTable.setCellFactory((TableColumn<Task, String> column) -> {
            return new TableCell<Task, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    setText(empty ? "" : getItem().toString());
                    setGraphic(null);
                    TableRow<Task> currentRow = getTableRow();

                    if (currentRow.getItem() != null ) {
                        if (currentRow.getItem().getPriority().equals("LOW")) {
                            currentRow.setStyle("-fx-background-color:green");
                        } else if (currentRow.getItem().getPriority().equals("MEDIUM")) {
                            currentRow.setStyle("-fx-background-color:yellow");
                        } else if (currentRow.getItem().getPriority().equals("HIGH")) {
                            currentRow.setStyle("-fx-background-color:red");
                        }
                    } else {currentRow.setStyle(null);}
                }
            };
        });

        thirdTable.setCellFactory((TableColumn<Task, String> column) -> {
            return new TableCell<Task, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    setText(empty ? "" : getItem().toString());
                    setGraphic(null);
                    TableRow<Task> currentRow = getTableRow();

                    if (currentRow.getItem() != null ) {
                        if (currentRow.getItem().getPriority().equals("LOW")) {
                            currentRow.setStyle("-fx-background-color:green");
                        } else if (currentRow.getItem().getPriority().equals("MEDIUM")) {
                            currentRow.setStyle("-fx-background-color:yellow");
                        } else if (currentRow.getItem().getPriority().equals("HIGH")) {
                            currentRow.setStyle("-fx-background-color:red");
                        }
                    } else {currentRow.setStyle(null);}
                }
            };
        });

    }

    public void setMain(Main main) {
        this.main = main;
        // Add observable list data to the table
        toDoTable.setItems(main.getTaskData());
    }

    // Button Add Task
    public boolean showAddTask(Task task) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AddNewTask.fxml"));
            BorderPane page = (BorderPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            //dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AddNewTaskController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setTask(task);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();


            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML private void handleNewTask(){
        Task task = new Task();
        boolean okClicked = showAddTask(task);
        if (okClicked) {
            main.getTaskData().add(task);
        }
    }

    //WYLACZANIE APLIKACJI
    public void closeApp() {
        Platform.exit();
        System.exit(0);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

}
