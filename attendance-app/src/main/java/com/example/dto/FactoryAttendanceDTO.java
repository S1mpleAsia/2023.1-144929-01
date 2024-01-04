package dto;

import enums.Shift;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Comparator;

public class FactoryAttendanceDTO implements Comparable<FactoryAttendanceDTO>{
    final private SimpleStringProperty name = new SimpleStringProperty();
    final private SimpleObjectProperty<Shift> shift= new SimpleObjectProperty<>();
    final private SimpleDoubleProperty mondayTime = new SimpleDoubleProperty();
    final private SimpleDoubleProperty tuesdayTime = new SimpleDoubleProperty();
    final private SimpleDoubleProperty wednesdayTime = new SimpleDoubleProperty();
    final private SimpleDoubleProperty thursdayTime = new SimpleDoubleProperty();
    final private SimpleDoubleProperty fridayTime = new SimpleDoubleProperty();
    final private Comparator<FactoryAttendanceDTO> workerNameComparator = Comparator.comparing(FactoryAttendanceDTO::getName);

    public FactoryAttendanceDTO(String name, Shift shift, double mondayTime, double tuesdayTime, double wednesdayTime, double thursdayTime, double fridayTime) {
        setName(name);
        setShift(shift);
        setMondayTime(mondayTime);
        setTuesdayTime(tuesdayTime);
        setWednesdayTime(wednesdayTime);
        setThursdayTime(thursdayTime);
        setFridayTime(fridayTime);
    }

    public String getName() {
        return name.get();
    }
    public StringProperty nameProperty() {
        return name;
    }
    public void setName(String name) {
        this.name.set(name);
    }

    public Shift getShift() {
        return shift.get();
    }
    public SimpleObjectProperty<Shift> shiftProperty() {
        return shift;
    }
    public void setShift(Shift shift) {
        this.shift.set(shift);
    }

    public Double getMondayTime() {
        return mondayTime.get();
    }
    public SimpleDoubleProperty mondayTimeProperty() {
        return mondayTime;
    }
    public void setMondayTime(double timeShift) {
        this.mondayTime.set(timeShift);
    }

    public Double getTuesdayTime() {
        return tuesdayTime.get();
    }
    public SimpleDoubleProperty tuesdayTimeProperty() {
        return tuesdayTime;
    }
    public void setTuesdayTime(double timeShift) {
        this.tuesdayTime.set(timeShift);
    }

    public Double getWednesdayTime() {
        return wednesdayTime.get();
    }
    public SimpleDoubleProperty wednesdayTimeProperty() {
        return wednesdayTime;
    }
    public void setWednesdayTime(double timeShift) {
        this.wednesdayTime.set(timeShift);
    }

    public Double getThursdayTime() {
        return thursdayTime.get();
    }
    public SimpleDoubleProperty thursdayTimeProperty() {
        return thursdayTime;
    }
    public void setThursdayTime(double timeShift) {
        this.mondayTime.set(timeShift);
    }

    public Double getFridayTime() {
        return fridayTime.get();
    }
    public SimpleDoubleProperty fridayTimeProperty() {
        return fridayTime;
    }
    public void setFridayTime(double timeShift) {
        this.fridayTime.set(timeShift);
    }
    @Override
    public int compareTo(FactoryAttendanceDTO factoryAttendanceDTO) {
        return workerNameComparator.compare(this, factoryAttendanceDTO);
    }
}
