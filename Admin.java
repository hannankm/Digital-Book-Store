package com.mycompany.finalbook;
import java.util.*;
import java.io.*;


public class Admin extends User{
    

   ArrayList<Book> books= new ArrayList<Book>();
   ArrayList<Order> orders= new ArrayList<Order>();


   ListIterator<Book> li= null;
   ListIterator<Order> lo=null;
   File file= new File("books.txt");
   File fileOrder= new File("orders.txt");
   ObjectOutputStream oos;
   ObjectInputStream ois;


    // Scanner objects to input from user
   Scanner input= new Scanner(System.in);
   Scanner input1= new Scanner(System.in);

   
    //Argument constructor
    public Admin(String fname, String lname, String email){
    super(fname,lname,email);  
    }
    //No arg constructor
    public Admin(){
        super();
    }
    public void greetUser(){
        System.out.println("Hello Admin");
    }
    

    /*
     * 
     * -------------------------------------------
     * Admin Menu Method
     * -------------------------------------------- 
     * 
     */
    
    public void adminMenu() throws IOException, FileNotFoundException, ClassNotFoundException{
     int choice;
        do{
    System.out.println("Admin Menu");
    System.out.println("1. Add new book");
    System.out.println("2. View all books");
    System.out.println("3. Update books");
    System.out.println("4. Search book");
    System.out.println("5. Delete book");
    System.out.println("6. Add to stock");
    System.out.println("7. View Order History");
    System.out.println("0. Exit");
    System.out.println("Enter your choice: ");
   choice=input.nextInt();
   switch(choice){
    case 1:
        addBook();
        break;
    case 2: 
        viewBooks();
        break;
    case 3: 
        updateBook();
        break;  
    case 4: 
        searchBook();
        break;
    
    case 5: 
        deleteBook();
        break;   
        
    case 6: 
      addStock();
        break;
    
    case 7: 
        viewOrderHistory();
        break;
     
    case 0: 
    System.out.println("Exited admin menu ");
        break; 
                
    
    default:
    System.out.println("Invalid button ");

        
   
}

        } while(choice!=0);

    }
    
    
     /*
     * 
     * -------------------------------------------
     * Admin Login Method
     * -------------------------------------------- 
     * 
     */

    public static void adminLogin(String username, String password) throws IOException, ClassNotFoundException{
     
     String tempUsername= username;
     String tempPassword= password;
     if("Admin".equals(tempUsername)&& "admin123".equals(tempPassword)){
     System.out.println("Welcome back Admin, you are sucessfully logged in!");
     Admin a1=new Admin("Book", "World", "bookworld@gmail.com");
     a1.adminMenu();
    }else{
         System.out.println("Invalid username or password :(");      
             }

    }
     /*
     * 
     * -------------------------------------------
     * Add Book Method
     * -------------------------------------------- 
     * 
     */

    public void addBook() throws IOException{
        FileOutputStream fs=new FileOutputStream(file);
        System.out.println("How many books do you want to add? ");
        
        int n= input.nextInt();
        for(int i=0; i<n; i++){
           System.out.println("Enter book ISBN: ");
           int ISBN=input.nextInt();
           System.out.println("Enter book title: "); 
           String title =input1.nextLine();
           System.out.println("Enter book author: ");
           String author=input1.nextLine();
           System.out.println("Enter book quantity: ");
           int qty= input.nextInt();
           System.out.println("Enter book price: ");
           double price= input.nextDouble();
            
            books.add(new Book(ISBN,title, author, qty, price));
            
       }
       
      oos= new ObjectOutputStream(fs);
      oos.writeObject(books);
      oos.close();
        
    }
    
     /*
     * 
     * -------------------------------------------
     * View Book Method
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
       System.out.println("----------------------------------------------------------");
       }
       else{
         System.out.println("File is not found!");
       }
       
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
        System.out.println("Enter the ISBN of the book you want to search: ");
        int isbn= input.nextInt();
        li=books.listIterator();
       System.out.println("------------------------------------------------------------");
       while(li.hasNext()){
           Book b=(Book)li.next();
           if(b.getIsbn()==isbn){
             System.out.println(b);
             found=true;
           }
       }
       if(!found){
           System.out.println("Book not found, make sure to enter the right key and try again");
       }
           System.out.println("--------------------------------------------------");
           
             }else{
         System.out.println("File is not found!");
       }
    }

    /*
     * 
     * -------------------------------------------
     * Delete Book Method
     * -------------------------------------------- 
     * 
     */

