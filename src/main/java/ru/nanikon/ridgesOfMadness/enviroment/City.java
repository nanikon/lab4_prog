package ru.nanikon.ridgesOfMadness.enviroment;

import java.util.Arrays;

public class City {
    private String name;
    private Pattern design;
    private int age;
    private InformativeObject[] components = {};

    public City(String name) {
        this.name = name;
        this.age = 0;
    }

    public void setDesign(Pattern design) {
        this.design = design;
    }

    public Pattern getDesign() { return design; }

    public int getAge() { return age; }

    public void incAge() { ++age; }

    public String getName() {
        return name;
    }

    public void addComponent(InformativeObject component) {
        int l = components.length;
        components = Arrays.copyOf(components, l + 1);
        components[l] = component;
    }

    public String getCondition() {
        switch (age) {
            case 0:
                return "молодой";
            case 1:
                return "устоявшийся";
            case 2:
                return "старый";
            case 3:
                return "древний";
            default:
                return "очень древний";
        }
    }

    public void findCondition() {
        System.out.println(this.toString() + " " + this.getCondition());
    }

    public InformativeObject[] getObjects() { return components; }

    @Override
    public String toString(){
        return "город " + this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof City) {
            City other = (City) obj;
            return name.equals(other.getName()) && (age == other.getAge()) && (design == other.getDesign());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (this.toString() + " " + this.getCondition()).hashCode();
    }
}
