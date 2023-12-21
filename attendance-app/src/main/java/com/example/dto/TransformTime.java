package dto;

public class TransformTime {
    private Double workTime;
    private Double checkIn;
    private Double checkOut;

    public TransformTime() {
    }

    public TransformTime(Double workTime, Double checkIn, Double checkOut) {
        this.workTime = workTime;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Double getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Double workTime) {
        this.workTime = workTime;
    }

    public Double getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Double checkIn) {
        this.checkIn = checkIn;
    }

    public Double getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Double checkOut) {
        this.checkOut = checkOut;
    }
}
