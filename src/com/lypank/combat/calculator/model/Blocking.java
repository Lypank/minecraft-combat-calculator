package com.lypank.combat.calculator.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.math.BigDecimal;

public class Blocking
{
    private final ObjectProperty<BigDecimal> isBlocking;

    public Blocking()
    {
        this(null);
    }

    public Blocking(BigDecimal isBlocking)
    {
        this.isBlocking = new SimpleObjectProperty<>(isBlocking);
    }

    public BigDecimal getIsBlocking()
    {
        return isBlocking.get();
    }

    public void setIsBlocking(BigDecimal isBlocking)
    {
        this.isBlocking.set(isBlocking);
    }

    public ObjectProperty<BigDecimal> isBlockingProperty()
    {
        return isBlocking;
    }
}
