package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Runnable, Serializable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(runner);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = (Thread) in.readObject();
        Thread thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        Solution savedObject = new Solution(26);
        Solution loadedObject = new Solution(12);

        try(OutputStream outputStream = new FileOutputStream("C:\\Users\\DenG14\\Desktop\\For_Tests\\ForOutput.txt", false);
            ObjectOutput objectOutput = new ObjectOutputStream(outputStream);
            InputStream inputStream = new FileInputStream("C:\\Users\\DenG14\\Desktop\\For_Tests\\ForOutput.txt");
            ObjectInput objectInput = new ObjectInputStream(inputStream)) {

            objectOutput.writeObject(savedObject);

            loadedObject = (Solution) objectInput.readObject();

            System.out.println(savedObject);
            System.out.println(loadedObject);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
