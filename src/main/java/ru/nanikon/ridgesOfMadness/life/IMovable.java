package ru.nanikon.ridgesOfMadness.life;

import ru.nanikon.ridgesOfMadness.enviroment.Building;
import ru.nanikon.ridgesOfMadness.enviroment.City;

public interface IMovable {
    void move(City city);
    void go(Building.Room room);
}
