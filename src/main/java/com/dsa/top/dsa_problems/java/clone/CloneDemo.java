package com.dsa.top.dsa_problems.java.clone;
class  Address implements Cloneable{
    String area;
    String state;
    public Address(String area, String state){
        this.area=area;
        this.state=state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "area='" + area + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public Address clone() {
        try {
            Address clone = (Address) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

class Employee implements Cloneable{

    public Integer id;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public String name;
    public Address address;

    public Employee(Integer id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public Employee(){

    }

    @Override
    public Employee clone() {
        try {
            Employee employee=(Employee) super.clone();
            employee.address=(Address) address.clone();
            return  employee;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
public class CloneDemo {

    public static void main(String[] args) {
    Address a1=new Address("abc","New York");
    Employee e1=new Employee(1,"msa63",a1);
    Employee e2=e1.clone();
    e1.id=2;
    a1.area="Los Angels";

        System.out.println(e1);
        System.out.println(e2);
    }
}
