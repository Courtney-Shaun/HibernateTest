package RosterTest;

import java.util.*;

public class RunRosterExample {

    public static void main(String[] args) {

        TestDAO t = TestDAO.getInstance();

        List<Players> p = t.getPlayers();
        for (Players i : p) {
            System.out.println(i);
        }

        System.out.println(t.getPlayer(2));


    }
}
