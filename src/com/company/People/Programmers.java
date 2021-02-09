package com.company.People;

import com.company.Projects;

import java.util.HashSet;
import java.util.Set;

public class Programmers extends People {

    public Set<String> workerTechnologies = new HashSet<String>();
    public double payment;
    public String precision;
    //public String fidelity;
    public String punctuality;


    public Programmers(int levelOfKnowledge) {
        for (int i = 0; i < levelOfKnowledge; i++)
            workerTechnologies.add(getRandomTechnology());
        if (levelOfKnowledge == 1) {
            payment = 2500;
        } else if (levelOfKnowledge == 2) {
            payment = 4000;
        } else if (levelOfKnowledge == 3) {
            payment = 5000;
        } else if (levelOfKnowledge == 4) {
            payment = 6000;
        } else if (levelOfKnowledge == 5) {
            payment = 7000;
        } else if (levelOfKnowledge == 6) {
            payment = 10000;
        }
        int i = getRandom(1, 3);
        int j = getRandom(1, 3);
        if (i == 1)
            precision = "niedbały/lekkoduch";
        else if (i == 2)
            precision = "roztrzepany/ambitny";
        else if (i == 3)
            precision = "arcymistrzowski";
        if (j == 1)
            punctuality = "mało punktualny";
        if (j == 2)
            punctuality = "średnio punktalny";
        if (j == 3)
            punctuality = "terminowy";


    }

    private String getRandomTechnology() {
        String[] Technologies = {Projects.FRONTEND, Projects.BACKEND, Projects.BAZA_DANYCH, Projects.MOBILE, Projects.WORDPRESS, Projects.PRESTASHOP};
        return Technologies[getRandom(0, 5)];
    }


}
