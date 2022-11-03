package com.mycompany.finalbook;
import java.io.*;

public class Order implements Serializable {
    String firstName, lastName, email; 
    int ISBN, quantity;
    double totalBill;

    public Order(String firstName, String lastName, String email, int quantity, double totalBill, int ISBN) {
        this.firstName= firstName;
        this.lastName=lastName;
        this.ISBN=ISBN;
        this.email= email;
        this.quantity=quantity;
        this.totalBill= totalBill;

    }
    
    public Order(){
        this.firstName= null;
        this.lastName=null;
        this.ISBN=0;
        this.email= null;
        this.quantity=0;
        this.totalBill= 0.0;
    
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

   
    
@Override
    public String toString() {
        return ISBN + "\t" + firstName + " "+ lastName+"\t"
        + email +"\t" + quantity + "\t" + totalBill;
    } 
    
       
    
}
