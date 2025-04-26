package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void satisfyAssert() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).isNotNull()
                .allSatisfy(e -> {
                    assertThat(e).isLessThan("twelve");
                    assertThat(e).isGreaterThan("apple");
                })
                .anySatisfy(e -> {
                    assertThat(e).isLessThan(String.valueOf("zip"));
                    assertThat(e).isEqualTo("five");
                })
                .allMatch(e -> e.compareTo("zip") < 0)
                .anyMatch(e -> e.equals("second"))
                .noneMatch(e -> e.compareTo("apple") < 0);
    }

    @Test
    void assertMap() {
        Map<Integer, String> map = Map.of(
                1, "first", 2, "second", 3, "three");
        assertThat(map).hasSize(3)
                .containsKeys(1, 3, 2)
                .containsValues("first", "second", "three")
                .doesNotContainKey(0)
                .doesNotContainValue("zero")
                .containsEntry(2, "second");
    }
}
