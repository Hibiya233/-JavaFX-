package com.parkingmanagesystem.parkingmanagesystem.UI;

import com.parkingmanagesystem.parkingmanagesystem.PMSApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class loginInterface {
    public Stage stage;

    private double oldStageX;
    private double oldStageY;
    private double oldScreenX;
    private double oldScreenY;

    public loginInterface() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PMSApplication.class.getResource("fxml/loginInterface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 480);
        stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image("D:\\大一（下）资料汇总\\java期末项目\\ParkingManageSystem\\src\\main\\resources\\com\\parkingmanagesystem\\parkingmanagesystem\\img\\icon.png"));
        stage.setTitle("司舆");
        stage.setScene(scene);

        // 鼠标按下
        scene.setOnMousePressed(event -> {
            oldStageX = stage.getX();
            oldStageY = stage.getY();
            oldScreenX = event.getScreenX();
            oldScreenY = event.getScreenY();
        });

        //鼠标拖拽
        scene.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - oldScreenX + oldStageX);
            stage.setY(event.getScreenY() - oldScreenY + oldStageY);
        });
    }
}
