package test.tools;

import junit.framework.TestCase;

import org.junit.Test;

import targetcircle.tools.LList;
import targetcircle.tools.Random;

public class RandomTest extends TestCase {
		@Test
		public void test_getInt_Max(){
			int tmp, maxi=50;
			Random rnd = new Random();

			for(int i=0; i<5000 ; i++){
				tmp = rnd.getInt(maxi);
				assertTrue(tmp < maxi);
				assertTrue(tmp >= 0);
			}
		}
		
		@Test
		public void test_getInt_MinMax(){
			int tmp, mini=50, maxi=100;
			Random rnd = new Random();
			for(int i=0; i<5000 ; i++){
				tmp = rnd.getInt(mini, maxi);
				assertTrue(tmp < maxi);
				assertTrue(tmp >= mini);
			}
		}
		
		@Test
		public void test_getList(){
			int r=1; // How many difference in each term.
			int start=1;
			int nb_elements=51;
			
			// Test
			Random rnd = new Random();
			
			LList<Integer> subject = new LList<Integer>();
			for(int i=start; i<=nb_elements ; i=i+r){
				subject.add(i);
			}
			
			LList<Integer> randomised = rnd.getList(subject);
			
			assertTrue(subject.size() == randomised.size());
			
			int test = (nb_elements-start+1)*(2*start+(nb_elements-start)*r)/2;
			int tmp=0;
			for(int i=0; i<randomised.size() ; i++){
				tmp += subject.get(i);
			}
			
			System.out.println(tmp);
			System.out.println(test);
			assertTrue(tmp == test);
		}
		
}
