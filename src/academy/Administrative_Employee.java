package academy;

public class Administrative_Employee extends Employee {
    private double overtime;

    public Administrative_Employee(String name, String surname, String pesel, String gender,
                                   String position, int seniority, double salary, double overtime) {
        super(name, surname, pesel, gender, position, seniority, salary);
        this.overtime = overtime;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    @Override
    public String toString() {
        if (this.getCheckPesel())
            return "Pracownik administracyjny: " + super.toString() + "\nNadgodziny: "
                    + overtime;
        else return super.toString();
    }

}
