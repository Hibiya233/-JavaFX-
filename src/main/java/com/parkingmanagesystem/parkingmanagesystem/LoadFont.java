package com.parkingmanagesystem.parkingmanagesystem;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Objects;

public class LoadFont {
    public Font font;

    public LoadFont(double size) {
        font = Font.loadFont(Objects.requireNonNull(PMSApplication.class.getResource("font/AlimamaShuHeiTi-Bold.ttf")).toExternalForm(), size);
    }
}
