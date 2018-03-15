package com.setmore.root.SubSystem.CustomerDetails;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerInformation {

    public static Scanner readInput = new Scanner(System.in);

    public static List<CustomerDetailTemplate> CustomerContactList = new ArrayList<CustomerDetailTemplate>();

    public void addCustomerDetail(){
        try{
            System.out.print("Enter the Customer Id : ");
            int customerID = readInput.nextInt();
            System.out.print("Enter the Customer Name : ");
            String customerName = readInput.next();
            System.out.print("Enter the Customer Address : ");
            String customerAddress = readInput.next();
            System.out.print("Enter the Customer Mobile Number : ");
            long customerMobile = readInput.nextLong();
            System.out.print("Enter the Customer Email Address : ");
            String customerEmailAddress = readInput.next();
            CustomerContactList.add(new CustomerDetailTemplate(customerID,customerName,customerAddress,customerMobile,customerEmailAddress));
            System.out.println("Customer Information Is Added");
        }catch (InputMismatchException e){
            System.out.println("Sorry you have entered wrong information");

        }
    }

    public void removeCustomerDetail(){
        System.out.print("Enter the Customer name :");
        String customerName = readInput.next();
        for (int i = 0 ; i < CustomerContactList.size(); i ++){
            if (CustomerContactList.get(i).customerName.equalsIgnoreCase(customerName))
                CustomerContactList.remove(CustomerContactList.get(i));
        }
        System.out.println(customerName +" is Deleted from List");
    }

    public void displayCustomerDetail(){
        System.out.println("ID\tName\tAddress\t\tMobileNumber\tEmailAddress");
        for (CustomerDetailTemplate cdt : CustomerContactList){
            System.out.println(cdt.customerID + "\t" + cdt.customerName + "\t" + cdt.customerAddress + "\t\t" + cdt.customerMobileNumber + "\t\t" + cdt.customerEmailAddress);
        }
    }
}