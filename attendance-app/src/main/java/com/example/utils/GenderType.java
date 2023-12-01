package utils;

public enum GenderType {
    MALE("male"), FEMALE("female"), OTHER("other");
    private String gender;

    GenderType(String gender) {
        this.gender = gender;
    }
}
