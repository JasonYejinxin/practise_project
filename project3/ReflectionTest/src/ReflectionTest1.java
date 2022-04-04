import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionTest1 {


    @Test
    public void test1() throws Exception {
        Class clazz = Person.class;
        //1.通过反射创建Person的对象
        Constructor cons = clazz.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("Tom",12);
        Person p = (Person)obj;
        System.out.println(p.toString());

        //2.通过反射，调用对象指定的属性、方法
        Field age = clazz.getDeclaredField("age");
        age.set(p,11);
        System.out.println(p.toString());

        System.out.println("******************************");

        //3.调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("******************************");

        //通过反射，可以调用Person类私有结构，比如私有构造器、方法、属性
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        System.out.println("******************************");

        //修改私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Jason");
        System.out.println(p1);

        //调用私有方法
        Method show1 = clazz.getDeclaredMethod("show1");
        show1.setAccessible(true);
        String show1Content = (String) show1.invoke(p1);
        System.out.println(show1Content);

    }

    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        //此时的我呢见默认在当前的module下，eclipse在当前工程下
        //读取方式一
        FileInputStream fis = new FileInputStream("src//jdbc1.properties");
        pros.load(fis);


        //读取方式二：使用classLoad
        //配置文件识别为：当前module下
//        ClassLoader classLoader = ReflectionTest1.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
//        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + " password = " + password);

    }

}
