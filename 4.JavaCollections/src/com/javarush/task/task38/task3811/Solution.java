package com.javarush.task.task38.task3811;

/* 
Тикеты
*/

@Ticket (
        priority = Ticket.Priority.HIGH,
        createdBy = "Noodles",
        tags = {"bug","fix asap"}
)
public class Solution {
    public static void main(String[] args) {
        Class solutionClass = Solution.class;

        if (solutionClass.isAnnotationPresent(Ticket.class)) {
            Ticket ticket = (Ticket) solutionClass.getAnnotation(Ticket.class);
            System.out.println(ticket);
        }
    }
}
