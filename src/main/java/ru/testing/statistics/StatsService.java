package ru.testing.statistics;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StatsService {

    // Сумма покупок
     int salesSum(int[] sales) {
         int sum = 0;
         for (int sale : sales) {
             sum += sale;
         }
         return sum;
     }

     // Среднее значение продаж по месяцам, учтены дробные значения
     double salesAverage(int[] sales) {
         BigDecimal decimalSum = new BigDecimal(salesSum(sales));
         BigDecimal decimalLength = new BigDecimal(sales.length);
         return decimalSum.divide(decimalLength, 2, RoundingMode.HALF_UP).doubleValue();
     }

     // Индекс месяца с максимальной выручкой
     int getMonthIndexWithMaxSale(int[] sales) {
        int monthIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= maxValue) {
                maxValue = sales[i];
                monthIndex = i;
            }
        }
        // 0 месяца не бывает
        return monthIndex + 1;
     }

    // Индекс месяца с минимальной выручкой
    int monthWithMinSale(int[] sales) {
        int monthIndex = 0;
        if (sales.length > 0) {
            int minValue = sales[0];
            for (int i = 0; i < sales.length; i++) {
                if (sales[i] <= minValue) {
                    minValue = sales[i];
                    monthIndex = i;
                }
            }
        }
        // 0 месяца не бывает
        return monthIndex + 1;
    }

    // Количесто месяцев с выручкой ниже среднего
    int getMonthCountLessAvg(int[] sales) {
        double average = salesAverage(sales);
        int monthCount = 0;
        for (int sale : sales) {
            if (sale < average) {
                monthCount++;
            }
        }
        return monthCount;
    }

    // Количесто месяцев с выручкой выше среднего
    int     getMonthCountGreaterAvg(int[] sales) {
        double average = salesAverage(sales);
        int monthCount = 0;
        for (int sale : sales) {
            if (sale > average) {
                monthCount++;
            }
        }
        return monthCount;
    }
}
