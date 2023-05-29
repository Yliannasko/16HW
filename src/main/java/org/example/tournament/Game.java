package org.example.tournament;

import java.util.ArrayList;
import java.util.List;


public class Game {

    List<Player> playerList = new ArrayList<>();

    //метод регистрации игрока
    public void register(Player player) {
        playerList.add(player);
    }

    //метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : playerList) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) { // зарегистрирован или нет
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1.getStrength() > player2.getStrength()) { //проверка силы игрока
            return 1;
        }
        if (player2.getStrength() > player1.getStrength()) {
            return 2;
        }
        return 0;
    }
}



