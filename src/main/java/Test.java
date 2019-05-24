import org.docx4j.openpackaging.exceptions.Docx4JException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException, Docx4JException {
        DocumentService documentService = new DocumentService();
        InputParser parser = new InputParser();
        File resources = new File("D:\\work\\collectdocx\\src\\main\\resources");
        File[] files = resources.listFiles();
        List<NistTestResult> tests = new ArrayList<NistTestResult>();
        for(File file: files){
            tests.add(parser.parse(file));
        }
        File exportFile = documentService.createDocx(tests);
        System.out.println(exportFile);
    }
}
