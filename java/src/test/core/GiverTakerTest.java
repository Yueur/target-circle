package test.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import targetcircle.core.GiverTaker;
import targetcircle.core.Participant;
import targetcircle.output.IOutVisitor;
import targetcircle.output.VisitorArrow;

public class GiverTakerTest {
	@Test
	public void test_construct(){
		IOutVisitor visitor = new VisitorArrow();
		GiverTaker<Participant, Participant> subject = new GiverTaker<Participant, Participant>();
		
		foo(visitor, subject, "");
		
		subject.setEntry(new Participant("1"), new Participant("2"));
		foo(visitor, subject, "1 -> 2\n");

		subject.setEntry(new Participant("2"), new Participant("1"));
		foo(visitor, subject, "1 -> 2\n2 -> 1\n");
	}
	
	private void foo(IOutVisitor visitor, GiverTaker<Participant, Participant> subject, String expectation){
		visitor.reset();
		subject.visit(visitor);
		assertEquals(visitor.toString(), expectation);
	}
}
