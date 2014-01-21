public class Solution {
    public double pow(double x, int n) {
        if (n == 0)
            return 1.0;
        if (n<0){
            if (n == Integer.MIN_VALUE)
            	return 1.0 / pow(x, Integer.MAX_VALUE);
        	return 1.0 / pow(x, -1* n);
        }
        
        if( Math.abs(x - 1) <= 0.00000001)
        	return x >0 ? 1.0 : -1.0;
        double tmp = pow(x, n/2);
        return n%2 == 1 ? tmp * tmp * x : tmp * tmp;
    }
}
