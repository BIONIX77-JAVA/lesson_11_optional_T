package com.company.Bionix;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        System.out.println("..........................EXAMPLE (empty)...................");
        Optional<Student> empty = Optional
                .empty();
        System.out.println(empty.isEmpty());
        System.out.println(empty.isPresent());

        System.out.println("........................ofNullable().... of().....isPresent()- (true if is not null)...................");
        Optional<Student> notPresent = Optional
                .ofNullable(null);
        Optional<Student> student = Optional
                .of(new Student("John", 23));
        System.out.println("Here we have null, \" null of .isPresent\" is : " + notPresent.isPresent());
        System.out.println("new Student() isPresent is : " + student.isPresent() + "\n");


        System.out.println("........................orElse ()..first not null.................");
        Optional<Student> optionalStudent1 = Optional
                .of(new Student<String, Integer>("Mark", 23, 3, "mark@gmail.com"));
        Student orElseStudent1 = optionalStudent1
                .orElse(new Student("Jenifer", 24, 3, "genifer@gmail.com"));
        System.out.println("Everything ok, optional student is not empty : " + orElseStudent1.name + " , " + orElseStudent1.mailAddress + "\n");

        System.out.println("........................orElse ()....first is null....(.orElseGet())...........");
        Optional<Student> optionalStudent2 = Optional.ofNullable(null);
        Student orElseNullStudent = optionalStudent2
                .orElse(new Student("Linda", 22, 3, "linda@gmail.com"));
        System.out.println("Everything ok, optional student is not empty : " + orElseNullStudent.name + " , " + orElseNullStudent.mailAddress);
        Student orElseGetStudent = optionalStudent2
                .orElseGet(() -> {
                    return new Student("Molly", 22, 3, "molly@gmail.com");
                });
        System.out.println(orElseGetStudent.name);

        System.out.println("........................orElseThrow()...........");
//        Student orElseThrowStudent = optionalStudent2
//                .orElseThrow(()-> new IllegalStateException("Student could not be null value"));
//        System.out.println(orElseThrowStudent);

        System.out.println("........................ifPresent()., ifPresentOrElse().........");
        Optional<Student> newStudent = Optional.of(new Student("Jim", 22, 2, null));
        newStudent
                .ifPresent(System.out::println);
        newStudent
                .ifPresentOrElse(System.out::println, () -> System.out.println("You see this because students value is null"));

        System.out.println("........................get() and NoSuchElementException........");
        Optional<Student> thisOptionalStudent = Optional.ofNullable(new Student(null, 21, 1, null));
        if (thisOptionalStudent.get().getName().isPresent()){
            System.out.println(thisOptionalStudent.get());
        }else{
            throw new NoSuchElementException("Name value cannot be null");
        }
    }
}