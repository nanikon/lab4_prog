package ru.nanikon.ridgesOfMadness.life;

import ru.nanikon.ridgesOfMadness.enviroment.City;
import ru.nanikon.ridgesOfMadness.enviroment.InformativeObject;
import ru.nanikon.ridgesOfMadness.enviroment.Pattern;

public interface IBuilder {
    City build(String name);
    void decorate(City city, Pattern design);
    void addThing(City city, InformativeObject obj);
}
