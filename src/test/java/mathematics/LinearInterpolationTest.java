package mathematics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinearInterpolationTest {
    private final double[] increaseArrayX = {-1.23, 2., 3.41, 8.5, 9.123, 10, 12.345, 12.3451, 12.3452};
    private final double[] decreaseArrayX = {12.3452, 12.3451, 12.345, 10, 9.123, 8.5, 3.41, 2., -1.23};
    private final double[] arrayY = {-2.5, -5., 6.7, 7.2, 9.1, 12., 5.6, 10., 25.5001};


    private double expectedValue;
    private double actualValue;
    private double initialValue;


    @Test
    public void linearInterpolationUnderflow() throws LinearInterpolationException {
        double number = -1.2301;
        Assertions.assertThrows(LinearInterpolationException.class, ()-> LinearInterpolation.linearInterpolation(increaseArrayX, arrayY, number));
    }

    @Test
    public void linearInterpolationOverflow() throws LinearInterpolationException {
        double number = 12.34521;
        Assertions.assertThrows(LinearInterpolationException.class, ()-> LinearInterpolation.linearInterpolation(increaseArrayX, arrayY, number));
    }


    @Test
    public void checkValueAtLowerBound() throws LinearInterpolationException {
        initialValue = -1.23;
        expectedValue = -2.5;
        actualValue = LinearInterpolation.linearInterpolation(increaseArrayX,arrayY,initialValue);
        Assertions.assertEquals(expectedValue,actualValue,0.001);


        initialValue = -1.23;
        expectedValue = 25.5001;
        actualValue = LinearInterpolation.linearInterpolation(decreaseArrayX,arrayY,initialValue);
        Assertions.assertEquals(expectedValue,actualValue,0.001);
    }

    @Test
    public void checkValueAtUpperBound() throws LinearInterpolationException {
        initialValue = 12.3452;
        expectedValue = 25.5001;
        actualValue = LinearInterpolation.linearInterpolation(increaseArrayX,arrayY,initialValue);
        Assertions.assertEquals(expectedValue,actualValue,0.001);

        initialValue = 12.3452;
        expectedValue = -2.5;
        actualValue = LinearInterpolation.linearInterpolation(decreaseArrayX,arrayY,initialValue);
        Assertions.assertEquals(expectedValue,actualValue,0.001);
    }

    @Test
    public void linearInterpolationValidation() throws LinearInterpolationException {
        initialValue = 2.0;
        expectedValue = -5.000;
        actualValue = LinearInterpolation.linearInterpolation(increaseArrayX,arrayY,initialValue);
        Assertions.assertEquals(expectedValue,actualValue,0.001);

        initialValue = 12.345;
        expectedValue = 5.600;
        actualValue = LinearInterpolation.linearInterpolation(increaseArrayX,arrayY,initialValue);
        Assertions.assertEquals(expectedValue,actualValue,0.001);

        initialValue = 2.51;
        expectedValue = -0.76809;
        actualValue = LinearInterpolation.linearInterpolation(increaseArrayX,arrayY,initialValue);
        Assertions.assertEquals(expectedValue,actualValue,0.00001);

        initialValue = 12.34503;
        expectedValue = 6.920;
        actualValue = LinearInterpolation.linearInterpolation(increaseArrayX,arrayY,initialValue);
        Assertions.assertEquals(expectedValue,actualValue,0.001);
    }

}
