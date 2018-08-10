package com.company;

public class Main {

    public static void main(String[] args) {

        CSVHelper csvHelper = new CSVHelper();

        Lookup lookup = new Lookup();
        try {
            lookup.checkHosts();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
