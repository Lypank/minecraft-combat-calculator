package com.lypank.combat.calculator.resources;

import java.math.BigDecimal;
import java.util.Scanner;

public class EPF extends BaseArmor
{
    //Type Modifiers
    final double PROTECTION_MODIFIER = 0.75;
    final double FIRE_PROTECTION_MODIFIER = 1.25;
    final double PROJECTILE_PROTECTION_MODIFER = 1.5;
    final double BLAST_PROTECTION_MODIFIER = 1.5;
    final double FEATHER_FALLING_MODIFIER = 2.5;

    final double MAX_MODIFIER = 1;
    final double MIN_MODIFIER = 0.5;

    int[] enchantments = new int[4];

    double protectionEPF;
    double fireEPF;
    double projectileEPF;
    double blastEPF;
    double featherFallingEPF;

    double protectionModifierMin;
    double protectionModifierMax;
    double protectionModifierAvg;
    double[] protectionValues = {protectionModifierMin, protectionModifierAvg, protectionModifierMax};

    double fireModifierMin;
    double fireModifierMax;
    double fireModifierAvg;
    double[] fireValues = {fireModifierMin, fireModifierAvg, fireModifierMax};

    double projectileModifierMin;
    double projectileModifierMax;
    double projectileModifierAvg;
    double[] projectileValues = {projectileModifierMin, projectileModifierAvg, projectileModifierMax};

    double blastModifierMin;
    double blastModifierMax;
    double blastModifierAvg;
    double[] blastValues = {blastModifierMin, blastModifierAvg, blastModifierMax};

    double featherModifierMin;
    double featherModifierMax;
    double featherModifierAvg;
    double[] featherValues = {featherModifierMin, featherModifierAvg, featherModifierMax};

    Scanner enchantmentLevel = new Scanner(System.in);

    public int[][] setEnchantments()
    {
        int length = ARMOR_PIECES.length;
        int[][] enchantmentLevels = new int[4][5];
        for(int i = 0; i < length; i++)
        {
            System.out.println(ARMOR_PIECES[i] + " Properties");

            System.out.println("Please Enter your Protection Level (If Applicable): ");
            int protectionLevel = enchantmentLevel.nextInt();

            System.out.println("Please Enter your Fire Protection Level (If Applicable): ");
            int fireProtectionLevel = enchantmentLevel.nextInt();

            System.out.println("Please Enter your Projectile Protection Level (If Applicable): ");
            int projectileProtectionLevel = enchantmentLevel.nextInt();

            System.out.println("Please Enter your Blast Protection Level (If Applicable): ");
            int blastProtectionLevel = enchantmentLevel.nextInt();

            System.out.println("Please Enter your Feather Falling Level (If Applicable: ");
            int featherFallingLevel = enchantmentLevel.nextInt();

            enchantmentLevels[i][0] = protectionLevel;
            enchantmentLevels[i][1] = fireProtectionLevel;
            enchantmentLevels[i][2] = projectileProtectionLevel;
            enchantmentLevels[i][3] = blastProtectionLevel;
            enchantmentLevels[i][4] = featherFallingLevel;
        }

        return enchantmentLevels;
    }

