package ru.nanikon.ridgesOfMadness.life;

public interface IThinkable {
    void guess(String thing, boolean condition);
    void learn(String thing, boolean condition);
    void decide(boolean condition, String name, IConditionFunc cf);
}
