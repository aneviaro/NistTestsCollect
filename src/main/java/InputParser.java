import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputParser {
    public List<NistTestResult> parse(File nonoverlapping, File serial, File enthropy, File spectral, File cumulative, File ones) throws IOException {
        FileReader serialReader = new FileReader(serial);
        FileReader enthropyReader = new FileReader(enthropy);
        FileReader spectralReader = new FileReader(spectral);
        FileReader cumulativeReader = new FileReader(cumulative);
        FileReader onesReader = new FileReader(ones);
        Scanner serialScanner = new Scanner(serialReader);
        Scanner enthropyScanner = new Scanner(enthropyReader);
        Scanner spectralScanner = new Scanner(spectralReader);
        Scanner cumulativeScanner = new Scanner(cumulativeReader);
        Scanner onesScanner = new Scanner(onesReader);
        List<NistTestResult> tests = createTests(nonoverlapping);
        for (int i=0; i<tests.size(); i++){
            String[] serialStr = serialScanner.nextLine().trim().split("\\s+");
            String[] enthropyStr = enthropyScanner.nextLine().trim().split("\\s+");
            String[] spectralStr = spectralScanner.nextLine().trim().split("\\s+");
            String[] cumulativeStr = cumulativeScanner.nextLine().trim().split("\\s+");
            String[] onesStr = onesScanner.nextLine().trim().split("\\s+");
            tests.get(i).setpSerial(Double.parseDouble(serialStr[2]));
            tests.get(i).setpEnthropy(Double.parseDouble(enthropyStr[2]));
            tests.get(i).setpSpectral(Double.parseDouble(spectralStr[2]));
            tests.get(i).setpCumulative(Double.parseDouble(cumulativeStr[2]));
            tests.get(i).setpOnes(Double.parseDouble(onesStr[2]));
        }
        return tests;
    }

    private List<NistTestResult> createTests(File nonoverlapping) throws FileNotFoundException {
        FileReader nonoverlappingReader = new FileReader(nonoverlapping);
        Scanner nonoverlappingScanner = new Scanner(nonoverlappingReader);
        List<NistTestResult> tests = new ArrayList<NistTestResult>();
        while(nonoverlappingScanner.hasNextLine()){
            String[] nonoverlap = nonoverlappingScanner.nextLine().trim().split("\\s+");
            NistTestResult test = new NistTestResult();
            test.setScenario(nonoverlap[0]);
            test.setSize(Integer.parseInt(nonoverlap[1]));
            test.setpNonOverlapping(Double.parseDouble(nonoverlap[2]));
            tests.add(test);
        }
        return tests;
    }
}
