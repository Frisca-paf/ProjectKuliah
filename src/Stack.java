/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CLIENT
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Stack {

    public static void main(String[] args) throws IOException {
      //Jangan merubah main method
        StackBerbasisLinkedList stack = new StackBerbasisLinkedList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nama = reader.readLine().split(" ");
        String[] nim = reader.readLine().split(" ");
        for (int i = 0; i < nama.length; i++) {
            stack.push(new Node(new Mahasiswa(nama[i], nim[i])));
        }
        int jumlahPop = Integer.parseInt(reader.readLine());
        for (int i = 0; i < jumlahPop; i++) {
            stack.pop();
        }
        System.out.println("Isi Stack :");
        stack.print();
    }
}

class StackBerbasisLinkedList {

    Node top;
    int count;

    public boolean isEmpty() {
        //Isi Method ini
        return count ==0;
    }

    public void push(Node input) {
        //Isi Method ini
        if(isEmpty()){
            top = input;
            top.next = input;
            top.prev = input;
        }else{
            input.next = top;
            input.prev = top.prev;
            top.prev.next = input;
          top.prev = input;
            top=input;
        }
        count++;
    }

    public void pop() {
        Node p = top;
                if(count==1){
                    top=null;
          }else{
                    p.next.prev = top.prev;
                    p.prev.next = top.next;
                    top = top.next;
                }
                count--;
   System.out.println("Mahasiswa dengan Nama "+p.data.getNama()+" dan NIM "+p.data.getNim()+" telah dikeluarkan dari stack");             
    }

    public void print() {
        //Isi Method ini
           if(isEmpty()){
            System.out.println("Stack Empty");
        }
        else{
            Node p = top;
            for(int i =0;i<count;i++){
                System.out.print(p.data.getNama()+" ");
                p = p.next;
            }
        }
    }
    }



class Node {

    public Node(Mahasiswa data) {
        //Isi Method ini
        this.data=data;
    }

    Mahasiswa data;
    Node next, prev;

}

class Mahasiswa {

    String nama;
    String nim;

    public Mahasiswa(String nama, String nim) {
        //Isi Method ini
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        //Isi Method ini
        return nama;
    }

    public String getNim() {
        //Isi Method ini
        return nim;
    }

}
