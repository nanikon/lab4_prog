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
        private int age;
        private final int criticAge;
        private String nextCondition;
        private String condition;

        public Furniture(int criticAge) {
            super("здесь находится мебель");
            this.age = 0;
            this.criticAge = criticAge;
            this.condition = "мебель";
        }

        public void update() {
            ++age;
            if (criticAge <= age) {
                condition = nextCondition;
            }
        }

        public void setNextCondition(String nextCondition) {
            this.nextCondition = nextCondition;
            System.out.println(this.nextCondition);
        }

        @Override
        public String getInformation() {
            return "здесь находится " + condition;
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
