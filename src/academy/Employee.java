package academy;

public abstract class Employee extends Person {
    private String position;
    private int seniority;
    private double salary;

    public Employee(String name, String surname, String pesel, String gender, String position,
                    int seniority, double salary) {
        super(name, surname, pesel, gender);
        this.position = position;
        this.seniority = seniority;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        if (this.getCheckPesel())
            return super.toString() + "\nStanowisko: " + position + "\nStaz pracy: " + seniority + " lat\nPensja: " + salary
                    + " PLN";
        else return super.toString();
    }

}