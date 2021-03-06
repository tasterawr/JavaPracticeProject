package org.inversion_of_control;

public class TeamWorker {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\n-----------" +
                "\nFirst name: " + firstName +
                "\nLast name: " + lastName +
                "\nAge: " + age +
                "\n-----------";
    }
}
