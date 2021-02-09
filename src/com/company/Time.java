package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {

    public int dayOfWeek = 0;
    String dt;
    SimpleDateFormat sdf;
    Calendar c;
    int addProject;
    boolean haveClients;
    int lastDay;
    int currentDay;
    int daysLeft;
    public void startDate(String startDate) throws ParseException {
        this.dt = startDate;
        this.sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));

        dt = sdf.format(c.getTime());  // dt is now the new date
        //LocalDate date = LocalDate.parse(dt);
        // DayOfWeek day = date.getDayOfWeek();
        // System.out.println(day); // dayOfWeek po angielsku
        dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        addProject =0;
        haveClients =false;
    }

    public void daysleftMoth(){

        lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        currentDay = c.get(Calendar.DAY_OF_MONTH);
        daysLeft = lastDay - currentDay;


        System.out.println("*               Ostatni dzień w miesiącu: " + lastDay);
        System.out.println("*               Dzisiejszy dzień w tym miesiącu: " + currentDay);
        System.out.println("*               Pozostało "+Projects.RED + daysLeft +Projects.RESET+ " dni do końca miesiąca.");
        System.out.println("*               Pamiętaj aby mieć na opłaty/pracowników i ZUS :)");

    }
    public void nextDay() {

        c.add(Calendar.DATE, 1);
        dt = sdf.format(c.getTime());
        if (haveClients) {
            addProject++;
        }
    }

    public int returnDayInt() {
        return dayOfWeek;
    }


    public void printDay() {
        dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        System.out.println("*               Dzisiaj mamy " + dt);
        System.out.print("*               Jest ");

        // System.out.println(dayOfWeek); //dayOfWeek int
        switch (dayOfWeek) {
            case 1 -> System.out.println("niedziela");
            case 2 -> System.out.println("poniedziałek");
            case 3 -> System.out.println("wtorek");
            case 4 -> System.out.println("środa");
            case 5 -> System.out.println("czwartek");
            case 6 -> System.out.println("piątek");
            case 7 -> System.out.println("sobota");
        }
    }
}
