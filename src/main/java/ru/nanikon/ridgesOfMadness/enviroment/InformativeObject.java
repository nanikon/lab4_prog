package ru.nanikon.ridgesOfMadness.enviroment;

abstract public class InformativeObject {
    private String information;

    public InformativeObject(String information) {
        this.information = information;
    }

    public String getInformation() { return information; }

    public void setInformation(String information) {
        this.information = information;
    }

    public static class Relief extends InformativeObject {
        public Relief() {
            super("страшная тайна");
        }

        public Relief(String information) {
            super(information);
        }

        @Override
        public String toString() {
            return "барельеф";
        }
    }

    public static class WallDrawing extends InformativeObject {
        public WallDrawing() {
            super("здесь находилась странная мебель");
        }

        public WallDrawing(String information) {
            super(information);
        }

        @Override
        public String toString() {
            return "настенный рисунок";
        }
    }

    public static class Furniture extends InformativeObject {
        private String condition;
        public Furniture() {
            super("здесь находится мебель");
            condition = "мебель";
        }

        public Furniture(String information) {
            super(information);
            condition = "мебель";
        }

        public void update() {
            condition = "рухлядь";
            setInformation("здесь находится " + condition);
        }

        @Override
        public String toString() {
            return condition;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            obj = (InformativeObject) obj;
            return this.getInformation().equals(((InformativeObject) obj).getInformation());
        } else {
            return false;
        }
    }
}
