package academyProject.comparators;

import academy.Person;

import java.util.Comparator;

public class PersonSurnameAndAgeComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2){
        if(p1.getSurname().equals(p2.getSurname()) && (p1.getAge()<p2.getAge())) return -1;
        if(p1.getSurname().equals(p2.getSurname()) && (p1.getAge()>p2.getAge())) return 1;
        return p1.getSurname().compareTo(p2.getSurname());
    }
}
