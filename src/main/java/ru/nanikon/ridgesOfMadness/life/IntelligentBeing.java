package ru.nanikon.ridgesOfMadness.life;

import ru.nanikon.ridgesOfMadness.enviroment.Building;
import ru.nanikon.ridgesOfMadness.enviroment.City;
import ru.nanikon.ridgesOfMadness.enviroment.InformativeObject;
import ru.nanikon.ridgesOfMadness.enviroment.Pattern;
import ru.nanikon.ridgesOfMadness.exceptions.LifeException;

abstract public class IntelligentBeing extends LivingBeing implements IBuilder {
    public IntelligentBeing(String name) {
        super(name);
    }

    public abstract void dead();

    @Override
    public City establish(String name) {
        if (this.getIsAlive()) {
            City city = new City(name);
            System.out.println(this.toString() + " основывает " + city.toString());
            return city;
        } else {
            throw new LifeException(this.toString() + " умер, и больше не сможет основать ни одного города");
        }
    }

    @Override
    public Building build(City city, String name, boolean order, int[] template) {
        if (this.getIsAlive()) {
            Building building = new Building(name, order, template);
            city.addBuilding(building);
            System.out.println(this.toString() + " строит " + building.toString() + " в " + city.toString());
            System.out.println(building.getDescription());
            return building;
        } else {
            throw new LifeException(this.toString() + " умер, и больше не сможет основать ни одного города");
        }
    }

    @Override
    public void decorate(City city, Pattern design) {
        if (this.getIsAlive()) {
            city.setDesign(design);
            System.out.println(this.toString() + " украшает " + city.toString() + " декоративным элементом " + design.getName());
        } else {
            throw new LifeException(this.toString() + " умер, и больше ничего не украсит");
        }
    }

    @Override
    public void addThing(Building building, InformativeObject obj) {
        if (this.getIsAlive()) {
            building.addObject(obj);
            System.out.println(this.toString() + " добавляет в " + building.toString() + " " + obj.toString());
        } else {
            throw new LifeException(this.toString() + " умер, и больше ничего не добавит");
        }
    }
}
