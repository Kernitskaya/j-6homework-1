package ru.testing.statistics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StatsServiceTest {

    static final int[] NUMBERS = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
    private StatsService statsService = new StatsService();

    public static Stream<Arguments> averageArguments() {
        return Stream.of(
                Arguments.of(new int[] {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18}, 15.0),
                Arguments.of(new int[] {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 16}, 15.0)
        );
    }

    @Test
    void testSum() {
        final int expected = 180;
        assertEquals(expected, statsService.salesSum(NUMBERS));
    }

    @ParameterizedTest
    @MethodSource("averageArguments")
    void testAverage(int[] array, double expected) {
        assertEquals(expected, statsService.salesAverage(array));
    }

    @Test
    void testGetMonthIndexWithMaxSale() {
        final int expected = 8;
        assertEquals(expected, statsService.getMonthIndexWithMaxSale(NUMBERS));
    }

    @Test
    void testMonthWithMinSale() {
        final int expected = 9;
        assertEquals(expected, statsService.getMonthIndexWithMinSale(NUMBERS));
    }

    @Test
    void testGetMonthCountLessAvg() {
        final int expected = 5;
        assertEquals(expected, statsService.getMonthCountLessAvg(NUMBERS));
    }

    @Test
    void testGetMonthCountGreaterAvg() {
        final int expected = 5;
        assertEquals(expected, statsService.getMonthCountGreaterAvg(NUMBERS));
    }
}