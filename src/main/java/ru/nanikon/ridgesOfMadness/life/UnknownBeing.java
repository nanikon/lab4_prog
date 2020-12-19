package ru.nanikon.ridgesOfMadness.life;

public class UnknownBeing extends IntelligentBeing {
    private boolean isAlive = true;

    public UnknownBeing() {
        super("Немо");
    }

    public UnknownBeing(String name){
        super(name);
    }

    public boolean getIsAlive() { return isAlive; }

    @Override
    public void dead() {
        isAlive = false;
        System.out.println(this.toString() + " исчез, как и его сородичи");
    }

    @Override
    public String toString() {
        return "неведомое существо " + this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UnknownBeing)) return false;
        return this.toString().equals(obj.toString()) & (this.getIsAlive() == ((UnknownBeing) obj).getIsAlive());
    }

    @Override
    public int hashCode() {
        return (this.toString() + (this.getIsAlive() ? "1" : "0")).hashCode();
    }
}
