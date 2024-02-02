package SerializationTest;

import java.io.*;

public class ByteStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MyObject obj = new MyObject();
        obj.setName("Test");
        obj.setAge(20);
        FileOutputStream fileOut = new FileOutputStream("file.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();
        obj = null;
        FileInputStream fileIn = new FileInputStream("file.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        obj = (MyObject) in.readObject();
        in.close();
        fileIn.close();
        System.out.println(obj.toString());
    }
    static class MyObject implements Serializable {
        private String name;
        private int age;

        public MyObject() {
        }

        public MyObject(String name, int age) {
            this.name = name;
            this.age = age;
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
            return "MyObject{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
