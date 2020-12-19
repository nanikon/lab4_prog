package ru.nanikon.ridgesOfMadness.life;

import ru.nanikon.ridgesOfMadness.enviroment.City;
import ru.nanikon.ridgesOfMadness.enviroment.InformativeObject;

import java.util.Arrays;

public class Hero extends Human implements IMovable, ISensible, IThinkable, ISeeable, ITalkable {
    private City location;
    private Feeling feeling;
    private String[] information = {};

    public Hero(String name) {
        super(name);
    }

    public City getLocation() { return location; }

    public String[] getInformation() { return information; }

    public Feeling getFeeling() { return feeling; }

    @Override
    public void move(City city) {
        location = city;
        System.out.println(this.toString() + " переместился в " + city.toString());
    }

    @Override
    public void decide(boolean condition, String name, IConditionFunc cf) {
        if (condition) {
            System.out.println(this.toString() + " решил совершить действие: " + name);
            cf.func();
        } else {
            System.out.println(this.toString() + " решил не совершать действие: " + name);
        }
    }

    @Override
    public void talk(Hero other, String information) {
        System.out.println(this.toString() + " сказал " + other.toString() + ": " + information);
        other.learn(information);
    }

    @Override
    public void changeFeeling(Feeling feeling) {
        this.feeling = feeling;
        this.checkFeeling();
    }

    @Override
    public void checkFeeling() {
        System.out.println("Состояние " + this.getName() + ": " + feeling.getName());
    }

    @Override
    public void guess(String thing, boolean condition) {
        if (condition) {
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
        int l = this.information.length;
        this.information = Arrays.copyOf(this.information, l + 1);
        this.information[l] = thing;
        System.out.println(this.toString() + " узнал о " + thing);
    }

    @Override
    public void see(InformativeObject obj) {
        System.out.println(this.toString() + " смотрит на " + obj.toString());
        this.learn(obj.getInformation());
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
