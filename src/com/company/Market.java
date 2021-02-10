package com.company;

import com.company.People.Sellers;
import com.company.People.Testers;
import com.company.People.Programmers;

import java.util.ArrayList;
import java.util.Scanner;

public class Market {
    public ArrayList<Projects> availableProjects = new ArrayList<>();
    public ArrayList<Programmers> availableProgrammers = new ArrayList<>();
    public ArrayList<Sellers> availableSellers = new ArrayList<>();
    public ArrayList<Testers> availableTesters = new ArrayList<>();

    public Market(int numberOfProjects, int numberOfProgrammers, int numberOfSeller) {
        for (int x = 0; x < numberOfProjects; x++) {
            this.availableProjects.add(new Projects());
        }
        for (int x = 0; x < numberOfProgrammers; x++) {
            this.availableProgrammers.add(new Programmers(Projects.getRandom(1, 6)));
        }
        for (int x = 0; x < numberOfSeller; x++) {
            this.availableSellers.add(new Sellers());
        }
    }
    public void makeWorkers(int numberOfTesters,int numberOfProgrammers,int numberOfSeller)
    {
        for (int x = 0; x < numberOfTesters; x++) {
            this.availableTesters.add(new Testers());
        }
        for (int x = 0; x < numberOfProgrammers; x++) {
            this.availableProgrammers.add(new Programmers(Projects.getRandom(1, 6)));
        }
        for (int x = 0; x < numberOfSeller; x++) {
            this.availableSellers.add(new Sellers());
        }
    }

    public void createProjects(int numberOfProjects) {
        for (int x = 0; x < numberOfProjects; x++) {
            this.availableProjects.add(new Projects());
        }

    }

    public void showProjects() {
        System.out.println("*              ****************************************************************");
        System.out.println("*              ****************************************************************");
        for (int i = 0; i < availableProjects.size(); i++) {
            System.out.println("**              " + (i + 1) + ". - " + availableProjects.get(i).name);
            System.out.println("*               Poziom trudności " + availableProjects.get(i).levelOfDifficulty);
            System.out.println("*               Cena " + availableProjects.get(i).cost);
            System.out.println("*               Dni pozostałych do oddania " + availableProjects.get(i).days);
            System.out.println("*               Klient:  " + availableProjects.get(i).client.name + " " + availableProjects.get(i).client.lastName);
            System.out.println("*               Technologie wymagane:  " + availableProjects.get(i).setOfTechnologies);
            System.out.println();
        }

    }

    public int projectYouChoose() {
        System.out.println("*              Wybierz projekt lub 0 cofnij");
        System.out.print("*              ");
        Scanner input = new Scanner(System.in);
        int which = input.nextInt();
        if (which > availableProjects.size()) {
            System.out.println("*              Liczba z poza zakresu");
            return 0;
        } else {
            return which;
        }
    }

    public void removeAvailableProject(int which) {
        availableProjects.remove(which - 1);
    }
    public void removeAvailableProgrammer(int which) {
        availableProgrammers.remove(which - 1);
    }
    public void removeAvailableTester(int which) {
        availableTesters.remove(which - 1);
    }
    public void removeAvailableSeller(int which) {
        availableSellers.remove(which - 1);
    }

    public void showMeProgrammers() {
        System.out.println("*               ****************************************************************");
        for (int i = 0; i < availableProgrammers.size(); i++) {
            System.out.println("*               " + (i + 1) + ". - " + availableProgrammers.get(i).name + " " + availableProgrammers.get(i).lastName);
            System.out.println("*               Wymagania płacowe: " + availableProgrammers.get(i).payment);
            System.out.println("*               Znane technologie:  " + availableProgrammers.get(i).workerTechnologies);
            System.out.println();
            System.out.println("*               ");
        }

    }

    public void chosenProgrammer(){
        System.out.println("*               ****************************************************************");
        System.out.println("*               Wybierz projekt lub 0 cofnij");
        Scanner input = new Scanner(System.in);
        int select = input.nextInt();
    }


}




