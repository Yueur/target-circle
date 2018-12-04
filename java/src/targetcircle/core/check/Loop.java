package targetcircle.core.check;

import targetcircle.core.GiverTaker;
import targetcircle.core.IElement;
import targetcircle.tools.LException;
import targetcircle.tools.LList;
import targetcircle.tools.LRuntimeException;
import targetcircle.tools.Random;

public class Loop implements ICheck, IFix {
	private int nb_default;
	private int max_loop_for_fix;
	
	public Loop(){
		this(2);
	}
	
	public Loop(int nb){
		nb_default = nb;
		max_loop_for_fix = 20;
	}
	
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
	
	// ----------------------
	
	public GiverTaker<IElement, IElement> fix(GiverTaker<IElement, IElement> elem) throws LException{
		return fix(elem, nb_default);
	}

	public GiverTaker<IElement, IElement> fix(GiverTaker<IElement, IElement> elem, int nb) throws LException{
		return fix(elem, nb, max_loop_for_fix);
	}
	
	/**
	 * Not quite done...
	 * 
	 * @param elem
	 * @param nb
	 * @return
	 * @throws LException 
	 */
	public GiverTaker<IElement, IElement> fix(GiverTaker<IElement, IElement> elem, int nb, int max_loop) throws LException{
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
		if(0 < target.size()){
			if(target.size() > nb){
				throw new LException("Cannot fix this list");
			}
			// else
			int i=0;
			Random rnd = new Random();
			GiverTaker<IElement, IElement> output_part = new GiverTaker<IElement, IElement>();
			do{
				if(i >= max_loop){
					throw new LException("Cannot randomly fix this list");
				}
				i++;
				
				output_part.clear(); 
				LList<IElement> new_target = rnd.getList(target);
				
				for(int j=0; j < target.size() ; j++){
					output_part.setEntry(giver.get(j), new_target.get(j));
				}
			}while(!isValid(output_part, nb));
			
			giver = output_part.keyList();
			for(int j=0 ; j<giver.size() ; j++){
				output.setEntry(giver.get(j), output_part.get(giver.get(j)));
			}
		}
		
		return output;
	}
}
