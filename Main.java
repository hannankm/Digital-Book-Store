package com.mycompany.finalbook;
import java.io.*;
import java.util.*;

public class Main{
    
     /*
     * 
     * -------------------------------------------
     * Display Program Intro Method
     * -------------------------------------------- 
     * 
     */

public static void intro(){
    System.out.println("||====================================================||");
    System.out.println("||============== B O O K     W O R L D ===============||");
    System.out.println("||====================================================||");
	 
    System.out.println("Welcome to Book World");
    System.out.println("I'm your digital assistant, and I'm here to help you navigate through our digital book shop!");
}

     /*
     * 
     * -------------------------------------------
     * MAIN Method
     * -------------------------------------------- 
     * 
     */
public static void main(String [] args) throws IOException, ClassNotFoundException{
intro();
User user;
int role;
Scanner input= new Scanner(System.in);
Scanner input1= new Scanner(System.in);
do{
    System.out.println("Are you an admin or a client? ");
    System.out.println("1. Admin ");
    System.out.println("2. Client");
    System.out.println("0. Exit");
    System.out.println("Enter your choice: ");
    role =input.nextInt();
    switch(role){
        case 1:
        user=new Admin();
        user.greetUser();
         System.out.println("Admin Login");
         System.out.println("Enter your username: ");
         String uname=input1.nextLine();
         System.out.println("Enter your password: ");
         String pword=input1.nextLine();

         
         Admin.adminLogin(uname,pword);
           
            break;
        case 2: 
        user=new Client();
        user.greetUser();
        Client newClient= new Client();
        newClient.clientMenu();
        break;
       
        case 0: 
        System.exit(role);
        break;

        default:
        System.out.println("Invalid Button, try again!: ");
            
    }

} while(role!=0);

input.close();
input1.close();

}


}

