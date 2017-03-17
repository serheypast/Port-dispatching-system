package bsuir.by.labWord2.run;



/**
 * Created by Сергей on 14.03.2017.
 */
import bsuir.by.labWord2.gui.MainForm;

import org.eclipse.swt.widgets.Display;






public class Main {
    public static void main(String args[]) {
        try {
            MainForm window = new MainForm();
            window.setBlockOnOpen(true);
            window.open();
            Display.getCurrent().dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


