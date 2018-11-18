package targetcircle.core;

import targetcircle.output.IOutVisitor;
import targetcircle.tools.LComparable;

public interface IElement extends LComparable {
	public String accept(IOutVisitor visitor); // For IOutVisitor => This allow proper format especially for Lists...
}
