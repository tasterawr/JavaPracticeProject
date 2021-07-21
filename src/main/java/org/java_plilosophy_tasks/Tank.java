package org.java_plilosophy_tasks;

/**Philosophy of Java, Chapter 5.
 * Class created to test finalizer's work.*/
public class Tank {
    private int capacity;

    public Tank() {
        this.capacity = 0;
    }

    public Tank(int capacity) {
        this.capacity = Math.abs(capacity);
    }

    public void fillTank(int capacity) {
        this.capacity += capacity;
    }

    public void emptyTank() {
        this.capacity = 0;
    }

    @Override
    protected void finalize() {
        if (capacity != 0){
            System.out.println("Error: Tank was not devastated.");
        }
    }
}
