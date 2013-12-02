
@SuppressWarnings("unused")
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Room entrance = new Room("Mansion Entrance", "Dooby-Scoo enters a house full of monsters and ghosts. As he enters the house he is debating whether to look for these monsters and ghosts upstairs or in the basement.", " Where should he look?", "Upstairs", "Basement");
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
		Room upstairs = new Room("Upstairs", "Dooby creeps around the corner, and spots two doors.", "Which door should he enter?", "\"Do Not Enter\" Door", "\"Hamburgers and Hot Dogs!\" Door");
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
		End end = new End("Food Room", "With images of food floating in his head, Dooby enters the food room and is promptly murdered by the monster.", true);
	}
	
	public static void dneDoor()
	{
		Room dne = new Room("Do Not Enter Room", "Dooby opens the door, and spots the monster!", "What should he do?!", "Pounce", "Sneak");
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
		End end = new End("Do Not Enter Room", "Dooby pounces on the monster! Taken by surprise, it hesitates a moment too long.\nDooby rips off its mask to reveal Old Man Jenkins!", false);
	}
	
	public static void sneak()
	{
		End end = new End("Do Not Enter Room", "Dooby tries to sneak up on the monster, but trips and falls flat on his face!\nThe monster spins around, and slices Dooby in half with a chainsaw!", true);
	}

	public static void basement()
	{
		Room basement = new Room("Basement", "As Dooby enters the basement, he hears a noise! He quickly scrabbles around for a weapon.", "What does Dooby pick up?", "Gun", "Bat");
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
		End end = new End("Basement", "Dooby finds a gun! However, the creepiness of the mansion is scaring Dooby so much that he quickly puts the gun to his head and pulls the trigger.", true);
	}
	
	public static void bat()
	{
		Room bat = new Room("Basement", "Dooby picks up the bat. Suddenly he hears a creepy noise behind him!", "OH NO!! QUICK, DO SOMETHING!", "Swing", "Confront");
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
		End end = new End("Basement", "Dooby quickly swings his bat behind him, and hits something!\nWhen he turns around, he sees the monster lying on the floor, dead!", false);
	}
	
	public static void confront()
	{
		End end = new End("Basement", "Not wanting to hit a civilian, Dooby takes a look behind him first.\nThe monster reaches out and rips Dooby's head off!", true);
	}
}
