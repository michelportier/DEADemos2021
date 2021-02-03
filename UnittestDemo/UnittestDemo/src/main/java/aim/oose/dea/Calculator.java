package aim.oose.dea;

public class Calculator {
    public int multiply(int x, int y) {
        return x * y;
    }

    public int add(int x, int y) {
        return x + y;
    }

    public float divide (float x, float y){
        if (y==0){
            //TODO: iets met exceptions!
            System.out.println("dit kan niet");
        }

        return (float) x / y;
    }
}
