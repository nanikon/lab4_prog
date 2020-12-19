package ru.nanikon.ridgesOfMadness.life;

public interface IThinkable {
    void guess(String thing, boolean condition);
    void learn(String thing);
    void decide(boolean condition, String name, IConditionFunc cf);
}
