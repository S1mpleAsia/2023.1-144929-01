package utils;

public enum EmployeeType {
    HR(1), MANAGER(2), WORKER(3), OFFICER(4);
    private Integer type;

    EmployeeType(Integer type) {
        this.type = type;
    }
}
