package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {


    private ObservableList<Task> taskData = FXCollections.observableArrayList();
    public ObservableList<Task> getTaskData() {
        return taskData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{ showMainview(); }

    //WYSWIETLANIE GLOWNEGO EKRANU
    private void showMainview() throws IOException {
         FXMLLoader loader=new FXMLLoader();
         loader.setLocation(Main.class.getResource("sample.fxml"));
         BorderPane mainLayout=loader.load();

         Scene scene=new Scene(mainLayout);
         Stage primaryStage=new Stage();
         primaryStage.setScene(scene);
         primaryStage.setTitle("Kanban");

        Controller controller = loader.getController();
        controller.setMain(this);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
