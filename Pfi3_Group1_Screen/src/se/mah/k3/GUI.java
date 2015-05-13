package se.mah.k3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Logic logic = new Logic();
		
		//These methods are probably just for testing
		logic.updateActiveTreasureCount();
		logic.generateTreasureLocations();
		logic.updateFirebase();
		//logic.updateInfo();
		//drawMarkers();
	}
	
	public static void drawMarkers(){
		
		for (TreasureLocation tl : Logic.treasureLocations){
			if(tl.getActive()){
				int x = tl.getPosX();
				int y = tl.getPosY();
				placeMarker(x,y);
				System.out.println(x+" "+y);
			}
		}
	}
	
	public static void placeMarker(int x, int y){
		
	}
	

}
