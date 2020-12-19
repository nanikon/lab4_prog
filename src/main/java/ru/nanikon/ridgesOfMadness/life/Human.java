package ru.nanikon.ridgesOfMadness.life;

public class Human extends IntelligentBeing {
    private boolean isAlive = true;

    public Human() {
        super("Немо");
    }

    public Human(String name) {
        super(name);
    }

    public boolean getIsAlive() { return isAlive; }

    @Override
    public void dead() {
        this.isAlive = false;
        System.out.println(this.toString() + " умер, но род людской не прервался");
    }

    @Override
    public String toString() {
        return "человек " + this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Human) {
            return this.toString().equals(obj.toString()) & (this.getIsAlive() == ((Human) obj).getIsAlive());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (this.toString() + (this.getIsAlive() ? "1" : "0")).hashCode();
    }
}
