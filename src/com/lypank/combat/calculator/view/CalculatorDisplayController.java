package com.lypank.combat.calculator.view;

import com.lypank.combat.calculator.MainApp;
import com.lypank.combat.calculator.model.Armor;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class CalculatorDisplayController
{
    @FXML
    private Label combatCalculator;
    @FXML
    private Label helmet;
    @FXML
    private Label chestplate;
    @FXML
    private Label leggings;
    @FXML
    private Label boots;

    @FXML
    private ChoiceBox helmetMaterial;
    @FXML
    private ChoiceBox chestplateMaterial;
    @FXML
    private ChoiceBox leggingsMaterial;
    @FXML
    private ChoiceBox bootsMaterial;

    @FXML
    private Button calculate;

    private MainApp main;
    private Armor armor;
    private ObservableList materials;

    public CalculatorDisplayController()
    {

    }

    @FXML
    private void initialize()
    {
        List<String> materials = new ArrayList<>();
        materials.add("None");
        materials.add("Leather");
        materials.add("Gold");
        materials.add("Chain");
        materials.add("Iron");
        materials.add("Diamond");

        ObservableList materialsList = FXCollections.observableArrayList(materials);

        helmetMaterial.setItems(materialsList);
        helmetMaterial.getSelectionModel().select(0);

        chestplateMaterial.setItems(materialsList);
        chestplateMaterial.getSelectionModel().select(0);

        leggingsMaterial.setItems(materialsList);
        leggingsMaterial.getSelectionModel().select(0);

        bootsMaterial.setItems(materialsList);
        bootsMaterial.getSelectionModel().select(0);
    }

    public void setMainApp(MainApp main)
    {
        this.main = main;


    }
}
