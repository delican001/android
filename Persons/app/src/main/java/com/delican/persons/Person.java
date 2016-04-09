package com.delican.persons;

public class Person implements Comparable<Person> {
    Integer ocenka;
    String name;

    @Override
    public int compareTo(Person another) {
        int result = 0;

        if (this.ocenka > another.ocenka) {
            result = 1;
        } else if (this.ocenka < another.ocenka) result = -1;
        else if (this.ocenka.equals(another.ocenka)) result = this.name.compareTo(another.name);
        return result;

    }

    public Person(Integer oc, String n) {
        ocenka = oc;
        name = n;
    }

    public Integer getOcenka() {
        return ocenka;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ocenka.toString() + "  " + name;

    }
}
