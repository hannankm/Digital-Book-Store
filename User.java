package com.mycompany.finalbook;
import java.io.*;


public abstract class User {
        String firstName;
        String lastName;
        String email;

        public void greetUser(){
            System.out.println("Hello User");
        }
        
        public abstract void searchBook() throws IOException, ClassNotFoundException;
        public abstract void viewBooks() throws IOException, ClassNotFoundException;

        public User(String firstName, String lastName, String email){
            this.firstName=firstName;
            this.lastName=lastName;
            this.email=email;
           
        }
        
        public User(){
           this.firstName=null;
           this.lastName=null;
           this.email=null;
         
        }
        
        public String toString(){
            return firstName+" || "+ lastName+" || "+ email+" || ";
        }

        public void menu()throws IOException, FileNotFoundException, ClassNotFoundException{

            System.out.println("1. Add new book");
            System.out.println("2. View book list");
            System.out.println("3. Update book list");
            System.out.println("4. Delete book");
            System.out.println("5. Exit");
        }
    
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    
    }



