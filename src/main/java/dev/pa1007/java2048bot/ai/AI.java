package dev.pa1007.java2048bot.ai;

import dev.pa1007.java2048bot.Game;

public interface AI {

    public AI.Response resolve(Game game);


    enum Response {
        UP,
        LEFT,
        DOWN,
        RIGHT
    }
}
