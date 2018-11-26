package com.company.exo2;

public class Appli {
    public static void main(String[] args) {
        A a1 = new A(11001);
        A a2 = new A(11001);
        B b = new B();
        C c = new C();
        c.start();
        b.start();
        a1.start();
        a2.start();
    }
}
