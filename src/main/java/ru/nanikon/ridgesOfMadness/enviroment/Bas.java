package ru.nanikon.ridgesOfMadness.enviroment;

public class Bas extends InformativeObject {
    private String information;

    public Bas(String information) {
        this.information = information;
    }

    @Override
    public String getInformation() { return information; }

    @Override
    public String toString() {
        return "барельеф";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bas) {
            obj = (Bas) obj;
            return this.getInformation().equals(((Bas) obj).getInformation());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return information.hashCode();
    }
}
