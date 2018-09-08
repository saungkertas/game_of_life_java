package com.saungkertas.backyard;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int matrix = 10;

        HashMap grid = new HashMap();
        for (int x = 0; x < matrix; x++) {
            for (int y = 0; y < matrix; y++) {
                grid.put(new Point(x, y), 0);
            }
        }

        for (int x = 0; x < matrix; x++) {
            for (int y = 0; y < matrix; y++) {
                if (grid.get(new Point(x, y)).equals(0)) {
                    System.out.print("   ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }
}
