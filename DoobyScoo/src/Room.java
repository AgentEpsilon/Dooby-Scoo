import javax.swing.JOptionPane;


public class Room {

	private int choice;
	
	/**
	 * Use this for when you are creating an encounter with exits, not an End.
	 * @param roomName The title of the windows.
	 * @param roomDescript The description that pops up first for the room.
	 * @param roomQuestion What the choice dialog asks.
	 * @param exit1 The first choice of an exit.
	 * @param exit2 The second choice of an exit.
	 */
	public Room(String roomName, String roomDescript, String roomQuestion, String exit1, String exit2)
	{
		JOptionPane.showMessageDialog(null, roomDescript, roomName, JOptionPane.INFORMATION_MESSAGE);
		Object[] exits = {exit1, exit2};
		choice = JOptionPane.showOptionDialog(null, roomQuestion, roomName, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, exits, null);
	}
	
	/**
	 * Gets the choice from the Option dialog. Suggested use: Right after the constructor.
	 * @return choice Tells whether you chose the first button (0) or the second (1).
	 */
	public int getChoice()
	{
		return choice;
	}
}
