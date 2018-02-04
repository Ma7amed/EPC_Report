import java.io.File;
import java.util.ArrayList;

/**
 * Created by Admin on 2/1/2018.
 */
public class EPG {

    private String epgName;

    private ArrayList<EPGSlot> slots;
    private ArrayList<EPGCard> cards;
    private ArrayList<EPGPort> ports;
    private ArrayList<EPGNotification> notifications;

    private EPGStatistics epgStatistics;

    private String epgIP;
    private File cmdOutFile;

    private EPGMemory memory;
    private String redundancyStatus;
//    private int noPdpActive;
//    private int noEpsActiveBearer;
//    private double uplinkGn;
//    private double uplinkS5;
//    private double downlinkGn;
//    private double downlinkS5;

    public EPG() {
        slots = new ArrayList<>();
        cards = new ArrayList<>();
        ports = new ArrayList<>();
        notifications = new ArrayList<>();
    }

    public EPG(String epgName,String fileName) {

        slots = new ArrayList<>();
        cards = new ArrayList<>();
        ports = new ArrayList<>();
        notifications = new ArrayList<>();
        this.cmdOutFile = new File(fileName);
        this.epgName = epgName;
    }

    public ArrayList<EPGSlot> getSlots() {
        return slots;
    }

    public ArrayList<EPGCard> getCards() {
        return cards;
    }

    public ArrayList<EPGPort> getPorts() {
        return ports;
    }

    public ArrayList<EPGNotification> getNotifications() {
        return notifications;
    }

    public void setSlots(ArrayList<EPGSlot> slots) {
        this.slots = slots;
    }

    public EPGMemory getMemory() {
        return memory;
    }

    public void setMemory(EPGMemory memory) {
        this.memory = memory;
    }

    public String getRedundancyStatus() {
        return redundancyStatus;
    }

    public void setRedundancyStatus(String redundancyStatus) {
        this.redundancyStatus = redundancyStatus;
    }
//
//    public int getNoPdpActive() {
//        return noPdpActive;
//    }
//
//    public void setNoPdpActive(int noPdpActive) {
//        this.noPdpActive = noPdpActive;
//    }
//
//    public int getNoEpsActiveBearer() {
//        return noEpsActiveBearer;
//    }
//
//    public void setNoEpsActiveBearer(int noEpsActiveBearer) {
//        this.noEpsActiveBearer = noEpsActiveBearer;
//    }
//
//    public double getUplinkGn() {
//        return uplinkGn;
//    }
//
//    public void setUplinkGn(double uplinkGn) {
//        this.uplinkGn = uplinkGn;
//    }
//
//    public double getUplinkS5() {
//        return uplinkS5;
//    }
//
//    public void setUplinkS5(double uplinkS5) {
//        this.uplinkS5 = uplinkS5;
//    }
//
//    public double getDownlinkGn() {
//        return downlinkGn;
//    }
//
//    public void setDownlinkGn(double downlinkGn) {
//        this.downlinkGn = downlinkGn;
//    }
//
//    public double getDownlinkS5() {
//        return downlinkS5;
//    }
//
//    public void setDownlinkS5(double downlinkS5) {
//        this.downlinkS5 = downlinkS5;
//    }

    public void addSlot(EPGSlot epgSlot) {
        slots.add(epgSlot);
    }

    public void addCard(EPGCard epgCard) {
        cards.add(epgCard);
    }

    public void addCard(ArrayList<EPGCard> card) {
        this.cards.addAll(card);
    }


    public void addPort(EPGPort epgPort) {
        ports.add(epgPort);
    }

    public void addNotification(EPGNotification epgNotification) {
        notifications.add(epgNotification);
    }

    public void addNotification(ArrayList<EPGNotification> epgNotifications) {
        notifications.addAll(epgNotifications);
    }


    public String getEpgIP() {
        return epgIP;
    }

    public void setEpgIP(String epgIP) {
        this.epgIP = epgIP;
    }

    public File getCmdOutFile() {
        return cmdOutFile;
    }

    public void setCmdOutFile(File cmdOutFile) {
        this.cmdOutFile = cmdOutFile;
    }

    public EPGStatistics getEpgStatistics() {
        return epgStatistics;
    }

    public void setEpgStatistics(EPGStatistics epgStatistics) {
        this.epgStatistics = epgStatistics;
    }

    public String getEpgName() {
        return epgName;
    }

    public void setEpgName(String epgName) {
        this.epgName = epgName;
    }

    @Override
    public String toString() {
        return "EPG{" +
                "slots=" + slots +
                ", cards=" + cards +
                ", ports=" + ports +
                ", notifications=" + notifications +
                ", epgStatistics=" + epgStatistics +
                ", epgIP='" + epgIP + '\'' +
                ", cmdOutFile=" + cmdOutFile +
                ", memory=" + memory +
                ", redundancyStatus='" + redundancyStatus + '\'' +
                '}';
    }
}
