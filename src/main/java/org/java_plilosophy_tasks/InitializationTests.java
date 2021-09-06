package org.java_plilosophy_tasks;

class SomeClass{
    public static int staticVariableX = 1;
    public static String staticVariableY = "static";
    public int variableX = 1;
    public String variableY;

    static {
        System.out.println("staticVariableX = " + staticVariableX);
        System.out.println("staticVariableY = " + staticVariableY);
    }

    {
        System.out.println("variableX = " + variableX);
        System.out.println("variableY = " + variableY);
    }

    public SomeClass(){ }
}

class InterestingClass extends SomeClass{
    public static int interestingStaticX = 1;
    public int interestingX = 2;

    static {
        System.out.println("interestingStaticX = " + interestingStaticX);
    }

    {
        System.out.println("interestingX = " + interestingX);
    }

    public InterestingClass(){ };
}

// Firstly all base class static fields are initialized.
// Then all child class static fields are initialized.
// Every time a class object is being created its non-static fields are initialized.
// Static fields are initialized only once.

public class InitializationTests {
    public static void main(String[] args) {
        System.out.println("Creating InterestingClass object 1...");
        InterestingClass interestingObject = new InterestingClass();
        int x = SomeClass.staticVariableX;
        System.out.println();
        System.out.println("Creating SomeClass object 1...");
        SomeClass someObject = new SomeClass(); // non-static fields are initialized
        System.out.println();
        System.out.println("Creating SomeClass object 2...");
        SomeClass someObject2 = new SomeClass();
        System.out.println();
    }
}