    public int[] totalEPF(int[][] enchantmentLevels)
    {
        double totalProtectionEPF = Math.floor((6 + (enchantmentLevels[0][0] + enchantmentLevels[1][0] + enchantmentLevels[2][0] + enchantmentLevels[3][0])) * PROTECTION_MODIFIER / 3);
        double totalFireEPF = Math.floor((6 + (enchantmentLevels[0][1] + enchantmentLevels[1][1] + enchantmentLevels[2][1] + enchantmentLevels[3][1])) * FIRE_PROTECTION_MODIFIER / 3);
        double totalProjectileEPF = Math.floor((6 + (enchantmentLevels[0][2] + enchantmentLevels[1][2] + enchantmentLevels[2][2] + enchantmentLevels[3][2])) * PROJECTILE_PROTECTION_MODIFER / 3);
        double totalBlastEPF = Math.floor((6 + (enchantmentLevels[0][3] + enchantmentLevels[1][3] + enchantmentLevels[2][3] + enchantmentLevels[3][3])) * BLAST_PROTECTION_MODIFIER / 3);
        double totalFeatherEPF = Math.floor((6 + (enchantmentLevels[0][4] + enchantmentLevels[1][4] + enchantmentLevels[2][4] + enchantmentLevels[3][4])) * FEATHER_FALLING_MODIFIER / 3);

        int[] totalEnchantEPF = {(int)totalProtectionEPF, (int)totalFireEPF, (int)totalProjectileEPF, (int)totalBlastEPF, (int)totalFeatherEPF};
        return totalEnchantEPF;
    }

    public double[][] enchantReduction(double protectionEPF, double fireEPF, double projectileEPF, double blastEPF, double featherFallingEPF)
    {
        double protectionModifierMin = Math.ceil(protectionEPF * MIN_MODIFIER);
        double protectionModifierMax = Math.ceil(protectionEPF * MAX_MODIFIER);
        double protectionModifierAvg = (protectionModifierMax + protectionModifierMin) / 2;

        double fireModifierMin = Math.ceil(fireEPF * MIN_MODIFIER);
        double fireModifierMax = Math.ceil(fireEPF * MAX_MODIFIER);
        double fireModifierAvg = (fireModifierMax + fireModifierMin) / 2;

        double projectileModifierMin = Math.ceil(projectileEPF * MIN_MODIFIER);
        double projectileModifierMax = Math.ceil(projectileEPF * MAX_MODIFIER);
        double projectileModifierAvg = (projectileModifierMax + projectileModifierMin) / 2;

        double blastModifierMin = Math.ceil(blastEPF * MIN_MODIFIER);
        double blastModifierMax = Math.ceil(blastEPF * MAX_MODIFIER);
        double blastModifierAvg = (blastModifierMax + blastModifierMin) / 2;

        double featherModifierMin = Math.ceil(featherFallingEPF * MIN_MODIFIER);
        double featherModifierMax = Math.ceil(featherFallingEPF * MAX_MODIFIER);
        double featherModifierAvg = (featherModifierMax + featherModifierMin) / 2;

        double[][] modifierReduction = {{protectionModifierMin, protectionModifierAvg, protectionModifierMax},
                                        {fireModifierMin, fireModifierAvg, fireModifierMax},
                                        {projectileModifierMin, projectileModifierAvg, projectileModifierMax},
                                        {blastModifierMin, blastModifierAvg, blastModifierMax},
                                        {featherModifierMin, featherModifierAvg, featherModifierMax}
                                       };
        return modifierReduction;
    }

    public BigDecimal[] damageReduction()
    {
        BigDecimal baseReduction = getTotalProtection(getHelmet(), getChestplate(), getLeggings(), getBoots());
        BigDecimal damageTaken = new BigDecimal(100);

        damageTaken = damageTaken.subtract(baseReduction);

        BigDecimal[] generalProtection = new BigDecimal[3];
        generalProtection[0] = damageTaken.multiply(BigDecimal.valueOf(protectionValues[0]));
        generalProtection[1] = damageTaken.multiply(BigDecimal.valueOf(protectionValues[1]));
        generalProtection[2] = damageTaken.multiply(BigDecimal.valueOf(protectionValues[2]));

        return generalProtection;
    }

    public double[] getProtection()
    {
        return this.protectionValues;
    }

    public double[] getFire()
    {
        return this.fireValues;
    }

    public double[] getProjectileValues()
    {
        return this.projectileValues;
    }

    public double[] getBlast()
    {
        return this.blastValues;
    }

    public double[] getFeather()
    {
        return this.featherValues;
    }




}
