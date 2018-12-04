package targetcircle;

import targetcircle.core.FacadeCore;
import targetcircle.core.GiverTaker;
import targetcircle.core.IElement;
import targetcircle.core.Participant;
import targetcircle.core.check.ICheck;
import targetcircle.core.check.Loop;
import targetcircle.output.FacadeOut;
import targetcircle.tools.LList;

/**
 * Entrypoint for the user to use this package.
 *
 */
public class Facade {
	public static LList<Participant> create_dummy_list_participant(int numberParticipants){
		LList<Participant> output = new LList<Participant>();
		
		for(int i=0 ; i<numberParticipants ; i++){
			output.add(new Participant(""+i));
		}
		
		return output;
	}
	
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
		FacadeCore fc = new FacadeCore();
		LList<Participant> taker = create_dummy_list_participant(numberParticipants);
		GiverTaker<IElement, IElement> gt = fc.create_secret_santa_list(taker);
		
		ICheck check = new Loop();
		if(!check.isValid(gt)){
			System.out.println("Best effort");
		}
		
		
		FacadeOut.toConsole(gt);
	}
	
}
