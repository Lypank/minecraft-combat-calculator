package com.lypank.combat;

import com.lypank.combat.calculator.formulas.EPF;

public class Main
{
    public static void main(String[] args)
    {
        EPF armor = new EPF();

        System.out.println("Armor Materials: Leather, Gold, Chain, Iron, and Diamond");

        armor.setArmorMaterial();
        armor.convertArmorMaterial();
        armor.setArmorProtection();
        System.out.println("Base Armor Damage Reduction: " + armor.getTotalProtection(armor.getHelmet(), armor.getChestplate(), armor.getLeggings(), armor.getBoots()));

        int[][] enchantments = armor.setEnchantments();





    }

}
