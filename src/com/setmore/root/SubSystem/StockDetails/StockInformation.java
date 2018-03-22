package com.setmore.root.SubSystem.StockDetails;

import java.util.*;

public class StockInformation{

    public static Scanner readInput = new Scanner(System.in);

    public static Map<String, Set<StockDetailsTemplate>> StockMapDetail = new HashMap<String, Set<StockDetailsTemplate>>();
    public static Set<StockDetailsTemplate> StockSetDetail = new HashSet<StockDetailsTemplate>();

    public static Set updateSetStockList(int stockId, String stockName, int stockPrice, int stockUnit, String stockPurchaseDate){
        StockSetDetail.add(new StockDetailsTemplate(stockId, stockName, stockPrice, stockUnit, stockPurchaseDate));
        return StockSetDetail;
    }

    public static Map updateMapStockDatabase(String stockName, Set stockDetail){
        StockMapDetail.put(stockName, StockSetDetail);
        return StockMapDetail;
    }

    public void addStock(){
        try{
            System.out.print("Enter the Stock Id : ");
            int stockId = readInput.nextInt();
            System.out.print("Enter the Stock Name : ");
            String stockName = readInput.next();
            System.out.print("Enter the Stock Price : ");
            int stockPrice = readInput.nextInt();
            System.out.print("Enter the Stock Unit Size : ");
            int stockUnit = readInput.nextInt();
            System.out.print("Enter the Date of Purchased [dd/MM/yyyy] : ");
            String stockPurchaseDate = readInput.next();
            updateMapStockDatabase(stockName, updateSetStockList(stockId, stockName, stockPrice, stockUnit, stockPurchaseDate));
        }catch (InputMismatchException e){
            System.out.println("Sorry you have entered wrong information");
        }
        System.out.println("Stock is Added");
    }

    public static void deleteStock(String stockName){
        for (Map.Entry map : StockMapDetail.entrySet())
            if (map.getKey().equals(stockName)) {
                StockMapDetail.remove(map.getKey());
                StockSetDetail.remove(map.getValue());
            }
    }

    public static void displayStock(){
        Iterator<Map.Entry<String, Set<StockDetailsTemplate>>> iterator = StockMapDetail.entrySet().iterator();
        System.out.println("Id\tName\t\tPrice\tUnit\tPurchaseDate");
        while (iterator.hasNext()){
            Map.Entry<String, Set<StockDetailsTemplate>> entry = iterator.next();
            Iterator<StockDetailsTemplate> iterator1 = entry.getValue().iterator();
            while (iterator1.hasNext()) {
                StockDetailsTemplate sdt = iterator1.next();
                if (entry.getKey().equals(sdt.stockName))
                    System.out.println(sdt.stockId + "\t" + sdt.stockName + "\t\t" + sdt.stockPrice + "\t\t" + sdt.stockUnit + "\t\t" + sdt.stockPurchaseDate);
            }
        }
    }

    public static void updateStock(){
        int choice = 0;
        displayStock();
        System.out.print("Enter the Stock Name : ");
        String stockName = readInput.next();
        for (Map.Entry<String, Set<StockDetailsTemplate>> updateDetail : StockMapDetail.entrySet()){
            String existStockName = updateDetail.getKey();
            if (existStockName.equalsIgnoreCase(stockName)){
                for (StockDetailsTemplate sdt: updateDetail.getValue()){
                    do {
                        System.out.println("1. Stock Id 2. Stock Price 3. Stock Unit 4. Stock Purchase Date 5 Exit");
                        System.out.print("Choose the option to update : ");
                        choice = readInput.nextInt();
                        switch (choice) {
                            case 1: System.out.print("Enter the stock ID :");
                                    int id = readInput.nextInt();
                                    sdt.stockId = id;
                                    break;
                            case 2: System.out.print("Enter the Stock Price : ");
                                    int price = readInput.nextInt();
                                    sdt.stockPrice = price;
                                    break;
                            case 3: System.out.print("Enter the Stock Unit : ");
                                    int unit = readInput.nextInt();
                                    sdt.stockUnit = unit;
                                    break;
                            case 4: System.out.print("Enter the Stock Purchase Date : ");
                                    String purDate = readInput.next();
                                    sdt.stockPurchaseDate = purDate;
                                    break;
                            case 5: System.out.println("Exiting from the update stock");
                                    break;
                            default: System.out.println("Sorry!!! Enter the correct option");
                                    break;
                        }
                    }while (choice != 5);
                }
            }
        }
    }
}