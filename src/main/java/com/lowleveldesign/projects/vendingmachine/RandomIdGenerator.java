package com.lowleveldesign.projects.vendingmachine;

import java.util.Random;

public class RandomIdGenerator {
    private static int start = 0;
    public static int generateRandomId() {
        return start++;
    }
}
