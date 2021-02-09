package com.company.People;

import java.util.Random;

public class People {

    public String name;
    public String lastName;


    public People() {
        this.name = getRandomName();
        this.lastName = getRandomLastName();
    }

    public int getRandom(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }

    private String getRandomName() {
        String[] names = {"Michał", "Damian", "Robert", "Krzysztof", "Angelika", "Aleksandra", "Wiolka ", "Pamela", "Dorota", "Franciszek", "Piotruś", "Maniek", "Ireneusz"};
        return names[getRandom(0, names.length - 1)];
    }

    private String getRandomLastName() {
        String[] lastName = {"Kuśtyka", "Paradownik", "Ożeszty", "Smagawiatr", "Upizdżyńska", "Pudelłebka", "Dużeuda", "Staranoga", "Zabierze", "Utrzynoska", "Ożeszpański", "Kurzydupa"};
        return lastName[getRandom(0, lastName.length - 1)];
    }

}
