import org.docx4j.model.table.TblFactory;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DocumentService {
    public File createDocx(List<NistTestResult> tests) throws Docx4JException {
        WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
        formMainDocumentPart(tests, wordPackage);
        File output = new File("output.docx");
        wordPackage.save(output);
        return output;
    }

    private MainDocumentPart formMainDocumentPart(List<NistTestResult> tests, WordprocessingMLPackage wordPackage) {
        MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
        mainDocumentPart.addStyledParagraphOfText("Title", "Таблица результатов тестирования выходных последовательностей");
        Tbl tbl = createTable(tests, wordPackage);
        mainDocumentPart.addObject(tbl);
        return mainDocumentPart;
    }

    private Tbl createTable(List<NistTestResult> tests, WordprocessingMLPackage wordPackage) {
        int writableWidthTwips = wordPackage.getDocumentModel()
                .getSections().get(0).getPageDimensions().getWritableWidthTwips();
        int columnNumber = 9;
        Tbl tbl = TblFactory.createTable(tests.size()+1, columnNumber, writableWidthTwips/columnNumber);
        List<Object> rows = tbl.getContent();
        Tr header = (Tr)rows.get(0);
        addHeader(header, wordPackage);
        for(int i=0; i< tests.size(); i++){
            Tr row = (Tr) rows.get(i+1);
            NistTestResult test=tests.get(i);
            addTestRow(row, test, wordPackage);
        }
        return tbl;
    }

    private List<P> testToP(NistTestResult test, WordprocessingMLPackage wordPackage){
        List<P> ps = new ArrayList<P>();
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText(String.valueOf(test.getScenario())));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText(String.valueOf(test.getSize())));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText(String.valueOf(test.getpNonOverlapping())));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText(String.valueOf(test.getpSerial())));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText(String.valueOf(test.getpOnes())));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText(String.valueOf(test.getpCumulative())));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText(String.valueOf(test.getpEnthropy())));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText(String.valueOf(test.getpMatrix())));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText(String.valueOf(test.getpSpectral())));
        return ps;
    }

    private List<P> headerToP(WordprocessingMLPackage wordPackage){
        List<P> ps = new ArrayList<P>();
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText("Сценарий"));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText("Число тактов"));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText("NonOverlapping"));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText("Serial"));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText("Ones"));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText("Cumulative"));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText("Enthropy"));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText("Matrix"));
        ps.add(wordPackage.getMainDocumentPart().createParagraphOfText("Spectral"));
        return ps;
    }

    private void addHeader(Tr tr,WordprocessingMLPackage wordPackage ){
        List<Object> cells = tr.getContent();
        List<P> header = headerToP(wordPackage);
        for(int i=0; i< cells.size(); i++){
            Tc tc = (Tc) cells.get(i);
            tc.getContent().add(header.get(i));
        }
    }

    private void addTestRow(Tr tr, NistTestResult test, WordprocessingMLPackage wordPackage){
        List<Object> cells = tr.getContent();
        List<P> row = testToP(test, wordPackage);
        for(int i=0; i< cells.size(); i++){
            Tc tc = (Tc) cells.get(i);
            tc.getContent().add(row.get(i));
        }
    }


}
