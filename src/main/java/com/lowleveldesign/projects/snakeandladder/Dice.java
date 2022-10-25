package com.lowleveldesign.projects.snakeandladder;

import java.util.Random;

public class Dice {
    private static Random random = new Random();
    public static int getDiceRoll() {
        return 1 + random.nextInt(6);
    }
}
