package ru.nanikon.ridgesOfMadness.life;

public class Dinosaur extends LivingBeing {
    private boolean isAlive = true;

    public Dinosaur() {
        super("Рекс");
    }

    public Dinosaur(String name) {
        super(name);
    }

    @Override
    public boolean getIsAlive() { return isAlive; }

    @Override
    public void dead() {
        this.isAlive = false;
        System.out.println(this.toString() + " вымер, как и его сородичи");
    }

    @Override
    public String toString() {
        return "динозавр " + this.getName();
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
