package ru.nanikon.ridgesOfMadness.life;

public enum Feeling {
    NORMAL("нормальное"),
    STUNNED("потрясенное"),
    NO_MENTAL_BALANCE("отсутствие душевного равновесия"),
    PANIC("сильный испуг"),
    DESTROYED_WORlD("привычная картина мира разрушена");

    private String name;
    Feeling(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}
