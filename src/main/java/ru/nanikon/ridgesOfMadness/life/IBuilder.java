package ru.nanikon.ridgesOfMadness.life;

import ru.nanikon.ridgesOfMadness.enviroment.Building;
import ru.nanikon.ridgesOfMadness.enviroment.City;
import ru.nanikon.ridgesOfMadness.enviroment.InformativeObject;
import ru.nanikon.ridgesOfMadness.enviroment.Pattern;

public interface IBuilder {
    City establish(String name);
    Building build(City city, String name, boolean order, int[] template);
    void decorate(City city, Pattern design);
    void addThing(Building building, InformativeObject obj);
}
