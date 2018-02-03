/**
 * Created by Admin on 2/1/2018.
 */
public class EPGSlot {

    String name;
    String adminStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    @Override
    public String toString() {
        return "EPGSlot{" +
                "name='" + name + '\'' +
                ", adminStatus='" + adminStatus + '\'' +
                '}';
    }
}
