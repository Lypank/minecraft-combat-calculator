package com.lypank.combat.calculator.view;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Lists;
import com.lypank.combat.calculator.MainApp;
import com.lypank.combat.calculator.model.Armor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

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
    private Armor armor = new Armor(null, null, null, null);
    private ArrayTable<String, String, BigDecimal> finalArmorTable;

    // Armor Types with the included value of that Armor
    // Armor is structured as [0] = Helmet [1] = Chestplate [2] = Leggings [3] = Boots
    //private final String ARMOR_PIECES[] = {"Helmet", "Chestplate", "Leggings", "Boots"};
    //private final String[] MATERIALS = {"None", "Leather", "Gold", "Chain", "Iron", "Diamond"};
    private final BigDecimal[] LEATHER = {new BigDecimal(0.04), new BigDecimal(0.12), new BigDecimal(0.08), new BigDecimal(0.04)};
    private final BigDecimal[] GOLD = {new BigDecimal(0.08), new BigDecimal(0.20), new BigDecimal(0.12), new BigDecimal(0.04)};
    private final BigDecimal[] CHAIN = {new BigDecimal(0.08), new BigDecimal(0.20), new BigDecimal(0.16), new BigDecimal(0.04)};
    private final BigDecimal[] IRON = {new BigDecimal(0.08), new BigDecimal(0.24), new BigDecimal(0.20), new BigDecimal(0.08)};
    private final BigDecimal[] DIAMOND = {new BigDecimal(0.12), new BigDecimal(0.32), new BigDecimal(0.24), new BigDecimal(0.12)};

    private final List<String> MATERIALS = Lists.newArrayList("None", "Leather", "Gold", "Chain", "Iron", "Diamond");
    private final List<String> ARMOR_PIECES = Lists.newArrayList("Helmet", "Chestplate", "Leggings", "Boots");

    public ArrayTable<String, String, BigDecimal> setArmorTableValues()
    {
        ArrayTable<String, String, BigDecimal> armorTable = ArrayTable.create(MATERIALS, ARMOR_PIECES);

        //Values for Armor Pieces if the material is: "None"
        armorTable.put(MATERIALS.get(0), ARMOR_PIECES.get(0), BigDecimal.ZERO);
        armorTable.put(MATERIALS.get(0), ARMOR_PIECES.get(1), BigDecimal.ZERO);
        armorTable.put(MATERIALS.get(0), ARMOR_PIECES.get(2), BigDecimal.ZERO);
        armorTable.put(MATERIALS.get(0), ARMOR_PIECES.get(3), BigDecimal.ZERO);

        //Values for Armor Piece if material is: "Leather"
        armorTable.put(MATERIALS.get(1), ARMOR_PIECES.get(0), LEATHER[0].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(1), ARMOR_PIECES.get(1), LEATHER[1].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(1), ARMOR_PIECES.get(2), LEATHER[2].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(1), ARMOR_PIECES.get(3), LEATHER[3].setScale(2, RoundingMode.HALF_UP));

        //Values for Armor Piece if material is: "Gold"
        armorTable.put(MATERIALS.get(2), ARMOR_PIECES.get(0), GOLD[0].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(2), ARMOR_PIECES.get(1), GOLD[1].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(2), ARMOR_PIECES.get(2), GOLD[2].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(2), ARMOR_PIECES.get(3), GOLD[3].setScale(2, RoundingMode.HALF_UP));

        //Values for Armor Piece if material is: "Chain"
        armorTable.put(MATERIALS.get(3), ARMOR_PIECES.get(0), CHAIN[0].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(3), ARMOR_PIECES.get(1), CHAIN[1].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(3), ARMOR_PIECES.get(2), CHAIN[2].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(3), ARMOR_PIECES.get(3), CHAIN[3].setScale(2, RoundingMode.HALF_UP));

        //Values for Armor Piece if material is: "Iron"
        armorTable.put(MATERIALS.get(4), ARMOR_PIECES.get(0), IRON[0].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(4), ARMOR_PIECES.get(1), IRON[1].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(4), ARMOR_PIECES.get(2), IRON[2].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(4), ARMOR_PIECES.get(3), IRON[3].setScale(2, RoundingMode.HALF_UP));

        //Values for Armor Piece if material is: "Diamond"
        armorTable.put(MATERIALS.get(5), ARMOR_PIECES.get(0), DIAMOND[0].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(5), ARMOR_PIECES.get(1), DIAMOND[1].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(5), ARMOR_PIECES.get(2), DIAMOND[2].setScale(2, RoundingMode.HALF_UP));
        armorTable.put(MATERIALS.get(5), ARMOR_PIECES.get(3), DIAMOND[3].setScale(2, RoundingMode.HALF_UP));

        return armorTable;
    }

    public BigDecimal[] getArmorTableValues(ChoiceBox<String> helmetMaterial, ChoiceBox<String> chestplateMaterial, ChoiceBox<String> leggingsMaterial, ChoiceBox<String> bootsMaterial)
    {
        String helmetIndex = helmetMaterial.getValue();
        String chestplateIndex = chestplateMaterial.getValue();
        String leggingsIndex = leggingsMaterial.getValue();
        String bootsIndex = bootsMaterial.getValue();

        BigDecimal helmetValue = finalArmorTable.get(helmetIndex, ARMOR_PIECES.get(0));
        BigDecimal chestplateValue = finalArmorTable.get(chestplateIndex, ARMOR_PIECES.get(1));
        BigDecimal leggingsValue = finalArmorTable.get(leggingsIndex, ARMOR_PIECES.get(2));
        BigDecimal bootsValue = finalArmorTable.get(bootsIndex, ARMOR_PIECES.get(3));

        /*
        System.out.println(chestplateValue);
        System.out.println(finalArmorTable.get(MATERIALS.get(0), ARMOR_PIECES.get(0)));
        System.out.println(finalArmorTable.get("Leather", "Helmet"));
        System.out.println(helmetValue);
        System.out.println(finalArmorTable.at(0,0));
        */

        BigDecimal[] armorValues = {helmetValue, chestplateValue, leggingsValue, bootsValue};
        return armorValues;
    }

    public CalculatorDisplayController()
    {

    }

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

        finalArmorTable= setArmorTableValues();
    }

    @FXML
    private void calculateResults()
    {
        BigDecimal[] armorValues = getArmorTableValues(helmetMaterial, chestplateMaterial, leggingsMaterial, bootsMaterial);

        armor.setHelmetProtection(armorValues[0]);
        armor.setChestplateProtection(armorValues[1]);
        armor.setLeggingsProtection(armorValues[2]);
        armor.setBootsProtection(armorValues[3]);


        System.out.println(armor.getHelmetProtection());
/*
        BigDecimal topHalf = suit.getHelmetProtection().add(suit.getChestplateProtection());
        BigDecimal bottomHalf = suit.getLeggingsProtection().add(suit.getBootsProtection());
        BigDecimal bothHalves = topHalf.add(bottomHalf);
*/
        main.showCalculatorResults(armor);
    }

    public void setMainApp(MainApp main)
    {
        this.main = main;

    }
}
