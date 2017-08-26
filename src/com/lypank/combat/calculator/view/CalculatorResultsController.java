package com.lypank.combat.calculator.view;

import com.lypank.combat.calculator.model.Armor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.math.BigDecimal;

public class CalculatorResultsController
{
    @FXML
    private Label armorDR;

    @FXML
    private Label enchantmentDR;

    @FXML
    private Label resistanceDR;

    @FXML
    private Label blockingDR;

    @FXML
    private Label totalDR;

    private Stage resultsStage;
    private boolean blocking;
    private Armor armor;

    @FXML
    private void initialize()
    {

    }

    public void setResultsStage(Stage resultsStage)
    {
        this.resultsStage = resultsStage;
    }

    public void setDR(Armor armor)
    {
        this.armor = armor;





    }

    @FXML
    private void handleClose()
    {
        resultsStage.close();
    }

}
