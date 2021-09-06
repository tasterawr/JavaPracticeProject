package org.java_plilosophy_tasks;

import java.util.Random;

class Unit{
    protected static Random random = new Random();
    protected float health;
    protected int strength;

    public Unit(){
        health = 100;
        strength = 10;
    }

    public Unit (int strength) {
        this();
        this.strength = strength;
    }

    public Unit(float health, int strength){
        this.health = health;
        this.strength = strength;
    }

    public float attack(){
        return random.nextFloat() * strength;
    }

    public float getHealth(){
        return health;
    }

    public float getStrength(){
        return strength;
    }

    @Override
    public String toString() {
        return "Unit: " +
                "Health = " + health +
                ", Strength = " + strength;
    }
}

final class Archer extends Unit{
    private int ammo;

    public Archer(){
        super();
        ammo = 10;
    }

    public Archer(int ammo){
        super();
        this.ammo = ammo;
    }

    public Archer(float health, int strength, int ammo){
        super(health, strength);
        this.ammo = ammo;
    }

    @Override
    public float attack() throws IllegalArgumentException{
        if (ammo <= 0)
            throw new IllegalArgumentException();
        ammo--;
        if (random.nextFloat() > 0.2)
            return strength;
        else
            return 0;
    }

    // Overload, not override
    public float attack(int shots) {
        float sumDamage = 0;

        for (int i = 0; i < shots && ammo > 0;i++){
            if (random.nextFloat() > 0.2)
                sumDamage += strength;
            else
                sumDamage += 0;
            ammo--;
        }

        return sumDamage;
    }

    public int getAmmo() {
        return ammo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Ammo = " + ammo;
    }
}

final class Magician extends Unit{
    private int mana;
    private boolean hasElixir;

    public Magician(){
        super();
        mana = 100;
        hasElixir = true;
    }

    public Magician(int mana){
        super();
        this.mana = mana;
        hasElixir = true;
    }

    public Magician(float health, int strength, int mana, boolean hasElixir){
        super(health, strength);
        this.mana = mana;
        this.hasElixir = hasElixir;
    }

    @Override
    public float attack() {
        float damage;
        if (mana == 0)
            return 0;

        if (random.nextFloat() >= 0.2)
            damage = strength / 2;
        else if (random.nextFloat() >= 0.5)
            damage = strength;
        else if (random.nextFloat() >= 0.8)
            damage = strength * 2;
        else
            damage = 0;

        mana -= 10;
        if (mana < 0)
            mana = 0;
        return damage;
    }

    public void restoreMana(){
        if (hasElixir){
            hasElixir = false;
            mana = 100;
        }
        else
            return;
    }

    @Override
    public String toString() {
        String elixir = hasElixir ? "yes" : "no";
        return super.toString() +
                ", Mana = " + mana +
                ", Has Elixir = " + elixir ;
    }
}

public class InheritanceTest {
    public static void main(String[] args) {
        Unit unit1 = new Unit(5);
        System.out.println(unit1);
        Unit archer1 = new Archer(); //upcasting
        System.out.println(archer1);

        System.out.println("Unit attacked: " + unit1.attack());
        System.out.println("Archer 1 shot: " + archer1.attack()); //polymorphic method call
        //System.out.println("Archer shot: " + archer1.attack(5)); //this function is not available due to upcasting performed

        Archer archer2 = new Archer(5);
        System.out.println("Archer 2 shot multiple times: " + archer2.attack(6));

        Magician magician1 = new Magician(10);
        System.out.println("Magician 1 attack: " + magician1.attack());
        System.out.println(magician1);
        magician1.restoreMana();
        System.out.println(magician1);

    }

}
