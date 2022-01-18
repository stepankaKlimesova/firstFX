package com.example.firstfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private ComboBox<String> inputBox;

    @FXML
    private ComboBox<String> outputBox;

    @FXML
    private TextField userInput;

    @FXML
    private TextField userOutput;

    @FXML
    private Button convert;

    @FXML
    protected void onHelloButtonClick() {
        convert();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputBox.getItems().add("m");
        inputBox.getItems().add("dm");
        inputBox.getItems().add("cm");

        outputBox.getItems().add("m");
        outputBox.getItems().add("dm");
        outputBox.getItems().add("cm");

    }

    protected void convert() {
        double unit = Double.parseDouble(userInput.getText());

        switch (inputBox.getSelectionModel().getSelectedItem()) {
            case "cm" -> {
                switch (outputBox.getSelectionModel().getSelectedItem()) {
                    case "m" -> unit *= 0.01;

                    case "dm" -> unit *= 0.1;
                }
            }
            case "dm" -> {
                switch (outputBox.getSelectionModel().getSelectedItem()) {
                    case "m" -> unit *= 0.1;

                    case "cm" -> unit *= 10;
                }
            }
            case "m" -> {
                switch (outputBox.getSelectionModel().getSelectedItem()) {
                    case "dm" -> unit *= 10;

                    case "cm" -> unit *= 100;
                }
            }
        }
        userOutput.setText(String.valueOf(unit));

    }


}