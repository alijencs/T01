
/*
 *  GreeterServerExample.java
 *
 *  A sample server example using socklib.ServerListener
 *  See also: GreaterServerProtocol.java
 *
 *  (C) 2022 Ali Jannatpour <ali.jannatpour@concordia.ca>
 *
 *  This code is licensed under GPL.
 *
 */

package com.comp6231.lab1.example;

import com.comp6231.socklib.ServerListener;

import java.util.Scanner;

public class GreeterServerExample {
    public static void main(String[] args) {
        try {
            int port = 6231;
            ServerListener server = new ServerListener("GreeterServer", port, GreeterServerProtocol::new);
            server.start();
            System.out.println(String.format("\nThe server is listening on port %d.\nPlease open telnet and connect to " +
                    "this machine on port %d. You may open multiple simultaneous connections.", port, port));
            System.out.println("\nPress hit ENTER if you wish to stop the server. Note that the service may NOT stop immediately.");
            new Scanner(System.in).nextLine(); // waiting for EOL from the console to terminate
            server.stop();
        }
        catch (Exception ex) {
            System.out.println("FATAL ERROR: " + ex.getMessage());
        }
    }

}
