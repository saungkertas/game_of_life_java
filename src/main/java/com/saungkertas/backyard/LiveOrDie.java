package com.saungkertas.backyard;

public class LiveOrDie {

    private int status;
    private int aliveNeighbours;

    public LiveOrDie(int status, int aliveNeighbours) {
        this.status = status;
        this.aliveNeighbours = aliveNeighbours;
    }

    public int isAlive() {
        if ((this.status == 1) && (aliveNeighbours < 2)) {
            return (0);
        } else if ((this.status == 1) && (aliveNeighbours > 3)) {
            return (0);
        } else if ((this.status == 0) && (aliveNeighbours == 3)) {
            return (1);
        } else {
            return (this.status);
        }
    }
}
