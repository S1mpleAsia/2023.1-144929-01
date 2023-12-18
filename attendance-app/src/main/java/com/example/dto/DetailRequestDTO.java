package dto;

public class DetailRequestDTO {

    private String createDay;

    private String requestDay;

    private String timeIn;

    private String timeOut;

    private String reason;

    private Integer id;

    public DetailRequestDTO(){

    }

    public DetailRequestDTO(String createDay, String requestDay, String timeIn, String timeOut, String reason, Integer id) {
        this.createDay = createDay;
        this.requestDay = requestDay;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.reason = reason;
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }

    public String getRequestDay() {
        return requestDay;
    }

    public void setRequestDay(String requestDay) {
        this.requestDay = requestDay;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }
}
