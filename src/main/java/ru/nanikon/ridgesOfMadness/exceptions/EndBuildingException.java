package ru.nanikon.ridgesOfMadness.exceptions;

public class EndBuildingException extends Exception {
    public EndBuildingException() {
        super("Герой дошел до конца здания");
    }
}
