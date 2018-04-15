package sample;

import javafx.scene.control.Alert;

public class Dialogs {

    public static void dialogAboutTask(){
        Alert informationAlert=new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("Information about author");
        informationAlert.setHeaderText("Urszula Slusarz");
        informationAlert.showAndWait();
    }
}
