package com.lypank.combat.calculator.view;

import com.lypank.combat.calculator.MainApp;
import com.lypank.combat.calculator.model.Armor;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.concurrent.Callable;

public class CalculatorDisplayController
{
    @FXML
    private ChoiceBox<String> helmetMaterial;
    @FXML
    private ChoiceBox<String> chestplateMaterial;
    @FXML
    private ChoiceBox<String> leggingsMaterial;
    @FXML
    private ChoiceBox<String> bootsMaterial;

    private MainApp main;
    private Armor suit = new Armor(null, null, null, null);

    // Armor Types with the included value of that Armor
    // Armor is structured as [0] = Helmet [1] = Chestplate [2] = Leggings [3] = Boots
    private final String[] MATERIALS = {"None", "Leather", "Gold", "Chain", "Iron", "Diamond"};
    private final BigDecimal[] LEATHER = {new BigDecimal(0.04), new BigDecimal(0.12), new BigDecimal(0.08), new BigDecimal(0.04)};
    private final BigDecimal[] GOLD = {new BigDecimal(0.08), new BigDecimal(0.20), new BigDecimal(0.12), new BigDecimal(0.04)};
    private final BigDecimal[] CHAIN = {new BigDecimal(0.08), new BigDecimal(0.20), new BigDecimal(0.16), new BigDecimal(0.04)};
    private final BigDecimal[] IRON = {new BigDecimal(0.08), new BigDecimal(0.24), new BigDecimal(0.20), new BigDecimal(0.08)};
    private final BigDecimal[] DIAMOND = {new BigDecimal(0.12), new BigDecimal(0.32), new BigDecimal(0.24), new BigDecimal(0.12)};



    public CalculatorDisplayController()
    {

    }


    /*
     * The following methods set the armor protection of that armor piece depending on the material found
     * The material that is used in the formula is dependant on the GUI choice box selection
     */

    private BigDecimal helmetValue(ChoiceBox<String> helmetMaterial)
    {
        String chosenHelmetMaterial = helmetMaterial.getValue();

        if(chosenHelmetMaterial.equals(MATERIALS[0]))
        {
            suit.setHelmetProtection(BigDecimal.ZERO);
        }

        else if(chosenHelmetMaterial.equals(MATERIALS[1]))
        {
            suit.setHelmetProtection(LEATHER[0].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenHelmetMaterial.equals(MATERIALS[2]))
        {
            suit.setHelmetProtection(GOLD[0].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenHelmetMaterial.equals(MATERIALS[3]))
        {
            suit.setHelmetProtection(CHAIN[0].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenHelmetMaterial.equals(MATERIALS[4]))
        {
            suit.setHelmetProtection(IRON[0].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenHelmetMaterial.equals(MATERIALS[5]))
        {
            suit.setHelmetProtection(DIAMOND[0].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else
        {
            System.out.println("Something's Wrong: Helmet Selection");
        }

        return suit.getHelmetProtection();
    }

    private BigDecimal chestplateValue(ChoiceBox<String> chestplateMaterial)
    {
        String chosenChestplateMaterial = chestplateMaterial.getValue();

        if(chosenChestplateMaterial.equals(MATERIALS[0]))
        {
            suit.setChestplateProtection(BigDecimal.ZERO);
        }

        else if(chosenChestplateMaterial.equals(MATERIALS[1]))
        {
            suit.setChestplateProtection(LEATHER[1].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenChestplateMaterial.equals(MATERIALS[2]))
        {
            suit.setChestplateProtection(GOLD[1].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenChestplateMaterial.equals(MATERIALS[3]))
        {
            suit.setChestplateProtection(CHAIN[1].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenChestplateMaterial.equals(MATERIALS[4]))
        {
            suit.setChestplateProtection(IRON[1].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenChestplateMaterial.equals(MATERIALS[5]))
        {
            suit.setChestplateProtection(DIAMOND[1].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else
        {
            System.out.println("Something's Wrong: Chestplate Selection");
        }

        return suit.getChestplateProtection();
    }

    private BigDecimal leggingsValue(ChoiceBox<String> leggingsMaterial)
    {
        String chosenLeggingsMaterial = leggingsMaterial.getValue();

        if(chosenLeggingsMaterial.equals(MATERIALS[0]))
        {
            suit.setLeggingsProtection(BigDecimal.ZERO);
        }

        else if(chosenLeggingsMaterial.equals(MATERIALS[1]))
        {
            suit.setLeggingsProtection(LEATHER[2].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenLeggingsMaterial.equals(MATERIALS[2]))
        {
            suit.setLeggingsProtection(GOLD[2].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenLeggingsMaterial.equals(MATERIALS[3]))
        {
            suit.setLeggingsProtection(CHAIN[2].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenLeggingsMaterial.equals(MATERIALS[4]))
        {
            suit.setLeggingsProtection(IRON[2].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenLeggingsMaterial.equals(MATERIALS[5]))
        {
            suit.setLeggingsProtection(DIAMOND[2].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else
        {
            System.out.println("Something's Wrong: Leggings Selection");
        }

        return suit.getLeggingsProtection();
    }

    private BigDecimal bootsValue(ChoiceBox<String> bootsMaterial)
    {
        String chosenBootsMaterial = bootsMaterial.getValue();

        if(chosenBootsMaterial.equals(MATERIALS[0]))
        {
            suit.setBootsProtection(BigDecimal.ZERO);
        }

        else if(chosenBootsMaterial.equals(MATERIALS[1]))
        {
            suit.setBootsProtection(LEATHER[3].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenBootsMaterial.equals(MATERIALS[2]))
        {
            suit.setBootsProtection(GOLD[3].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenBootsMaterial.equals(MATERIALS[3]))
        {
            suit.setBootsProtection(CHAIN[3].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenBootsMaterial.equals(MATERIALS[4]))
        {
            suit.setBootsProtection(IRON[3].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else if(chosenBootsMaterial.equals(MATERIALS[5]))
        {
            suit.setBootsProtection(DIAMOND[3].setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        else
        {
            System.out.println("Something's Wrong: Boots Selection");
        }

        return suit.getBootsProtection();
    }


    //Sets the default selected material for each possible armor piece
    @FXML
    private void initialize()
    {
        ObservableList<String> materialsList = FXCollections.observableArrayList(MATERIALS);

        helmetMaterial.setItems(materialsList);
        helmetMaterial.getSelectionModel().select(0);

        chestplateMaterial.setItems(materialsList);
        chestplateMaterial.getSelectionModel().select(0);

        leggingsMaterial.setItems(materialsList);
        leggingsMaterial.getSelectionModel().select(0);

        bootsMaterial.setItems(materialsList);
        bootsMaterial.getSelectionModel().select(0);
    }

    @FXML
    private void calculateResults()
    {
        suit.setHelmetProtection(helmetValue(helmetMaterial));
        suit.setChestplateProtection(chestplateValue(chestplateMaterial));
        suit.setLeggingsProtection(leggingsValue(leggingsMaterial));
        suit.setBootsProtection(bootsValue(bootsMaterial));

        BigDecimal topHalf = suit.getHelmetProtection().add(suit.getChestplateProtection());
        BigDecimal bottomHalf = suit.getLeggingsProtection().add(suit.getBootsProtection());
        BigDecimal bothHalves = topHalf.add(bottomHalf);


        System.out.println(topHalf + " " + bottomHalf);
        System.out.println(bothHalves);

        //main.showCalculatorResults(baseArmor);
    }

    public void setMainApp(MainApp main)
    {
        this.main = main;

    }
}
