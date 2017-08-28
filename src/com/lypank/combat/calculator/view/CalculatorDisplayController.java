package com.lypank.combat.calculator.view;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Lists;
import com.lypank.combat.calculator.MainApp;
import com.lypank.combat.calculator.model.Armor;
import com.lypank.combat.calculator.model.Protection;
import com.lypank.combat.calculator.model.Resistance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Hashtable;
import java.util.List;

public class CalculatorDisplayController
{
    //Armor Selection
    @FXML
    private ChoiceBox<String> helmetMaterial;
    @FXML
    private ChoiceBox<String> chestplateMaterial;
    @FXML
    private ChoiceBox<String> leggingsMaterial;
    @FXML
    private ChoiceBox<String> bootsMaterial;

    //Protection Values
    @FXML
    private ChoiceBox<String> helmetProtection;
    @FXML
    private ChoiceBox<String> chestplateProtection;
    @FXML
    private ChoiceBox<String> leggingsProtection;
    @FXML
    private ChoiceBox<String> bootsProtection;

    //Extra Reduction
    @FXML
    private ChoiceBox<String> resistanceChoice;
    @FXML
    private ChoiceBox<String> blocking;

    private MainApp main;

    //Models
    private Armor armor = new Armor(null, null, null, null);
    private Protection protection = new Protection(null);
    private Resistance resistance = new Resistance(null);

    //Array Tables that are used in the initialize method
    private ArrayTable<String, String, BigDecimal> finalArmorTable;
    private ArrayTable<String, String, Double> finalProtectionTable;

    //Hashtables
    private Hashtable<String, BigDecimal> finalResistanceValues;

    // Armor Types with the included value of that Armor
    // Armor is structured as [0] = Helmet [1] = Chestplate [2] = Leggings [3] = Boots
    private final BigDecimal[] LEATHER = {new BigDecimal(0.04), new BigDecimal(0.12), new BigDecimal(0.08), new BigDecimal(0.04)};
    private final BigDecimal[] GOLD = {new BigDecimal(0.08), new BigDecimal(0.20), new BigDecimal(0.12), new BigDecimal(0.04)};
    private final BigDecimal[] CHAIN = {new BigDecimal(0.08), new BigDecimal(0.20), new BigDecimal(0.16), new BigDecimal(0.04)};
    private final BigDecimal[] IRON = {new BigDecimal(0.08), new BigDecimal(0.24), new BigDecimal(0.20), new BigDecimal(0.08)};
    private final BigDecimal[] DIAMOND = {new BigDecimal(0.12), new BigDecimal(0.32), new BigDecimal(0.24), new BigDecimal(0.12)};

    // Protection Type Modifiers
    // Available Protection Levels
    private final BigDecimal PROTECTION_MODIFIER = new BigDecimal(0.75);
    final double FIRE_PROTECTION_MODIFIER = 1.25;
    final double PROJECTILE_PROTECTION_MODIFER = 1.5;
    final double BLAST_PROTECTION_MODIFIER = 1.5;
    final double FEATHER_FALLING_MODIFIER = 2.5;
    private final BigDecimal MIN_MODIFIER = new BigDecimal(0.5);
    private final BigDecimal MAX_MODIFIER = new BigDecimal(1);

    //Array String Lists that contain identifiers
    private final List<String> MATERIALS = Lists.newArrayList("None", "Leather", "Gold", "Chain", "Iron", "Diamond");
    private final List<String> ARMOR_PIECES = Lists.newArrayList("Helmet", "Chestplate", "Leggings", "Boots");
    private final List<String> PROTECTION_TYPES = Lists.newArrayList("Protection", "Fire Protection", "Projectile Protection", "Blast Protection", "Feather Falling");
    private final List<String> PROTECTION_LEVELS = Lists.newArrayList("~", "I", "II", "III", "IV", "V");
    private final List<String> RESISTANCE_LEVELS = Lists.newArrayList("~", "I", "II", "III", "IV");

    //Armor
    private ArrayTable<String, String, BigDecimal> setArmorTableValues()
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

