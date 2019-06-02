package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        OutputStream fileOut = null;
        ObjectOutput objectOutput = null;

        InputStream fileIn = null;
        ObjectInput objectInput = null;

        try(Solution solution = new Solution("C:\\Users\\DenG14\\Desktop\\For_Tests\\ForOutput.txt")) {

            solution.writeObject("Line for test 1");

            fileOut = new FileOutputStream("C:\\Users\\DenG14\\Desktop\\For_Tests\\1.txt");
            objectOutput = new ObjectOutputStream(fileOut);
            objectOutput.writeObject(solution);
            objectOutput.close();

            fileIn = new FileInputStream("C:\\Users\\DenG14\\Desktop\\For_Tests\\1.txt");
            objectInput = new ObjectInputStream(fileIn);

            Solution newSolution = (Solution) objectInput.readObject();
            objectInput.close();

            newSolution.writeObject("Line for test 2");

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                objectOutput.close();
                objectInput.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
