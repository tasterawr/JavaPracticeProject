package org.inversion_of_control;

public class Test {
    public static void main(String[] args) {
        Container container = new Container(Config.class, TeamConfig.class);

        System.out.println(container.getBean("teamworker", TeamWorker.class));
        System.out.println(container.getBean("team", Team.class));
    }
}
