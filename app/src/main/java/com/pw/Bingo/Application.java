package com.pw.Bingo;

/**
 * Created by admin on 17-Apr-16.
 */
public class Application {

    private static int myID =0;

    public static String getArenaID() {
        return arenaID;
    }

    public static void setArenaID(String arenaID) {
        Application.arenaID = arenaID;
    }

    private static String arenaID;

    public static int getMyID() {
        return myID;
    }

    public static void setMyID(int myID) {
        Application.myID = myID;
    }
}
