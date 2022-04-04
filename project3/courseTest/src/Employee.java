import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


public class Employee {

    //name,age,birthday
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof Employee){
//            Employee employee = (Employee) o;
//            return this.name.compareTo(employee.name);
//        }
//        else{
//            throw new RuntimeException("类型不匹配");
//        }
//    }


}





class TreeSetTest{
    public static void main(String[] args) {
        Employee test1 = new Employee("Tom",18,new MyDate(1997,9,21));
        Employee test2 = new Employee("Jack",18,new MyDate(1998,3,3));
        Employee test3 = new Employee("Eric",18,new MyDate(1999,5,23));

        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                if(o instanceof Employee && t1 instanceof Employee){
                    Employee e1 = (Employee) o;
                    Employee e2 = (Employee) t1;

                    MyDate d1 = e1.getBirthday();
                    MyDate d2 = e2.getBirthday();

                    int minusYear = d1.getYear() - d2.getYear();
                    if(minusYear != 0){
                        return minusYear;
                    }
                    int minusMonth = d1.getMonth() - d2.getMonth();
                    if(minusMonth != 0){
                        return minusMonth;
                    }
                    return d1.getDay()-d2.getDay();
                }
                else{
                    throw new RuntimeException("传入类型不一致");
                }
            }
        });

        set.add(test1);
        set.add(test2);
        set.add(test3);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
