package targetcircle.core;

import targetcircle.core.check.ICheck;
import targetcircle.core.check.IFix;
import targetcircle.core.check.Loop;
import targetcircle.tools.LException;
import targetcircle.tools.LList;
import targetcircle.tools.Random;

public class FacadeCore {
	public GiverTaker<IElement, IElement> get_random_list(LList<Participant> participants){
		Random rnd = new Random();
		LList<Participant> taker = rnd.getList(participants);
		GiverTaker<IElement, IElement> gt = new GiverTaker<IElement, IElement>();
		
		for(int i=0 ; i<taker.size() ; i++){
			gt.setEntry(participants.get(i), taker.get(i));
		}
		
		return gt;
	}
	
	/**
	 * Best effort, no fix.
	 * 
	 * @param participants
	 * @return
	 */
	public GiverTaker<IElement, IElement> create_secret_santa_list(LList<Participant> participants){
		GiverTaker<IElement, IElement> output;
		Loop tmp = new Loop();
		ICheck check = tmp;
		
		int j=0;
		int max_j=20;
		do{
			output = get_random_list(participants);
			j++;
		}while(!check.isValid(output) && j < max_j);
		
		return output;
	}
}
