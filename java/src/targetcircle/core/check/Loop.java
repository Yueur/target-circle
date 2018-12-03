package targetcircle.core.check;

import targetcircle.core.GiverTaker;
import targetcircle.core.IElement;
import targetcircle.tools.LList;
import targetcircle.tools.LRuntimeException;

public class Loop {
	private int nb_default=2;
	
	/**
	 * Checks if the ref is one of the n-th first element after him.
	 * 
	 * @param elem List of element. One key only has 1 value (taken from the list of keys)
	 * @param nb Number of person after you you musn't appear in. 
	 * @param ref The reference 
	 * @return
	 */
	private boolean inRange(GiverTaker<IElement, IElement> elem, int nb, IElement ref){
		IElement k = elem.get(ref);
		for(int j=0; j < nb ; j++){
			// Compare with next
			if(ref.compareTo(k) == 0){
				return true;
			}
			k = elem.get(k);
		}
		return false;
	}
	
	// -------------------
	
	public boolean isValid(GiverTaker<IElement, IElement> elem){
		return isValid(elem, nb_default);
	}
	
	public boolean isValid(GiverTaker<IElement, IElement> elem, int nb){
		if(nb < 0 ){
			throw new LRuntimeException("nb < 0");
		}
		
		LList<IElement> aaa = elem.keyList();
		
		for(int i=0 ; i<aaa.size() ; i++){
			IElement ref = elem.get(aaa.get(i));
			if(inRange(elem, nb, ref)){
				return false;
			}
		}
		return true;
	}
	
	public GiverTaker<IElement, IElement> fix(GiverTaker<IElement, IElement> elem){
		return fix(elem, nb_default);
	}
	
	
	/**
	 * Not done
	 * 
	 * @todo
	 * 
	 * @param elem
	 * @param nb
	 * @return
	 */
	public GiverTaker<IElement, IElement> fix(GiverTaker<IElement, IElement> elem, int nb){
		if(nb < 0 ){
			throw new LRuntimeException("nb < 0");
		}
		
		LList<IElement> aaa = elem.keyList();
		GiverTaker<IElement, IElement> output = new GiverTaker<IElement, IElement>();
		LList<IElement> target = new LList<IElement>();
		LList<IElement> giver = new LList<IElement>();
		
		for(int i=0 ; i<aaa.size() ; i++){
			IElement ref = elem.get(aaa.get(i));
			IElement tmpTarget = elem.get(ref);
			if(inRange(elem, nb, ref)){
				giver.add(ref);
				target.add(tmpTarget);
			}
			else{
				output.setEntry(ref, tmpTarget);
			}
		}
		
		// Resort rest
		if(0 < target.size() && target.size() < nb){
			
		}
		
		return output;
	}
}
