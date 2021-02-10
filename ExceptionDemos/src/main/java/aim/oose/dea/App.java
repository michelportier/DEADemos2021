package aim.oose.dea;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main ( String[] args )
    {
        try {
            action();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void action() throws Exception {
        App app = new App();
        app.doSomething("Michel");

    }


    public void doSomething(String name) throws DiscriminationException, DiseaseException {
        if (name.equals("Zwarte Piet")){
            throw new DiscriminationException("Zwarte Piet kan echt niet meer");
        }
        if (name.toUpperCase().equals("CORONA")){
            throw new DiseaseException("Hier willen we allemaal vanaf!");
        }

        System.out.println("Wat een mooie naam!");
    }
}
