package academy;

import java.io.Serializable;

public class Course implements Serializable {
    private String courseName;
    private int ETC;
    private String subject;

    public Course(String courseName, int ETC, String subject) {
        super();
        this.courseName = courseName;
        this.ETC = ETC;
        this.subject = subject;
    }

    public static void printCourse(Course k) {
        System.out.println(k.getCourseName() + "\t" + k.getETC());
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getETC() {
        return ETC;
    }

    public void setETC(int eTC) {
        ETC = eTC;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    @Override
    public String toString() {
        return courseName + " - " + ETC + " na kierunku " + subject;
    }

}
