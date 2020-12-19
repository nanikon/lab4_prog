package ru.nanikon.ridgesOfMadness.enviroment;

public enum Period {
    MILLIONS_YEARS_AGO(Pattern.FIVE_POINTED, "миллионы лет назад"),
    PRIMITIVE_TRIBE(Pattern.TOTEM_ANIMAL, "первобытных племен"),
    EGYPTIAN_CIVILIZATION(Pattern.SCARAB, "египетской цивилизации"),
    MINOAN_CIVILIZATION(Pattern.SACRED_BULL, "минойской цивилизации"),
    PRESENT("настоящее");

    private Pattern design;
    private String name;
    Period(String name) {
        this.design = null;
        this.name = name;
    }

    Period(Pattern design, String name) {
        this.design = design;
        this.name = name;
    }

    public String getName() { return name; }
    public Pattern getDesign() { return design; }
    public Period nextPeriod() {
        Period[] timing = Period.values();
        int volume = timing.length;
        int next = this.ordinal() + 1;
        if (next >= volume) {
            return Period.PRESENT;
        } else {
            return timing[next];
        }
    }
}
