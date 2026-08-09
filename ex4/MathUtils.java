class MathUtils {
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0)
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        if (n > 16)
            throw new IllegalArgumentException("Factorial is defined only up to 16.");
        int fact = 1;
        for (int i = 2; i <= n; i++)
            fact *= i;
        return fact;
    }
}
