package targetcircle.core;

import targetcircle.tools.LList;

public interface IGenerate {
	public GiverTaker<IElement, IElement> generateRandom(LList<Participant> liste);
}
