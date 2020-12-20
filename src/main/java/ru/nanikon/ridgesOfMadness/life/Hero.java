package ru.nanikon.ridgesOfMadness.life;

import ru.nanikon.ridgesOfMadness.enviroment.Building;
import ru.nanikon.ridgesOfMadness.enviroment.City;
import ru.nanikon.ridgesOfMadness.enviroment.InformativeObject;
import ru.nanikon.ridgesOfMadness.exceptions.LifeException;

import java.util.Arrays;

public class Hero extends Human implements IMovable, ISensible, IThinkable, ISeeable, ITalkable {
    private Building.Room location;
    private City cityLocation;
    private Feeling feeling;
    private String[] information = {};

    public Hero(String name) {
        super(name);
    }

    public Building.Room getLocation() { return location; }

    public City getCityLocation() { return cityLocation; }

    public String[] getInformation() { return information; }

    public Feeling getFeeling() { return feeling; }

    @Override
    public void move(City city) {
        cityLocation = city;
        System.out.println(this.toString() + " переместился в " + city.toString());
    }

    @Override
    public void go(Building.Room room) {
        location = room;
        System.out.println(this.toString() + " перешел в " + room.getBuilding().toString() + room.toString());
    }

    @Override
    public void decide(boolean condition, String name, IConditionFunc cf) {
        if (!getIsAlive()) {
            throw new LifeException(this.toString() + " умер, и больше ничего не решит");
        } else if (condition) {
            System.out.println(this.toString() + " решил совершить действие: " + name);
            cf.func();
        } else {
            System.out.println(this.toString() + " решил не совершать действие: " + name);
        }
    }

    @Override
    public void talk(Hero other, String information) {
        if (!getIsAlive()) {
            throw new LifeException(this.toString() + " умер, и больше ничего не скажет");
        }
        System.out.println(this.toString() + " сказал " + other.toString() + ": " + information);
        other.learn(information);
    }

    @Override
    public void changeFeeling(Feeling feeling) {
        if (!getIsAlive()) {
            throw new LifeException(this.toString() + " умер, и больше ничего не почувствует");
        }
        this.feeling = feeling;
        this.checkFeeling();
    }

    @Override
    public void checkFeeling() {
        System.out.println("Состояние " + this.getName() + ": " + feeling.getName());
    }

    @Override
    public void guess(String thing, boolean condition) {
        if (!getIsAlive()) {
            throw new LifeException(this.toString() + " умер, и больше ни о чем не догадается");
        } else if (condition) {
            int l = this.information.length;
            this.information = Arrays.copyOf(this.information, l + 1);
            this.information[l] = thing;
            System.out.println(this.toString() + " догадался о " + thing);
        } else {
            System.out.println(this.toString() + " не смог догадаться о " + thing);
        }
    }

    @Override
    public void learn(String thing) {
        if (!getIsAlive()) {
            throw new LifeException(this.toString() + " умер, и больше ничего не узнает");
        }
        int l = this.information.length;
        this.information = Arrays.copyOf(this.information, l + 1);
        this.information[l] = thing;
        System.out.println(this.toString() + " узнал: " + thing);
    }

    @Override
    public void see(InformativeObject obj) {
        if (!getIsAlive()) {
            throw new LifeException(this.toString() + " умер, и больше ничего не увидит");
        }
        System.out.println(this.toString() + " смотрит на " + obj.toString());
        this.learn(obj.getInformation());
    }

    @Override
    public void lookAround() {
        InformativeObject[] objects = location.getObjects();
        for (InformativeObject thing: objects) {
            see(thing);
        }
    }

    @Override
    public String toString() {
        return "герой " + this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hero) {
            obj = (Hero) obj;
            return this.toString().equals(obj.toString()) & (this.getLocation() == ((Hero) obj).getLocation()) & (Arrays.equals(this.information, ((Hero) obj).getInformation())) & (this.feeling == ((Hero) obj).getFeeling());
        }  else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (this.toString() + " в состоянии " + this.getFeeling().getName()).hashCode();
    }
}
