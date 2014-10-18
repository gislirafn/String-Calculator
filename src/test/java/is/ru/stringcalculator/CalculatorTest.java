package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
    
    //1
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

    //2
	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

    //3
	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	
    
    //4
	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    //5
    @Test
    public void testMultipleNumbersWithNewLine(){
        assertEquals(10, Calculator.add("1\n2\n3\n4"));
    }
    
    //6
    @Test
    public void testMultipleNumbersWithNewLineAndComma(){
        assertEquals(6, Calculator.add("1\n2,3"));
    }
    
    //7
    @Test
    public void testMultipleNumbers2(){
        assertEquals(13, Calculator.add("1\n3,4\n5"));
    }

    //8
    @Test
    public void delimiterTest(){
        assertEquals(3, Calculator.add("//;\n1;2"));
    }

    //9
    @Test
    public void delimiterTest2(){
        assertEquals(5, Calculator.add("//r\n1r1,1r1\n1"));
    }

    //10
    @Test
    public void negativeTest(){
        assertEquals(2, Calculator.add("1,1,-2,-4"));
    }

    //11
    @Test
    public void notNegativeTest(){
        assertEquals(2, Calculator.add("1\n1"));
    }

    //12
    @Test
    public void negativeTest2(){
        assertEquals(5, Calculator.add("2,-9\n2,-2,1"));
    }

    //13
    @Test
    public void tooBigTest(){
        assertEquals(2, Calculator.add("1001,2"));
    }

    //14
    @Test
    public void tooBigTest2(){
        assertEquals(40, Calculator.add("//g\n13,7,1020g1001\n20"));
    }

    //15
    @Test
    public void anyLengthDelimiters(){
        assertEquals(6, Calculator.add("//[rrr]\n1rrr2rrr3"));
    }

    //16
    @Test
    public void anyLengthDelimiter2(){
        assertEquals(7, Calculator.add("//[***]\n1***2***3,1"));
    }
}
