package RosterTest;

import java.util.*;
import RosterTest.Players;
// Code is based of example provided by Brother Tuckett and edited.
// This is where the program is run.  Will print list of all players in the database as well as single
// player by database id and single player by player number.

public class RunRosterExample {

    public static void main(String[] args) {


        TestDAO t = TestDAO.getInstance();



        List<Players> p = t.getPlayers();
        System.out.println("Roster:\n");
        for (Players i : p) {
            System.out.println(i);
        }

        System.out.println("Player Selected:\n");
        System.out.println(t.getPlayer(5));
        System.out.println(t.getNumber(11))   ;



        }


    }