    public void deleteBook() throws IOException, ClassNotFoundException{
        if(file.isFile()){
           ois= new ObjectInputStream(new FileInputStream(file));
           books=(ArrayList<Book>)ois.readObject();
           ois.close();
   
        boolean found=false;
        viewBooks();
        System.out.println("Enter the ISBN of the book you want to delete: ");
        int isbn= input.nextInt();
        li=books.listIterator();
       System.out.println("-------------------------------------------------------------------");
       while(li.hasNext()){
           Book b=(Book)li.next();
           if(b.getIsbn()==isbn){
             System.out.println(b+" ");
             li.remove();
             found=true;
           }
       }
       if(found){
           oos= new ObjectOutputStream(new FileOutputStream(file));
           oos.writeObject(books);
           oos.close();
           System.out.println("Selected Book has been deleted from the list");
       }
       else{
           System.out.println("Book not found, make sure to enter the right key and try again");
       }
           System.out.println("----------------------------------------------------------");
           
             }else{
         System.out.println("File is not found!");
       }
    }

    /*
     * 
     * -------------------------------------------
     * Update Book Method
     * -------------------------------------------- 
     * 
    */

    public void updateBook() throws IOException, ClassNotFoundException{
        if(file.isFile()){
           ois= new ObjectInputStream(new FileInputStream(file));
           books=(ArrayList<Book>)ois.readObject();
           ois.close();
   
        boolean found=false;
        System.out.println("Enter the ISBN of the book you want to update: ");
        int isbn1= input.nextInt();
        li=books.listIterator();
       System.out.println("------------------------------------------------------------");
       while(li.hasNext()){
           Book b=(Book)li.next();
           if(b.getIsbn()==isbn1){
            System.out.println(b);
             System.out.print("Enter new Book ISBN: ");
             int isbn= input.nextInt();
             System.out.print("Enter new Book Title: ");
             String title= input1.nextLine();
             System.out.print("Enter new Book Author: ");
             String author=input1.nextLine();
             System.out.println("Enter book quantity: ");
            int qty= input.nextInt();
             System.out.println("Enter book price: ");
            double price= input.nextDouble();
            
             li.set(new Book(isbn, title, author, qty, price));
             found=true;
           }
       }
       if(found){
           
           oos= new ObjectOutputStream(new FileOutputStream(file));
           oos.writeObject(books);
           oos.close();
           System.out.println("Book has been updated!");
       }
       else{
           System.out.println("Book not found, make sure to enter the right key and try again");
       }
           System.out.println("----------------------------------------------------------");
           
             }else{
         System.out.println("File is not found!");
       }
        
    }

   
    
    /*
     * 
     * -------------------------------------------
     * Add Stock Method
     * -------------------------------------------- 
     * 
     */

    public void addStock() throws ClassNotFoundException, IOException{
        if(file.isFile()){
            ois= new ObjectInputStream(new FileInputStream(file));
            books=(ArrayList<Book>)ois.readObject();
            ois.close();
    
         boolean found=false;
         System.out.println("Enter the ISBN of the book you want to add stock: ");
         int isbn1= input.nextInt();
         li=books.listIterator();
        System.out.println("-------------------------------------------------------");
        while(li.hasNext()){
            Book b=(Book)li.next();
            if(b.getIsbn()==isbn1){
             System.out.println(b);
              System.out.print("Enter how many of this book do you want to add: ");
              int addQty= input.nextInt();
                b.addQty(addQty);
             
              li.set(new Book(b.getIsbn(),b.getTitle(), b.getAuthor(), b.getQty(), b.getPrice()));
              found=true;
            }
        }
        if(found){
            
            oos= new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(books);
            oos.close();
            System.out.println("Stock quantity has been updated!");
        }
        else{
            System.out.println("Book not found, make sure to enter the right key and try again");
        }
            System.out.println("---------------------------------------------------------");
            
              }else{
          System.out.println("File is not found!");
        }
    }


    /*
     * 
     * -------------------------------------------
     * View Order History Method
     * -------------------------------------------- 
     * 
     */


    public void viewOrderHistory() throws ClassNotFoundException, IOException{
        if(fileOrder.isFile()){
            ois= new ObjectInputStream(new FileInputStream(fileOrder));
            orders=(ArrayList<Order>)ois.readObject();
            ois.close();
     
        lo=orders.listIterator();
        orderHeader();
        while(lo.hasNext()){
              System.out.println(lo.next());
        }
        System.out.println("--------------------------------------------------------");
        }
        else{
          System.out.println("File is not found!");
        }
    }   
    
    
    /*
     * 
     * -------------------------------------------
     * Display book header Method
     * -------------------------------------------- 
     * 
     */
    
    
    public void bookHeader(){
        System.out.println("=======================================================");
        System.out.println("ISBN\tTitle\t\tAuthor\t\tQty\tPrice");
        System.out.println("=======================================================");
    }

    /*
     * 
     * -------------------------------------------
     * Display order header Method
     * -------------------------------------------- 
     * 
     */

    public void orderHeader(){
        System.out.println("===========================================================");
        System.out.println("ISBN\tName\t\tEmail\t\t\tQty\tBill");
        System.out.println("===========================================================");
      }
    
}


