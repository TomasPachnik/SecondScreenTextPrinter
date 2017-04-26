package sk.tomas.sstp.main;

import javax.swing.*;

/**
 * Created by tomas on 4/24/17.
 */
public class Main {

    public static void main (String [] args){
        SwingUtilities.invokeLater(() -> new App().twoscreen());

    }

}
