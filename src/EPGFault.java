/**
 * Created by Admin on 2/1/2018.
 */
public class EPGFault {

    String faultID;
    String alarmSeverity;
    String specificProblem;
    String managedObject;
    String additionalText;
    String eventTime;

    public String getFaultID() {
        return faultID;
    }

    public void setFaultID(String faultID) {
        this.faultID = faultID;
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
}
