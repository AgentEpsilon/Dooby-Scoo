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
			endMessage = "Oh No! Looks like you met a bad end.\nTry again for a better ending!";
		}
		JOptionPane.showMessageDialog(null, endMessage, "The End", JOptionPane.ERROR_MESSAGE);
	}

}
