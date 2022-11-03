package com.mycompany.finalbook;

import java.io.*;
import java.util.*;



public class Client extends User implements Serializable{


    
    ArrayList<Order> orders= new ArrayList<>();
    ArrayList<Book> books= new ArrayList<>();
    ListIterator<Book> li=null;
    ListIterator<Order> lo=null;
 
    File file= new File("books.txt");
    File fileOrder= new File("orders.txt");
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Scanner input1= new Scanner(System.in);
    Scanner input= new Scanner(System.in);
  
    // Argument Constructor
    public Client(String firstName, String lastName, String email){
    super(firstName,lastName, email);

  }
  
    // No arg Client constructor
    public Client(){
        super();
       
    }
    public void greetUser(){
      System.out.println("Hello Client");
  }
  
  
    /*
     * 
     * -------------------------------------------
     * Client Menu Method
     * -------------------------------------------- 
     * 
     */

  public void clientMenu() throws ClassNotFoundException, IOException{
      int  choice;
        do{
    System.out.println("------Menu------");
    System.out.println("1. View Book List");
    System.out.println("2. Order book");
    System.out.println("3. Search for book");
    System.out.println("0. Exit");
     choice=input.nextInt();
     switch(choice){
      case 1:
        try {
          viewBooks();
        } catch (ClassNotFoundException e) {
         //e.getMessage();
         System.out.println(e.getMessage());
        } catch (IOException e) {
          
          System.out.println(e.getMessage());
          //e.printStackTrace();
        }
          break;
      case 2: 
         orderBook();
         break;
      case 3: 
          searchBook();
        
          break; 

      case 0: 
          System.out.println("Exited client menu ");
          break;  
           
      default:
      System.out.println("Invalid Button, try again! ");

          }
        } while(choice!=0);

 
  }

     /*
     * 
     * -------------------------------------------
     * View Books Method
     * -------------------------------------------- 
     * 
     */

 public void viewBooks() throws  IOException, ClassNotFoundException{
     if(file.isFile()){
           ois= new ObjectInputStream(new FileInputStream(file));
           books=(ArrayList<Book>)ois.readObject();
           ois.close();
    
       li=books.listIterator();
       bookHeader();
       while(li.hasNext()){
        System.out.println(li.next());
       }

             
       System.out.println("-------------------------------------------------------");
        }
       else{
         System.out.println("File is not found!");
        }
 }
     /*
     * 
     * -------------------------------------------
     * Order Book Method
     * -------------------------------------------- 
     * 
     */
    public void orderBook() throws IOException, ClassNotFoundException{
   
        int buy=0;

        do{
          viewBooks();
          if(file.isFile()){
            ois= new ObjectInputStream(new FileInputStream(file));
            books=(ArrayList<Book>)ois.readObject();
            ois.close();
    
         boolean found=false;
        System.out.println("Enter the ISBN of the book you wish to order: ");
        int ISBN= input.nextInt();
        li=books.listIterator();
       System.out.println("---------------------------------------------------------");
       while(li.hasNext()){
           Book b=(Book)li.next();
           if(b.getIsbn()==ISBN && b.getQty()>0){
            found=true;
            System.out.println("Enter your first name: ");
            String fname=input1.nextLine();
            System.out.println("Enter your last name: ");
            String lname=input1.nextLine();
            System.out.println("Enter your email: ");
            String emaill=input1.nextLine();
            int purchase_qty;
            double bill;
            do{

              System.out.println("Enter the quantity: ");
              purchase_qty= input.nextInt();
              if(purchase_qty>b.getQty())
               System.out.println("Oops we don't have that much in stock please decrease your order quantity!");
              
            }while(purchase_qty>b.getQty());
            b.setQty(b.getQty()-purchase_qty);
            li.set(new Book(b.getIsbn(), b.getTitle(), b.getAuthor(), b.getQty(), b.getPrice()));
            oos= new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(books);
            oos.close();

           bill=purchase_qty*b.getPrice();

         System.out.println("-------------------------------------");
         System.out.println("||          ORDER SUMMARY          ||");
         System.out.println("-------------------------------------");
         System.out.println("Customer Name: "+fname+" "+lname);
         System.out.println("Email: "+ emaill);
         System.out.println("Book Title: "+ b.getTitle()+ "\nBook Author: "+ b.getAuthor()+"\nQuantity: "+ purchase_qty);
         System.out.println("Total bill: "+ bill+" birr");

         System.out.println("Would you like to purchase another book? ");
         System.out.println("1. Yes 2. No");
         buy= input.nextInt();

         orders.add(new Order(fname,lname, emaill, purchase_qty, bill, ISBN));
      
         oos= new ObjectOutputStream(new FileOutputStream(fileOrder));
         oos.writeObject(orders);
         
         oos.close();
           
            
           }
       }
       if(!found){
           System.out.println("Book is not currently available, make sure to enter the right key and try again");
           break;
       }
           System.out.println("----------------------------------------------------------");
           
             }else{
         System.out.println("Book File is not found, please try again later. And contact us by email at bookworld@gmail.com if such error persists.");
             }

        }while(buy==1); 
        
    }

     /*
     * 
     * -------------------------------------------
     * Search Book Method
     * -------------------------------------------- 
     * 
     */

    public void searchBook() throws  IOException, ClassNotFoundException{
      if(file.isFile()){
    ois= new ObjectInputStream(new FileInputStream(file));
    books=(ArrayList<Book>)ois.readObject();
    ois.close();

      boolean found=false;
    System.out.println("Enter the title of the book you want to search: ");
    String title= input1.nextLine();
    li=books.listIterator();
    System.out.println("---------------------------------------------------------------");
    while(li.hasNext()){
       Book b=(Book)li.next();
       if((b.getTitle().toLowerCase()).equals(title.toLowerCase())){
        System.out.println(b);
        found=true;
           }
        }
      if(!found){
        System.out.println("Book not found, make sure to enter the right key and try again");
          }
      System.out.println("----------------------------------------------------------------");
      
        }else{
        System.out.println("File is not found!");
            }
}

     /* 
     * 
     * -------------------------------------------
     * Display Book Header Method
     * -------------------------------------------- 
     * 
     */
public void bookHeader(){
  System.out.println("=======================================================");
  System.out.println("ISBN\tTitle\t\tAuthor\t\tQty\tPrice");
  System.out.println("=======================================================");
}


}
