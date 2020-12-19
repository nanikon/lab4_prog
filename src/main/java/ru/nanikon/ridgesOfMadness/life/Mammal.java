package ru.nanikon.ridgesOfMadness.life;

public class Mammal extends LivingBeing {
    private boolean isAlive = true;

    public Mammal() {
        super("Туш");
    }

    public Mammal(String name) {
        super(name);
    }

    public boolean getIsAlive() { return isAlive; }

    @Override
    public void dead() {
        isAlive = false;
        System.out.println(this.toString() + " умер, но его потомки значительно развились");
    }

    @Override
    public String toString() {
        return "млекопитающее " + this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dinosaur) {
            return this.toString().equals(obj.toString()) & (this.getIsAlive() == ((Dinosaur) obj).getIsAlive());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (this.toString() + (this.getIsAlive() ? "1" : "0")).hashCode();
    }
}
