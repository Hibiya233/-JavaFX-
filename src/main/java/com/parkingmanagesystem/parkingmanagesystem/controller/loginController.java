package com.parkingmanagesystem.parkingmanagesystem.controller;

import com.parkingmanagesystem.parkingmanagesystem.LoadFont;
import com.parkingmanagesystem.parkingmanagesystem.UI.mainInterface;
import com.parkingmanagesystem.parkingmanagesystem.sql.SQLExecutor;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginController {
    public Label title;
    @FXML
    private Label dengluzhanghao;
    @FXML
    private HBox passwordBox;
    @FXML
    private HBox usernameBox;
    @FXML
    private Rectangle leftBackground;
    @FXML
    private Rectangle upStripes;
    @FXML
    private Button loginButton;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ImageView logo;
    @FXML
    private Button minWindowButton;
    @FXML
    private Button closeWindowButton;

    public void closeWindowButton_MouseEntered(MouseEvent mouseEvent) {
        closeWindowButton.setStyle("-fx-background-color: #f2370b; -fx-text-fill: #f2d5d5;");

        closeWindowButton.setOnAction(event -> System.exit(0));
    }

    public void closeWindowButton_MouseExited(MouseEvent mouseEvent) {
        closeWindowButton.setStyle("-fx-background-color: transparent;");
    }

    public void minWindowButton_MouseEntered(MouseEvent mouseEvent) {
        minWindowButton.setStyle("-fx-background-color: #bec0b6;");

        minWindowButton.setOnAction(event -> {
            Stage stage = (Stage) minWindowButton.getScene().getWindow();
            stage.setIconified(true);
        });
    }

    public void minWindowButton_MouseExited(MouseEvent mouseEvent) {
        minWindowButton.setStyle("-fx-background-color: transparent;");
    }

    public void logo_MouseEntered(MouseEvent mouseEvent) {
        // 添加动画
        ScaleTransition st = new ScaleTransition(Duration.millis(100), logo);
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(1.1);
        st.setToY(1.1);
        st.play();
    }

    public void logo_MouseExited(MouseEvent mouseEvent) {
        // 添加动画
        ScaleTransition st = new ScaleTransition(Duration.millis(200), logo);
        st.setFromX(1.1);
        st.setFromY(1.1);
        st.setToX(1);
        st.setToY(1);
        st.play();
    }

    @FXML
    public void loginButton_MouseEntered(MouseEvent mouseEvent) {
        // 添加动画
        ScaleTransition st = new ScaleTransition(Duration.millis(100), loginButton);
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(1.03);
        st.setToY(1.03);
        st.play();

        loginButton.setOnMouseClicked(e -> {
            String Username = username.getText();
            String Password = password.getText();

            String queryStr = String.format("SELECT * FROM `操作员` WHERE `账号` = '%s' AND `密码` = '%s';",Username,Password);

            SQLExecutor auth = new SQLExecutor(); // 连接数据库
            ResultSet ret = auth.query(queryStr); // 执行sql语句

            try {
                // 验证成功则打开主界面
                if(ret.next()) {
                    Stage loginStage = (Stage) loginButton.getScene().getWindow();
                    loginStage.close();

                    // 修改主界面的个人信息
                    mainInterface mainStage = new mainInterface();
                    GridPane gridpane = (GridPane) mainStage.scene.getRoot().getChildrenUnmodifiable().get(2);
                    AnchorPane anchorpane = (AnchorPane) gridpane.getChildrenUnmodifiable().get(1);
                    Text user = (Text) anchorpane.getChildren().get(2);
                    user.setText(ret.getString(3));
                    Text id = (Text) anchorpane.getChildren().get(3);
                    id.setText("操作员编号：" + ret.getString(1));
                    mainStage.stage.show();
                }
            } catch (IOException | SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void loginButton_MouseExited(MouseEvent mouseEvent) {
        // 添加动画
        ScaleTransition st = new ScaleTransition(Duration.millis(200), loginButton);
        st.setFromX(1.03);
        st.setFromY(1.03);
        st.setToX(1);
        st.setToY(1);
        st.play();
    }

    public void username_MouseEntered(MouseEvent mouseEvent) {
        // 添加动画
        ScaleTransition st = new ScaleTransition(Duration.millis(100), username);
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(0.95);
        st.setToY(0.80);
        st.play();

        username.setStyle("-fx-background-color: #eef1e4");
    }

    public void username_MouseExited(MouseEvent mouseEvent) {

    }

    public void password_MouseEntered(MouseEvent mouseEvent) {
        // 添加动画
        ScaleTransition st = new ScaleTransition(Duration.millis(100), password);
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(0.95);
        st.setToY(0.80);
        st.play();

        password.setStyle("-fx-background-color: #eef1e4; transform: all 0.5s;");
    }

    public void password_MouseExited(MouseEvent mouseEvent) {

    }

    public void usernameBox_MouseExited(MouseEvent mouseEvent) {
        // 添加动画
        ScaleTransition st = new ScaleTransition(Duration.millis(200), username);
        st.setFromX(0.95);
        st.setFromY(0.80);
        st.setToX(1);
        st.setToY(1);
        st.play();

        username.setStyle("-fx-background-color: transparent");
    }

    public void passwordBox_MouseExited(MouseEvent mouseEvent) {
        // 添加动画
        ScaleTransition st = new ScaleTransition(Duration.millis(200), password);
        st.setFromX(0.95);
        st.setFromY(0.80);
        st.setToX(1);
        st.setToY(1);
        st.play();

        password.setStyle("-fx-background-color: transparent");
    }

    public void initialize() {
        // 设置控件的字体
        title.setFont(new LoadFont(24).font);
        username.setFont(new LoadFont(14).font);
        dengluzhanghao.setFont(new LoadFont(36).font);
    }
}