    private BigDecimal[] getArmorTableValues(ChoiceBox<String> helmetMaterial, ChoiceBox<String> chestplateMaterial, ChoiceBox<String> leggingsMaterial, ChoiceBox<String> bootsMaterial)
    {
        String helmetIndex = helmetMaterial.getValue();
        String chestplateIndex = chestplateMaterial.getValue();
        String leggingsIndex = leggingsMaterial.getValue();
        String bootsIndex = bootsMaterial.getValue();

        BigDecimal helmetValue = finalArmorTable.get(helmetIndex, ARMOR_PIECES.get(0));
        BigDecimal chestplateValue = finalArmorTable.get(chestplateIndex, ARMOR_PIECES.get(1));
        BigDecimal leggingsValue = finalArmorTable.get(leggingsIndex, ARMOR_PIECES.get(2));
        BigDecimal bootsValue = finalArmorTable.get(bootsIndex, ARMOR_PIECES.get(3));

        BigDecimal[] armorValues = {helmetValue, chestplateValue, leggingsValue, bootsValue};
        return armorValues;
    }

    //Protection Enchant
    private ArrayTable<String, String, Double> setProtectionEPFs()
    {
        ArrayTable<String, String, Double> protectionTable = ArrayTable.create(PROTECTION_LEVELS, PROTECTION_TYPES);

        //Protection EPF value based on Protection level
        protectionTable.put(PROTECTION_LEVELS.get(0), PROTECTION_TYPES.get(0), 0.0);
        protectionTable.put(PROTECTION_LEVELS.get(1), PROTECTION_TYPES.get(0), 1.0);
        protectionTable.put(PROTECTION_LEVELS.get(2), PROTECTION_TYPES.get(0), 2.0);
        protectionTable.put(PROTECTION_LEVELS.get(3), PROTECTION_TYPES.get(0), 3.0);
        protectionTable.put(PROTECTION_LEVELS.get(4), PROTECTION_TYPES.get(0), 5.0);
        protectionTable.put(PROTECTION_LEVELS.get(5), PROTECTION_TYPES.get(0), 7.0);

        return protectionTable;
    }

    private BigDecimal[] getProtectionReduction(ChoiceBox<String> helmetProtection, ChoiceBox<String> chestplateProtection, ChoiceBox<String> leggingsProtection, ChoiceBox<String> bootsProtection)
    {
        Double helmetProtectionEPF = finalProtectionTable.get(helmetProtection.getValue(), PROTECTION_TYPES.get(0));
        Double chestplateProtectionEPF = finalProtectionTable.get(chestplateProtection.getValue(), PROTECTION_TYPES.get(0));
        Double leggingsProtectionEPF = finalProtectionTable.get(leggingsProtection.getValue(), PROTECTION_TYPES.get(0));
        Double bootsProtectionEPF = finalProtectionTable.get(bootsProtection.getValue(), PROTECTION_TYPES.get(0));

        Double totalProtectionEPF = helmetProtectionEPF + chestplateProtectionEPF + leggingsProtectionEPF + bootsProtectionEPF;

        BigDecimal protectionMin = new BigDecimal(totalProtectionEPF).multiply(MIN_MODIFIER).multiply(new BigDecimal(4));
        BigDecimal protectionMax = new BigDecimal(totalProtectionEPF).multiply(MAX_MODIFIER).multiply(new BigDecimal(4));

        BigDecimal[] protectionMinMax = {protectionMin, protectionMax};
        return protectionMinMax;
    }

    //Resistance Potion Effect
    private Hashtable<String, BigDecimal> setResistanceValues()
    {
        Hashtable<String, BigDecimal> resistanceHash = new Hashtable<>();
        resistanceHash.put(RESISTANCE_LEVELS.get(0), BigDecimal.ZERO);
        resistanceHash.put(RESISTANCE_LEVELS.get(1), new BigDecimal(0.2).setScale(2, BigDecimal.ROUND_HALF_UP));
        resistanceHash.put(RESISTANCE_LEVELS.get(2), new BigDecimal(0.4).setScale(2, BigDecimal.ROUND_HALF_UP));
        resistanceHash.put(RESISTANCE_LEVELS.get(3), new BigDecimal(0.6).setScale(2, BigDecimal.ROUND_HALF_UP));
        resistanceHash.put(RESISTANCE_LEVELS.get(4), new BigDecimal(0.8).setScale(2, BigDecimal.ROUND_HALF_UP));

        return resistanceHash;
    }

