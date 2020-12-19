package ru.nanikon.ridgesOfMadness.enviroment;

public enum Pattern {
    FIVE_POINTED("пятиконечие"),
    TOTEM_ANIMAL("тотемные животные"),
    SCARAB("скарабей"),
    SACRED_BULL("священный бык");

    private String name;
    Pattern(String name) {
        this.name = name;
    }
    public String getName() { return name; }
}
