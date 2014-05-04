/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 * Extend informations about a user
 * @author Maciej
 */
public class Person extends User{ 
private String firstName; 
private String lastName; 
private String address; 
 
public Person() {} 
public Person(String userLogin, String 
password) { 
/*this.firstName = firstName; 
this.lastName = lastName; 
this.address = address; */
super.setUserLogin(userLogin); 
super.setPassword(password); 
} 
 
//w tym miejscu należy utworzyć odpowiednie dla istniejących pól metody get i set 
// Menu kontekstowe: Insert code… --> Getter and Setter… 
 
@Override 
public String toString() { 
//return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + '}'; 
    return "String";
} 
} 

