package org.inversion_of_control;

import java.util.Random;

public class Config {

    @Bean(name="teamworker")
    @Prototype
    public static TeamWorker getWorker(){
        TeamWorker teamWorker = new TeamWorker();
        teamWorker.setFirstName(generateString());
        teamWorker.setLastName(generateString());
        teamWorker.setAge(generateNumber());
        return teamWorker;
    }

    @Bean
    public static TeamWorker worker1(){
        TeamWorker teamWorker = new TeamWorker();
        teamWorker.setFirstName("Vasia");
        teamWorker.setLastName("Butin");
        teamWorker.setAge(30);
        return teamWorker;
    }

    @Bean(name="teamlead")
    @Prototype
    public static TeamLead getTeamLead(){
        TeamLead teamLead = new TeamLead();
        teamLead.setFirstName(generateString());
        teamLead.setLastName(generateString());
        teamLead.setAge(generateNumber());
        return teamLead;
    }

    private static String generateString(){
        Random random = new Random();
        int length = random.nextInt(11 - 5) + 5;
        String str = "";
        for (int i = 0; i<length; i++){
            str += Character.toString((char)random.nextInt(91 - 65) + 65);
        }

        return str;
    }

    private static int generateNumber(){
        Random random = new Random();
        return random.nextInt(51-20) + 20;
    }
}
