package com.lypank.combat.calculator.view;

import com.lypank.combat.calculator.model.Armor;
import com.lypank.combat.calculator.model.Protection;
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

    private Armor armor;
    private Protection protection;

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
        BigDecimal armorProtectionPercent = armor.getArmorProtection().multiply(new BigDecimal(100));
        armorDR.setText(armorProtectionPercent.toString() + "%");
    }

    public void setEnchantmentDR(Protection protection)
    {
        this.protection = protection;
        BigDecimal protectionEnchantmentPercent = protection.getProtectionValue();
        enchantmentDR.setText(protectionEnchantmentPercent.toString() + "%");
    }

    public void setTotalDR(Armor armor, Protection protection)
    {
        this.armor = armor;
        this.protection = protection;

        BigDecimal armorProtection = armor.getArmorProtection().multiply(new BigDecimal(100));
        BigDecimal protectionProtection = protection.getProtectionValue();

        BigDecimal damageReductionTotal = armorProtection.add(protectionProtection);
        totalDR.setText(damageReductionTotal.toString() + "%");

    }

    @FXML
    private void handleClose()
    {
        resultsStage.close();
    }

}
