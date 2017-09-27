package Pr1_JDBC.db.model;

public class Salary {
    private Long salary_id;
    private Long amount;

    public Salary(Long salary_id, Long amount) {
        this.salary_id = salary_id;
        this.amount = amount;
    }

    public Long getSalary_id() {
        return salary_id;
    }

    public void setSalary_id(Long salary_id) {
        this.salary_id = salary_id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salary_id=" + salary_id +
                ", amount=" + amount +
                '}';
    }
}
