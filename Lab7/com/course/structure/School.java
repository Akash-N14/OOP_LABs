package com.course.structure;

import java.util.Scanner;

public class School extends Building {
    int numOfClassRooms;
    String gradeLev;
    Scanner sc = new Scanner(System.in);
    public School() {
        numOfClassRooms = -1;
        gradeLev = "Default";
    }

    public void assign() {
        super.assign();
        System.out.print("Enter number of class rooms ");
        numOfClassRooms = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter grade level ");
        gradeLev = sc.next();
    }

    public void display() {
        super.display();
        System.out.println("Number of classrooms: " + numOfClassRooms + "\nGrade Level: " + gradeLev);
    }
}
