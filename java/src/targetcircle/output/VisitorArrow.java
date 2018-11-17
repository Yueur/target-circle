package targetcircle.output;

import targetcircle.core.IElement;

public class VisitorArrow implements IOutVisitor {
	private String text;
	
	public VisitorArrow(){
		text="";
	}

	public void participantGT(IElement giver, IElement target) {
		text += giver+" -> "+target+ToConsole.newline();
	}
	
	public void reset() {
		text="";
	}
	
	public String toString(){
		return text;
	}

}
