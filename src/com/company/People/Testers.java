package com.company.People;

import com.company.Projects;

public class Testers extends People{
    public double payment;


    public Testers() {
        int Typ = Projects.getRandom(0, 4);
        switch (Typ) {
            case 0 -> this.payment = 2100;
            case 1 -> this.payment = 2500;
            case 2 -> this.payment = 3000;
            case 3 -> this.payment = 3500;
            case 4 -> this.payment = 4500;

        }
    }}
