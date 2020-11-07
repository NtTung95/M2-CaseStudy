package Store.Employee;

import Entities.Person;

public class Employee extends Person {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Nhân viên {"
                + super.toString() +
                "Lương: " + salary +
                "}" ;
    }
}
