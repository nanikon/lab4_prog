package ru.nanikon.ridgesOfMadness.enviroment;

import ru.nanikon.ridgesOfMadness.exceptions.EndBuildingException;

import java.util.Arrays;

public class Building {
    private final String name;
    private final Room[][] rooms;
    private final boolean order;

    public Building(String name, boolean order, int[] template) {
        this.name = name;
        this.order = order;
        int l = template.length;
        rooms = new Room[l][];
        int number = 1;
        for (int i = 0; i < l; i++) {
            int k = template[i];
            rooms[i] = new Room[k];
            for (int j = 0; j < k; j++) {
                rooms[i][j] = new Room(number++);
            }
        }
    }

    public String getName() { return name; }

    public String getDescription() {
        int l = rooms.length;
        String result = getName() + " имееет " + l + " этажей";
        for (int i = 1; i <= l; i++) {
            result = result + "\n " + i + " этаж:";
            for (Room room: rooms[i - 1]) {
                result = result + room.toString();
            }
        }
        return result;
    }

    public void addObject(InformativeObject object) {
        for (Room[] floor: rooms) {
            for (Room room: floor) {
                room.addObject(object);
            }
        }
    }

    public Room getEntrance() {
        if (order) {
            return rooms[0][0];
        } else {
            int highFloor = rooms.length - 1;
            int lastRoom = rooms[highFloor].length - 1;
            return rooms[highFloor][lastRoom];
        }
    }

    public Room getRoom(int floor, int number) {
        return rooms[floor][number];
    }

    public void update() {
        for (Room[] floor: rooms) {
            for (Room room: floor) {
                room.update();
            }
        }
    }

    @Override
    public String toString() {
        return "здание " + getName();
    }

    public class Room {
        private InformativeObject[] objects = {};
        private int id;
        private int light;
        private String nextFurnitureCondition = "рухлядь";

        public Room(int id) {
            this.id = id;
        }

        public void addObject(InformativeObject object) {
            if (object instanceof InformativeObject.Furniture) {
                InformativeObject.Furniture furniture = (InformativeObject.Furniture) object;
                furniture.setNextCondition(nextFurnitureCondition);
                //System.out.println(1);
            }
            int l = objects.length;
            objects = Arrays.copyOf(objects, l + 1);
            objects[l] = object;
        }

        public InformativeObject[] getObjects() { return objects; }

        public void setLight(int light) {
            this.light = light;
        }

        public int getLight() { return light; }

        public Building getBuilding() { return Building.this; }

        public void setNextFurnitureCondition(String nextFurnitureCondition) {
            this.nextFurnitureCondition = nextFurnitureCondition;
        }

        public void update() {
            for (InformativeObject obj: objects) {
                if (obj instanceof InformativeObject.Furniture) {
                    InformativeObject.Furniture furniture = (InformativeObject.Furniture) obj;
                    furniture.update();
                }
            }
        }

        public int getId() { return id; }

        public Room nextRoom() throws EndBuildingException {
            int number;
            if (order) {
                number = id + 1;
            } else {
                number = id - 1;
            }
            Room result = null;
            for (int i = 0; i < Building.this.rooms.length; i++) {
                for (int j = 0; j < Building.this.rooms[i].length; j++) {
                    if (number == Building.this.rooms[i][j].getId()) {
                        result = Building.this.rooms[i][j];
                    }
                }
            }
            if (result != null) {
                return result;
            } else {
                throw new EndBuildingException();
            }
        }

        @Override
        public String toString() {
            return " комната " + id;
        }
    }
}
