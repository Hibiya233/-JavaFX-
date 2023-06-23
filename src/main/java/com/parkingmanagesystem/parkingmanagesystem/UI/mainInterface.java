package com.parkingmanagesystem.parkingmanagesystem.UI;

import com.parkingmanagesystem.parkingmanagesystem.PMSApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class mainInterface {
    public Stage stage;

    public Scene scene;

    public mainInterface() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PMSApplication.class.getResource("fxml/mainInterface.fxml"));
        this.scene = new Scene(fxmlLoader.load(), 1280, 720);
        this.stage = new Stage();
        this.stage.getIcons().add(new Image(Objects.requireNonNull(PMSApplication.class.getResource("img/icon.png")).toExternalForm()));
        this.stage.setTitle("司舆");
        this.stage.setScene(scene);
    }
}
