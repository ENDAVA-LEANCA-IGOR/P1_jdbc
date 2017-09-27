package Pr1_JDBC.db.model;

public class Departament {

    private Long departamant_id;
    private String departament_name;

    public Departament(Long departamant_id, String departament_name) {
        this.departamant_id = departamant_id;
        this.departament_name = departament_name;
    }

    public Long getDepartamant_id() {
        return departamant_id;
    }

    public void setDepartamant_id(Long departamant_id) {
        this.departamant_id = departamant_id;
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
                "departamant_id=" + departamant_id +
                ", departament_name='" + departament_name + '\'' +
                '}';
    }
}
