package dto;

public class ParticularInfoDTO {
    private String date;
    private String checkTime;

    public ParticularInfoDTO() {
    }

    public ParticularInfoDTO(String date, String checkTime) {
        this.date = date;
        this.checkTime = checkTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }
}
