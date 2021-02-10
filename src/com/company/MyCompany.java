package com.company;

import com.company.People.Programmers;
import com.company.People.Sellers;
import com.company.People.Testers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyCompany {

    public Set<String> myCompanyTechnologies;
    public Set<String> myKnownTechnologies = new HashSet<String>();
    public List<Projects> currentProjects = new ArrayList<>();
    public List<Programmers> currentProgrammers = new ArrayList<>();
    public List<Sellers> currentSellers = new ArrayList<>();
    public List<Testers> currentTesters = new ArrayList<>();
    public double cash;
    public int clients;
    public boolean taxman;
    public boolean pay;
    public MyCompany(double cash) {
        this.cash = cash;
        this.myKnownTechnologies.add(Projects.BACKEND);
        this.myKnownTechnologies.add(Projects.BAZA_DANYCH);
        this.myKnownTechnologies.add(Projects.FRONTEND);
        this.myCompanyTechnologies=this.myKnownTechnologies;
        this.clients=0;
        this.pay=false;

    }




    public void addToCurrentProjects(Projects projectChosen) {
        currentProjects.add(projectChosen);
    }

    public void addNewProgrammer(Programmers programmerChosen) {
        currentProgrammers.add(programmerChosen);
    }

    public void addNewSeller(Sellers sellerChosen) {
        currentSellers.add(sellerChosen);
    }

    public void addNewTester(Testers testerChoosen) {
        currentTesters.add(testerChoosen);
    }

    public void removeCurrentProjects(int projectChosen) {
        currentProjects.remove(projectChosen);
    }

    public void removeProgrammer(int programmerChosen) {
        currentProgrammers.remove(programmerChosen);
    }

    public void removeSeller(int sellerChosen) {
        currentSellers.remove(sellerChosen);
    }

    public void removeTester(int testerChoosen) {
        currentTesters.remove(testerChoosen);
    }
    public void myProgramers()
    {   if (currentProgrammers.size()==0){
        System.out.println("*               Nie masz żadnego programisty");
        System.out.println();
        return;
    }
        for (int i= 0; i< currentProgrammers.size();i++)
        {
            System.out.println("*               " +(i+1)+". "+ currentProgrammers.get(i).name + " "+currentProgrammers.get(i).lastName);
            System.out.println("*               Płaca: " + currentProgrammers.get(i).payment);
            System.out.println("*               Punktualność: " + currentProgrammers.get(i).punctuality);
            System.out.println("*               Precyzjność: " + currentProgrammers.get(i).precision);
            System.out.println("*               Znane technologie:  " + currentProgrammers.get(i).workerTechnologies);
            System.out.println();
            System.out.println("*               ");
         }
    }

    public void mySellers() {
        {
            if (currentSellers.size() == 0) {
                System.out.println("*               Nie masz żadnego sprzedawcy");
                System.out.println();
                return;
            }
            for (int i = 0; i < currentSellers.size(); i++) {
                System.out.println("*               " + (i+1)+". " + currentSellers.get(i).name + " " + currentSellers.get(i).lastName);
                System.out.println("*               Płaca: " + currentSellers.get(i).payment);
                System.out.println();
                System.out.println("*               ");
            }
        }
    }
    public void myTesters(){
            {   if (currentTesters.size()==0){
                System.out.println("*               Nie masz żadnego testera");
                System.out.println();
                return;
            }
        }
        for (int i= 0; i< currentTesters.size();i++)
        {
            System.out.println("*               " +(i+1)+". "+ currentTesters.get(i).name + " "+currentTesters.get(i).lastName);
            System.out.println("*               Płaca: " + currentTesters.get(i).payment);
            System.out.println();
            System.out.println("*               ");
        }
    }
    public void showMyProjects() {
        System.out.println("*              ****************************************************************");
        System.out.println("*              ****************************************************************");
        for (int i = 0; i < currentProjects.size(); i++) {
            System.out.println("*               " + (i + 1) + ". - " + currentProjects.get(i).name);
            System.out.println("*               Poziom trudności " + currentProjects.get(i).levelOfDifficulty);
            System.out.println("*               Cena " + currentProjects.get(i).cost);
            System.out.println("*               Dni pozostałych do oddania " + currentProjects.get(i).days);
            System.out.println("*               Klient:  " + currentProjects.get(i).client.name + " " + currentProjects.get(i).client.lastName);
            System.out.println("*               Technologie wymagane:  " + currentProjects.get(i).setOfTechnologies);
            if (currentProjects.get(i).progress>100)
                currentProjects.get(i).progress=100;
            System.out.println("*               Postęp pracy:  " + currentProjects.get(i).progress+ " %");
            if (currentProjects.get(i).progressTesting>100)
                currentProjects.get(i).progressTesting=100;
            System.out.println("*               Przetestowanie kodu:  " + currentProjects.get(i).progressTesting+ " %");

            System.out.println();
        }
    }

}
