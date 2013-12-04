import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class End {

	/**
	 * @param roomName The title of the windows.
	 * @param actionMessage The message that plays for the ending.
	 * @param death Whether or not Scooby dies.
	 */
	public End(String roomName, String actionMessage, boolean death) {
		JOptionPane.showMessageDialog(null, actionMessage, roomName, JOptionPane.WARNING_MESSAGE);
		String endMessage = "Congratulations! You solved the mystery!\nWould you like to play again?";
		Object[] choices = {"Retry", "Quit"};
		if(death)
		{
			endMessage = "Oh No! Looks like you met a bad end.\nWould you like to try again?";
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
			int choice = JOptionPane.showOptionDialog(null, endMessage, "The End", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("meddlingkids1.jpg")), choices, null);
			switch(choice)
			{
			case 0:
				Main.main(null);
				break;
			case 1:
				break;
			}
		}
	}

}
