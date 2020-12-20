package ru.nanikon.ridgesOfMadness;

import ru.nanikon.ridgesOfMadness.enviroment.Building;
import ru.nanikon.ridgesOfMadness.enviroment.City;
import ru.nanikon.ridgesOfMadness.enviroment.InformativeObject;
import ru.nanikon.ridgesOfMadness.enviroment.Period;
import ru.nanikon.ridgesOfMadness.exceptions.EndBuildingException;
import ru.nanikon.ridgesOfMadness.life.*;

public class Main {
    public static void main(String[] args) {
        City[] cities = new City[5];
        LivingBeing[] beings = {null, null, null, null};
        String[] cityNames = {"Иерехон", "Фивы", "Кносс"};
        String[] names = {"Первобытный", "Египтянин", "Минойсец"};
        Period now = Period.MILLIONS_YEARS_AGO;
        System.out.println("Время " + now.getName());
        UnknownBeing strange = new UnknownBeing("Первый");
        beings[0] = strange;
        beings[1] = new Dinosaur();
        beings[2] = new Mammal();
        City labyrinth = strange.establish("Лабиринт");
        cities[0] = labyrinth;
        Building guildHall = strange.build(labyrinth, "Главное здание", false, new int[]{1, 2, 1});
        guildHall.getRoom(1,0).setNextFurnitureCondition("песок");
        guildHall.getRoom(1,1).setNextFurnitureCondition("пустота");
        strange.addThing(guildHall, new InformativeObject.Furniture());
        strange.addThing(guildHall, new InformativeObject.WallDrawing());
        strange.addThing(guildHall, new InformativeObject.Relief());
        strange.decorate(labyrinth, now.getDesign());
        now = Main.changeTime(now, cities, beings);
        while (now != Period.PRESENT) {
            int i = now.ordinal() - 1;
            Human human = new Human(names[i]);
            beings[3] = human;
            cities[i + 1] = human.establish(cityNames[i]);
            human.decorate(cities[i], now.getDesign());
            now = Main.changeTime(now, cities, beings);
        }
        Human human = new Human();
        Hero teller = new Hero("Рассказчик");
        Hero dan = new Hero("Денфорт");
        City camp = human.establish("Лагерь");
        teller.move(camp);
        dan.move(camp);
        teller.changeFeeling(Feeling.STUNNED);
        dan.changeFeeling(Feeling.STUNNED);
        teller.move(labyrinth);
        dan.move(labyrinth);
        labyrinth.findCondition();
        if (labyrinth.getAge() >= 4) {
            class Defects extends InformativeObject {
                private String name;

                Defects(String name) {
                    super("от времени здесь появились " + name);
                    this.name = name;
                }

                @Override
                public String toString() {
                    return name;
                }
            }
            guildHall.getRoom(1, 1).addObject(new Defects("трещины"));
            guildHall.getRoom(2, 0).addObject(new Defects("расколы"));
        }
        teller.go(teller.getCityLocation().getBuildings()[0].getEntrance());
        dan.go(teller.getCityLocation().getBuildings()[0].getEntrance());
        teller.lookAround();
        dan.lookAround();
        teller.changeFeeling(Feeling.NO_MENTAL_BALANCE);
        dan.changeFeeling(Feeling.NO_MENTAL_BALANCE);
        try {
            teller.go(teller.getLocation().nextRoom());
            dan.go(dan.getLocation().nextRoom());
        } catch (EndBuildingException e) {
            System.out.println(e.getMessage());
        }
        teller.lookAround();
        dan.lookAround();
        teller.guess("что-то", teller.getCityLocation() == labyrinth);
        dan.guess("что-то", teller.getCityLocation() == labyrinth);
        teller.decide(false, "поделиться догадкой", () -> {teller.talk(dan, "что-то");});
        dan.decide(false, "поделиться догадкой", () -> {dan.talk(teller, "что-то");});
        try {
            teller.go(teller.getLocation().nextRoom());
            dan.go(dan.getLocation().nextRoom());
        } catch (EndBuildingException e) {
            System.out.println(e.getMessage());
        }
        teller.lookAround();
        dan.lookAround();
        teller.changeFeeling(Feeling.PANIC);
        dan.changeFeeling(Feeling.PANIC);
        try {
            teller.go(teller.getLocation().nextRoom());
            dan.go(dan.getLocation().nextRoom());
        } catch (EndBuildingException e) {
            System.out.println(e.getMessage());
        }
        teller.lookAround();
        dan.lookAround();
        teller.changeFeeling(Feeling.DESTROYED_WORlD);
        dan.changeFeeling(Feeling.DESTROYED_WORlD);
    }

    public static Period changeTime(Period now, City[] cities, LivingBeing[] beings) {
        for (City city: cities) {
            if (city != null) {
                city.update();
            }
        }
        for (LivingBeing being: beings) {
            if (being != null) {
                if (being.getIsAlive()) {
                    being.dead();
                }
            }
        }
        now = now.nextPeriod();
        System.out.println("\nВремя " + now.getName());
        return now;
    }

}
