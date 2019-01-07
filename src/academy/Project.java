package academy;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Project {

    private static ArrayList array;
    private static String filename;

    public static void addPeople(ArrayList list) {
        list.add(new Student("Anna", "Nowak", "01321082190", "Kobieta", "543765", false, "Informatyka"));
        list.add(new Student("Robert", "Smith", "97022582190", "Mê¿czyzna", "582741", true, "Fizyka"));
        list.add(new Student("Adam", "Górny", "95122582190", "Mê¿czyzna", "83219", false, "Matematyka"));
        list.add(new Research_And_Educational_Worker("Jan", "Kowalski", "67010912378", "Mê¿czyzna",
                "Profesor zwyczajny", 24, 10000.5, 234));
        list.add(new Research_And_Educational_Worker("Patrycja", "Lesiak", "72031917275", "Kobieta",
                "Wyk³adowca", 12, 6000.5, 123));
        list.add(new Research_And_Educational_Worker("Karol", "Dolny", "84090902649", "Mê¿czyzna",
                "Asystent", 6, 6000.5, 432));
        list.add(new Administrative_Employee("Urszula", "Wróblewska", "66081470281", "Kobieta", "Starszy Specjalista", 20, 4500, 5));
        list.add(new Administrative_Employee("Barbara", "Wróblewska", "76111427401", "Kobieta", "Specjalista", 15, 3500, 2));
        list.add(new Administrative_Employee("Dominik", "Filipowski", "83020381493", "Mê¿czyzna", "Referent", 4, 3000, 0));

    }

    public static void addCourses(ArrayList courses) {
        courses.add(new Course("Analiza matematyczna", 5, "Informatyka"));
        courses.add(new Course("Analiza matematyczna", 5, "Fizyka"));
        courses.add(new Course("Analiza matematyczna", 5, "Matematyka"));
        courses.add(new Course("Algebra", 5, "Informatyka"));
        courses.add(new Course("Algebra", 5, "Fizyka"));
        courses.add(new Course("Algebra", 5, "Matematyka"));
        courses.add(new Course("Fizyka ogólna", 3, "Informatyka"));
        courses.add(new Course("Fizyka cia³a sta³ego", 3, "Fizyka"));
        courses.add(new Course("Podstawy elektrodynamiki", 3, "Fizyka"));
        courses.add(new Course("Programowanie strukturalne i obiektowe", 7, "Informatyka"));
        courses.add(new Course("Organizacja systemów komputerowych", 4, "Informatyka"));
        courses.add(new Course("Logika dla Informatyków", 4, "Informatyka"));
        courses.add(new Course("Funkcje zespolone", 4, "Matematyka"));
    }


    public static void assignCourses(ArrayList<Person> people, ArrayList<Course> courses) {
        for (Person o : people) {
            if (o instanceof Student && (((Student) o).getCourses()).size() == 0 ){
                for (Course c : courses) {
                    if (((Student) o).getSubject().equals(c.getSubject())) {
                        ((Student) o).addCourse(c);
                    }
                }
            }
        }
    }

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

    public static void printByClass(ArrayList<Person> people, String attribute) {
        for (Person o : people) {
            if (o.getClass().toString().replace("class academy.", "").toLowerCase().equals(attribute)) {
                System.out.println(o);
                System.out.println("\n");
            }

        }
    }

    public static void findPerson(ArrayList<Person> people, Object attribute) {
        for (Person o : people) {

            if (attribute instanceof String) {
                attribute = ((String) attribute).toLowerCase();
                if (o.getName().toLowerCase().equals(attribute) || o.getSurname().toLowerCase().equals(attribute) || o.getPesel().equals(attribute) || o.getGender().toLowerCase().equals(attribute)) {
                    System.out.println(o);
                    System.out.println("\n");
                } else {
                    if (o instanceof Student) {
                        if (((Student) o).getSubject().equals(attribute)) {
                            System.out.println(o);
                            System.out.println("\n");
                        }
                    }
                    if (o instanceof Employee) {
                        if (((Employee) o).getPosition().equals(attribute)) {
                            System.out.println(o);
                            System.out.println("\n");
                        }
                    }
                }
            } else if (attribute instanceof Double) {
                if (o instanceof Employee) {
                    if (((Employee) o).getSalary() == (Double) attribute) {
                        System.out.println(o);
                        System.out.println("\n");
                    }
                    if (o instanceof Administrative_Employee)
                        if (((Administrative_Employee) o).getOvertime() == (Double) attribute) {
                            System.out.println(o);
                            System.out.println("\n");
                        }
                }
            } else {
                if (o instanceof Employee) {
                    if (((Employee) o).getSeniority() == (int) attribute) {
                        System.out.println(o);
                        System.out.println("\n");
                    }
                }
            }

        }

    }

    public static void findCourse(ArrayList<Course> courses, Object attribute) {
        for (Course c : courses) {
            if (attribute instanceof String) {
                ((String) attribute).toLowerCase();
                if (c.getCourseName().toLowerCase().equals(attribute) || c.getSubject().toLowerCase().equals(attribute)) {
                    System.out.println(c);
                    System.out.println("\n");
                }
            } else {
                if (c.getETC() == (int) attribute) {
                    System.out.println(c);
                    System.out.println("\n");
                }
            }
        }
    }


    public static void deletePersonByPesel(ArrayList<Person> people, String pesel) {
        for (Person o : people) {
            if (o.getPesel().equals(pesel)) {
                people.remove(o);
                break;
            }
        }
        saveData(people,"People.ser");
    }

    public static void saveData(ArrayList array, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Integer size = array.size();
            oos.writeObject(size);
            for (Object o : array) {
                oos.writeObject(o);
            }
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readData(ArrayList<Course> courses, ArrayList<Person> people) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Courses.ser"));
            Integer counter = (Integer) ois.readObject();

            for(int i=0;i<counter;i++){
                courses.add((Course)ois.readObject());
            }
            ois = new ObjectInputStream(new FileInputStream("People.ser"));
            counter = (Integer) ois.readObject();

            for(int i=0;i<counter;i++){
                people.add((Person) ois.readObject());
            }

            ois.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void addPerson(ArrayList<Person> people){
        Scanner scan = new Scanner(System.in);
        String name, surname, pesel, gender;
        System.out.println("Podaj imiê: ");
        name = scan.nextLine();
        System.out.println("Podaj nazwisko: ");
        surname = scan.nextLine();
        System.out.println("Podaj numer PESEL: ");
        pesel = scan.nextLine();
        System.out.println("Podaj p³eæ: ");
        gender = scan.nextLine();

        System.out.println("Dodawana osoba jest:\n[1] - studentem\n[2] - pracownikiem badawczo-dydaktycznym\n[3] - pracownikiem administracyjnym\n");
        int choice = 0;
        choice = scan.nextInt();
        switch (choice){
            case 1:{
                boolean erasmus;
                String IndexNumber, subject;
                System.out.println("Czy erasmus?: ");
                erasmus = scan.nextBoolean();
                System.out.println("Podaj numer albumu: ");
                IndexNumber = scan.next();
                System.out.println("Podaj kierunek: ");
                subject = scan.next();

                people.add(new Student(name, surname, pesel, gender, IndexNumber, erasmus, subject));
                break;
            }

            case 2:{
                int academicAchievementPoints, seniority;
                String position;
                double salary;

                System.out.println("Podaj stanowisko: ");
                position = scan.next();
                System.out.println("Podaj staz pracy: ");
                seniority = scan.nextInt();
                System.out.println("Podaj pensjê: ");
                salary = scan.nextDouble();
                System.out.println("Podaj punktacjê z dorobku naukowego: ");
                academicAchievementPoints = scan.nextInt();



                people.add(new Research_And_Educational_Worker(name, surname, pesel, gender,
                        position, seniority, salary, academicAchievementPoints));
                break;
            }
            case 3: {
                int seniority;
                String position;
                double salary, overtime;

                System.out.println("Podaj stanowisko: ");
                position = scan.next();
                System.out.println("Podaj staz pracy: ");
                seniority = scan.nextInt();
                System.out.println("Podaj pensjê: ");
                salary = scan.nextDouble();
                System.out.println("Podaj liczbê nadgodzin: ");
                overtime = scan.nextDouble();

                people.add(new Administrative_Employee(name, surname, pesel, gender,
                        position, seniority, salary, overtime));
                break;
            }
        }
        saveData(people,"People.ser");
    }



    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<Person> people = new ArrayList<Person>();

        //addCourses(courses);    // dodawanie kursów
        //addPeople(people);      // dodawanie osób
        //assignCourses(people, courses);     // przypiswyanie studentom kursów domyœlnych (tych, na które uczêszczaj¹ z racji wybranego kierunku studiów)

        readData(courses,people);

        printAllPeople(people);

        System.out.println("-----------------------------------------------------\n\n");

        int choice = 0;
        System.out.println("Co chcesz zrobiæ?\n[1] - dodaæ do bazy now¹ osobê\n[2] - usun¹æ osobê z bazy\n[3] - wyœwietliæ posortowan¹ listê osób");
        choice = scan.nextInt();
        switch(choice){
            case 1:{
                addPerson(people);
                assignCourses(people,courses);
                break;
            }
            case 2:{
                String temp = new String();
                System.out.println("Podaj numer pesel osoby, któr¹ chcesz usun¹æ z bazy: ");
                temp = scan.next();
                deletePersonByPesel(people,temp);
                break;
            }

            case 3:{
                System.out.println("\nSortuj wed³ug:\n[1] - Nazwiska\n[2] - Nazwiska i imienia\n[3] - Nazwiska i wieku");
                choice = scan.nextInt();
                switch (choice){
                    case 1:{
                        PersonCompareSurname compSurname = new PersonCompareSurname();
                        people.sort(compSurname);
                        break;
                    }
                    case 2:{
                        PersonCompareSurnameAndName compSurnameAndName = new PersonCompareSurnameAndName();
                        people.sort(compSurnameAndName);
                        break;
                    }
                    case 3:{
                        PersonCompareSurnameAndAge compSurnameAndAge = new PersonCompareSurnameAndAge();
                        people.sort(compSurnameAndAge);
                        break;
                    }
                    default: break;
                }

               // printAllPeople(people);
                break;
            }
            default:{
                break;
            }
        }

        printAllPeople(people);

        saveData(people,"People.ser");
        saveData(courses,"Courses.ser");

        scan.close();
    }

}

class PersonCompareSurname implements Comparator<Person> {
    public int compare(Person p1, Person p2){
        return p1.getSurname().compareTo(p2.getSurname());
    }
}

class PersonCompareSurnameAndName implements Comparator<Person>{
    public int compare(Person p1, Person p2){
        if(!p1.getSurname().equals(p2.getSurname()))
            return p1.getSurname().compareTo(p2.getSurname());
        if(p1.getSurname().equals(p2.getSurname()) && (p1.getName().compareTo(p2.getName()))<0) return -1;
        if(p1.getSurname().equals(p2.getSurname()) && (p1.getName().compareTo(p2.getName()))>0) return 1;
        return 0;
    }
}

class PersonCompareSurnameAndAge implements Comparator<Person>{
    public int compare(Person p1, Person p2){
        if(!p1.getSurname().equals(p2.getSurname()))
            return p1.getSurname().compareTo(p2.getSurname());
        if(p1.getSurname().equals(p2.getSurname()) && (p1.getAge()<p2.getAge())) return -1;
        if(p1.getSurname().equals(p2.getSurname()) && (p1.getAge()>p2.getAge())) return 1;
        return 0;
    }
}
