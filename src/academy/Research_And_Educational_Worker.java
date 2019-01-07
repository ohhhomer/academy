package academy;

public class Research_And_Educational_Worker extends Employee {
    private int academicAchievementPoints;

    public Research_And_Educational_Worker(String name, String surname, String pesel, String gender,
                                           String position, int seniority, double salary, int academicAchievementPoints) {
        super(name, surname, pesel, gender, position, seniority, salary);
        this.academicAchievementPoints = academicAchievementPoints;
    }

    public int getacAdemicAchievementPoints() {
        return academicAchievementPoints;
    }

    public void setAcademicAchievementPoints(int academicAchievementPoints) {
        this.academicAchievementPoints = academicAchievementPoints;
    }

    @Override
    public String toString() {
        if (getCheckPesel())
            return "Pracownik badawczo dydaktyczny " + super.toString() + "\nPunktacja z dorobku naukowego: "
                    + academicAchievementPoints;
        else return super.toString();
    }

}
