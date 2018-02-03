import java.util.ArrayList;

/**
 * Created by Admin on 2/1/2018.
 */
public class EPG {

    ArrayList<EPGSlot> slots;
    ArrayList<EPGCard> cards;
    ArrayList<EPGPort> ports;
    ArrayList<EPGNotification> notifications;

    EPGMemory memory;
    String redundancyStatus;
    int noPdpActive;
    int noEpsActiveBearer;
    double uplinkGn;
    double uplinkS5;
    double downlinkGn;
    double downlinkS5;

    public EPG() {
        slots = new ArrayList<>();
        cards = new ArrayList<>();
        ports = new ArrayList<>();
        notifications = new ArrayList<>();
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


    @Override
    public String toString() {
        return "EPG{" +
                "slots=" + slots +
                ", cards=" + cards +
                ", ports=" + ports +
                ", notifications=" + notifications +
                ", memory=" + memory +
                ", redundancyStatus='" + redundancyStatus + '\'' +
                ", noPdpActive=" + noPdpActive +
                ", noEpsActiveBearer=" + noEpsActiveBearer +
                ", uplinkGn=" + uplinkGn +
                ", uplinkS5=" + uplinkS5 +
                ", downlinkGn=" + downlinkGn +
                ", downlinkS5=" + downlinkS5 +
                '}';
    }
}
