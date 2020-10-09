package ru.testing.statistics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StatsServiceTest {

    static final int[] NUMBERS = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};

    @Test
    void testSum() {
        StatsService statsService = new StatsService();
        final int expected = 180;
        assertEquals(expected, statsService.salesSum(NUMBERS));
    }

    @Test
    void testAverage() {
        StatsService statsService = new StatsService();
        final double expected = 15.0;
        assertEquals(expected, statsService.salesAverage(NUMBERS));
    }

    @Test
    void testGetMonthIndexWithMaxSale() {
        StatsService statsService = new StatsService();
        final int expected = 8;
        assertEquals(expected, statsService.getMonthIndexWithMaxSale(NUMBERS));
    }

    @Test
    void testMonthWithMinSale() {
        StatsService statsService = new StatsService();
        final int expected = 9;
        assertEquals(expected, statsService.monthWithMinSale(NUMBERS));
    }

    @Test
    void testGetMonthCountLessAvg() {
        StatsService statsService = new StatsService();
        final int expected = 5;
        assertEquals(expected, statsService.getMonthCountLessAvg(NUMBERS));
    }

    @Test
    void testGetMonthCountGreaterAvg() {
        StatsService statsService = new StatsService();
        final int expected = 5;
        assertEquals(expected, statsService.getMonthCountGreaterAvg(NUMBERS));
    }
}