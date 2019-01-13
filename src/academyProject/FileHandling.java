package academyProject;

import academy.Course;
import academy.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandling {

    public static ArrayList<Person> loadPeople(){
        ArrayList<Person> people = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Courses.ser"));

            ois = new ObjectInputStream(new FileInputStream("People.ser"));
            people = (ArrayList<Person>) ois.readObject();

            ois.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return people;
    }

    public static ArrayList<Course> loadCourses(){
        ArrayList<Course> courses = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Courses.ser"));

            ois = new ObjectInputStream(new FileInputStream("Courses.ser"));
            courses = (ArrayList<Course>) ois.readObject();

            ois.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return courses;
    }

    public static void saveDataPeople(ArrayList<Person> people, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(people);
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveDataCourses(ArrayList<Course> courses, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(courses);
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
