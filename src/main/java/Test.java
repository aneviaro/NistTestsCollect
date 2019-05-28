import org.docx4j.openpackaging.exceptions.Docx4JException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException, Docx4JException {
        DocumentService documentService = new DocumentService();
        InputParser parser = new InputParser();
        File nonoverlap = new File("D:\\work\\collectdocx\\src\\main\\resources\\Non-overlapping.txt");
        File serial = new File("D:\\work\\collectdocx\\src\\main\\resources\\Serial.txt");
        File spectral = new File("D:\\work\\collectdocx\\src\\main\\resources\\Spectral.txt");
        File enthropy = new File("D:\\work\\collectdocx\\src\\main\\resources\\Entropy.txt");
        File cumulative = new File("D:\\work\\collectdocx\\src\\main\\resources\\cumulative_sums.txt");
        File ones = new File("D:\\work\\collectdocx\\src\\main\\resources\\longest_run_of_ones.txt");
        List<NistTestResult> tests = parser.parse(nonoverlap, serial, enthropy, spectral, cumulative, ones);
        File exportFile = documentService.createDocx(tests);
        System.out.println(exportFile);
    }
}
