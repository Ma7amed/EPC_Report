/**
 * Created by Admin on 2/3/2018.
 */
public class EPGStatistics {

    private int noPdpActive;
    private int noEpsActiveBearer;
    private double uplinkGn;
    private double uplinkS5;
    private double downlinkGn;
    private double downlinkS5;

    public int getNoPdpActive() {
        return noPdpActive;
    }

    public void setNoPdpActive(int noPdpActive) {
        this.noPdpActive = noPdpActive;
    }

    public int getNoEpsActiveBearer() {
        return noEpsActiveBearer;
    }

    public void setNoEpsActiveBearer(int noEpsActiveBearer) {
        this.noEpsActiveBearer = noEpsActiveBearer;
    }

    public double getUplinkGn() {
        return uplinkGn;
    }

    public void setUplinkGn(double uplinkGn) {
        this.uplinkGn = uplinkGn;
    }

    public double getUplinkS5() {
        return uplinkS5;
    }

    public void setUplinkS5(double uplinkS5) {
        this.uplinkS5 = uplinkS5;
    }

    public double getDownlinkGn() {
        return downlinkGn;
    }

    public void setDownlinkGn(double downlinkGn) {
        this.downlinkGn = downlinkGn;
    }

    public double getDownlinkS5() {
        return downlinkS5;
    }

    public void setDownlinkS5(double downlinkS5) {
        this.downlinkS5 = downlinkS5;
    }

    @Override
    public String toString() {
        return "EPGStatistics{" +
                "noPdpActive=" + noPdpActive +
                ", noEpsActiveBearer=" + noEpsActiveBearer +
                ", uplinkGn=" + uplinkGn +
                ", uplinkS5=" + uplinkS5 +
                ", downlinkGn=" + downlinkGn +
                ", downlinkS5=" + downlinkS5 +
                '}';
    }
}
