package test.core;

import static org.junit.Assert.*;

import org.junit.Test;

import targetcircle.core.Participant;

public class ParticipantTest {
	@Test
	public void test_construct(){
		String name = "sdfghjkl";
		Participant test = new Participant(new String(name));
		assertEquals(test.toString(),name);
	}
	
}
