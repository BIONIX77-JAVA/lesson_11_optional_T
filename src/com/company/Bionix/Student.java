package com.company.Bionix;

import java.util.Objects;
import java.util.Optional;

public class Student <T,V>{
    public final T name;
    public final V age;
    public V groupNumber;
    public T mailAddress;


    public Student(T name, V age, V groupNumber, T mailAddress) {
        this.name = name;
        this.age = age;
        this.groupNumber = groupNumber;
        this.mailAddress = mailAddress;
    }

    public Student(T name, V age) {
        this.name = name;
        this.age = age;
    }

    public Optional<T> getName() {
        return Optional.ofNullable(name); // only for example
    }

    public V getAge() {
        return age;
    }

    public V getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(V groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Optional<T> getMailAddress() {
        return Optional.ofNullable(mailAddress);
    }

    public void setMailAddress(T mailAddress) {
        this.mailAddress = mailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student<?, ?> student = (Student<?, ?>) o;
        return Objects.equals(getName(), student.getName()) && Objects.equals(getAge(), student.getAge()) && Objects.equals(getGroupNumber(), student.getGroupNumber()) && Objects.equals(getMailAddress(), student.getMailAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getGroupNumber(), getMailAddress());
    }

    @Override
    public String toString() {
        return "NAME - " + name +
                ", AGE  - " + age +
                ", groupNumber - " + groupNumber +
                ", mailAddress  - " + mailAddress;
    }
}