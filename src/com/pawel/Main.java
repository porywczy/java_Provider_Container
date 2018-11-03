package com.pawel;

import java.io.*;

public class Main {

     public static void main(String[] args) {

        System.out.println("********** zadanie **********");

        DataProvider dataProviderCSV = new DataProviderCSV();

//        dataProviderCSV.get(1,2);
//         dataProviderCSV.count();

        DataContainer dataContainer = new DataContainer();

        dataContainer.load(dataProviderCSV);
        dataContainer.printAll();
//
//        dataContainer.add("6;UK;London");
//        dataContainer.printAll();
//
//        dataContainer.filter("5;Poland;Warsaw").forEach(System.out::println);
//
//        dataContainer.update(2, "3;UK;London");
//        dataContainer.printAll();
//
//        dataContainer.remove(2);
//        dataContainer.printAll();
//
//        System.out.println( dataContainer.findById(3) );
//
//        dataContainer.print(1, 3);
//
//        System.out.println(dataContainer.get(2,4).toString());
//
//        dataContainer.clear();
//        dataContainer.printAll();
    }

}
