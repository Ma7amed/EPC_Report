/**
 * Created by Admin on 2/2/2018.
 */
public class EPGNotification {

    private String faultId;
    private String alarmSeverity;
    private String specificProblem;
    private String managedObject;
    private String additionalText;
    private String eventTime;

    public String getFaultId() {
        return faultId;
    }

    public void setFaultId(String faultId) {
        this.faultId = faultId;
    }

    public String getAlarmSeverity() {
        return alarmSeverity;
    }

    public void setAlarmSeverity(String alarmSeverity) {
        this.alarmSeverity = alarmSeverity;
    }

    public String getSpecificProblem() {
        return specificProblem;
    }

    public void setSpecificProblem(String specificProblem) {
        this.specificProblem = specificProblem;
    }

    public String getManagedObject() {
        return managedObject;
    }

    public void setManagedObject(String managedObject) {
        this.managedObject = managedObject;
    }

    public String getAdditionalText() {
        return additionalText;
    }

    public void setAdditionalText(String additionalText) {
        this.additionalText = additionalText;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return "EPGNotification{" +
                "faultId='" + faultId + '\'' +
                ", alarmSeverity='" + alarmSeverity + '\'' +
                ", specificProblem='" + specificProblem + '\'' +
                ", managedObject='" + managedObject + '\'' +
                ", additionalText='" + additionalText + '\'' +
                ", eventTime='" + eventTime + '\'' +
                '}';
    }
}
