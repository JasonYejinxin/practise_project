import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest3 {
    //调用运行时指定的结构：属性、方法、构造器
    //不理想，对指定属性要求太高
//    @Test
//    public void test1() throws Exception {
//        Class<Person> clazz = Person.class;
//
//        //创建运行时类的对象
//        Person p = clazz.newInstance();
//        //获取指定的属性:要求运行时类声明为public
//        //通常不采用该方式
//        Field age = clazz.getField("age");
//        /*
//        set():
//        参数一：指明设置哪个对象的属性
//        参数二：将此属性设置为多少
//         */
//        age.set(p,12);
//        /*
//        get():
//        参数一：获取哪个对象的当前属性值
//         */
//        int pAge = (int) age.get(p);
//        System.out.println(pAge);
//    }


    /*
    如何操作运行时类中指定的属性-----需要掌握
     */
    @Test
    public void test2() throws Exception{
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person p = clazz.newInstance();

        //1.getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //2.保证当前类是可访问的
        name.setAccessible(true);

        //3.获取、设置指定对象的操作
        name.set(p,"Tom");
        String pName = (String) name.get(p);
        System.out.println(pName);
    }

    @Test
    public void test3() throws Exception{
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        /*
        1.获取指定的某个方法，getDeclaredMethod:
        参数一：指明获取的方法的名称
        参数二：指明方法的形参列表
         */
        Method show = clazz.getDeclaredMethod("show");

        /*
        2.保证当前方法可访问
         */
        show.setAccessible(true);

        /*
        调用方法的invoke()，去执行
        参数一：方法调用者
        参数二：给方法赋值的实参
        invoke()方法的返回值，即为对应类中调用方法的返回值
         */
        String str = (String) show.invoke(p);
        System.out.println(str);

    }

    @Test
    public void test4() throws Exception{
        Class<Person> clazz = Person.class;
//        Person p = clazz.newInstance();

        Method showReality = clazz.getDeclaredMethod("showReality");
        showReality.setAccessible(true);
        String str = (String) showReality.invoke(Person.class);
        System.out.println(str);

    }

    //调用运行时类指定的构造器
    @Test
    public void test5()throws Exception{
        Class<Person> clazz = Person.class;

        /*
        2.获取指定的构造器,getDeclaredConstructor
        参数：指明构造器的形参列表
         */
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器可访问
        constructor.setAccessible(true);

        //3.调用此构造器，创建运行时类的对象
        Person per = (Person) constructor.newInstance("Tom");

        System.out.println(per);
    }

}
