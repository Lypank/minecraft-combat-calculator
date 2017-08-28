package com.lypank.combat.calculator.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.math.BigDecimal;

public class Protection
{
    private final ObjectProperty<BigDecimal> protectionValue;

    public Protection()
    {
        this(null);
    }

    public Protection(BigDecimal protectionValue)
    {
        this.protectionValue = new SimpleObjectProperty<>(protectionValue);
    }

    public BigDecimal getProtectionValue()
    {
        return protectionValue.get();
    }
    public void setProtectionEPF(BigDecimal protectionValue)
    {
        this.protectionValue.set(protectionValue);
    }

    public ObjectProperty<BigDecimal> protectionValueProperty()
    {
        return protectionValue;
    }


}
