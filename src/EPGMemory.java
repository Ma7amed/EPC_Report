/**
 * Created by Admin on 2/1/2018.
 */
public class EPGMemory {

    int totalMemory;
    int usedMemory;
    int freeMemory;

    public int getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(int totalMemory) {
        this.totalMemory = totalMemory;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(int usedMemory) {
        this.usedMemory = usedMemory;
    }

    public int getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(int freeMemory) {
        this.freeMemory = freeMemory;
    }

    @Override
    public String toString() {
        return "EPGMemory{" +
                "totalMemory=" + totalMemory +
                ", usedMemory=" + usedMemory +
                ", freeMemory=" + freeMemory +
                '}';
    }
}
