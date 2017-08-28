package com.lypank.combat.calculator.resources;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class BaseArmor
{
    Scanner armorMaterial = new Scanner(System.in);

    //Types of armor pieces
    private String helmetMaterial;
    private String chestplateMaterial;
    private String leggingsMaterial;
    private String bootsMaterial;

    //Armor Piece + Protection
    private double helmet;
    private double chestplate;
    private double leggings;
    private double boots;

    final MathContext twoDigit = new MathContext(2, RoundingMode.HALF_UP);

    /* Armor Pieces correspond to place in array
     * 0 = helmet
     * 1 = chestplate
     * 2 = leggings
     * 3 = boots
     */

    String[] wornArmor = new String[4];

    final String[] ARMOR_PIECES = {"Helmet", "Chestplate", "Legging", "Boot"};

    //Materials Armor can be made out of
    final String LEATHER = "leather";
    final String GOLD = "gold";
    final String CHAIN = "chain";
    final String IRON = "iron";
    final String DIAMOND = "diamond";

    //Protection Values for Helmet Materials
    final double LEATHER_HELMET = 0.04;
    final double GOLD_HELMET = 0.08;
    final double CHAIN_HELMET = 0.08;
    final double IRON_HELMET = 0.08;
    final double DIAMOND_HELMET = 0.12;

    //Protection Values for Chestplate Materials
    final double LEATHER_CHESTPLATE = 0.12;
    final double GOLD_CHESTPLATE = 0.2;
    final double CHAIN_CHESTPLATE = 0.2;
    final double IRON_CHESTPLATE = 0.24;
    final double DIAMOND_CHESTPLATE = 0.32;

    //Protection Values for Legging Materials
    private final double LEATHER_LEGGINGS = 0.08;
    final double GOLD_LEGGINGS = 0.12;
    final double CHAIN_LEGGINGS = 0.16;
    final double IRON_LEGGINGS = 0.2;
    final double DIAMOND_LEGGINGS = 0.24;

    //Protection Values for Boot Materials
    final double LEATHER_BOOTS = 0.04;
    final double GOLD_BOOTS = 0.04;
    final double CHAIN_BOOTS = 0.04;
    final double IRON_BOOTS = 0.08;
    final double DIAMOND_BOOTS = 0.12;

    public void setArmorMaterial()
    {
        System.out.println("What Material is your Helmet?\nEnter the Corresponding Material\nLeather\nGold\nChain\nIron\nDiamond");
        helmetMaterial = armorMaterial.nextLine();

        System.out.println("What Material is your Chestplate?\nEnter the Corresponding Material\nLeather\nGold\nChain\nIron\nDiamond");
        chestplateMaterial = armorMaterial.nextLine();

        System.out.println("What Material are your Leggings?\nEnter the Corresponding Material\nLeather\nGold\nChain\nIron\nDiamond");
        leggingsMaterial = armorMaterial.nextLine();

        System.out.println("What Material are your Boots?\nEnter the Corresponding Material\nLeather\nGold\nChain\nIron\nDiamond");
        bootsMaterial = armorMaterial.nextLine();

        wornArmor[0] = helmetMaterial;
        wornArmor[1] = chestplateMaterial;
        wornArmor[2] = leggingsMaterial;
        wornArmor[3] = bootsMaterial;
    }

    public void convertArmorMaterial()
    {
        int armorPiece = wornArmor.length;

        for(int i = 0; i < armorPiece; i++)
        {
            if(wornArmor[i].equalsIgnoreCase(LEATHER))
            {
                wornArmor[i] = LEATHER;
            }

            else if(wornArmor[i].equalsIgnoreCase(GOLD))
            {
                wornArmor[i] = GOLD;
            }

            else if(wornArmor[i].equalsIgnoreCase(CHAIN))
            {
                wornArmor[i] = CHAIN;
            }

            else if(wornArmor[i].equalsIgnoreCase(IRON))
            {
                wornArmor[i] = IRON;
            }

            else if(wornArmor[i].equalsIgnoreCase(DIAMOND))
            {
                wornArmor[i] = DIAMOND;
            }

            else
            {
                System.out.println("Something's Wrong!");
            }
        }
    }

    public void setArmorProtection()
    {
        int armorPiece = wornArmor.length;

        for(int i = 0; i < armorPiece; i++)
        {
            if(wornArmor[i].equals(LEATHER))
            {
                if(i == 0)
                {
                    helmet = LEATHER_HELMET;
                }

                else if(i == 1)
                {
                    chestplate = LEATHER_CHESTPLATE;
                }

                else if(i == 2)
                {
                    leggings = LEATHER_LEGGINGS;
                }

                else if(i == 3)
                {
                    boots = LEATHER_BOOTS;
                }
            }

            else if(wornArmor[i].equals(GOLD))
            {
                if(i == 0)
                {
                    helmet = GOLD_HELMET;
                }

                else if(i == 1)
                {
                    chestplate = GOLD_CHESTPLATE;
                }

                else if(i == 2)
                {
                    leggings = GOLD_LEGGINGS;
                }

                else if(i == 3)
                {
                    boots = GOLD_BOOTS;
                }
            }

            else if(wornArmor[i].equals(CHAIN))
            {
                if(i == 0)
                {
                    helmet = CHAIN_HELMET;
                }

                else if(i == 1)
                {
                    chestplate = CHAIN_CHESTPLATE;
                }

                else if(i == 2)
                {
                    leggings = CHAIN_LEGGINGS;
                }

                else if(i == 3)
                {
                    boots = CHAIN_BOOTS;
                }
            }

            else if(wornArmor[i].equals(IRON))
            {
                if(i == 0)
                {
                    helmet = IRON_HELMET;
                }

                else if(i == 1)
                {
                    chestplate = IRON_CHESTPLATE;
                }

                else if(i == 2)
                {
                    leggings = IRON_LEGGINGS;
                }

                else if(i == 3)
                {
                    boots = IRON_BOOTS;
                }
            }

            else if(wornArmor[i].equals(DIAMOND))
            {
                if(i == 0)
                {
                    helmet = DIAMOND_HELMET;
                }

                else if(i == 1)
                {
                    chestplate = DIAMOND_CHESTPLATE;
                }

                else if(i == 2)
                {
                    leggings = DIAMOND_LEGGINGS;
                }

                else if(i == 3)
                {
                    boots = DIAMOND_BOOTS;
                }
            }

            else
            {
                System.out.println("Something's Wrong!");
            }
        }
    }

    public BigDecimal getTotalProtection(double helmet, double chestplate, double leggings, double boots)
    {
        BigDecimal helmetBase = new BigDecimal(helmet);
        BigDecimal chestplateBase = new BigDecimal(chestplate);
        BigDecimal leggingsBase = new BigDecimal(leggings);
        BigDecimal bootsBase = new BigDecimal(boots);

        BigDecimal totalBase = new BigDecimal(0);
        totalBase = totalBase.add(helmetBase);
        totalBase = totalBase.add(chestplateBase);
        totalBase = totalBase.add(leggingsBase);
        totalBase = totalBase.add(bootsBase);

        totalBase = totalBase.round(twoDigit);

        return totalBase;
    }

    public double getHelmet()
    {
        return this.helmet;
    }

    public double getChestplate()
    {
        return this.chestplate;
    }

    public double getLeggings()
    {
        return this.leggings;
    }

    public double getBoots()
    {
        return this.boots;
    }


}
