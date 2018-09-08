package com.saungkertas.backyard;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int matrix = 20;

        HashMap<Object, Integer> grid = new HashMap<>();
        HashMap<Object, Integer> nextGrid = new HashMap<>();
        for (int x = -1; x <= matrix; x++) {
            for (int y = -1; y <= matrix; y++) {
                grid.put(new Point(x, y), 0);
                nextGrid.put(new Point(x, y), 0);
            }
        }

        grid.put(new Point(3, 2), 1);
        grid.put(new Point(3, 3), 1);
        grid.put(new Point(3, 4), 1);

        for (int x = 0; x < matrix; x++) {
            for (int y = 0; y < matrix; y++) {
                if (getPointValue(grid, x, y) == 0) {
                    System.out.print("   ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }

        while (true) {
            for (int x = 0; x < matrix; x++) {
                for (int y = 0; y < matrix; y++) {
                    int aliveNeighbours = getPointValue(grid, x - 1, y - 1) +
                            getPointValue(grid, x - 1, y) +
                            getPointValue(grid, x - 1, y + 1) +
                            getPointValue(grid, x, y - 1) +
                            getPointValue(grid, x, y + 1) +
                            getPointValue(grid, x + 1, y - 1) +
                            getPointValue(grid, x + 1, y) +
                            getPointValue(grid, x + 1, y + 1);

                    LiveOrDie liveOrDie = new LiveOrDie(getPointValue(grid, x, y), aliveNeighbours);
                    int status = liveOrDie.isAlive();
                    nextGrid.put(new Point(x, y), status);
                }
            }

            for (int x = 0; x < matrix; x++) {
                for (int y = 0; y < matrix; y++) {
                    grid.put(new Point(x, y), nextGrid.get(new Point(x, y)));
                }
            }

            for (int x = 0; x < matrix; x++) {
                for (int y = 0; y < matrix; y++) {
                    if (getPointValue(grid, x, y) == 0) {
                        System.out.print("   ");
                    } else {
                        System.out.print(" * ");
                    }
                }
                System.out.println();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Integer getPointValue(HashMap<Object, Integer> grid, int x, int y) {
        return grid.get(new Point(x, y));
    }
}
