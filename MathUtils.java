// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
public class MathUtils {

	//-------------------------------------------------------------
	// Returns the factorial of the argument given
	//-------------------------------------------------------------
	public static int factorial(int n) throws IllegalArgumentException {
		if (n < 1) {
			throw new IllegalArgumentException("Number entered was below 1, factorial does not exist.");
		}else if (n > 16) {
			throw new IllegalArgumentException("Number entered was above 16, factorial too large for int type.");
		}else if (n > 16) {

		}
		int fac = 1;
		for (int i=n; i>0; i--) {
			fac *= i;
		}
		return fac;
	}
	
}