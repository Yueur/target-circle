package targetcircle.output;

import targetcircle.core.GiverTaker;
import targetcircle.core.IElement;

public interface IOutput {
	public void output(GiverTaker<IElement, IElement> toOuput);
}
