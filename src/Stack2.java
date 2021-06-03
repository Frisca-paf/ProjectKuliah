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
//public class Stack2 {
// 
//    public static void main(String[] args) throws IOException {
//      //Jangan merubah main method
//        StackBerbasisLinkedList stack = new StackBerbasisLinkedList();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] nama = reader.readLine().split(" ");
//        String[] nim = reader.readLine().split(" ");
//        for (int i = 0; i < nama.length; i++) {
//            stack.push(new Node(new Mahasiswa(nama[i], nim[i])));
//        }
//        int jumlahPop = Integer.parseInt(reader.readLine());
//        for (int i = 0; i < jumlahPop; i++) {
//            stack.pop();
//        }
//        System.out.println("Isi Stack :");
//        stack.print();
//    }
//}
// 
//class StackBerbasisLinkedList {
// 
//    Node top;
//    int count;
// 
//    public boolean isEmpty() {
//        return count == 0;
//    }
// 
//    public void push(Node input) {
//        if(isEmpty()){
//            top = input;
//            top.next = top.prev = input;
//        }
//        else{
//            input.next = top;
//            input.prev = top.prev;
//            top.prev.next = input;
//            top.prev = input;
//            top = input;
//        }
//        count++;
//    }
// 
//    public void pop() {
//        Node temp = top;
//        if(count == 1){
//            top = null;
//        }
//        else{
//            top.next.prev = top.prev;
//            top.prev.next = top.next;
//            top = top.next;
//        }
//        count--;
//        System.out.println("Mahasiswa dengan Nama "+temp.data.getNama()+" dan NIM "+temp.data.getNim()+" telah dikeluarkan dari stack");
//    }
// 
//    public void print() {
//        if(isEmpty()){
//            System.out.println("Stack Empty");
//        }
//        else{
//            Node temp = top;
//            for(int i =0;i<count;i++){
//                System.out.print(temp.data.getNama()+" ");
//                temp = temp.next;
//            }
//        }
//    }
// 
//}
// 
//class Node {
// 
//    public Node(Mahasiswa data) {
//        this.data = data;
//    }
// 
//    Mahasiswa data;
//    Node next, prev;
// 
//}
// 
//class Mahasiswa {
// 
//    String nama;
//    String nim;
// 
//    public Mahasiswa(String nama, String nim) {
//        this.nama = nama;
//        this.nim = nim;
//    }
// 
//    public String getNama() {
//        return nama;
//    }
// 
//    public String getNim() {
//        return nim;
//    }
// 
//}
