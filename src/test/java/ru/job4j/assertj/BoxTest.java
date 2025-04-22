package ru.job4j.assertj;

import org.assertj.core.api.AbstractCharSequenceAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void whenCubeThenVertices8() {
        Box box = new Box(8, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(8);
    }
    @Test
    void whenEdgeIsZeroThenEdgesMinus1Vertices() {
        Box box = new Box(4, 0);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(-1);
    }
    @Test
    void whenValidBoxThenExistTrue() {
        Box box = new Box(4, 5);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }
    @Test
    void whenInvalidBoxThenExistFalse() {
        Box box = new Box(6, 2);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }
    @Test
    void whenSphereEdge4ThenGetArea() {
        Box box = new Box(8, 2);
        double result = box.getArea();
        assertThat(result).isEqualTo(24);
    }
    @Test
    void whenCubeEdge2ThenGetArea() {
        Box box = new Box(4, 2);
        double result = box.getArea();
        assertThat(result).isCloseTo(6.92, withPrecision(0.01));
    }
}
