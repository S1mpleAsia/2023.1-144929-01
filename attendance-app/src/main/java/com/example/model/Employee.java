package model;

public class Employee {
    private Integer id;
    private String employeeId; // map to employee_id
    private String name;
    private String gender;
    private Integer age;
    private Integer departmentId; // map to department_id
    private String type;

    public Employee() {
    }

    public Employee(Integer id, String employeeId, String name, String gender, Integer age, Integer departmentId, String type) {
        this.id = id;
        this.employeeId = employeeId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.departmentId = departmentId;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
