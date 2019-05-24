import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InputParser {
    public NistTestResult parse(File input) throws IOException {
        FileReader fileReader = new FileReader(input);
        Scanner scanner = new Scanner(fileReader);
        String[] in = scanner.nextLine().split(" ");
        return new NistTestResult(in);
    }
}
