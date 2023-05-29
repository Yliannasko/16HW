package org.example.tournament;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Игрок  именем не найден" + playerName);
    }
}
