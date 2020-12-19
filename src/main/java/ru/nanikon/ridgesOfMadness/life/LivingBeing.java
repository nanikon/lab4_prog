package ru.nanikon.ridgesOfMadness.life;

abstract public class LivingBeing {
    private String name;

    public LivingBeing(String name) {
        this.name = name;
        System.out.println("Живет " + this.toString());
    }

    public abstract void dead();

    public abstract boolean getIsAlive();

    public String getName() { return name; }
}
