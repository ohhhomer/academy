package academyProject.comparators;

import academy.Person;

import java.util.Comparator;

public class PersonSurnameAndNameComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2){
        if(p1.getSurname().equals(p2.getSurname()) && (p1.getName().compareTo(p2.getName()))<0) return -1;
        if(p1.getSurname().equals(p2.getSurname()) && (p1.getName().compareTo(p2.getName()))>0) return 1;
        return p1.getSurname().compareTo(p2.getSurname());
    }
}
