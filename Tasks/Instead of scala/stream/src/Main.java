import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\kolma\\Desktop\\java\\stream\\src\\alice.txt");
        List list = Files.lines(Paths.get(file.getAbsolutePath()))
                .flatMap( s -> Stream.of(s.split(" ")))
                .map(word -> (word,1))
                .collect(Collectors.toList());
        System.out.println(list);
        /*
        counts = file.flatMap(line => line.split(" "))
                         .map(word => (word, 1))
                         .reduceByKey(_ + _)

         */
    }
}
