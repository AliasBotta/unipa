package com.tuoazienda;

import java.time.LocalDate;
// import java.time.format.TextStyle;
import java.util.Locale;
import java.time.format.DateTimeFormatter;

public class DayOfWeekCalculator {


    public int calculateDayOfWeek(int day, String month, int year) {
        Locale locale = Locale.ITALIAN;
        LocalDate date = LocalDate.of(year, monthStringToNumber(month, locale), day);
        // Il valore di ritorno è già conforme al sistema ISO-8601 dove 1 = lunedì e 7 = domenica.
        return date.getDayOfWeek().getValue();
    }

    private int monthStringToNumber(String month, Locale locale) {
        return LocalDate.parse("01 " + month + " 2000", DateTimeFormatter.ofPattern("dd MMMM yyyy", locale)).getMonthValue();
    }
}