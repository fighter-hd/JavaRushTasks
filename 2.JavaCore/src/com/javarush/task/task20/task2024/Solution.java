package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.node = 10;

        solution.edges.add(new Solution());
        solution.edges.add(new Solution());

        String fileName = "C:\\Users\\DenG14\\Desktop\\For_Tests\\ForOutput.txt";

        try(OutputStream outputStream = new FileOutputStream(fileName, false);
            InputStream inputStream = new FileInputStream(fileName);
            ObjectOutput objectOutput = new ObjectOutputStream(outputStream);
            ObjectInput objectInput = new ObjectInputStream(inputStream)) {

            objectOutput.writeObject(solution);

            Solution newSolution = (Solution) objectInput.readObject();

//            System.out.println(solution.node);
//            System.out.println(newSolution.node);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
