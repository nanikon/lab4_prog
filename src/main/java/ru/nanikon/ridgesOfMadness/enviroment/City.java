package ru.nanikon.ridgesOfMadness.enviroment;

import java.util.Arrays;

public class City {
    private String name;
    private Pattern design;
    private int age;
    private Building[] buildings = {};

    public City(String name) {
        this.name = name;
        this.age = 0;
    }

    public void setDesign(Pattern design) {
        this.design = design;
    }

    public Pattern getDesign() { return design; }

    public int getAge() { return age; }

    private void incAge() { ++age; }

    public void update() {
        incAge();
        for (Building build: buildings) {
            build.update();
        }
    }

    public String getName() {
        return name;
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

    public void addBuilding(Building building) {
        int l = buildings.length;
        buildings = Arrays.copyOf(buildings, l + 1);
        buildings[l] = building;
    }

    public Building[] getBuildings() {
        return buildings;
    }

    public boolean checkBuilding(Building building) {
        boolean result = false;
        for (Building build : getBuildings()) {
            if (build.equals(building)) {
                result = true;
                break;
            }
        }
        return result;
    }

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
