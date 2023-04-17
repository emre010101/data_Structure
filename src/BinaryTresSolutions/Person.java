package BinaryTresSolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.age == o.age){
            return 0;
        } else if (this.age > o.age){
            return 1;
        } else {
            return -1;
        }
/*        if (this.name.length() == o.name.length()){
            return 0;
        } else if (this.name.length() > o.name.length()){
            return 1;
        } else {
            return -1;
        }
*/
    }

    public static void main(String[] args) {
        Person k = new Person("Keith", 21);
        Person j = new Person("Dominic", 23);
        Person p = new Person("Joe", 54);
        Person l = new Person("Louise", 34);

        List<Person> people = new ArrayList<>();
        people.add(k);
        people.add(j);
        people.add(p);
        people.add(l);

        System.out.println("These will be printed in the order of insertion");
        for (Person current : people) {
            System.out.println("current = " + current);
        }

        Collections.sort(people);

        System.out.println("These should be printed in sorted order by age");
        for (Person current : people) {
            System.out.println("current = " + current);
        }
    }


}
