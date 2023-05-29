package org.example.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Sasha19", 16);
    Player player2 = new Player(2, "Masha2000", 10);
    Player player3 = new Player(3, "Ivan18", 16);

    @Test
    public void shouldTestWhenPlayer2StrongerPlayer1() {
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Masha2000", "Sasha19");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenPlayer1StrongerPlayer2() {
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Sasha19", "Masha2000");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenPlayer1EqualsPlayer3() {
        game.register(player1);
        game.register(player3);
        int expected = 0;
        int actual = game.round("Sasha19", "Ivan18");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenPlayer1NotFound() {
        game.register(player1);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Oleg222", "Ivan18"));
    }

    @Test
    public void shouldTestWhenPlayer2NotFound() {
        game.register(player1);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Sasha19", "Petya18"));
    }

    @Test
    public void shouldTestWhenAllPlayersNotFound() {
        game.register(player1);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Oleg222", "Petya18"));
    }

}
