module com.parkingmanagesystem.parkingmanagesystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires mysql.connector.java;

    opens com.parkingmanagesystem.parkingmanagesystem to javafx.fxml;
    exports com.parkingmanagesystem.parkingmanagesystem;
    exports com.parkingmanagesystem.parkingmanagesystem.controller;
    opens com.parkingmanagesystem.parkingmanagesystem.controller to javafx.fxml;
}