package org;

import org.java_plilosophy_tasks.Tank;
import org.java_plilosophy_tasks.VampireNumbers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VampireNumbers.getVampireNumbers(1000, 10000);

        new Tank(50);

        System.gc();
    }
}
