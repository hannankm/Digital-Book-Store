package com.mycompany.finalbook;
public class Book implements java.io.Serializable
{

   private String title,author;
   private double price;
   private int qty, isbn;
   

   public Book(int isbn,String title, String author, int qty, double price)
   {
      this.isbn = isbn;
      this.title = title;
      this.price = price;
      this.author=author;
      this.qty = qty;
   }
   public Book() {
}

public int getIsbn()
   {
      return  isbn;
   }
   public String getAuthor()
   {
      return  author;
   }
   
   public String getTitle()
   {
      return  title;
   }

   public int getQty()
   {
      return  qty;
   }

   public double getPrice()
   {
      return  price;
   }

   public void setTitle(String title)
   {   this.title = title; }

   public void setAuthor(String author)
   {   this.author= author; }

   public void setPrice(double price)
   {   this.price = price; }

public void setIsbn(int isbn)
   {   this.isbn=isbn;}

   public void setQty(int qty)
   {   this.qty = qty; }

   public void addQty(int qty)
   {   this.qty += qty;  }

      @Override
   public String toString() {
      return isbn + "\t"+ title+ "\t" + author+ "\t"+ qty+ "\t"+ price; 
   }

   
 
   

   
} // end of class 
    

