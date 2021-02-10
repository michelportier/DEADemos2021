package aim.oose.dea;

public class Calculator {
    private CustomCalculation customCalculation;

    public int multiply(int x, int y) {
        return x * y;
    }

    public int add(int x, int y) {
        return x + y;
    }

    public float divide(float x, float y) {
        if (y == 0) {
            throw new IllegalArgumentException("Delen door nul is flauwekul!");
        }

        return (float) x / y;
    }

    public void setCustomCalculation(CustomCalculation customCalculation) {
        this.customCalculation = customCalculation;
    }

    public int performCustomCalculation(int x, int y) {
        if (customCalculation != null)
            return customCalculation.calculate(x, y);

        return -1;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Old fashinoned: implement a class for every calculation
        MyCustomCalculation myCustomCalculation = new MyCustomCalculation();
        MyOtherCustomCalculation myOtherCustomCalculation = new MyOtherCustomCalculation();
        calculator.setCustomCalculation(myOtherCustomCalculation);

        System.out.println(calculator.performCustomCalculation(10, 5));

        // Cool functional style (the only thing that is good about e.g. javascript)
        calculator.setCustomCalculation(
                (x,y) ->  488 * x - y / 23
        );
        System.out.println(calculator.performCustomCalculation(50, 25));

    }
}
