package ru.nanikon.ridgesOfMadness;

import ru.nanikon.ridgesOfMadness.enviroment.Bas;
import ru.nanikon.ridgesOfMadness.enviroment.City;
import ru.nanikon.ridgesOfMadness.enviroment.Period;
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
        City labyrinth = strange.build("Лабиринт");
        cities[0] = labyrinth;
        strange.addThing(labyrinth, new Bas("страшная тайна"));
        strange.decorate(labyrinth, now.getDesign());
        now = Main.changeTime(now, cities, beings);
        while (now != Period.PRESENT) {
            int i = now.ordinal() - 1;
            Human human = new Human(names[i]);
            beings[3] = human;
            cities[i + 1] = human.build(cityNames[i]);
            human.decorate(cities[i], now.getDesign());
            now = Main.changeTime(now, cities, beings);
        }
        Human human = new Human();
        Hero teller = new Hero("Рассказчик");
        Hero dan = new Hero("Денфорт");
        City camp = human.build("Лагерь");
        teller.move(camp);
        dan.move(camp);
        teller.changeFeeling(Feeling.STUNNED);
        dan.changeFeeling(Feeling.STUNNED);
        teller.move(labyrinth);
        dan.move(labyrinth);
        labyrinth.findCondition();
        teller.changeFeeling(Feeling.NO_MENTAL_BALANCE);
        dan.changeFeeling(Feeling.NO_MENTAL_BALANCE);
        teller.guess("что-то", teller.getLocation() == labyrinth);
        dan.guess("что-то", teller.getLocation() == labyrinth);
        teller.decide(false, "поделиться догадкой", () -> {teller.talk(dan, "что-то");});
        dan.decide(false, "поделиться догадкой", () -> {dan.talk(teller, "что-то");});
        teller.changeFeeling(Feeling.PANIC);
        dan.changeFeeling(Feeling.PANIC);
        teller.see(labyrinth.getObjects()[0]);
        dan.see(labyrinth.getObjects()[0]);
        teller.changeFeeling(Feeling.DESTROYED_WORlD);
        dan.changeFeeling(Feeling.DESTROYED_WORlD);
    }

    public static Period changeTime(Period now, City[] cities, LivingBeing[] beings) {
        for (City city: cities) {
            if (city != null) {
                city.incAge();
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
