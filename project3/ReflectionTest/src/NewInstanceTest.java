import org.junit.Test;

import java.util.Random;

public class NewInstanceTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        /*
        newInstance():调用此方法，创建类的运行对象，内部调用了运行时类的空参构造器

        要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供空参构造器
        2.空参构造器的访问权限得够，正常是public。

        在javabean中要求提供一个空参的构造器
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行类时，默认调用super()时，保证父类有次构造器
         */
        Person obj = clazz.newInstance();
        System.out.println(obj);



    }
    @Test
    public void test2(){
        //反射的动态性
        int num = new Random().nextInt(3); // 0,1,2
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "Person";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
    创建一个指定类的对象
    classPath:指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();

    }
}
