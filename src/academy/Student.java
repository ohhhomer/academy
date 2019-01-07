package academy;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    boolean erasmus;
    private String IndexNumber;
    private String subject;
    private List<Course> courses = new ArrayList<>();
    private int term;

    public Student(String name, String surname, String pesel, String gender, String IndexNumber,
                   boolean erasmus, String subject) {
        super(name, surname, pesel, gender);
        this.IndexNumber = IndexNumber;
        this.erasmus = erasmus;
        this.subject = subject;
    }

    public void wypiszKursy() {
        for (Course k : courses) {
            Course.printCourse(k);
        }
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourse(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public String getIndexNumber() {
        return IndexNumber;
    }

    public void setIndexNumber(String IndexNumber) {
        this.IndexNumber = IndexNumber;
    }

    public boolean getErasmus() {
        return erasmus;
    }

    public void setErasmus(boolean erasmus) {
        this.erasmus = erasmus;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        if (this.getCheckPesel())
            return "Student " + super.toString() + "\nNumer indeksu: " + IndexNumber +
                    "\nCzy jest cz³onkiem programu Erasums: " + erasmus + "\nKierunek studiów: " + getSubject() + "\nUczêszcza na kursy:\n\t" + getCourses();
        else return super.toString();
    }

}
