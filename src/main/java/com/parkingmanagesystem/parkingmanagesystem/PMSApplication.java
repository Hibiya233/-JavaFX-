package com.parkingmanagesystem.parkingmanagesystem;
import com.parkingmanagesystem.parkingmanagesystem.UI.*;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class PMSApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage = new loginInterface().stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}