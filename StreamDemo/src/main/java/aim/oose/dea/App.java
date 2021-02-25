package aim.oose.dea;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Predicate predicate = (grade) -> (int) grade >= 6;

        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(4);
        grades.add(7);
        grades.add(5);

        // demo for each element print element
        grades.parallelStream()
                .forEach(
                        (grade -> System.out.println(grade))

        );

        System.out.println("---filter demo---");

        // demo map + filter
        grades.stream()
                .map(grade -> grade + 1)
                .filter (predicate)
                .forEach(
                        grade -> System.out.println(grade)
                );

        System.out.println("---change type  demo---");

        // demo map change type
        grades.stream()
                .map(grade -> {
                    if (grade < 6)
                        return "onvoldoende";
                    return "voldoende";
                })
                .forEach(
                        grade -> System.out.println(grade)
                );

        System.out.println("---collect---");

        // demo collect
        List<String> gradesAsString = grades.stream()
                .map(grade -> {
                    if (grade < 6)
                        return "onvoldoende";
                    return "voldoende";
                })
                .collect(Collectors.toList());


        System.out.println("---reduce sum---");

        // demo reduce
        // calculate the sum of the grades
        int sum = grades.stream()
                .reduce(0,
                        (result, grade) -> grade + result);
        System.out.println(sum);


        System.out.println("---demo instream---");

        // demo intstream
        OptionalDouble average  = grades.stream()
                .mapToInt(grade -> grade)
                .average();

        if (average.isPresent()){
            System.out.println(average.getAsDouble());
        }

        // Int stream with numbers from 0 -250
        IntStream.range(0,250);
    }
}
