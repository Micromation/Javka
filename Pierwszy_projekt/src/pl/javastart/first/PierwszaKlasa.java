package pl.javastart.first;

import java.awt.Frame;

//import javax.swing.JComponent;

public class PierwszaKlasa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		Frame frame = new Frame("Puste okno");
        frame.setSize(500, 600);
        frame.setVisible(true);
        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
            
        });

}
}
