package targetcircle;

import targetcircle.core.GiverTaker;
import targetcircle.core.IElement;
import targetcircle.core.Participant;
import targetcircle.output.FacadeOut;
import targetcircle.tools.LList;
import targetcircle.tools.Random;

/**
 * Entrypoint for the user to use this package.
 *
 */
public class Facade {
	/**
	 * Generate a dot file with the number of participants.
	 * 
	 * @param numberParticipants The number of participants
	 */
	public static void createSantaToDot(int numberParticipants){
		createSantaToDot(numberParticipants, "secret-santa.dot");
	}
	
	/**
	 * Generate a dot file with the number of participants.
	 * 
	 * @todo Body of function
	 * @param numberParticipants The number of participants
	 * @param filename Path to the dot file you want to save
	 */
	public static void createSantaToDot(int numberParticipants, String filename){
		
	}
	
	public static void createSantaToConsole(int numberParticipants){
		Random rnd = new Random();
		LList<Participant> taker = new LList<Participant>();
		GiverTaker<IElement, IElement> gt = new GiverTaker<IElement, IElement>();
		
		for(int i=0 ; i<numberParticipants ; i++){
			taker.add(new Participant(""+i));
		}

		taker=rnd.getList(taker);
		
		for(int i=0 ; i<numberParticipants ; i++){
			gt.setEntry(new Participant(""+i), taker.get(i));
		}
		
		FacadeOut.toConsole(gt);
	}
	
}
