package academyProject;

import academy.*;

import java.io.File;
import java.util.ArrayList;


public class Project {

    public static void printAllPeople(ArrayList<Person> people) {
        for (Person o : people) {
            System.out.println(o);
            System.out.println("\n");
        }
    }

    public static void printAllCourses(ArrayList<Course> courses) {
        for (Course c : courses) {
            System.out.println(c);
            System.out.println("\n");
        }
    }





    public static void main(String[] args){
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Person> people = new ArrayList<Person>();

        people = FileHandling.loadPeople();
        courses = FileHandling.loadCourses();

        printAllPeople(people);
        //printAllCourses(courses);

        Menu.showMenu(people,courses);

        System.out.println("-----------------------------------------------------\n\n");





        FileHandling.saveDataPeople(people,"People.ser");
        FileHandling.saveDataCourses(courses,"Courses.ser");


    }

}

