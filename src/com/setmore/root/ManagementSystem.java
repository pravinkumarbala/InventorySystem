package com.setmore.root;

import com.setmore.root.SubSystem.CustomerDetails.CustomerInformation;
import com.setmore.root.SubSystem.StockDetails.StockInformation;
import com.setmore.root.SubSystem.StockPurchaseDetails.PurchaseInformation;

import java.util.Scanner;

public class ManagementSystem {

    public static Scanner readInput = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("Inventory Management System");
            System.out.println("===========================");
            System.out.println("1. Customer Details 2. Stock Details 3. Purchase Stock 4. Exit");
            System.out.print("Select the tab : ");
            choice = readInput.nextInt();
            switch (choice){
                case 1: System.out.println("Welcome to Customer Details");
                        System.out.println("---------------------------");
                        int custChoice = 0;
                        do {
                            System.out.println("1. Add Customer Info\t 2. Delete Customer Info\t 3. Display Customer Info\t 4. Exit");
                            System.out.print("Select the tab : ");
                            custChoice = readInput.nextInt();
                            CustomerInformation ci = new CustomerInformation();
                            switch (custChoice){
                                case 1: System.out.println("Adding Customer Information");
                                        ci.addCustomerDetail();
                                        System.out.println("**************************************");
                                        break;
                                case 2: System.out.println("Deleting Customer Information");
                                        ci.removeCustomerDetail();
                                        System.out.println("**************************************");
                                        break;
                                case 3: System.out.println("Customer Information");
                                        System.out.println("--------------------");
                                        ci.displayCustomerDetail();
                                        System.out.println("**************************************");
                                        break;
                                case 4: System.out.println("Exit from Customer Information Tab");
                                        System.out.println("**************************************");
                                        break;
                                default: System.out.println("Sorry!!! Enter the correct option");
                                        break;
                            }
                        }while (custChoice != 4);
                        break;
                case 2: System.out.println("Welcome to Stock Details");
                        System.out.println("------------------------");
                        StockInformation si = new StockInformation();
                        int stockChoice = 0;
                        do{
                            System.out.println("1. Add Stock\t 2. Delete Stock\t 3. Display Stock\t 4. Update Stock\t 5. Exit");
                            System.out.print("Select the tab : ");
                            stockChoice = readInput.nextInt();
                            switch (stockChoice){
                                case 1: System.out.println("Adding Stock Information");
                                        si.addStock();
                                        System.out.println("**************************************");
                                        break;
                                case 2: System.out.println("Deleting Stock Information");
                                        System.out.print("Enter the stock name : ");
                                        String stockName = readInput.next();
                                        si.deleteStock(stockName);
                                        System.out.println("Stock is deleted");
                                        System.out.println("**************************************");
                                        break;
                                case 3: System.out.println("Stock Information");
                                        System.out.println("-----------------");
                                        si.displayStock();
                                        System.out.println("**************************************");
                                        break;
                                case 4: System.out.println("Update Stock Information");
                                        System.out.println("------------------------");
                                        si.updateStock();
                                        break;
                                case 5:System.out.println("Exit from Stock Information Tab");
                                        System.out.println("**************************************");
                                        break;
                                default: System.out.println("Sorry!!! Enter the correct option");
                                        break;
                            }
                        }while (stockChoice != 5);
                        break;
                case 3: System.out.println("Welcome to Purchase Details");
                        System.out.println("---------------------------");
                        int purchaseChoice = 0;
                        do {
                            System.out.println("1. Purchase Stock 2. Stock Sale History 3. Customer Purchase History 4. Exit");
                            System.out.print("Select the tab : ");
                            purchaseChoice = readInput.nextInt();
                            PurchaseInformation pi = new PurchaseInformation();
                            switch (purchaseChoice){
                                case 1: System.out.println("Purchase Stock");
                                        StockInformation psi = new StockInformation();
                                        psi.displayStock();
                                        pi.buyStock();
                                        System.out.println("***********************************");
                                        break;
                                case 2: System.out.println("Stock Sale History");
                                        System.out.println("------------------");
                                        pi.stockSalesHistory();
                                        break;
                                case 3: System.out.println("Customer Purchase History");
                                        System.out.println("-------------------------");
                                        pi.customerPurchaseHistory();
                                        break;
                                case 4: System.out.println("Exit from Purchase Information Tab");
                                        System.out.println("***********************************");
                                        break;
                                default: System.out.println("Sorry!!! Enter the correct option");
                                        break;
                            }
                        }while (purchaseChoice != 4);
                        break;
                case 4: System.out.println("Exit from Inventory Management System");
                        System.out.println("**************************************");
                        break;
                default: System.out.println("Sorry!!! Enter the correct option");
                        break;
            }
        }while (choice != 4);
    }
}