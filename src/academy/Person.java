package academy;

import java.io.Serializable;
import java.util.Calendar;


public abstract class Person implements Serializable {
    private String name, surname, pesel, gender;
    private int age;
    private boolean checkPesel;

    public Person(String name, String surname, String pesel, String gender) {
        super();
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        checkPesel = isCheckPesel(pesel);
        if (checkPesel) {
            this.pesel = pesel;
            this.age = calculateAge();
        }
    }

    private boolean isCheckPesel(String pesel) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int yearFromPesel = Integer.parseInt(pesel.substring(0, 2));
        int monthFromPesel = Integer.parseInt(pesel.substring(2, 4));
        if (monthFromPesel - 20 > 0 && monthFromPesel - 20 <= 12) {
            yearFromPesel += 2000;
        } else yearFromPesel += 1900;
        int dayFromPesel = Integer.parseInt(pesel.substring(4, 6));
        if (monthFromPesel - 20 > 12 || monthFromPesel < 1 || dayFromPesel > 31 || dayFromPesel < 1 || yearFromPesel >= currentYear || pesel.length() != 11)
            return false;
        else return true;
    }

    private int calculateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        int yearFromPesel = Integer.parseInt(getPesel().substring(0, 2));
        int monthFromPesel = Integer.parseInt(getPesel().substring(2, 4));
        if (monthFromPesel > 12) {
            monthFromPesel -= 20;
            yearFromPesel += 2000;
        } else {
            yearFromPesel += 1900;
        }
        int dayFromPesel = Integer.parseInt(getPesel().substring(4, 6));

        int years = currentYear - yearFromPesel;
        if (currentMonth <= monthFromPesel && currentDay < dayFromPesel)
            years--;

        return years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        if (isCheckPesel(pesel)) {
            this.pesel = pesel;
            checkPesel = true;
        } else System.out.println("Niepoprawny PESEL!!!");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }


    public boolean getCheckPesel() {
        return checkPesel;
    }


    @Override
    public String toString() {
        if (checkPesel)
            return name + " " + surname + "\nPESEL: " + pesel + "\n" + gender + "\nWiek: " + age;
        else return "Nie mo¿na wypisaæ danych tej osoby. Zosta³y one b³êdnie wprowadzone!!!";
    }

}
