package model;

public class Department {
    private Integer id;
    private Integer managerId;  // map to manager_id
    private String departmentName; // map to department_name

    public Department() {
    }

    public Department(Integer id, Integer managerId, String departmentName) {
        this.id = id;
        this.managerId = managerId;
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
