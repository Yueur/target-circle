package targetcircle.core.check;

import targetcircle.core.GiverTaker;
import targetcircle.core.IElement;
import targetcircle.tools.LList;
import targetcircle.tools.LRuntimeException;

public class Loop {
	public boolean isValid(GiverTaker<IElement, IElement> elem){
		return isValid(elem,2);
	}
	
	public boolean isValid(GiverTaker<IElement, IElement> elem, int nb){
		if(nb < 0 ){
			throw new LRuntimeException("nb < 0");
		}
		
		LList<IElement> aaa = elem.keyList();
		
		for(int i=0 ; i<aaa.size() ; i++){
			IElement ref = elem.get(aaa.get(i));
			IElement k = elem.get(ref);
			for(int j=0; j < nb ; j++){
				// Compare with next
				if(ref.compareTo(k) == 0){
					return false;
				}
				k = elem.get(k);
			}
		}
		return true;
	}
}
