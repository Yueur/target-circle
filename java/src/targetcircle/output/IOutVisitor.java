package targetcircle.output;

import targetcircle.core.IElement;

public interface IOutVisitor {
	public void reset();
	
	public void participantGT(IElement giver, IElement target);
}
