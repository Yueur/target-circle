package targetcircle.output;

import targetcircle.core.GiverTaker;
import targetcircle.core.IElement;

public class FacadeOut {
	public static void toConsole(GiverTaker<IElement, IElement> entry){
		ToConsole tmp = new ToConsole();
		tmp.output(entry);
	}
}
