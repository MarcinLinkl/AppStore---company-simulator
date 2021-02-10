package com.company;

import com.company.People.Client;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Projects {
    public static final String BLACK = "\u001B[40m";
    public static final String RED = "\u001B[41m";
    public static final String GREEN = "\u001B[42m";
    public static final String YELLOW = "\u001B[43m";
    public static final String BLUE = "\u001B[44m";
    public static final String PURPLE = "\u001B[45m";
    public static final String CYAN = "\u001B[46m";
    public static final String WHITE = "\u001B[47m";
    public static final String RESET = "\033[0m";

    public static final String FRONTEND = "front-end";
    public static final String BACKEND = "back-end";
    public static final String BAZA_DANYCH = "bazy danych";
    public static final String MOBILE = "mobile";
    public static final String WORDPRESS = "wordpress";
    public static final String PRESTASHOP = "prestashop";


    public String name;
    public int days;
    public Client client;
    public double cost;
    public String levelOfDifficulty;
    public int levelOfDif;
    public int progress=0;
    public int progressTesting=0;
    public boolean extendedReturn=false;
    Set<String> setOfTechnologies = new HashSet<String>();

    public Projects() {
        int levelOfDiff = (getRandom(0, 2));
        this.client = (new Client());
        switch (levelOfDiff) {
            case 0 -> {
                this.name = getLowProject();
                this.days = (getRandom(7, 10));
                this.levelOfDif=0;
                this.levelOfDifficulty = getLevelOfDifficulty(0);
                this.cost = getPriceLow();
                this.setOfTechnologies = setTechnologies(levelOfDiff);

            }
            case 1 -> {
                this.name = getMedProject();
                this.days = (getRandom(10, 20));
                this.levelOfDif=1;
                this.levelOfDifficulty = getLevelOfDifficulty(1);
                this.cost = getPriceMed();
                this.setOfTechnologies = setTechnologies(levelOfDiff);
            }
            case 2 -> {
                this.name = getHardProject();
                this.days = (getRandom(17, 30));
                this.levelOfDif=2;
                this.levelOfDifficulty = getLevelOfDifficulty(2);
                this.cost = getPriceHard();
                this.setOfTechnologies = setTechnologies(levelOfDiff);


            }
        }
    }

    private String getLevelOfDifficulty(int index) {
        String[] levelOfDifficulty = {GREEN + "Low" + RESET, BLUE + "Medium" + RESET, RED + "Hard" + RESET};
        return levelOfDifficulty[index];
    }

    private Set setTechnologies(int diff) {
        String[] Technologies = {FRONTEND, BACKEND, BAZA_DANYCH, MOBILE, WORDPRESS, PRESTASHOP};
        switch (diff) {
            case 0 -> {
                for (int i = 0; i < 2; i++) {
                    {
                        setOfTechnologies.add(Technologies[getRandom(0, 5)]);
                        if (setOfTechnologies.size() != i) {
                            i = setOfTechnologies.size();
                        }

                    }
                }
            }
            case 1 -> {
                for (int i = 0; i < 3; i++) {
                    {
                        setOfTechnologies.add(Technologies[getRandom(0, 5)]);
                        if (setOfTechnologies.size() != i) {
                            i = setOfTechnologies.size();
                        }

                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < 5; i++) {
                    {
                        setOfTechnologies.add(Technologies[getRandom(0, 5)]);
                        if (setOfTechnologies.size() != i) {
                            i = setOfTechnologies.size();
                        }

                    }
                }
            }
        }
        return setOfTechnologies;
    }

    private Double getPriceLow() {
        double[] pricesLow = {200, 400, 600, 800, 1400, 2000, 700, 1100, 2000, 1240};
        return pricesLow[getRandom(0, pricesLow.length - 1)];
    }

    private Double getPriceMed() {
        double[] pricesMed = {700, 1400, 2100, 4500, 5100, 1800, 3000, 2600, 2999, 2350};
        return pricesMed[getRandom(0, pricesMed.length - 1)];
    }

    private Double getPriceHard() {
        double[] pricesHard = {8000, 7000, 6000, 9000, 5000, 11000, 12000, 7400, 4700, 10700};
        return pricesHard[getRandom(0, pricesHard.length - 1)];
    }

    private String getHardProject() {
        String[] projectsHard = {"Symulator reaktora termonuklearnego ITER", "Inteligentna armia dronów", "Sciśle tajny projekt działa laserowego około-orbitalnego sterowanego dzięki splontaniu kwantowemu satelitów z AI",
                "Biblioteka miejska oparta na technologii zdecentralizowanego block-chaina", "System inteligętnych odkurzaczy ulicznych "};
        return projectsHard[getRandom(0, projectsHard.length - 1)];
    }

    private String getMedProject() {
        String[] projectsMed = {"Symulator lotu śmigłowcem", "Księgarnia", "Forum miłośników broni palnej i straszenia kotów", "Oprogramowanie optymalizacyjno - podatkowe", "Strona miłośników likieru"};
        return projectsMed[getRandom(0, projectsMed.length - 1)];
    }

    private String getLowProject() {
        String[] projectsLow = {"Kawiarenka Pani Zosi", "Sklep z zachodnim ziołem", "Blog libernalo-neomarksistowski", "Wsparcie krawieckie online", "Strona dyskoteki szkolnej"};
        return projectsLow[getRandom(0, projectsLow.length - 1)];
    }

    public static int getRandom(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}




