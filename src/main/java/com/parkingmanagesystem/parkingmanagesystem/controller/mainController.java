package com.parkingmanagesystem.parkingmanagesystem.controller;

import com.parkingmanagesystem.parkingmanagesystem.LoadFont;
import com.parkingmanagesystem.parkingmanagesystem.sql.SQLExecutor;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class mainController {
    public AnchorPane mainScene;
    public AnchorPane sideBar;
    public Button sideBarButton;
    public GridPane dataDisplayBoard;
    public TextField parkingCardSearch;
    public TextField parkingSpaceSearch;
    public TextField recordSearch;
    public TextField receiptSearch;
    public ImageView pageIcon;
    public Text pageText;
    public Text user;
    public Text id;
    public Text todayTrafficFlow;
    public Text remainingParkingSpace;
    public Text todayRegisteredCards;
    public Text todayTotalIncome;
    public GridPane parkingSpaceFirstArea;
    public GridPane parkingSpaceSecondArea;
    public GridPane parkingSpaceThirdArea;
    public GridPane parkingSpaceFourthArea;
    public GridPane parkingSpaceFifthArea;
    public Text jinricheliuliang;
    public Text cheweishengyuliang;
    public Text jinrizhucetingchekashuliang;
    public Text jinrizongshouru;
    public AnchorPane parkingSpaceManage;
    public AnchorPane parkingCardManage;
    public AnchorPane receiptManage;
    public AnchorPane recordManage;
    public Button dataDisplayBoardButton;
    public Button parkingSpaceManageButton;
    public Button parkingCardManageButton;
    public Button receiptManageButton;
    public Button recordManageButton;
    public TableView<ObservableList> recordTable;
    public TableView<ObservableList> receiptTable;
    public TableView<ObservableList> parkingCardTable;
    public TableView<ObservableList> parkingSpaceTable;
    public AnchorPane parkingCardSearchBox;
    public Button parkingCardSearchButton;
    public ImageView parkingCardSearchButtonImage;
    public AnchorPane parkingSpaceSearchBox;
    public Button parkingSpaceSearchButton;
    public ImageView parkingSpaceSearchButtonImage;
    public AnchorPane receiptSearchBox;
    public Button receiptSearchButton;
    public ImageView receiptSearchButtonImage;
    public AnchorPane recordSearchBox;
    public Button recordSearchButton;
    public ImageView recordSearchButtonImage;
    public ChoiceBox parkingSpaceSearchChoiceBox;
    public ChoiceBox parkingCardSearchChoiceBox;
    public ChoiceBox receiptSearchChoiceBox;
    public ChoiceBox recordSearchChoiceBox;
    public Text zuixinrukucheliang;
    public Text tingchekazhuceqinkuang;
    public Text yizhucetingchekashuliang;
    public Text linqitingchekashuliang;
    public Text huoyuetingchekashuliang;
    public Text registeredParkingCardCounts;
    public Text activeParkingCardCounts;
    public Text temporaryParkingCardCounts;
    public Text churukucheliuliangtongji;
    public LineChart trafficFlowLineChart;
    public Text cheliangleixinfenbu;
    public PieChart carTypePieChart;
    public Text tingchekaleixinfenbu;
    public PieChart cardTypePieChart;
    public Text shouruqushi;
    public BarChart incomeBarChart;

    public Text dataUpdateText_1;
    public Button turnRightButton_1;
    public ImageView turnRightButtonIcon_1;
    public Button turnLeftButton_1;
    public ImageView turnLeftButtonIcon_1;
    public ImageView dataUpdateIcon_1;

    public Text dataUpdateText_2;
    public Button turnRightButton_2;
    public ImageView turnRightButtonIcon_2;
    public Button turnLeftButton_2;
    public ImageView turnLeftButtonIcon_2;
    public ImageView dataUpdateIcon_2;

    public Text dataUpdateText_3;
    public Button turnRightButton_3;
    public ImageView turnRightButtonIcon_3;
    public Button turnLeftButton_3;
    public ImageView turnLeftButtonIcon_3;
    public ImageView dataUpdateIcon_3;

    public Text dataUpdateText_4;
    public Button turnRightButton_4;
    public ImageView turnRightButtonIcon_4;
    public Button turnLeftButton_4;
    public ImageView turnLeftButtonIcon_4;
    public ImageView dataUpdateIcon_4;
    public TableView latestStorageCars;


    public void sideBarButton_MouseEntered(MouseEvent mouseEvent) {
        sideBarButton.setStyle("-fx-background-color: #FE894B;");

        sideBarButton.setOnMouseClicked(e -> {
                TranslateTransition tt = new TranslateTransition(Duration.millis(500), sideBar);
                if (sideBar.getLayoutX() < 0) {
                    tt.setFromX(sideBar.getLayoutX());
                    tt.setToX(sideBar.getLayoutX() + 252);
                    sideBar.setLayoutX(0);
                } else {
                    tt.setFromX(sideBar.getLayoutX() + 252);
                    tt.setToX(sideBar.getLayoutX());
                    sideBar.setLayoutX(- 252);
                }
                tt.play();
            }
        );
    }

    public void sideBarButton_MouseExited(MouseEvent mouseEvent) {
        sideBarButton.setStyle("-fx-background-color: #7b7784;");
    }

    public void dataDisplayBoardButton_MouseEntered(MouseEvent mouseEvent) {
        dataDisplayBoardButton.setStyle("-fx-text-fill: #fc8e1b; -fx-background-color: transparent;");


        dataDisplayBoardButton.setOnMouseClicked(e -> {
            dataDisplayBoard.setVisible(true);
            parkingSpaceManage.setVisible(false);
            parkingCardManage.setVisible(false);
            receiptManage.setVisible(false);
            recordManage.setVisible(false);

            is_runLater_running = true; // 启动runLater

            pageIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/图表.png"))));
            pageText.setText("数据展板");
        });
    }

    public void dataDisplayBoardButton_MouseExited(MouseEvent mouseEvent) {
        dataDisplayBoardButton.setStyle("-fx-text-fill: white; -fx-background-color: transparent;");
    }

    public void parkingSpaceManageButton_MouseEntered(MouseEvent mouseEvent) {
        parkingSpaceManageButton.setStyle("-fx-text-fill: #FE894B; -fx-background-color: transparent;");

        is_runLater_running = true;
        parkingSpaceManageButton.setOnMouseClicked(e -> {
            dataDisplayBoard.setVisible(false);
            parkingSpaceManage.setVisible(true);
            parkingCardManage.setVisible(false);
            receiptManage.setVisible(false);
            recordManage.setVisible(false);

            is_runLater_running = true; // 启动runLater

            pageIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/车位.png"))));
            pageText.setText("车位管理");
        });
    }

    public void parkingSpaceManageButton_MouseExited(MouseEvent mouseEvent) {
        parkingSpaceManageButton.setStyle("-fx-text-fill: white; -fx-background-color: transparent;");
    }

    public void parkingCardManageButton_MouseEntered(MouseEvent mouseEvent) {
        parkingCardManageButton.setStyle("-fx-text-fill: #FE894B; -fx-background-color: transparent;");

        is_runLater_running = true;
        parkingCardManageButton.setOnMouseClicked(e -> {
            dataDisplayBoard.setVisible(false);
            parkingSpaceManage.setVisible(false);
            parkingCardManage.setVisible(true);
            receiptManage.setVisible(false);
            recordManage.setVisible(false);

            pageIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/卡片.png"))));
            pageText.setText("停车卡管理");
        });
    }

    public void parkingCardManageButton_MouseExited(MouseEvent mouseEvent) {
        parkingCardManageButton.setStyle("-fx-text-fill: white; -fx-background-color: transparent;");
    }

    public void receiptManageButton_MouseEntered(MouseEvent mouseEvent) {
        receiptManageButton.setStyle("-fx-text-fill: #FE894B; -fx-background-color: transparent;");

        is_runLater_running = true;
        receiptManageButton.setOnMouseClicked(e -> {
            dataDisplayBoard.setVisible(false);
            parkingSpaceManage.setVisible(false);
            parkingCardManage.setVisible(false);
            receiptManage.setVisible(true);
            recordManage.setVisible(false);

            pageIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/缴费单.png"))));
            pageText.setText("缴费单管理");
        });
    }

    public void receiptManageButton_MouseExited(MouseEvent mouseEvent) {
        receiptManageButton.setStyle("-fx-text-fill: white; -fx-background-color: transparent;");
    }

    public void recordManageButton_MouseEntered(MouseEvent mouseEvent) {
        recordManageButton.setStyle("-fx-text-fill: #FE894B; -fx-background-color: transparent;");

        is_runLater_running = true;
        recordManageButton.setOnMouseClicked(e -> {
            dataDisplayBoard.setVisible(false);
            parkingSpaceManage.setVisible(false);
            parkingCardManage.setVisible(false);
            receiptManage.setVisible(false);
            recordManage.setVisible(true);


            pageIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/出入库记录.png"))));
            pageText.setText("出入记录管理");
        });
    }

    public void recordManageButton_MouseExited(MouseEvent mouseEvent) {
        recordManageButton.setStyle("-fx-text-fill: white; -fx-background-color: transparent;");
    }

    public boolean is_runLater_running = true;
    public void initialize() {
        // 设置控件的字体
        todayTrafficFlow.setFont(new LoadFont(20).font);
        todayRegisteredCards.setFont(new LoadFont(20).font);
        todayTotalIncome.setFont(new LoadFont(20).font);
        remainingParkingSpace.setFont(new LoadFont(20).font);
        user.setFont(new LoadFont(40).font);
        id.setFont(new LoadFont(16).font);
        pageText.setFont(new LoadFont(32).font);
        jinricheliuliang.setFont(new LoadFont(16).font);
        jinrizongshouru.setFont(new LoadFont(16).font);
        jinrizhucetingchekashuliang.setFont(new LoadFont(16).font);
        cheweishengyuliang.setFont(new LoadFont(16).font);
        zuixinrukucheliang.setFont(new LoadFont(18).font);
        tingchekazhuceqinkuang.setFont(new LoadFont(18).font);
        yizhucetingchekashuliang.setFont(new LoadFont(20).font);
        linqitingchekashuliang.setFont(new LoadFont(20).font);
        huoyuetingchekashuliang.setFont(new LoadFont(20).font);
        registeredParkingCardCounts.setFont(new LoadFont(20).font);
        activeParkingCardCounts.setFont(new LoadFont(20).font);
        temporaryParkingCardCounts.setFont(new LoadFont(20).font);
        churukucheliuliangtongji.setFont(new LoadFont(18).font);
        cheliangleixinfenbu.setFont(new LoadFont(18).font);
        tingchekaleixinfenbu.setFont(new LoadFont(18).font);
        shouruqushi.setFont(new LoadFont(18).font);

        // 修改车位状态图的字体
        for(int i = 0; i < 80; i++) {
            AnchorPane pane = (AnchorPane) parkingSpaceFirstArea.getChildrenUnmodifiable().get(i);
            Node rec = pane.getChildren().get(0);
            Node text = pane.getChildren().get(1);
            ((Text) text).setFont(new LoadFont(14).font);
            ((Text) text).setText(String.format("%d",i+1));
            if(i >= 10) {
                text.setLayoutX(22);
            }
            else {
                text.setLayoutX(26);
            }
            rec.setStyle("-fx-fill: #4bff87;");

            pane = (AnchorPane) parkingSpaceSecondArea.getChildrenUnmodifiable().get(i);
            rec = pane.getChildren().get(0);
            text = pane.getChildren().get(1);
            ((Text) text).setFont(new LoadFont(14).font);
            ((Text) text).setText(String.format("%d",i+81));
            if(i+80 >= 100) {
                text.setLayoutX(18);
            }
            else {
                text.setLayoutX(22);
            }
            rec.setStyle("-fx-fill: #4bff87;");

            pane = (AnchorPane) parkingSpaceThirdArea.getChildrenUnmodifiable().get(i);
            rec = pane.getChildren().get(0);
            text = pane.getChildren().get(1);
            ((Text) text).setFont(new LoadFont(14).font);
            ((Text) text).setText(String.format("%d",i+161));
            text.setLayoutX(18);
            rec.setStyle("-fx-fill: #4bff87;");

            pane = (AnchorPane) parkingSpaceFourthArea.getChildrenUnmodifiable().get(i);
            rec = pane.getChildren().get(0);
            text = pane.getChildren().get(1);
            ((Text) text).setFont(new LoadFont(14).font);
            ((Text) text).setText(String.format("%d",i+241));
            text.setLayoutX(18);
            rec.setStyle("-fx-fill: #4bff87;");

            pane = (AnchorPane) parkingSpaceFifthArea.getChildrenUnmodifiable().get(i);
            rec = pane.getChildren().get(0);
            text = pane.getChildren().get(1);
            ((Text) text).setFont(new LoadFont(14).font);
            ((Text) text).setText(String.format("%d",i+321));
            text.setLayoutX(18);
            rec.setStyle("-fx-fill: #4bff87;");
        }

        Thread thread = new Thread(() -> {
            while(true) {
                try {
                    String sql;
                    ResultSet ret;
                    SQLExecutor auth = new SQLExecutor(); // 连接数据库

                    // 这里面的代码执行在Application线程上
                    if(is_runLater_running) {
                        // 更新状态提示（更新中）
                        dataUpdateIcon_1.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/更新中.png"))));
                        dataUpdateIcon_2.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/更新中.png"))));
                        dataUpdateIcon_3.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/更新中.png"))));
                        dataUpdateIcon_4.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/更新中.png"))));
                        dataUpdateText_1.setText("数据正在持续更新");
                        dataUpdateText_2.setText("数据正在持续更新");
                        dataUpdateText_3.setText("数据正在持续更新");
                        dataUpdateText_4.setText("数据正在持续更新");

                        Platform.runLater(() -> {
                            try {
                                String Sql;
                                ResultSet Ret;
                                SQLExecutor Auth = new SQLExecutor(); // 连接数据库

                                // 更新数据展板的表格和数据
                                if(dataDisplayBoard.isVisible()) {
                                    ObservableList data = FXCollections.observableArrayList(); // 创建数据集
                                    // 车辆类型分布（饼图）
                                    Sql = "SELECT `车辆类型`, COUNT(`车辆类型`) AS 数量 FROM `车辆` GROUP BY `车辆类型`;";
                                    Ret = Auth.query(Sql);
                                    while(Ret.next()) {
                                        data.add(new PieChart.Data(Ret.getString(1),Ret.getInt(2)));
                                    }
                                    carTypePieChart.setData(data);


                                    // 停车卡类型分布（饼图）
                                    Sql = "SELECT `停车卡类型`,COUNT(`停车卡类型`) AS `数量` FROM `停车卡` GROUP BY `停车卡类型`;";
                                    Ret = Auth.query(Sql);
                                    data = FXCollections.observableArrayList(); // 创建数据集
                                    while(Ret.next()) {
                                        data.add(new PieChart.Data(Ret.getString(1),Ret.getInt(2)));
                                    }
                                    cardTypePieChart.setData(data);

                                    // 出入库车流量统计（折线图）
                                    Sql = "SELECT DATE(`出库时间`) AS `出库日期`,COUNT(DATE(`出库时间`)) AS `车流量` FROM `缴费单` WHERE DATE_SUB(CURDATE(), INTERVAL 6 DAY) <= DATE(`出库时间`) GROUP BY DATE(`出库时间`);";
                                    Ret = Auth.query(Sql);
                                    ObservableList<XYChart.Series> XYData = FXCollections.observableArrayList();
                                    XYChart.Series series = new XYChart.Series();
                                    while(Ret.next()) {
                                        series.getData().add(new XYChart.Data(Ret.getString(1),Ret.getInt(2)));
                                    }
                                    XYData.add(series);
                                    trafficFlowLineChart.setData(XYData);


                                    // 收入趋势（柱状图）
                                    Sql = "SELECT DATE(`出库时间`) AS `缴费日期`,SUM(`费用`) AS `收入` FROM `缴费单` WHERE DATE_SUB(CURDATE(), INTERVAL 6 DAY) <= DATE(`出库时间`) GROUP BY `缴费日期`;";
                                    Ret = Auth.query(Sql);
                                    XYData = FXCollections.observableArrayList();
                                    series = new XYChart.Series();
                                    while(Ret.next()) {
                                        series.getData().add(new XYChart.Data(Ret.getString(1),Ret.getInt(2)));
                                    }
                                    XYData.add(series);
                                    incomeBarChart.setData(XYData);

                                    // 停车卡注册情况
                                    // 已注册停车卡数量
                                    Sql = "SELECT COUNT(`停车卡编号`) AS `已注册停车卡数量` FROM `停车卡`;";
                                    Ret = Auth.query(Sql);
                                    while(Ret.next()) {
                                        registeredParkingCardCounts.setText(Ret.getString(1));
                                    }

                                    // 活跃停车卡数量
                                    Sql = "SELECT COUNT(`停车卡编号`) AS `活跃停车卡数量` FROM `停车卡` WHERE `有效情况` = '有效';";
                                    Ret = Auth.query(Sql);
                                    while(Ret.next()) {
                                        activeParkingCardCounts.setText(Ret.getString(1));
                                    }

                                    // 临期停车卡数量
                                    Sql = "SELECT COUNT(`停车卡编号`) AS `临期停车卡数量` FROM `停车卡` WHERE CURDATE() = DATE(`过期时间`) - 1;";
                                    Ret = Auth.query(Sql);
                                    while(Ret.next()) {
                                        temporaryParkingCardCounts.setText(Ret.getString(1));
                                    }

                                    // 最新入库车辆
                                    Sql = "SELECT `车牌编号`,`进入时间` AS `入库时间` FROM `出入` LIMIT 10;";
                                    Ret = Auth.query(Sql);
                                    ObservableList<ObservableList> latestData = FXCollections.observableArrayList();
                                    if(latestStorageCars.getColumns().isEmpty()) {
                                        for (int i = 0; i < Ret.getMetaData().getColumnCount(); i++) {
                                            final int j = i;
                                            TableColumn col = new TableColumn(Ret.getMetaData().getColumnName(i + 1));
                                            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                                                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                                                    return new SimpleStringProperty(param.getValue().get(j).toString());
                                                }
                                            });
                                            latestStorageCars.getColumns().addAll(col);
                                        }
                                    }
                                    while(Ret.next()) {
                                        ObservableList<Object> row = FXCollections.observableArrayList();
                                        for(int i = 1;i <= Ret.getMetaData().getColumnCount(); i++) {
                                            row.add(Ret.getString(i));
                                        }
                                        latestData.add(row);
                                    }
                                    latestStorageCars.setItems( latestData);
                                }

                                // 更新”车位管理“表格
                                if(parkingSpaceManage.isVisible()) {
                                    int first = 1;
                                    int end = 50;
                                    Sql = String.format("SELECT * FROM `车位` WHERE `车位编号` >= '%d' AND `车位编号` <= '%d';",first,end);
                                    Ret = Auth.query(Sql);
                                    ObservableList<ObservableList> data = FXCollections.observableArrayList();
                                    if(parkingSpaceTable.getColumns().isEmpty()) {
                                        for (int i = 0; i < Ret.getMetaData().getColumnCount(); i++) {
                                            final int j = i;
                                            TableColumn col = new TableColumn(Ret.getMetaData().getColumnName(i + 1));
                                            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                                                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                                                    return new SimpleStringProperty(param.getValue().get(j).toString());
                                                }
                                            });
                                            parkingSpaceTable.getColumns().addAll(col);
                                        }
                                    }
                                    while(Ret.next()) {
                                        ObservableList<Object> row = FXCollections.observableArrayList();
                                        for(int i = 1;i <= Ret.getMetaData().getColumnCount(); i++) {
                                            row.add(Ret.getString(i));
                                        }
                                        data.add(row);
                                    }
                                    parkingSpaceTable.setItems(data);
                                }

                                // 更新”停车卡管理“表格
                                if(parkingCardManage.isVisible()) {
                                    int first = 1;
                                    int end = 50;
                                    Sql = String.format("SELECT * FROM `停车卡` WHERE `停车卡编号` >= '%d' AND `停车卡编号` <= '%d';",10000+first,10000+end);
                                    Ret = Auth.query(Sql);
                                    if(parkingCardTable.getColumns().isEmpty()) {
                                        for (int i = 0; i < Ret.getMetaData().getColumnCount(); i++) {
                                            final int j = i;
                                            TableColumn col = new TableColumn(Ret.getMetaData().getColumnName(i + 1));
                                            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                                                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                                                    return new SimpleStringProperty(param.getValue().get(j).toString());
                                                }
                                            });
                                            parkingCardTable.getColumns().addAll(col);
                                        }
                                    }
                                    ObservableList<ObservableList> data = FXCollections.observableArrayList();
                                    while(Ret.next()) {
                                        ObservableList<Object> row = FXCollections.observableArrayList();
                                        for(int i = 1;i <= Ret.getMetaData().getColumnCount(); i++) {
                                            row.add(Ret.getString(i));
                                        }
                                        data.add(row);
                                    }
                                    parkingCardTable.setItems(data);
                                }

                                // 更新”缴费单管理“表格
                                if(receiptManage.isVisible()) {
//                                int first = 1;
//                                int end = 50;
                                    Sql = "SELECT * FROM `缴费单` LIMIT 50;";
                                    Ret = Auth.query(Sql);
                                    if(receiptTable.getColumns().isEmpty()) {
                                        for (int i = 0; i < Ret.getMetaData().getColumnCount(); i++) {
                                            final int j = i;
                                            TableColumn col = new TableColumn(Ret.getMetaData().getColumnName(i + 1));
                                            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                                                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                                                    return new SimpleStringProperty(param.getValue().get(j).toString());
                                                }
                                            });
                                            receiptTable.getColumns().addAll(col);
                                        }
                                    }
                                    ObservableList<ObservableList> data = FXCollections.observableArrayList();
                                    while(Ret.next()) {
                                        ObservableList<Object> row = FXCollections.observableArrayList();
                                        for(int i = 1;i <= Ret.getMetaData().getColumnCount(); i++) {
                                            row.add(Ret.getString(i));
                                        }
                                        data.add(row);
                                    }
                                    receiptTable.setItems(data);
                                }

                                // 更新”出入记录管理“表格
                                if(recordManage.isVisible()) {
//                                int first = 1;
//                                int end = 50;
                                    Sql = "SELECT * FROM `出入` LIMIT 50;";
                                    Ret = Auth.query(Sql);
                                    if(recordTable.getColumns().isEmpty()) {
                                        for (int i = 0; i < Ret.getMetaData().getColumnCount(); i++) {
                                            final int j = i;
                                            TableColumn col = new TableColumn(Ret.getMetaData().getColumnName(i + 1));
                                            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                                                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                                                    return new SimpleStringProperty(param.getValue().get(j).toString());
                                                }
                                            });
                                            recordTable.getColumns().addAll(col);
                                        }
                                    }
                                    ObservableList<ObservableList> data = FXCollections.observableArrayList();
                                    while(Ret.next()) {
                                        ObservableList<Object> row = FXCollections.observableArrayList();
                                        for(int i = 1;i <= Ret.getMetaData().getColumnCount(); i++) {
                                            row.add(Ret.getString(i));
                                        }
                                        data.add(row);
                                    }
                                    recordTable.setItems(data);
                                }
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    } else {
                        // 更新状态提示（停止更新）
                        dataUpdateIcon_1.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/停止更新.png"))));
                        dataUpdateIcon_2.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/停止更新.png"))));
                        dataUpdateIcon_3.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/停止更新.png"))));
                        dataUpdateIcon_4.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/停止更新.png"))));
                        dataUpdateText_1.setText("更新停止！");
                        dataUpdateText_2.setText("更新停止！");
                        dataUpdateText_3.setText("更新停止！");
                        dataUpdateText_4.setText("更新停止！");
                    }

                    // 更新今日总收入
                    sql = "SELECT SUM(`费用`) AS `今日总收入` FROM `缴费单` WHERE `出库时间` LIKE CONCAT(CURDATE(),' %');";
                    ret = auth.query(sql); // 执行sql语句
                    if(ret.next()) {
                        if(ret.getString(1) == null) {
                            todayTotalIncome.setText("0");
                        }
                        else {
                            todayTotalIncome.setText(ret.getString(1));
                        }
                    }

                    // 更新今日注册停车卡数量
                    sql = "SELECT COUNT(`取卡时间`) AS `今日注册停车卡数量` FROM `停车卡` WHERE `取卡时间` LIKE CONCAT(CURDATE(), ' %');";
                    ret = auth.query(sql);
                    if(ret.next()) {
                        if(ret.getString(1) == null) {
                            todayRegisteredCards.setText("0");
                        }
                        else {
                            todayRegisteredCards.setText(ret.getString(1));
                        }
                    }

                    // 更新车位剩余量
                    sql = "SELECT COUNT(`车位编号`) AS `车位剩余量` FROM `车位` WHERE `停放情况` = '空闲';";
                    ret = auth.query(sql);
                    if(ret.next()) {
                        remainingParkingSpace.setText(ret.getString(1) + "/400");
                    }

                    // 更新今日车流量
                    sql = "SELECT COUNT(`缴费单编号`) AS `今日车流量` FROM `缴费单` WHERE `出库时间` LIKE CONCAT(CURDATE(),' %');";
                    ret = auth.query(sql);
                    if(ret.next()) {
                        if(ret.getString(1) == null) {
                            todayTrafficFlow.setText("0");
                        }
                        else {
                            todayTrafficFlow.setText(ret.getString(1));
                        }
                    }

                    // 更新车位状态图
                    sql = "SELECT `车位编号`,`停放情况` FROM `车位` GROUP BY `车位编号`;";
                    ret = auth.query(sql);
                    while(ret.next()) {
                        if(ret.getInt(1) >= 1 && ret.getInt(1) <= 80) {
                            AnchorPane pane = (AnchorPane) parkingSpaceFirstArea.getChildrenUnmodifiable().get(ret.getInt(1)-1);
                            Node rec = pane.getChildren().get(0);
                            Node text = pane.getChildren().get(1);
                            if(ret.getString(2).equals("占用")) {
                                rec.setStyle("-fx-fill: #EC381C;");
                                text.setStyle("-fx-fill: white;");
                            }
                            else {
                                rec.setStyle("-fx-fill: #4bff87;");
                                text.setStyle("-fx-fill: black;");
                            }

                        }
                        else if(ret.getInt(1) >= 81 && ret.getInt(1) <= 160) {
                            AnchorPane pane = (AnchorPane) parkingSpaceSecondArea.getChildrenUnmodifiable().get(ret.getInt(1)-81);
                            Node rec = pane.getChildren().get(0);
                            Node text = pane.getChildren().get(1);
                            if(ret.getString(2).equals("占用")) {
                                rec.setStyle("-fx-fill: #EC381C;");
                                text.setStyle("-fx-fill: white;");
                            }
                            else {
                                rec.setStyle("-fx-fill: #4bff87;");
                                text.setStyle("-fx-fill: black;");
                            }
                        }
                        else if(ret.getInt(1) >= 161 && ret.getInt(1) <= 240) {
                            AnchorPane pane = (AnchorPane) parkingSpaceThirdArea.getChildrenUnmodifiable().get(ret.getInt(1)-161);
                            Node rec = pane.getChildren().get(0);
                            Node text = pane.getChildren().get(1);
                            if(ret.getString(2).equals("占用")) {
                                rec.setStyle("-fx-fill: #EC381C;");
                                text.setStyle("-fx-fill: white;");
                            }
                            else {
                                rec.setStyle("-fx-fill: #4bff87;");
                                text.setStyle("-fx-fill: black;");
                            }
                        }
                        else if(ret.getInt(1) >= 241 && ret.getInt(1) <= 320) {
                            AnchorPane pane = (AnchorPane) parkingSpaceFourthArea.getChildrenUnmodifiable().get(ret.getInt(1)-241);
                            Node rec = pane.getChildren().get(0);
                            Node text = pane.getChildren().get(1);
                            if(ret.getString(2).equals("占用")) {
                                rec.setStyle("-fx-fill: #EC381C;");
                                text.setStyle("-fx-fill: white;");
                            }
                            else {
                                rec.setStyle("-fx-fill: #4bff87;");
                                text.setStyle("-fx-fill: black;");
                            }
                        }
                        else if(ret.getInt(1) >= 321 && ret.getInt(1) <= 400) {
                            AnchorPane pane = (AnchorPane) parkingSpaceFifthArea.getChildrenUnmodifiable().get(ret.getInt(1)-321);
                            Node rec = pane.getChildren().get(0);
                            Node text = pane.getChildren().get(1);
                            if(ret.getString(2).equals("占用")) {
                                rec.setStyle("-fx-fill: #EC381C;");
                                text.setStyle("-fx-fill: white;");
                            }
                            else {
                                rec.setStyle("-fx-fill: #4bff87;");
                                text.setStyle("-fx-fill: black;");
                            }
                        }
                    }

                    // 定时3s后继续循环
                    Thread.sleep(1000L);

                    // 当主界面被关闭时，结束循环，即可结束线程
                    Stage stage = (Stage) mainScene.getScene().getWindow();
                    if(!stage.isShowing()) {
                        break;
                    }
                } catch (SQLException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();
    }

    public int parkingCardSearchChoiceBoxStoragedCounts = 0;
    public void parkingCardSearchButton_MouseEntered(MouseEvent mouseEvent) {
        parkingCardSearchButtonImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/向左-悬停.png"))));

        parkingCardSearchButton.setOnMouseClicked(e -> {
            RotateTransition rt = new RotateTransition(Duration.millis(600L),parkingCardSearchButtonImage);
            rt.setByAngle(180);
            rt.setCycleCount(1);
            rt.setAutoReverse(true);
            TranslateTransition tt = new TranslateTransition(Duration.millis(500L),parkingCardSearchBox);
            if(parkingCardSearchChoiceBoxStoragedCounts == 0) {
                parkingCardSearchChoiceBoxStoragedCounts = 1;
                tt.setByX(-100.0);
            }
            else {
                parkingCardSearchChoiceBoxStoragedCounts = 0;
                tt.setByX(100.0);
            }
            ParallelTransition pt = new ParallelTransition();
            pt.getChildren().addAll(rt,tt);
            pt.play();
        });
    }

    public void parkingCardSearchButton_MouseExited(MouseEvent mouseEvent) {
        parkingCardSearchButtonImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/向左.png"))));
    }

    public int parkingSpaceSearchChoiceBoxStoragedCounts = 0;
    public void parkingSpaceSearchButton_MouseEntered(MouseEvent mouseEvent) {
        parkingSpaceSearchButtonImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/向左-悬停.png"))));

        parkingSpaceSearchButton.setOnMouseClicked(e -> {
            RotateTransition rt = new RotateTransition(Duration.millis(600L),parkingSpaceSearchButtonImage);
            rt.setByAngle(180);
            rt.setCycleCount(1);
            rt.setAutoReverse(true);
            TranslateTransition tt = new TranslateTransition(Duration.millis(500L),parkingSpaceSearchBox);
            if(parkingSpaceSearchChoiceBoxStoragedCounts == 0) {
                parkingSpaceSearchChoiceBoxStoragedCounts = 1;
                tt.setByX(-100.0);
            }
            else {
                parkingSpaceSearchChoiceBoxStoragedCounts = 0;
                tt.setByX(100.0);
            }
            ParallelTransition pt = new ParallelTransition();
            pt.getChildren().addAll(rt,tt);
            pt.play();
        });
    }

    public void parkingSpaceSearchButton_MouseExited(MouseEvent mouseEvent) {
        parkingSpaceSearchButtonImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/向左.png"))));
    }

    public int receiptSearchChoiceBoxStoragedCounts = 0;
    public void receiptSearchButton_MouseEntered(MouseEvent mouseEvent) {
        receiptSearchButtonImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/向左-悬停.png"))));

        receiptSearchButton.setOnMouseClicked(e -> {
            RotateTransition rt = new RotateTransition(Duration.millis(600L),receiptSearchButtonImage);
            rt.setByAngle(180);
            rt.setCycleCount(1);
            rt.setAutoReverse(true);
            TranslateTransition tt = new TranslateTransition(Duration.millis(500L),receiptSearchBox);
            if(receiptSearchChoiceBoxStoragedCounts == 0) {
                receiptSearchChoiceBoxStoragedCounts = 1;
                tt.setByX(-100.0);
            }
            else {
                receiptSearchChoiceBoxStoragedCounts = 0;
                tt.setByX(100.0);
            }
            ParallelTransition pt = new ParallelTransition();
            pt.getChildren().addAll(rt,tt);
            pt.play();
        });
    }

    public void receiptSearchButton_MouseExited(MouseEvent mouseEvent) {
        receiptSearchButtonImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/向左.png"))));
    }

    public int recordSearchChoiceBoxStoragedCounts = 0;
    public void recordSearchButton_MouseEntered(MouseEvent mouseEvent) {
        recordSearchButtonImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/向左-悬停.png"))));

        recordSearchButton.setOnMouseClicked(e -> {
            RotateTransition rt = new RotateTransition(Duration.millis(600L),recordSearchButtonImage);
            rt.setByAngle(180);
            rt.setCycleCount(1);
            rt.setAutoReverse(true);
            TranslateTransition tt = new TranslateTransition(Duration.millis(500L),recordSearchBox);
            if(recordSearchChoiceBoxStoragedCounts == 0) {
                recordSearchChoiceBoxStoragedCounts = 1;
                tt.setByX(-100.0);
            }
            else {
                recordSearchChoiceBoxStoragedCounts = 0;
                tt.setByX(100.0);
            }
            ParallelTransition pt = new ParallelTransition();
            pt.getChildren().addAll(rt,tt);
            pt.play();
        });
    }

    public void recordSearchButton_MouseExited(MouseEvent mouseEvent) {
        recordSearchButtonImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/parkingmanagesystem/parkingmanagesystem/img/mainInterface/向左.png"))));
    }

    public void parkingSpaceSearch_KeyPressed(KeyEvent keyEvent) throws SQLException {
        if(keyEvent.getCode().equals(KeyCode.ENTER)) {
            String sql;
            if(Objects.equals(parkingSpaceSearch.getText(), "")) {
                    sql = "SELECT * FROM `车位` LIMIT 50;";
            }
            else {
                sql = String.format("SELECT * FROM `车位` WHERE `%s` = '%s'",
                        parkingSpaceSearchChoiceBox.getValue().toString(),
                        parkingSpaceSearch.getText());
            }
            ResultSet ret;
            SQLExecutor search = new SQLExecutor();
            ret = search.query(sql);
            is_runLater_running = false; // 关闭runLater更新
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            while(ret.next()) {
                ObservableList<Object> row = FXCollections.observableArrayList();
                for(int i = 1;i <= ret.getMetaData().getColumnCount(); i++) {
                    row.add(ret.getString(i));
                }
                data.add(row);
            }
            parkingSpaceTable.setItems(data);
        }
    }

    public void parkingCardSearch_KeyPressed(KeyEvent keyEvent) throws SQLException {
        if(keyEvent.getCode().equals(KeyCode.ENTER)) {
            String sql;
            if(Objects.equals(parkingCardSearch.getText(), "")) {
                sql = "SELECT * FROM `停车卡` LIMIT 50;";
            }
            else {
                sql = String.format("SELECT * FROM `停车卡` WHERE `%s` = '%s'",
                        parkingCardSearchChoiceBox.getValue().toString(),
                        parkingCardSearch.getText());
            }
            ResultSet ret;
            SQLExecutor search = new SQLExecutor();
            ret = search.query(sql);
            is_runLater_running = false; // 关闭runLater更新
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            while(ret.next()) {
                ObservableList<Object> row = FXCollections.observableArrayList();
                for(int i = 1;i <= ret.getMetaData().getColumnCount(); i++) {
                    row.add(ret.getString(i));
                }
                data.add(row);
            }
            parkingCardTable.setItems(data);
        }
    }

    public void receiptSearch_KeyPressed(KeyEvent keyEvent) throws SQLException {
        if(keyEvent.getCode().equals(KeyCode.ENTER)) {
            String sql;
            if(Objects.equals(receiptSearch.getText(), "")) {
                sql = "SELECT * FROM `缴费单` LIMIT 50;";
            }
            else {
                sql = String.format("SELECT * FROM `缴费单` WHERE `%s` = '%s'",
                        receiptSearchChoiceBox.getValue().toString(),
                        receiptSearch.getText());
            }
            ResultSet ret;
            SQLExecutor search = new SQLExecutor();
            ret = search.query(sql);
            is_runLater_running = false; // 关闭runLater更新
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            while(ret.next()) {
                ObservableList<Object> row = FXCollections.observableArrayList();
                for(int i = 1;i <= ret.getMetaData().getColumnCount(); i++) {
                    row.add(ret.getString(i));
                }
                data.add(row);
            }
            receiptTable.setItems(data);
        }
    }

    public void recordSearch_KeyPressed(KeyEvent keyEvent) throws SQLException {
        if(keyEvent.getCode().equals(KeyCode.ENTER)) {
            String sql;
            if(Objects.equals(recordSearch.getText(), "")) {
                sql = "SELECT * FROM `出入` LIMIT 50;";
            }
            else {
                sql = String.format("SELECT * FROM `出入` WHERE `%s` = '%s'",
                        recordSearchChoiceBox.getValue().toString(),
                        recordSearch.getText());
            }
            ResultSet ret;
            SQLExecutor search = new SQLExecutor();
            ret = search.query(sql);
            is_runLater_running = false; // 关闭runLater更新
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            while(ret.next()) {
                ObservableList<Object> row = FXCollections.observableArrayList();
                for(int i = 1;i <= ret.getMetaData().getColumnCount(); i++) {
                    row.add(ret.getString(i));
                }
                data.add(row);
            }
            recordTable.setItems(data);
        }
    }
}