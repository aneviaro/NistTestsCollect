public class NistTestResult {
    private String scenario;
    private int size;
    private double pNonOverlapping;
    private double pSerial;
    private double pOnes;
    private double pCumulative;
    private double pEnthropy;
    private double pSpectral;

    public NistTestResult() {
    }

    public NistTestResult(String[] in){
        this.scenario = in[0];
        this.size = Integer.parseInt(in[1]);
        this.pNonOverlapping = Double.parseDouble(in[2]);
        this.pSerial = Double.parseDouble(in[3]);
        this.pOnes = Double.parseDouble(in[4]);
        this.pCumulative = Double.parseDouble(in[5]);
        this.pEnthropy = Double.parseDouble(in[6]);
        this.pSpectral = Double.parseDouble(in[7]);
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setpNonOverlapping(double pNonOverlapping) {
        this.pNonOverlapping = pNonOverlapping;
    }

    public void setpSerial(double pSerial) {
        this.pSerial = pSerial;
    }

    public void setpOnes(double pOnes) {
        this.pOnes = pOnes;
    }

    public void setpCumulative(double pCumulative) {
        this.pCumulative = pCumulative;
    }

    public void setpEnthropy(double pEnthropy) {
        this.pEnthropy = pEnthropy;
    }

    public void setpSpectral(double pSpectral) {
        this.pSpectral = pSpectral;
    }

    public NistTestResult(String scenario, int size, double pNonOverlapping, double pSerial, double pOnes, double pCumulative, double pEnthropy, double pMatrix, double pSpectral) {
        this.scenario = scenario;
        this.size = size;
        this.pNonOverlapping = pNonOverlapping;
        this.pSerial = pSerial;
        this.pOnes = pOnes;
        this.pCumulative = pCumulative;
        this.pEnthropy = pEnthropy;
        this.pSpectral = pSpectral;
    }

    public String getScenario() {
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
                ", pSpectral=" + pSpectral +
                '}';
    }
}
