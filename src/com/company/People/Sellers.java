package com.company.People;

import com.company.Projects;

public class Sellers extends People {
    public double payment;


    public Sellers() {
        int Typ =Projects.getRandom(0,5);
        switch (Typ) {
            case 0 -> this.payment = 2700;
            case 1 -> this.payment = 3200;
            case 2 -> this.payment = 3500;
            case 3 -> this.payment = 4000;
            case 4 -> this.payment = 5000;
            case 5 -> this.payment = 7000;
        }
    }
}


