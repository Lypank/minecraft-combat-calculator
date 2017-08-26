package com.lypank.combat.calculator.model;

/*
 * Model class for Armor
 *
 * This will be the model for the CalculatorDisplay
 */

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.math.BigDecimal;

public class Armor
{
    private final ObjectProperty<BigDecimal> helmetProtection;
    private final ObjectProperty<BigDecimal> chestplateProtection;
    private final ObjectProperty<BigDecimal> leggingsProtection;
    private final ObjectProperty<BigDecimal> bootsProtection;

    public Armor()
    {
        this(null, null, null, null);
    }

    public Armor(BigDecimal helmetProtection, BigDecimal chestplateProtection, BigDecimal leggingsProtection, BigDecimal bootsProtection)
    {
        this.helmetProtection = new SimpleObjectProperty<>(helmetProtection);
        this.chestplateProtection = new SimpleObjectProperty<>(chestplateProtection);
        this.leggingsProtection = new SimpleObjectProperty<>(leggingsProtection);
        this.bootsProtection = new SimpleObjectProperty<>(bootsProtection);
    }

    public BigDecimal getHelmetProtection()
    {
        return helmetProtection.getValue();
    }
    public void setHelmetProtection(BigDecimal helmetProtection)
    {
        this.helmetProtection.setValue(helmetProtection);
    }
    public ObjectProperty<BigDecimal> helmetProtectionProperty()
    {
        return helmetProtection;
    }

    public BigDecimal getChestplateProtection()
    {
        return chestplateProtection.getValue();
    }
    public void setChestplateProtection(BigDecimal chestplateProtection)
    {
        this.chestplateProtection.setValue(chestplateProtection);
    }
    public ObjectProperty<BigDecimal> chestplateProtectionProperty()
    {
        return chestplateProtection;
    }

    public BigDecimal getLeggingsProtection()
    {
        return leggingsProtection.getValue();
    }
    public void setLeggingsProtection(BigDecimal leggingsProtection)
    {
        this.leggingsProtection.setValue(leggingsProtection);
    }
    public ObjectProperty<BigDecimal> leggingsProtectionProperty()
    {
        return leggingsProtection;
    }

    public BigDecimal getBootsProtection()
    {
        return bootsProtection.getValue();
    }
    public void setBootsProtection(BigDecimal bootsProtection)
    {
        this.bootsProtection.setValue(bootsProtection);
    }
    public ObjectProperty<BigDecimal> bootsProtectionProperty()
    {
        return bootsProtection;
    }

}
