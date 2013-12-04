import javax.swing.JOptionPane;


@SuppressWarnings("unused")
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Scooby-Doo approaches the mansion. Thunder rumbles ominously overhead, as the door creaks open to let Scooby in.", "Haunted Mansion", JOptionPane.INFORMATION_MESSAGE);
		Room entrance = new Room("Mansion Entrance", "Scooby-Doo enters the mansion. There is a grand staircase leading upstairs, and a trapdoor leading into the basement.", " Where should he look?", "Upstairs", "Basement");
		switch(entrance.getChoice())
		{
		case 0:
			upstairs();
		break;
		case 1:
			basement();
		break;
		}
	}
	
	public static void upstairs()
	{
		Room upstairs = new Room("Upstairs", "Scooby heads up the stairs. He creeps around the corner, and spots two doors.\nOne of these doors has a sign that says \"Do Not Enter\", and one says \"Hamburgers and Hotdogs!\" That door smells like food!", "Which door should he enter?", "\"Do Not Enter\" Door", "\"Hamburgers and Hot Dogs!\" Door");
		switch(upstairs.getChoice())
		{
		case 0:
			dneDoor();
			break;
		case 1:
			foodDoor();
			break;
		}
	}
	
	public static void foodDoor()
	{
		End end = new End("Food Room", "With images of food floating in his head, Scooby enters the food room and is promptly murdered by the monster.", true);
	}
	
	public static void dneDoor()
	{
		Room dne = new Room("Do Not Enter Room", "Scooby opens the door, and spots the monster!\nIt has its back to Scooby. Now is your chance to act!", "What should he do?!", "Pounce", "Sneak");
		switch(dne.getChoice())
		{
		case 0: 
			pounce();
			break;
		case 1: 
			sneak();
			break;
		}
		
	}
	
	public static void pounce()
	{
		End end = new End("Do Not Enter Room", "Scooby pounces on the monster! Taken by surprise, it hesitates a moment too long.\nScooby rips off its mask to reveal Old Man Jenkins!", false);
	}
	
	public static void sneak()
	{
		End end = new End("Do Not Enter Room", "Scooby tries to sneak up on the monster, but trips and falls flat on his face!\nThe monster spins around, and slices Scooby in half with a chainsaw!", true);
	}

	public static void basement()
	{
		Room basement = new Room("Basement", "Scooby enters the basement. Unidentifiable liquid drips from the mossy ceiling, creating a very slippery floor.\nSuddenly, he hears a noise! He quickly scrabbles around for a weapon.", "What does Scooby pick up?", "Gun", "Bat");
		switch(basement.getChoice())
		{
		case 0: 
			suicide();
			break;
		case 1: 
			bat(); 
			break;
		}
	}
	
	public static void suicide()
	{
		End end = new End("Basement", "Scooby finds a gun! Suddenly, the monster appears behind him!\nScooby quickly tries to shoot the monster, but the gun is jammed from the water!\nThe monster rips Scooby's head off!", true);
	}
	
	public static void bat()
	{
		Room bat = new Room("Basement", "Scooby picks up the bat. Suddenly he hears a creepy noise behind him!", "OH NO!! QUICK, DO SOMETHING!", "Swing", "Confront");
		switch(bat.getChoice())
		{
		case 0: 
			swing();
			break;
		case 1: 
			confront();
			break;
		}
	}
	
	public static void swing()
	{
		End end = new End("Basement", "Scooby quickly swings his bat behind him, and hits something!\nThe bat connects with the monster's head, causing the head to fly from its shoulders?!\nWait! That's not his head. That's a mask!", false);
	}
	
	public static void confront()
	{
		End end = new End("Basement", "Not wanting to hit a civilian, Scooby takes a look behind him first.\nThe monster reaches out and rips Scooby's head off!", true);
	}
}