    private BigDecimal getResistanceValue(ChoiceBox<String> resistance)
    {
        BigDecimal resistanceValue = finalResistanceValues.get(resistance.getValue());

        return resistanceValue;
    }


    public CalculatorDisplayController()
    {

    }

    @FXML
    private void initialize()
    {
        ObservableList<String> materialsList = FXCollections.observableArrayList(MATERIALS);
        ObservableList<String> levelList = FXCollections.observableArrayList(PROTECTION_LEVELS);
        ObservableList<String> resistanceLevels = FXCollections.observableArrayList(RESISTANCE_LEVELS);

        helmetMaterial.setItems(materialsList);
        helmetMaterial.getSelectionModel().select(0);

        chestplateMaterial.setItems(materialsList);
        chestplateMaterial.getSelectionModel().select(0);

        leggingsMaterial.setItems(materialsList);
        leggingsMaterial.getSelectionModel().select(0);

        bootsMaterial.setItems(materialsList);
        bootsMaterial.getSelectionModel().select(0);

        helmetProtection.setItems(levelList);
        helmetProtection.getSelectionModel().select(0);

        chestplateProtection.setItems(levelList);
        chestplateProtection.getSelectionModel().select(0);

        leggingsProtection.setItems(levelList);
        leggingsProtection.getSelectionModel().select(0);

        bootsProtection.setItems(levelList);
        bootsProtection.getSelectionModel().select(0);

        resistanceChoice.setItems(resistanceLevels);
        resistanceChoice.getSelectionModel().select(0);

        finalArmorTable = setArmorTableValues();
        finalProtectionTable = setProtectionEPFs();
        finalResistanceValues = setResistanceValues();
    }

    @FXML
    private void calculateResults()
    {
        //Arrays that are used to get Armor Protection, Enchantment Protection, and Resistance Protection
        BigDecimal[] armorValues = getArmorTableValues(helmetMaterial, chestplateMaterial, leggingsMaterial, bootsMaterial);
        BigDecimal[] protectionReduction = getProtectionReduction(helmetProtection, chestplateProtection, leggingsProtection, bootsProtection);
        BigDecimal resistanceLevel = getResistanceValue(resistanceChoice);

        //Methods that set all values regarding chosen armor pieces and their respective material
        armor.setHelmetProtection(armorValues[0]);
        armor.setChestplateProtection(armorValues[1]);
        armor.setLeggingsProtection(armorValues[2]);
        armor.setBootsProtection(armorValues[3]);

        //Sets the value that is used in the result display
        armor.setArmorProection(armorValues[0].add(armorValues[1].add(armorValues[2].add(armorValues[3]))));

        //BigDecimal that stores how much the player is unprotected after armor is applied
        BigDecimal unprotectedValue = BigDecimal.ONE.subtract(armor.getArmorProtection());

        //BigDecimal that stores how much the player is protected for by resistance
        BigDecimal resistanceReduction = unprotectedValue.multiply(resistanceLevel);

        //BigDecimal that stores how much the player is unprotected for after armor and resistance is applied
        BigDecimal unprotectedEnchants = unprotectedValue.subtract(resistanceReduction);

        //Methods that take the minimum and maximum amount that the protection enchantment can provide and averages them for the result
        BigDecimal protectionReductionMin = unprotectedEnchants.multiply(protectionReduction[0]).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal protectionReductionMax = unprotectedEnchants.multiply(protectionReduction[1]).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal averageProtectionReduction = protectionReductionMin.add(protectionReductionMax).divide(new BigDecimal(2).setScale(2, RoundingMode.HALF_UP));

        //Sets the value that is used in the result display
        protection.setProtectionEPF(averageProtectionReduction);
        resistance.setResistanceValue(resistanceReduction);

        main.showCalculatorResults(armor, protection, resistance);
    }

    public void setMainApp(MainApp main)
    {
        this.main = main;

    }
}