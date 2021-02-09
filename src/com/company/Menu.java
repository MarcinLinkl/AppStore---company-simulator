package com.company;

import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    MyCompany MyOwnCompany = new MyCompany(20000.0);
    Market AvailableOnMarket = new Market(3, 2, 1);
    Time NewTime = new Time();


    public void Intro() throws ParseException {
        int selection;
        Scanner input = new Scanner(System.in);
        System.out.println("*              ****************************************************************");
        System.out.println("*              *           Witaj wędrowcze w                                  *");
        System.out.println("*              *                  symulatorze firmy programistycznej!         *");
        System.out.println("*              ****************************************************************");
        System.out.println("*               Będziemy robić ciekawe projekty i zmuszać do pracy innych!");
        System.out.println("*               Skoro już tu jesteś przyjmij wyzwanie i wygraj, pamiętając jak cenny jest szmal");
        System.out.println("*               Tu jest [potrzebna] mądrość.");
        System.out.println("*               Kto ma rozum, niech liczby dobrze przeliczy i nie wyjdzie nigdy na zero.");
        System.out.println("*               Do dzieła, nie ma na co czekać! =)\n");
        System.out.println("*              ****************************************************************");

        System.out.println("*               Jesteś chętny? :)");
        System.out.println("*               1 - Tak, no pewnie!");
        System.out.println("*               2 - Exit");
        System.out.print("*               Mój wybór: ");
        selection = input.nextInt();


        if (selection != 1 && selection != 2) {
            System.out.println("*                Eee, coo!");
            System.out.println("*                Dam ci jeszcze jedną szansę - może tym razem ci się uda :)");
            input.next();
            Intro();
        }
        if (selection == 2) {
            System.out.println("*                Exit");
            printExitnfckway();

        } else {
            NewTime.startDate("2020-01-01");
            System.out.println("*               To mi się podoba!");
            System.out.println("*               ****************************************************************");
            System.out.println("*               Zaczynasz z określoną (niewielką) ilością pieniędzy.");
            System.out.println("*               Nie masz żadnych pracowników, biura ani klientów. ");
            System.out.println("*               Umiesz programować w Javie, wiesz coś o bazach danych i potrafisz zrobić front-end do aplikacji. ");
            System.out.println("*               Nie umiesz pisać pod aplikacje mobilne. ");
            System.out.println("*               Tą część musisz komuś zlecać, zatrudnić pracownika lub unikać tego typu projektów. ");
            System.out.println("*               Umiesz też postawić stronkę na wordpressie i prosty sklep na prestashop. ");
            System.out.println("*               ****************************************************************\n");
            System.out.println("*               Wpisz coś, aby iść dalej!");
            System.out.print("*               ");
            input.next();

        }
    }

    public void looser() {
        for (int j = 0; j < 40; j++) {
            System.out.println(Projects.RED + "               YOUUUUU LOOOOOOOSE!!!!!!!!!!!");
        }
        printExitnfckway();
    }

    public void printExitnfckway() {
        System.out.println("fuck! xd why?!?!?!23231");
        for (int x = 0; x < 10; x++)
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++)
                    System.out.print(" ");
                System.out.print("** ****  ***** *** **** ** ***** ******");

            }
        System.exit(0);
    }

    public void menu() throws Exception {
        while (true) {
            NewTime.printDay();
            NewTime.daysleftMoth();
            if (NewTime.daysLeft == 20)
                MyOwnCompany.pay = false;
            if (NewTime.daysLeft == 1 && !MyOwnCompany.taxman)
                looser();
            if (NewTime.daysLeft == 0 && !MyOwnCompany.pay)
                MyOwnCompany.cash = MyOwnCompany.cash - myExpenses();
            if (MyOwnCompany.cash <= 0) {
                System.out.println("*               Your cash =" + MyOwnCompany.cash);
                looser();
            }
            if (MyOwnCompany.clients > 0)
                addProjects();


            System.out.println("*               Moja flota $" + MyOwnCompany.cash);
            System.out.println("*               Technologie znane w firmie: " + MyOwnCompany.myCompanyTechnologies);
            if (MyOwnCompany.currentProjects.size() == 0)
                System.out.println("*               Nie ma żadnych projektów");
            else {
                checkOut();
            }

            System.out.println("*               ****************************************************************");
            System.out.println("*               0. Exit");
            System.out.println("*               1. Przeznacz dzień na szukanie klientów");
            System.out.println("*               2. Podpisz umowę na realizację jednego z dostępnych projektów");
            System.out.println("*               3. Przeznacz dzień na programowanie");
            System.out.println("*               4. Przeznaczyć dzień na testowanie");
            System.out.println("*               5. Oddaj gotowy projekt klientowi");
            System.out.println("*               6. Zwolnij pracowników");
            System.out.println("*               7. Przeznacz dzień na rozliczenia z urzędami (Wymagane 2 dni w miesiącu, w przeciwnym wypadku zamykasz firmę z długami)");
            System.out.println("*               8. Szukaj pracowników");
            System.out.println("*               9. Wystaw ogłoszenie o pracę");
            System.out.println("*               10. Sprawdź co w firmie");


            System.out.println("*               ****************************************************************");
            System.out.print("*               ");
            Scanner input = new Scanner(System.in);

            int select = input.nextInt();
            switch (select) {
                case 0 -> System.exit(0);
                case 1 -> getAClient();
                case 2 -> getProject();
                case 3 -> spendTimeOnPrograming();
                case 4 -> spendTimeOnTesting();
                case 5 -> giveTheProject();
                case 6 -> firePeople();
                case 7 -> goToTaxman();
                case 8 -> findWorkers();
                case 9 -> jobOffer();
                case 10 -> checkOut();


            }
        }
    }

    private void jobOffer() {
        System.out.println("*               Wystawić ogłoszenie o pracę?");
        System.out.println("*               [t/n]");
        System.out.print("*               ");
        Scanner input = new Scanner(System.in);
        String select = input.next();
        {
            if (select.equals("t")) {
                AvailableOnMarket.makeWorkers(1, 1, 1);
                System.out.println("*               Masz dostępnych nowych pracowników do zatrudnienia\n");
                NextDay();
            } else {
                System.out.println("*               no to nie...");
                System.out.println("*               ");
            }
        }
    }

    private void findWorkers() {
        {
            System.out.println("*               ****************************************************************");
            System.out.println("*               0.Cofaj mnie ! ");
            System.out.println("*               1.Programista ");
            System.out.println("*               2.Sprzedawca ");
            System.out.println("*               3.Tester");
            System.out.print("*               ");
            Scanner input = new Scanner(System.in);
            int select = input.nextInt();
            switch (select) {
                case 0 -> {

                }
                case 1 -> findProgrammer();
                case 2 -> findSeller();
                case 3 -> findTester();
            }
        }
    }

    private void findSeller() {
        System.out.println("\n\n*               ****************************************************************");
        if (AvailableOnMarket.availableSellers.size() == 0) {
            System.out.println("*              Brak sprzedawców - musisz wystawić ogłoszenie!");
            return;
        }
        for (int i = 0; i < AvailableOnMarket.availableSellers.size(); i++) {
            System.out.println("*               " + (i + 1) + ". - " + AvailableOnMarket.availableSellers.get(i).name + " " + AvailableOnMarket.availableProgrammers.get(i).lastName);
            System.out.println("*               Wymagania płacowe " + AvailableOnMarket.availableSellers.get(i).payment);
            System.out.println();
        }
        while (true) {
            System.out.println("*               ****************************************************************");
            System.out.println("*               0.Cofaj mnie ! ");
            System.out.print("*               Lub podaj sprzedawce którego chciałbyś zatrudnić (3000$):");
            Scanner input = new Scanner(System.in);
            int chosen = input.nextInt();
            if (chosen == 0 || chosen > AvailableOnMarket.availableSellers.size())
                return;
            MyOwnCompany.addNewSeller(AvailableOnMarket.availableSellers.get(chosen - 1));
            System.out.println();
            System.out.println("*               Wybrany sprzedawca nr: " + chosen);
            System.out.println();
            AvailableOnMarket.removeAvailableSeller(chosen);
            NextDay(); //nastepny dzień
            MyOwnCompany.cash = MyOwnCompany.cash - 3000.0;

        }
    }


    private void findTester() {
        System.out.println("*              ****************************************************************");
        if (AvailableOnMarket.availableTesters.size() == 0) {
            System.out.println("*              Brak testerów - musisz wystawić ogłoszenie!");
            return;
        }
        for (int i = 0; i < AvailableOnMarket.availableTesters.size(); i++) {
            System.out.println("*               " + (i + 1) + ". - " + AvailableOnMarket.availableTesters.get(i).name + " " + AvailableOnMarket.availableProgrammers.get(i).lastName);
            System.out.println("*               Wymagania płacowe: " + AvailableOnMarket.availableTesters.get(i).payment);
            System.out.println("*               ");
        }
        while (true) {
            System.out.println("*               ****************************************************************");
            System.out.println("*               0.Cofaj mnie ! ");
            System.out.print("*               Lub podaj testera którego chciałbyś zatrudnić (3000$): ");
            Scanner input = new Scanner(System.in);
            int chosen = input.nextInt();
            if (chosen == 0 || chosen > AvailableOnMarket.availableTesters.size())
                return;
            MyOwnCompany.addNewTester(AvailableOnMarket.availableTesters.get(chosen - 1));
            System.out.println();
            System.out.println("*               Wybrany tester nr: " + chosen);
            System.out.println();
            AvailableOnMarket.removeAvailableTester(chosen);
            NextDay(); //nastepny dzień
            MyOwnCompany.cash = MyOwnCompany.cash - 3000.0;
        }
    }


    private void findProgrammer() {
        if (AvailableOnMarket.availableProgrammers.size() == 0) {
            System.out.println("*              Brak programistów - musisz wystawić ogłoszenie!");
            return;
        }
        AvailableOnMarket.showMeProgrammers();
        {
            System.out.println("*               ****************************************************************");
            System.out.println("*               0.Cofaj mnie ! ");
            System.out.print("*               Lub podaj numer programisty którego chciałbyś zatrudnić: (3000$) ");
            Scanner input = new Scanner(System.in);
            int chosen = input.nextInt();
            if ((chosen == 0 || chosen > AvailableOnMarket.availableProgrammers.size()))
                return;
            MyOwnCompany.addNewProgrammer(AvailableOnMarket.availableProgrammers.get(chosen - 1));
            System.out.println();
            System.out.println("*               Wybrany programista nr: " + chosen);
            System.out.println();
            MyOwnCompany.myCompanyTechnologies.addAll(AvailableOnMarket.availableProgrammers.get(chosen - 1).workerTechnologies);
            AvailableOnMarket.removeAvailableProgrammer(chosen);
            NextDay(); //nastepny dzień
            MyOwnCompany.cash = MyOwnCompany.cash - 3000.0;
        }
    }


    private void getProject() {
        AvailableOnMarket.showProjects();
        int chosen = AvailableOnMarket.projectYouChoose();
        if (chosen == 0) {
        }
        if (!MyOwnCompany.myCompanyTechnologies.containsAll(AvailableOnMarket.availableProjects.get(chosen - 1).setOfTechnologies))
        {
            System.out.println("*               "+Projects.RED+"Nie znasz odpowiednich technologii - musisz zastrudnić programistę"+Projects.RESET);
            System.out.println("*               ");
        }
        else {
            MyOwnCompany.addToCurrentProjects(AvailableOnMarket.availableProjects.get(chosen - 1));

            AvailableOnMarket.removeAvailableProject(chosen);
            System.out.println("*               Wybrany projekt nr: " + chosen);
            NewTime.nextDay();
        }

    }

    private void checkOut() {
        System.out.println("*               ****************************************************************");
        NewTime.printDay();
        System.out.println("*               ****************************************************************");
        System.out.println("*               Mój budżet: " + MyOwnCompany.cash);
        System.out.println("*               Technologie znane w firmie: " + MyOwnCompany.myCompanyTechnologies);
        System.out.println("*               Moi programiści: ");
        MyOwnCompany.myProgramers();
        System.out.println("*               Moi Sprzedawcy: ");
        MyOwnCompany.mySellers();
        System.out.println("*               Moi Testerzy: ");
        MyOwnCompany.myTesters();
        System.out.println("*               Moje projekty: ");
        MyOwnCompany.showMyProjects();

    }


    private void goToTaxman() {
        NextDay();
        NextDay();
        MyOwnCompany.taxman = true;
    }

    private void firePeople() {
        System.out.println("*               ****************************************************************");
        System.out.println("*               Programiści do wykopania: ");
        System.out.println();
        MyOwnCompany.myProgramers();
        System.out.println("*               ****************************************************************");
        System.out.println("*               Sprzedawcy do wykopania: ");
        System.out.println();
        MyOwnCompany.mySellers();
        System.out.println("*               ****************************************************************");
        System.out.println("*               Testerzy do wykopania: ");
        System.out.println();
        MyOwnCompany.myTesters();
        System.out.println("*               0.Cofaj mnie ! ");
        System.out.println("*               1.Zwolnij sprzedawce");
        System.out.println("*               2.Zwolnij programiste ");
        System.out.println("*               3.Zwolnij testera ");
        System.out.print("*               ");
        Scanner input = new Scanner(System.in);
        int select = input.nextInt();
        while (true) {
            switch (select) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    if (MyOwnCompany.currentSellers.size() == 0) {
                        System.out.println("*               Nie masz sprzedawcy do wykopania ;(");
                        return;
                    } else
                        System.out.println("*               Wybierz sprzedawce: ");
                    MyOwnCompany.removeSeller(input.nextInt() - 1);
                    MyOwnCompany.cash = MyOwnCompany.cash - MyOwnCompany.currentSellers.get(input.nextInt() - 1).payment;
                }
                case 2 -> {
                    if (MyOwnCompany.currentProgrammers.size() == 0) {
                        System.out.println("*               Nie masz programisty do wykopania ;(");
                        return;
                    }
                    System.out.println("*               Wybierz programiste: ");
                    MyOwnCompany.cash = MyOwnCompany.cash - MyOwnCompany.currentProgrammers.get(input.nextInt() - 1).payment;
                    MyOwnCompany.myCompanyTechnologies.clear();
                    MyOwnCompany.myCompanyTechnologies.addAll(MyOwnCompany.myKnownTechnologies);
                    for (int i=0;i<MyOwnCompany.currentProgrammers.size();i++) {
                        MyOwnCompany.myCompanyTechnologies.addAll(MyOwnCompany.currentProgrammers.get(i).workerTechnologies);
                    }
                    MyOwnCompany.removeProgrammer(input.nextInt() - 1);
                }
                case 3 -> {
                    if (MyOwnCompany.currentTesters.size() == 0) {
                        System.out.println("*               Nie masz testera do wykopania ;(");
                        return;
                    }
                    {
                        System.out.println("*               Wybierz testera: ");
                        MyOwnCompany.cash = MyOwnCompany.cash - MyOwnCompany.currentTesters.get(input.nextInt() - 1).payment;
                        MyOwnCompany.removeTester(input.nextInt() - 1);
                    }
                }

            }
            NextDay();

        }
    }

    public void NextDay() {
        makeProgress();
        NewTime.nextDay();
        for (int i = 0; i < MyOwnCompany.currentProjects.size(); i++) {
            MyOwnCompany.currentProjects.get(i).days--;
            if (MyOwnCompany.currentProjects.get(i).days < 0) {
                System.out.println("Chyba zapomniałeś oddać projekt to klienta...");
                looser();
            }
        }
    }

    public void makeProgress(int b) {
        int x = MyOwnCompany.currentProgrammers.size();
        if (x > 0 && NewTime.dayOfWeek != 7 && NewTime.dayOfWeek != 1) {
            int y = MyOwnCompany.currentTesters.size();
            for (int i = 0; i < MyOwnCompany.currentProjects.size(); i++) {
                switch (MyOwnCompany.currentProjects.get(i).levelOfDif) {
                    case 0 -> {
                        MyOwnCompany.currentProjects.get(i).progress = (MyOwnCompany.currentProjects.get(i).progress + (10 * x));
                        MyOwnCompany.currentProjects.get(i).progressTesting = (MyOwnCompany.currentProjects.get(i).progressTesting + (20 * y));
                    }
                    case 1 -> {
                        MyOwnCompany.currentProjects.get(i).progress = (MyOwnCompany.currentProjects.get(i).progress + (5 * x));
                        MyOwnCompany.currentProjects.get(i).progressTesting = (MyOwnCompany.currentProjects.get(i).progressTesting + (15 * y));
                    }
                    case 2 -> {
                        MyOwnCompany.currentProjects.get(i).progress = (MyOwnCompany.currentProjects.get(i).progress + (2 * x));
                        MyOwnCompany.currentProjects.get(i).progressTesting = (MyOwnCompany.currentProjects.get(i).progressTesting + (6 * y));
                    }
                }
            }
        }
    }

    public void makeProgress() {
        this.makeProgress(0);
    }

    public void imakeProgress() {
        this.makeProgress(1);
    }

    public void makeByMyProgressTesting() {
        for (int i = 0; i < MyOwnCompany.currentProjects.size(); i++) {
            switch (MyOwnCompany.currentProjects.get(i).levelOfDif) {
                case 0 -> MyOwnCompany.currentProjects.get(i).progressTesting = MyOwnCompany.currentProjects.get(i).progressTesting + 20;
                case 1 -> MyOwnCompany.currentProjects.get(i).progressTesting = MyOwnCompany.currentProjects.get(i).progressTesting + 10;
                case 2 -> MyOwnCompany.currentProjects.get(i).progressTesting = MyOwnCompany.currentProjects.get(i).progressTesting + 5;
            }
        }
    }

    public void makeByMyProgress() {
        for (int i = 0; i < MyOwnCompany.currentProjects.size(); i++) {
            switch (MyOwnCompany.currentProjects.get(i).levelOfDif) {
                case 0 -> MyOwnCompany.currentProjects.get(i).progress = MyOwnCompany.currentProjects.get(i).progress + 10;
                case 1 -> MyOwnCompany.currentProjects.get(i).progress = MyOwnCompany.currentProjects.get(i).progress + 5;
                case 2 -> MyOwnCompany.currentProjects.get(i).progress = MyOwnCompany.currentProjects.get(i).progress + 2;
            }
        }
    }

    private void giveTheProject() {
        System.out.println("*               ****************************************************************");
        Scanner input = new Scanner(System.in);
        if (MyOwnCompany.currentProjects.size()==0) {
            System.out.println("\n*               Nie masz żadnego projektu!\n");
            System.out.println("\n*               Wpisz coś, aby iść dalej!");
            System.out.print("*               ");
            input.next();
            return;
        }
        System.out.println("*               Który projekt chcesz oddać");
        System.out.println("*               0. Cofnij");
        MyOwnCompany.showMyProjects();
        int select = input.nextInt();
        if(select==0){
            return;
        }
        if (MyOwnCompany.currentProjects.get(select).progress < 100) {
            System.out.println("*               Nie możesze oddać nieskończonego projektu!");
        }
        if (MyOwnCompany.currentProjects.get(select).progressTesting < 100) {
            System.out.println("*               Czy chcesz oddać nieprzetestowany kod?!");
            int insert = input.nextInt();
            System.out.println("*               1. Tak");
            System.out.println("*               2. Nie!");
            switch (insert) {
                case 1 -> sellTheProject(select);
                case 2 -> {
                    return;
                }

            }
        }
    }

    public void sellTheProject(int jaki) {
        if (MyOwnCompany.currentProjects.get(jaki).progressTesting < 50) {
            switch (Projects.getRandom(0, 2)) {
                case 0 -> {
                    System.out.println("*               Projekt był skopany! Klient chce zniżkę o 50%");
                    MyOwnCompany.cash = MyOwnCompany.cash + (MyOwnCompany.currentProjects.get(jaki).cost / 2);
                }
                case 1 -> {
                    System.out.println("*               Projekt był skopany czesciowo, da się naprawić! Klient chce zniżkę o połowe 20%");
                    MyOwnCompany.cash = MyOwnCompany.cash + (MyOwnCompany.currentProjects.get(jaki).cost * 0.8);
                }
                case 2 -> {
                    System.out.println("*               Wszystko poszło gładko - tym razem");
                    MyOwnCompany.cash = MyOwnCompany.cash + (MyOwnCompany.currentProjects.get(jaki).cost);
                }
            }
        }

        if (MyOwnCompany.currentProjects.get(jaki).progressTesting > 50)
            switch (Projects.getRandom(0, 1)) {
                case 0 -> {
                    System.out.println("*               Projekt był skopany! Klient chce zniżkę o 20%");
                    MyOwnCompany.cash = MyOwnCompany.cash + (MyOwnCompany.currentProjects.get(jaki).cost * 0.8);
                }
                case 1 -> {
                    System.out.println("*               Wszystko ok ;) - klient zadowolony");
                    MyOwnCompany.cash = MyOwnCompany.cash + (MyOwnCompany.currentProjects.get(jaki).cost);
                }

            }
        MyOwnCompany.removeCurrentProjects(jaki);
        NewTime.nextDay();
    }

    private void spendTimeOnTesting() {
        makeByMyProgressTesting();
        NextDay();
    }

    private void spendTimeOnPrograming() {
        makeByMyProgress();
        NextDay();
    }


    private void getAClient() {
        while (true) {
            System.out.println("*               ****************************************************************");
            System.out.println("*               Czy chcesz przeznaczyć 1 dzień na szukanie klientów? Do twojej puli dojdzie nowy projekt do wyboru");
            System.out.println("*               Przy czym każde 5 dni to jeden dostępny projekt na jeden klienta. ");
            System.out.println("*               [t/n]");
            System.out.print("*               ");
            Scanner input = new Scanner(System.in);
            var answer = input.next();
            switch (answer) {
                case "n" -> {
                    return;
                }
                case "t" -> {
                    MyOwnCompany.clients++;
                    AvailableOnMarket.createProjects(1);
                    NextDay();
                    NewTime.haveClients = true;
                    NewTime.printDay();
                    return;
                }
            }
        }

    }

    public void addProjects() {
        if (NewTime.addProject % 5 == 0) {
            AvailableOnMarket.createProjects(MyOwnCompany.clients);
        }


    }

    public double myExpenses() {
        double expenses = 0;
        for (int i = 0; i < MyOwnCompany.currentProgrammers.size(); i++) {
            expenses = expenses + MyOwnCompany.currentProgrammers.get(i).payment + 5000;
        }
        for (int i = 0; i < MyOwnCompany.currentSellers.size(); i++) {
            expenses = expenses + MyOwnCompany.currentSellers.get(i).payment + 5000;
        }
        for (int i = 0; i < MyOwnCompany.currentTesters.size(); i++) {
            expenses = expenses + MyOwnCompany.currentTesters.get(i).payment + 5000;
        }
        expenses = expenses + 7000;
        return expenses;

    }
}
