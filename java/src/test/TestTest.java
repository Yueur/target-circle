package test;

import org.junit.Test;

import junit.framework.TestCase;

public class TestTest extends TestCase {
	
	@Test
	public void testTrue(){
		assertTrue(true);
	}
	
	@Test
	public void testFalse(){
		assertFalse(false);
	}
	
	@Test
	public void testEquals(){
		assertEquals(1,1);
	}
}

