package mathematics;

public class LinearInterpolation {
    private static int index1, index2;

    //linear interpolation
    public static Double linearInterpolation (double[] X, double[] Y, double X0) throws LinearInterpolationException {
        if(X.length == 2) {
            index1 = 0; index2 = 1;
        } else searchIndex(X, X0);
        return functionLinearInterpolation(X[index1], Y[index1], X[index2], Y[index2], X0);
    }

    private static void searchIndex(double[] array, double value) throws LinearInterpolationException {
        int n = array.length;
        boolean increasingSequence;
        //checking if the argument is in the range
        if (array[0] < array[n-1]) {
            increasingSequence = true;
            if (!(value >= array[0] && value <= array[n-1]))
                throw new  LinearInterpolationException(String.format("the argument %f is out of range [%f %f]  ", value, array[0], array[n-1]));
        } else {
            increasingSequence = false;
            if (!(value <= array[0] && value >= array[n-1]))
                throw new  LinearInterpolationException(String.format("the argument %f is out of range [%f %f]  ", value, array[0], array[n-1]));
        }
        int a = 0, b = n-1, c;
        while (a < b-1) {
            c = (a + b)/2;
            if (increasingSequence) {
                if (value < array[c]) b = c;
                else a = c;
            } else {
                if (value < array[c]) a = c;
                else b = c;
            }
            if (Math.abs(b-a) == 1) {
                index1 = a; index2 = a+1;
                return;
            }
        }
    }

    private static double functionLinearInterpolation(double x1, double y1, double x2, double y2, double value) {
        return y1 + ((y2-y1)/(x2-x1)) * (value - x1);
    }
}
