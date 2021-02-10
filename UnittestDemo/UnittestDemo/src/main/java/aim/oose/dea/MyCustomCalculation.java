package aim.oose.dea;

public class MyCustomCalculation implements CustomCalculation{
    @Override
    public int calculate(int x, int y) {
        return x-y;
    }
}
