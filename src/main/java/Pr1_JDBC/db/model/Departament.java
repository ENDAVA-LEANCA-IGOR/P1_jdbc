package Pr1_JDBC.db.model;

public class Departament {
    private Long departament_id;
    private String departament_name;

    public Departament(Long departament_id, String departament_name) {
        this.departament_id = departament_id;
        this.departament_name = departament_name;
    }

    public Long getDepartament_id() {
        return departament_id;
    }

    public void setDepartament_id(Long departament_id) {
        this.departament_id = departament_id;
    }

    public String getDepartament_name() {
        return departament_name;
    }

    public void setDepartament_name(String departament_name) {
        this.departament_name = departament_name;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "departament_id=" + departament_id +
                ", departament_name='" + departament_name + '\'' +
                '}';
    }
}
