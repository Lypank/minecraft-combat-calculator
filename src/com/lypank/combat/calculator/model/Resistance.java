package com.lypank.combat.calculator.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.math.BigDecimal;

public class Resistance
{
    private final ObjectProperty<BigDecimal> resistanceValue;

    public Resistance()
    {
        this(null);
    }

    public Resistance(BigDecimal resistanceValue)
    {
        this.resistanceValue = new SimpleObjectProperty<>(resistanceValue);
    }

    public BigDecimal getResistanceValue()
    {
        return resistanceValue.get();
    }

    public void setResistanceValue(BigDecimal resistanceValue)
    {
        this.resistanceValue.set(resistanceValue);
    }

    public ObjectProperty<BigDecimal> resistanceValueProperty()
    {
        return resistanceValue;
    }
}
