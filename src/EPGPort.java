/**
 * Created by Admin on 2/2/2018.
 */
public class EPGPort {

    private String name;
    private String type;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "EPGPort{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
