import sun.misc.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\kolma\\Desktop\\java\\rankingSystem\\src\\vocabulary.txt");

        List<String> lines = Files.lines(path).flatMap( s -> Stream.of(s.split("\n")))

        //Stream<String> lines = Files.lines(path);
        //lines.forEach(s -> System.out.println(s));

        System.out.println(lines);

        String request = "The population";
        String[] subrequest = request.split(" ");
        for (String word: subrequest) {
            if (lines.contains(word)){
                if (indexer_lines.contains())
            }
        }
    }
}
