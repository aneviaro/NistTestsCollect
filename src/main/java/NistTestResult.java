public class NistTestResult {
    private int scenario;
    private int size;
    private double pNonOverlapping;
    private double pSerial;
    private double pOnes;
    private double pCumulative;
    private double pEnthropy;
    private double pMatrix;
    private double pSpectral;

    public NistTestResult(String[] in){
        this.scenario = Integer.parseInt(in[0]);
        this.size = Integer.parseInt(in[1]);
        this.pNonOverlapping = Double.parseDouble(in[2]);
        this.pSerial = Double.parseDouble(in[3]);
        this.pOnes = Double.parseDouble(in[4]);
        this.pCumulative = Double.parseDouble(in[5]);
        this.pEnthropy = Double.parseDouble(in[6]);
        this.pMatrix = Double.parseDouble(in[7]);
        this.pSpectral = Double.parseDouble(in[8]);
    }

    public NistTestResult(int scenario, int size, double pNonOverlapping, double pSerial, double pOnes, double pCumulative, double pEnthropy, double pMatrix, double pSpectral) {
        this.scenario = scenario;
        this.size = size;
        this.pNonOverlapping = pNonOverlapping;
        this.pSerial = pSerial;
        this.pOnes = pOnes;
        this.pCumulative = pCumulative;
        this.pEnthropy = pEnthropy;
        this.pMatrix = pMatrix;
        this.pSpectral = pSpectral;
    }

    public int getScenario() {
        return scenario;
    }

    public int getSize() {
        return size;
    }

    public double getpNonOverlapping() {
        return pNonOverlapping;
    }

    public double getpSerial() {
        return pSerial;
    }

    public double getpOnes() {
        return pOnes;
    }

    public double getpCumulative() {
        return pCumulative;
    }

    public double getpEnthropy() {
        return pEnthropy;
    }

    public double getpMatrix() {
        return pMatrix;
    }

    public double getpSpectral() {
        return pSpectral;
    }

    @Override
    public String toString() {
        return "NistTestResult{" +
                "scenario=" + scenario +
                ", size=" + size +
                ", pNonOverlapping=" + pNonOverlapping +
                ", pSerial=" + pSerial +
                ", pOnes=" + pOnes +
                ", pCumulative=" + pCumulative +
                ", pEnthropy=" + pEnthropy +
                ", pMatrix=" + pMatrix +
                ", pSpectral=" + pSpectral +
                '}';
    }
}
