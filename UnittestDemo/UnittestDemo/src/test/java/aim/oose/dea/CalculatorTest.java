package aim.oose.dea;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void multiplyTest(){
        int x = 3;
        int y = 3;
        int expected = 9; // 3 * 3 = 9;

        int result = calculator.multiply(x,y);

        assertEquals(expected,result);
    }

    @Test
    public void addTest(){
        assertEquals(4,calculator.add(2,2));
        assertEquals(10,calculator.add(5,5));

    }

    @Test
    public void divideTest(){
        assertEquals(0.33333333f,calculator.divide(1,3), 0.00001f);

    }

    @Test
    public void divideByZeroTest(){
        calculator.divide(100,0);
        fail();
    }



}
