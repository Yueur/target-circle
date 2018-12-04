package targetcircle.core.check;

import targetcircle.core.GiverTaker;
import targetcircle.core.IElement;

public interface ICheck {
	public boolean isValid(GiverTaker<IElement, IElement> elem);
}
