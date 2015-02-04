package audible;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AudibleTest {

	private ArrayPrinter ap;
	
	@Test
	public void testArrayPrinterExp1() {
		String[][] input = {
				{"1", "2", "3", "4"}, 
				{"5", "6", "7", "8"}, 
				{"9", "10", "11", "12"} 
		};
		
		String output = ap.getArraysStringClockwise(input);
		assertEquals(output, "1 2 3 4 8 12 11 10 9 5 6 7");
		System.out.println(output);
	}
	
	@Test
	public void testArrayPrinterExp2() {
		String[][] input = {
				{"A", "b", "c", "d", "e", "1"}, 
				{"F", "g", "h", "i", "j", "2"}, 
				{"K", "l", "m", "n", "o", "3"}, 
				{"P", "q", "r", "s", "t", "4"}
		};
		
		String output = ap.getArraysStringClockwise(input);
		assertEquals(output, "a b c d e 1 2 3 4 t s r q p k f g h i j o n m l");
		System.out.println(output);
	}
	
	@Test
	public void testArrayPrinterEndingWestEdge() {
		String[][] input = {
				{"1", "2", "3", "4"}, 
				{"5", "6", "7", "8"}, 
				{"9", "10", "11", "12"}, 
				{"13", "14", "15", "16"}, 
				{"17", "18", "19", "20"}   
		};
		
		String output = ap.getArraysStringClockwise(input);
		assertEquals(output, "1 2 3 4 8 12 16 20 19 18 17 13 9 5 6 7 11 15 14 10");
		System.out.println(output);
	}
	
	@Test
	public void testArrayPrinterEndingEastEdge() {
		String[][] input = {
				{"1", "2", "3"}, 
				{"5", "6", "7"}, 
				{"9", "10", "11"}, 
				{"13", "14", "15"}, 
				{"17", "18", "19"}   
		};
		
		String output = ap.getArraysStringClockwise(input);
		assertEquals(output, "1 2 3 7 11 15 19 18 17 13 9 5 6 10 14");
		System.out.println(output);
	}
	
	@Before
	public void setUp() throws Exception {
		ap = new ArrayPrinter();
	}


}
