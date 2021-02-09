package com.company.People;



public class Client extends People {


    public String clientType;

    public Client() {
        int i = getRandom(1, 3);
        if (i == 1)
            clientType = "wyluzowany";
        if (i == 2)
            clientType = "wymagający";
        if (i == 3)
            clientType = "skrwl";
    }


}