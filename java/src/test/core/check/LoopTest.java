package test.core.check;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import targetcircle.core.GiverTaker;
import targetcircle.core.IElement;
import targetcircle.core.Participant;
import targetcircle.core.check.Loop;

public class LoopTest {

	@Test
	public void test_1_0(){
		Loop subject = new Loop();
		GiverTaker<IElement, IElement> elem = new GiverTaker<IElement, IElement> ();

		elem.setEntry(new Participant("1"), new Participant("1"));
		assertEquals(subject.isValid(elem, 1), false);
	}
	
	@Test
	public void test_1_1(){
		Loop subject = new Loop();
		GiverTaker<IElement, IElement> elem = new GiverTaker<IElement, IElement> ();

		elem.setEntry(new Participant("1"), new Participant("2"));
		elem.setEntry(new Participant("2"), new Participant("1"));
		assertEquals(subject.isValid(elem, 1), true);
	}
	
	//------------------------
	@Test
	public void test_2_0(){
		Loop subject = new Loop();
		GiverTaker<IElement, IElement> elem = new GiverTaker<IElement, IElement> ();

		elem.setEntry(new Participant("1"), new Participant("1"));
		assertEquals(subject.isValid(elem), false);
	}

	@Test
	public void test_2_1(){
		Loop subject = new Loop();
		GiverTaker<IElement, IElement> elem = new GiverTaker<IElement, IElement> ();

		elem.setEntry(new Participant("1"), new Participant("2"));
		elem.setEntry(new Participant("2"), new Participant("1"));
		assertEquals(subject.isValid(elem), false);
	}

	@Test
	public void test_2_2(){
		Loop subject = new Loop();
		GiverTaker<IElement, IElement> elem = new GiverTaker<IElement, IElement> ();

		elem.setEntry(new Participant("1"), new Participant("2"));
		elem.setEntry(new Participant("2"), new Participant("3"));
		elem.setEntry(new Participant("3"), new Participant("1"));
		assertEquals(subject.isValid(elem), true);
	}

	//------

	@Test
	public void test_3_2(){
		Loop subject = new Loop();
		GiverTaker<IElement, IElement> elem = new GiverTaker<IElement, IElement> ();

		elem.setEntry(new Participant("1"), new Participant("2"));
		elem.setEntry(new Participant("2"), new Participant("3"));
		elem.setEntry(new Participant("3"), new Participant("1"));
		assertEquals(subject.isValid(elem, 3), false);
	}

	@Test
	public void test_3_3(){
		Loop subject = new Loop();
		GiverTaker<IElement, IElement> elem = new GiverTaker<IElement, IElement> ();

		elem.setEntry(new Participant("1"), new Participant("2"));
		elem.setEntry(new Participant("2"), new Participant("3"));
		elem.setEntry(new Participant("3"), new Participant("4"));
		elem.setEntry(new Participant("4"), new Participant("1"));
		assertEquals(subject.isValid(elem, 3), true);
	}


}
