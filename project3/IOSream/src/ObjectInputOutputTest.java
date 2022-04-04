import org.junit.Test;

import java.io.*;

public class ObjectInputOutputTest {
    @Test
    public void ObjectInputOutputStreamTest(){

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("abc.dat"));

            oos.writeObject("I love you");
            oos.flush();
            oos.writeObject(new Person("Jason", 24));
            oos.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(oos != null)
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }

    @Test
    public void ObjectInputStreamTest(){

            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream("abc.dat"));

                Object obj = ois.readObject();
                String str = (String)obj;
                System.out.println(str);

                Person p = (Person)ois.readObject();
                System.out.println(p.getAge() + p.getName());


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(ois != null)
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

