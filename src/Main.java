import exporters.HTMLExporter;
import exporters.NumberExporter;
import providers.FromFileNumberProvider;
import providers.NumberProvider;
import providers.RandomNumberProvider;
import sorters.BubbleSorter;
import sorters.NumberSorter;

import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        NumberProvider theProvider = new RandomNumberProvider(System.nanoTime());

        var theNumbers = theProvider.provideNumbers();

        System.out.println("BEFORE SORTING: [" + theNumbers.stream().map(Object::toString).collect(Collectors.joining(",")) + "]");

        NumberSorter theSorter = new BubbleSorter();
        var sortedNumbers = theSorter.sort(theNumbers);

        System.out.println("AFTER SORTING : [" + sortedNumbers.stream().map(Object::toString).collect(Collectors.joining(",")) + "]");

        NumberExporter theExporter = new HTMLExporter("numbersFormatted");
        theExporter.export(sortedNumbers);
    }
}
