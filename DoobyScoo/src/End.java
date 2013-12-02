import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class End {

	/**
	 * @param args
	 */
	public End(String roomName, String actionMessage, boolean death) {
		JOptionPane.showMessageDialog(null, actionMessage, roomName, JOptionPane.WARNING_MESSAGE);
		String endMessage = "Congratulations! You solved the mystery!\nThanks for playing!";
		if(death)
		{
			endMessage = "Oh No! Looks like you met a bad end.\nWould you like to try again?";
			Object[] choices = {"Retry", "Quit"};
			int choice = JOptionPane.showOptionDialog(null, endMessage, "The End", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, choices, null);
			switch(choice)
			{
			case 0:
				Main.main(null);
				break;
			case 1:
				break;
			}
		}else{
		JOptionPane.showMessageDialog(null, endMessage, "The End", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("meddlingkids1.jpg")));
		}
	}

}
