package com.saungkertas.backyard;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int matrixX = 20;
        int matrixY = 20;
        int maxX = 20;
        int maxY = 20;
        int minX = 0;
        int minY = 0;
        boolean expandMinX;
        boolean expandMinY;
        boolean expandMaxX;
        boolean expandMaxY;

        HashMap<Object, Integer> grid = new HashMap<>();
        HashMap<Object, Integer> nextGrid = new HashMap<>();
        for (int x = -1; x <= matrixX; x++) {
            for (int y = -1; y <= matrixY; y++) {
                grid.put(new Point(x, y), 0);
                nextGrid.put(new Point(x, y), 0);
            }
        }

        //glider
        grid.put(new Point(2, 2), 1);
        grid.put(new Point(4, 2), 1);
        grid.put(new Point(3, 3), 1);
        grid.put(new Point(4, 3), 1);
        grid.put(new Point(3, 4), 1);

        //blinker
//        grid.put(new Point(3, 2), 1);
//        grid.put(new Point(3, 3), 1);
//        grid.put(new Point(3, 4), 1);

        for (int x = 0; x < matrixX; x++) {
            for (int y = 0; y < matrixY; y++) {
                if (getPointValue(grid, x, y) == 0) {
                    System.out.print("   ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }

        while (true) {
            expandMinX = false;
            expandMinY = false;
            expandMaxX = false;
            expandMaxY = false;

            for (int x = minX; x < maxX; x++) {
                for (int y = minY; y < maxY; y++) {
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

            for (int x = minX; x < maxX; x++) {
                for (int y = minY; y < maxY; y++) {
                    grid.put(new Point(x, y), nextGrid.get(new Point(x, y)));
                    if (grid.get(new Point(x, maxY - 1)) == 1) {
                        expandMaxY = true;
                    }
                    if (grid.get(new Point(x, minY)) == 1) {
                        expandMinY = true;
                    }
                    if (grid.get(new Point(maxX - 1, y)) == 1) {
                        expandMaxX = true;
                    }
                    if (grid.get(new Point(minX, y)) == 1) {
                        expandMinX = true;
                    }
                }
            }

            if (expandMaxX) {
                maxX += 1;
                for (int y = minY - 1; y <= maxY + 1; y++) {
                    grid.put(new Point(maxX, y), 0);
                }
            }
            if (expandMinX) {
                minX -= 1;
                for (int y = minY - 1; y < maxY; y++) {
                    grid.put(new Point(minX, y), 0);
                }
            }
            if (expandMaxY) {
                maxY += 1;
                for (int x = minX - 1; x < maxX; x++) {
                    grid.put(new Point(x, maxY), 0);
                }
            }
            if (expandMinY) {
                minY -= 1;
                for (int x = minX - 1; x < maxX; x++) {
                    grid.put(new Point(x, minY), 0);
                }
            }

            for (int x = 0; x < matrixX; x++) {
                for (int y = 0; y < matrixY; y++) {
                    if (getPointValue(grid, x, y) == 0) {
                        System.out.print("   ");
                    } else {
                        System.out.print(" * ");
                    }
                }
                System.out.println();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Integer getPointValue(HashMap<Object, Integer> grid, int x, int y) {
        return grid.get(new Point(x, y));
    }
}
