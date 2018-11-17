package targetcircle.output;

import targetcircle.core.GiverTaker;
import targetcircle.core.IElement;

public class ToConsole implements IOutput {
	public static String newline(){
		return "\n";
	}

	public void output(GiverTaker<IElement, IElement> toOuput) {
		VisitorArrow visitor = new VisitorArrow();
		toOuput.visit(visitor);
		System.out.println(visitor);
	}	
}
