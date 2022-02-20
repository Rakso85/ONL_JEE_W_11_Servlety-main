package pl.coderslab.regex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main03 {

    public static void main(String[] args) {
        final Pattern OP_PATTERN = Pattern.compile("\\d+([-+*/]\\d+)*=\\d+");

      //  public static void main (String[]args) throws IOException {
            List<String> operations = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            String line;
            while (!(line = scanner.nextLine()).equals("quit")) {
                line = line.replaceAll("\\s+", "");
                if (OP_PATTERN.matcher(line).matches()) {
                    operations.add(line);
                }
            }

          //  Files.write(Paths.get("operations.txt"), operations);
        }
    }

