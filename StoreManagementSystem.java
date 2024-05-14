package SampleModules;

import java.util.*;

//Class to represent an article
class ArticleDetail
{
 private String name;
 private double sellingPrice;
 private double costPrice;

 public ArticleDetail(String name, double sellingPrice, double costPrice) 
 {
     this.name = name;
     this.sellingPrice = sellingPrice;
     this.costPrice = costPrice;
 }

 public String getName() 
 {
     return name;
 }

 public double getSellingPrice()
 {
     return sellingPrice;
 }

 public double getCostPrice()
 {
     return costPrice;
 }
}

class SalesRecord
{
 private List<ArticleDetail> sales;
 private double totalSales;
 private double totalProfit;

 public SalesRecord()
 {
     sales = new ArrayList<>();
     totalSales = 0;
     totalProfit = 0;
 }

 public void NewSale(ArticleDetail A) 
 {
     sales.add(A);
     totalSales += A.getSellingPrice();
     totalProfit += (A.getCostPrice() - A.getSellingPrice() );
 }

 public void printDailyReport() 
 {
     System.out.println("Daily Sales Report:-");
     System.out.println("Date:-" + new Date()); // Assuming today's date
     System.out.println("Total Sales:- Rs." + totalSales);
     System.out.println("Total Profit:- Rs." + totalProfit);
     System.out.println("Items Sold:-");
     for (ArticleDetail article : sales) {
         System.out.println(article.getName() + " - Rs." + article.getSellingPrice());
     }
 }
 }

public class StoreManagementSystem 
{
 public static void main(String[] args)
 {
     Scanner sc = new Scanner(System.in);
     SalesRecord salesrecord = new SalesRecord();

     while (true) 
     {
         System.out.println("Enter the name of the article:");
         String name = sc.nextLine();
         System.out.println("Enter the selling price of the article:");
         double sellingPrice = sc.nextDouble();
         System.out.println("Enter the cost price of the article:");
         double costPrice = sc.nextDouble();

         ArticleDetail A = new ArticleDetail(name, sellingPrice, costPrice);
         salesrecord.NewSale(A);

         System.out.println("Sale recorded. Do you want to add another sale? (yes/no)");
         String choice = sc.next();
         if (!choice.equalsIgnoreCase("yes"))
         {
             break;
         }
         sc.nextLine(); // Consume newline
     }
     salesrecord.printDailyReport();
     sc.close();
 }
}
