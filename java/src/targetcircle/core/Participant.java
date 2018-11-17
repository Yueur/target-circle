package targetcircle.core;

import targetcircle.output.IOutVisitor;

public class Participant implements IElement {
	private String name;
	
	public Participant(String name){
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

	public String accept(IOutVisitor visitor){
		return name;
	}
}
