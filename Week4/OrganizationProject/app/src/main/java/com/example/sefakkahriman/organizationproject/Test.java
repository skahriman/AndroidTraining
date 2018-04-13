package com.example.sefakkahriman.organizationproject;

/*
 * Inputs
 *
 * A1,B2,C3,D4
 * B2, E5, F6
 * D4, G7, I9
 * G7, H8
 */
public class Test {

    String s1;
    String s2;
    String s3;
    String s4;

    public static void main(String[] args) {



        Person A1 = new Person("A1");
        Person B2 = new Person("B2");
        Person C3 = new Person("C3");
        Person D4 = new Person("D4");
        Person E5 = new Person("E5");
        Person F6 = new Person("F6");
        Person G7 = new Person("G7");
        Person H8 = new Person("H8");
        Person I9 = new Person("I9");

        A1.addChild(B2);A1.addChild(C3);A1.addChild(D4);
        B2.addChild(E5);B2.addChild(F6);
        D4.addChild(G7);D4.addChild(I9);
        G7.addChild(H8);

        GetChild gc = new GetChild();
        System.out.println(A1.getName());
        gc.printChild(A1);
    }

}
