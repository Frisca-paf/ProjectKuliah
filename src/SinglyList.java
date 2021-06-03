/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CLIENT
 */
import java.util.*;
//Frisca Putri Ayu F_205150200111030
//class Node {
//  //Atribut
//  Object data;//sebagai isi dari node
//  Node next;//sebagai tangan dari node
//  
//  //Konstruktor
//  public Node() { }
//
//  public Node(Object data) {
//    this.data = data;
//  }
//
//  public Node(Object data, Node next) {
//      this. data = data;
//      this.next = next;
//    
//  }
//}

class LinkedList1 {
  //Atribut
  Node head,tail;//head menandakan node paling depan dan tail menandakan paling belakang
  int size=0;
  // int input = input.nextInt();

  //Konstruktor singly linked list
  public LinkedList1(){
      head=tail=null;
 
  }

  //Method mengecek apakah singly linked list kosong atau tidak
  boolean isEmpty(){
    return size == 0;
  }
 
  //Method mengecek ukuran singly linked list
  int size(){
    return size;
  }
 
  //Method menambahkan node ke paling depan
  void addFirst(Node input){
        if (this.isEmpty()){
            head=tail=input;
        }else{
            input.next = head;
            head = input;
        }size++;
        
  }

  //Method menambahkan node ke paling belakang
  void addLast(Node input){
        if (this.isEmpty()){
            head=tail=input;
        }else{
            input.next = null;
            tail.next = input;
            tail = input;
        }
        size++;
  }

  //Method menambahkan node setelah key
  void insert(Object key, Node input){
        Node p = head;
        while (p != null){
            if (p.data.equals(key)){
                if (p == tail){
                    this.addLast(input);
                }else if (p==head){
                    this.addFirst(input);
                }
                else{
                input.next = p.next;
                p.next = input;
                size++;
                   break;
    }
    }
             p = p.next;
    }
  }

  //Method menghapus node sesuai isinya
  void remove(Object key){
    Node temp = head;
    if (!isEmpty()){
      do{
        if ((temp.data.equals(key))&&(temp == head)){
          if (head == tail)
            head = tail = null;
          else{
            temp = temp.next;
            head = temp;
            temp = null;
          } 
          size--;
          break;
        }
        else if (temp.next.data.equals(key)){
          temp.next = temp.next.next;
          if(temp.next == null)
            tail=temp;
          size--;
          break;
        }
        temp = temp.next;
      }while(temp.next!=null);
    }
  }
                
        

  //Method mencetak seluruh isi linked list dari head
//  public void print(){
//    Node p = head;
//        while (p!= null){
//            System.out.print(p.data + " ");
//            p = p.next;
//        }
//      System.out.println(" ");
//    }
//  }

public class SinglyList {

  public static void main(String[] args) {
    //Disarankan untuk tidak mengubah main method
    Scanner input = new Scanner(System.in);
    LinkedList1 list =new LinkedList1();
    int n = input.nextInt();
    String s[] = new String[n];
    for(int i = 0;i<n;i++){
       s[i] = input.next();
      int a,c,d,e;
      switch(s[i]){
        case "isEmpty":
          System.out.println(list.isEmpty());
          break;
        case "size":
          System.out.println(list.size());
          break;
        case "addFirst":
          a = input.nextInt();
          list.addFirst(new Node(a));
          break;
        case "addLast":
          a = input.nextInt();
          list.addLast(new Node(a));
          break;
        case "insert":
          a = input.nextInt();
          int b = input.nextInt();
          list.insert(a,new Node(b));
          break;
        case "remove":
          a = input.nextInt();
          list.remove(a);
          break;
        case "print":
          list.print();
      }
    }
  }   
}
