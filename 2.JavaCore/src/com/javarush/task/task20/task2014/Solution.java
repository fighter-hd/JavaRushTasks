package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
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

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
