package targetcircle.core.check;

import targetcircle.core.GiverTaker;
import targetcircle.core.IElement;
import targetcircle.tools.LException;

public interface IFix {
	public GiverTaker<IElement, IElement> fix(GiverTaker<IElement, IElement> elem) throws LException;
}
