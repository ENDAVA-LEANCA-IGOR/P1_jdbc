package Pr1_JDBC.db.model;

public class Manager {
    private Long manager_id;
    private Long departament_id;
    private String f_name;
    private String l_name;

    public Manager(Long manager_id, Long departament_id, String f_name, String l_name) {

        this.manager_id = manager_id;
        this.departament_id = departament_id;
        this.f_name = f_name;
        this.l_name = l_name;
    }

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public Long getDepartament_id() {
        return departament_id;
    }

    public void setDepartament_id(Long departament_id) {
        this.departament_id = departament_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manager_id=" + manager_id +
                ", departament_id=" + departament_id +
                ", f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                '}';
    }
}
