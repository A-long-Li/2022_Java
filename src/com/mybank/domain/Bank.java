package com.mybank.domain;

public class Bank {
    static Customer [] customers;
    static int numbersOfCustomers;
    static {
        customers = new Customer[10];
        numbersOfCustomers = 0;
    }
    public static void addCustomer(String firstName, String lastName){
        Customer cus = new Customer(firstName,lastName);
        try {
            customers[numbersOfCustomers++] = cus;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
    public static int getNumbersOfCustomers(){
        return numbersOfCustomers;
    }
    public static Customer getCustomer(int id){
        try {
            return customers[id];
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        return null;
    }
}
