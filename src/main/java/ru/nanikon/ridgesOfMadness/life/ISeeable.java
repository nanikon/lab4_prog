package ru.nanikon.ridgesOfMadness.life;

import ru.nanikon.ridgesOfMadness.enviroment.Building;
import ru.nanikon.ridgesOfMadness.enviroment.InformativeObject;

public interface ISeeable {
    void see(InformativeObject obj);
    void lookAround();
}
