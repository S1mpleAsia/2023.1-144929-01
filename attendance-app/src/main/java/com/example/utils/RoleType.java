package utils;

public enum RoleType {
    HR("HR"), Manager("Manager"), Worker("Worker"), Officer("Officer");

    private String type;

    RoleType(String type) {
        this.type = type;
    }
}
