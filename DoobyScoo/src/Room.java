import javax.swing.JOptionPane;


public class Room {

	private int choice;
	
	/**
	 * @param args
	 * @return choice
	 */
	public Room(String roomName, String roomDescript, String roomQuestion, String exit1, String exit2)
	{
		JOptionPane.showMessageDialog(null, roomDescript);
		Object[] exits = {exit1, exit2};
		choice = JOptionPane.showOptionDialog(null, roomQuestion, roomName, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, exits, null);
	}
	
	public int getChoice()
	{
		return choice;
	}
}
