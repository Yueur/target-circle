package targetcircle.core;

import targetcircle.output.IOutVisitor;

public interface IElement {
	public String accept(IOutVisitor visitor); // For IOutVisitor => This allow proper format 
}
