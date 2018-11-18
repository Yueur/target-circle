package targetcircle.output;

import targetcircle.core.IElement;

/**
 * 
 * @todo ... clean for visitor and reusability. 
 *
 */
public class VisitorArrow implements IOutVisitor {
	private String text;
	
	public VisitorArrow(){
		text="";
	}

	public void participantGT(IElement giver, IElement target) {
		text += giver+" -> "+target+";"+ToConsole.newline(); // ... this is not pretty...
	}
	
	public void reset() {
		text="";
	}
	
	public String toString(){
		return text;
	}

}
