/**
 * Created by Admin on 2/1/2018.
 */
public class EPGCard {
    String serviceInterface;
    String function;
    String startTime;

    public String getServiceInterface() {
        return serviceInterface;
    }

    public void setServiceInterface(String serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "EPGCard{" +
                "serviceInterface='" + serviceInterface + '\'' +
                ", function='" + function + '\'' +
                ", startTime='" + startTime + '\'' +
                '}';
    }
}
