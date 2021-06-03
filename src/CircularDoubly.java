///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author CLIENT
// */
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//class Node {
// 
//    public Node(int data) {
//        //Isi kode berikut
//        this.data = data;
//    }
// 
//    int data;
//    Node next,prev;
// 
//}
// 
//class CircularDoubleLinkedList {
// 
//    Node head;
//    Node tail;
//    int size = 0;
// 
//    public boolean isEmpty() {
//        //Isi kode berikut
//        return size==0;
//    }
// 
//    public int getSize() {
//        //Isi kode berikut
//        return size;
//    }
// 
//    public void addFirst(Node input) {
//        //Isi kode berikut
//        if(this.isEmpty()){
//            head = input;
//            tail = input;
//            input.next = input;
//            input.prev = input;
//        }else{
//            input.next = head;
//            input.prev = tail;
//            tail.next = input;
//            head.prev = input;
//            head = input;
//        }
//        size++;
//    }
// 
//    public void addLast(Node input) {
//        //Isi kode berikut
//        if(this.isEmpty()){
//        head = input;
//            tail = input;
//            input.next = input;
//            input.prev = input;
//              
//        }else{
//            input.next = head;
//            input.prev = tail;
//            tail.next = input;
//            head.prev = input;
//            tail=input;
//        }
//        size++;
//    }
// 
//    public void print() {
//        //Isi kode berikut
//         Node p = head;
//       for(int i=0;i<size;i++){
//            System.out.print(p.data + " ");
//            p = p.next;
//        }
//      System.out.println(" ");
//    }
//    
// 
//    public void printReverse() {
//        //Isi kode berikut
//                 Node p = tail;
//       for(int i=0;i<size;i++){
//            System.out.print(p.data + " ");
//            p = p.prev;
//        }
//      System.out.println(" ");
//    }
//}
//
//public class CircularDoubly {
//
//    public static void main(String[] args) throws IOException {
//      // Jangan Merubah Main Method
//        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int jumlah = Integer.parseInt(reader.readLine());
//        String[] perintah = reader.readLine().split(" ");
//        String[] data = reader.readLine().split(" ");
//        for (int i = 0; i < jumlah; i++) {
//            if (perintah[i].equalsIgnoreCase("First")) {
//                cdll.addFirst(new Node(Integer.parseInt(data[i])));
//            } else {
//                cdll.addLast(new Node(Integer.parseInt(data[i])));
//            }
//        }
//        cdll.print();
//        cdll.printReverse();
//    }
//
//}
