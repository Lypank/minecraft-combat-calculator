package com.lypank.combat.calculator.model;

/*
 * Model class for Armor
 *
 * This will be the initial values for the CalculatorDisplay
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Armor
{
    private final StringProperty helmetMaterial;
    private final StringProperty chestplateMaterial;
    private final StringProperty leggingsMaterial;
    private final StringProperty bootsMaterial;

    public Armor()
    {
        this(null, null, null, null);
    }

    public Armor(String helmetMaterial, String chestplateMaterial, String leggingsMaterial, String bootsMaterial)
    {
        this.helmetMaterial = new SimpleStringProperty(helmetMaterial);
        this.chestplateMaterial = new SimpleStringProperty(chestplateMaterial);
        this.leggingsMaterial = new SimpleStringProperty(leggingsMaterial);
        this.bootsMaterial = new SimpleStringProperty(bootsMaterial);
    }

    public String getHelmetMaterial()
    {
        return helmetMaterial.get();
    }

    public void setHelmetMaterial(String helmetMaterial)
    {
        this.helmetMaterial.set(helmetMaterial);
    }

    public StringProperty helmetMaterialProperty()
    {
        return helmetMaterial;
    }

    public String getChestplateMaterial()
    {
        return chestplateMaterial.get();
    }
    public void setChestplateMaterial(String chestplateMaterial)
    {
        this.chestplateMaterial.set(chestplateMaterial);
    }

    public StringProperty chestplateMaterialProperty()
    {
        return chestplateMaterial;
    }

    public String getLeggingsMaterial()
    {
        return leggingsMaterial.get();
    }

    public void setLeggingsMaterial(String leggingsMaterial)
    {
        this.leggingsMaterial.set(leggingsMaterial);
    }

    public StringProperty bootsMaterialProperty()
    {
        return bootsMaterial;
    }

    public String getBootsMaterial()
    {
        return bootsMaterial.get();
    }

    public void setBootsMaterial(String bootsMaterial)
    {
        this.bootsMaterial.set(bootsMaterial);
    }

    public StringProperty leggingsMaterialProperty()
    {
        return leggingsMaterial;
    }
}
