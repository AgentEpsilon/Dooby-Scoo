package com.epsilon;

import java.awt.EventQueue;

public class Main {

	private static int room = 0;
	private static DoobyGUI gui;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui = new DoobyGUI();
					gui.setVisible(true);
					main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static void main()
	{
		gui.post("Hello!");
		for(int x = 0; x<4; x++)
		{
			handleInput(room);
		}
	}

	private static void handleInput(int arg1)
	{
		switch(room)
		{
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
		}
	}
}
