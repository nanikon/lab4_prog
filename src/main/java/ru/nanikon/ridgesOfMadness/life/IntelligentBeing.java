package ru.nanikon.ridgesOfMadness.life;

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
    public City build(String name) {
        if (this.getIsAlive()) {
            City build = new City(name);
            System.out.println(this.toString() + " строит " + build.toString());
            return build;
        } else {
            throw new LifeException(this.toString() + " умер, и больше ничего не построит");
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
    public void addThing(City city, InformativeObject obj) {
        if (this.getIsAlive()) {
            city.addComponent(obj);
            System.out.println(this.toString() + " добавляет в " + city.toString() + " " + obj.toString());
        } else {
            throw new LifeException(this.toString() + " умер, и больше ничего не добавит");
        }
    }
}
