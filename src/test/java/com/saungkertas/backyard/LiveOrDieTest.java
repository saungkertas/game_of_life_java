package com.saungkertas.backyard;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LiveOrDieTest {

    @Test
    public void statusZeroWhenCurrentStatusIsOneAndAliveNeighboursLessThanTwo() {
        LiveOrDie liveOrDie = new LiveOrDie(1, 1);
        assertThat(liveOrDie.isAlive(), is(equalTo(0)));
    }

    @Test
    public void statusZeroWhenCurrentStatusIsOneAndAliveNeighboursMoreThanThree() {
        LiveOrDie liveOrDie = new LiveOrDie(1, 4);
        assertThat(liveOrDie.isAlive(), is(equalTo(0)));
    }

    @Test
    public void statusOneWhenCurrentStatusIsZeroAndAliveNeighboursIsNotThree() {
        LiveOrDie liveOrDie = new LiveOrDie(0, 2);
        assertThat(liveOrDie.isAlive(), is(equalTo(0)));
    }
}
