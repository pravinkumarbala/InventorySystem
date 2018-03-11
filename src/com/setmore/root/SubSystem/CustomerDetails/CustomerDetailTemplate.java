package com.setmore.root.SubSystem.CustomerDetails;

public class CustomerDetailTemplate {
    public int customerID;
    public String customerName;
    public String customerAddress;
    public long customerMobileNumber;
    public String customerEmailAddress;

    public CustomerDetailTemplate(int customerID, String customerName, String customerAddress, long customerMobileNumber, String customerEmailAddress) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerMobileNumber = customerMobileNumber;
        this.customerEmailAddress = customerEmailAddress;
    }
}
