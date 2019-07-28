package task4;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;


public class TextSupplier {

    public static List<String> findFragmentsInFile() {

        String allFileAsString =
                null;
        try {
            allFileAsString = Files
                    .lines(Paths.get("src\\main\\resources\\text.html"), Charset.defaultCharset())
                    .collect(joining());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> fragments = new ArrayList<String>();

        Matcher m = Pattern.compile("<script[\\s>].+?</script>")
                .matcher(allFileAsString);
        while (m.find()) {
            fragments.add(m.group());
        }


        return fragments.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> result = findFragmentsInFile();
        try {
            Files.write(Paths.get("src\\main\\resources\\resultTask4"), result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




