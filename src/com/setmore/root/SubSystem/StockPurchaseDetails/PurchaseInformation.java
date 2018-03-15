package com.setmore.root.SubSystem.StockPurchaseDetails;

import com.setmore.root.SubSystem.CustomerDetails.CustomerInformation;
import com.setmore.root.SubSystem.StockDetails.StockDetailsTemplate;
import com.setmore.root.SubSystem.StockDetails.StockInformation;

import java.util.*;

public class PurchaseInformation {

    public static Map<HashMap<LinkedList<PurchaseDetailTemplate>, String>, String> PurchasedCustomerDetail = new HashMap<>();
    public static HashMap<LinkedList<PurchaseDetailTemplate>, String> PurchaseStockDetail = new HashMap<>();
    public static LinkedList<PurchaseDetailTemplate> PurchaseDetail = new LinkedList<>();

    public static Scanner readInput = new Scanner(System.in);

    public void buyStock(){
        System.out.print("Enter the stock name : ");
        String purchaseStockName = readInput.next();
        System.out.print("Enter the number of units : ");
        int purchaseStockUnit = readInput.nextInt();
        Iterator<Map.Entry<String, Set<StockDetailsTemplate>>> iterator = StockInformation.StockMapDetail.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Set<StockDetailsTemplate>> entry = iterator.next();
            if (entry.getKey().equals(purchaseStockName)){
                Iterator<StockDetailsTemplate> iterator1 = entry.getValue().iterator();
                while (iterator1.hasNext()){
                    StockDetailsTemplate sdt = iterator1.next();
                    if (sdt.stockUnit == 0 && purchaseStockUnit < sdt.stockUnit){
                        System.out.println("Sorry, The stock is not sufficient");
                    } else {
                        if (sdt.stockName.equalsIgnoreCase(purchaseStockName)){
                            int purchaseStockAmount = sdt.stockPrice * purchaseStockUnit;
                            System.out.print("Enter the customer Name : ");
                            String purchaseCustomerName = readInput.next();
                            for (int i = 0; i < CustomerInformation.CustomerContactList.size() ; i ++){
                                if (CustomerInformation.CustomerContactList.get(i).customerName.equalsIgnoreCase(purchaseCustomerName)){
                                    int purchaseStockID = sdt.stockId;
                                    String purchaseCustomerEmailAddress = CustomerInformation.CustomerContactList.get(i).customerEmailAddress;
                                    PurchaseDetail.add(new PurchaseDetailTemplate(purchaseStockID, purchaseStockName, purchaseStockAmount, purchaseCustomerName, purchaseCustomerEmailAddress, purchaseStockUnit));
                                    PurchaseStockDetail.put(PurchaseDetail, purchaseStockName);
                                    PurchasedCustomerDetail.put(PurchaseStockDetail, purchaseCustomerName);
                                    System.out.println(purchaseStockName + " " + purchaseStockUnit + " unit is purchase by " +  purchaseCustomerName + " for " + purchaseStockAmount);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void stockSalesHistory(){
        Iterator<Map.Entry<LinkedList<PurchaseDetailTemplate>, String>> iterator = PurchaseStockDetail.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<LinkedList<PurchaseDetailTemplate>, String> entry = iterator.next();
            Iterator<PurchaseDetailTemplate> saleStock = entry.getKey().iterator();
            while (saleStock.hasNext()){
                PurchaseDetailTemplate psd = saleStock.next();
                String stockName = psd.purchaseStockName;
                if (entry.getValue().equals(stockName)) {
                    System.out.println("Stock Name : " + stockName);
                    System.out.println("StockID\tSalesAmount\tCustomerName\tUnits");
                    System.out.println(psd.purchaseId + "\t\t" + psd.puchaseAmount + "\t\t\t" + psd.purchaseCustomerName + "\t\t\t" + psd.purchaseStockUnit);
                }
            }
        }
    }

    public void customerPurchaseHistory(){
        System.out.print("Enter the Customer Name : ");
        String customerName = readInput.next();
        System.out.println("ID\tStockName\tPurchaseAmount\tEmailAddress");
        Iterator<Map.Entry<HashMap<LinkedList<PurchaseDetailTemplate>, String>, String>> CustomerPurchaseTransaction = PurchasedCustomerDetail.entrySet().iterator();
        while (CustomerPurchaseTransaction.hasNext()){
            Map.Entry<HashMap<LinkedList<PurchaseDetailTemplate>, String>, String> CustomerPurchase = CustomerPurchaseTransaction.next();
            if (CustomerPurchase.getValue().equals(customerName)){
                Iterator<Map.Entry<LinkedList<PurchaseDetailTemplate>, String>> StockPurchaseTransaction =  CustomerPurchase.getKey().entrySet().iterator();
                while (StockPurchaseTransaction.hasNext()) {
                    Map.Entry<LinkedList<PurchaseDetailTemplate>, String> StockPurchase = StockPurchaseTransaction.next();
                    Iterator<PurchaseDetailTemplate> Transaction = StockPurchase.getKey().iterator();
                    while (Transaction.hasNext()){
                        PurchaseDetailTemplate pdt = Transaction.next();
                        if (StockPurchase.getValue().equalsIgnoreCase(pdt.purchaseStockName))
                            if (pdt.purchaseCustomerName.equals(customerName))
                                System.out.println(pdt.purchaseId + "\t" + pdt.purchaseStockName + "\t\t" + pdt.puchaseAmount + "\t" + pdt.purchaseCustomerEmailAdress);
                    }
                }
            }
        }
    }
}