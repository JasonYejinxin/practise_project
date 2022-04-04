
public class Person {


    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name){
        this.name = name;
    }

    public void show(){

        System.out.println("我是一个人");
    }
    private void show1(){
        System.out.println("私下里我还是假面骑士");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public static String showReality(){
        return ("我其实真实身份是外星人");
    }
}
