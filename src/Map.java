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
//FRISCA PUTRI AYU FEBRIYANTI(205150200111030)
 
class Solution {
 
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        
        String[] key = new String [n];
        Integer [] value = new Integer [n];
        String[] search = new String [m];
        
        for (int i=0; i<n;i++){
            key[i] = input.next();
        }
        for (int i=0; i<n;i++){
            value[i] = input.nextInt();
        }
        for (int i=0; i<m;i++){
            search[i] = input.next();
        }
        Map <String, Integer> map = new Map<>();
        for (int i=0; i<n;i++){
            map.add(key[i],(value[i]));
        }
        for (int i=0; i<m;i++){
            System.out.print(map.get(search[i])+" ");
        }
    }
//}
//class HashNode<String,Integer>{
//    String key;
//    Integer value;
// 
//    HashNode<String,Integer> next;
//    public HashNode(String key, Integer value){
//        this.key = key;
//        this.value = value;
//    }
//        int hash (String key, int tableSize){
//        int hashVal = 0;
//        for (int i=0; i<key.length(); i++){
//            hashVal = (hashVal * 128 + key.charAt(i)) % tableSize;
//        }
//        return hashVal % tableSize;
//    }
//}
public class Map<String,Integer>{
    ArrayList<HashNode<String,Integer>> storage;
    int capacity;
    int size;
    public Map(){
        storage = new ArrayList<>();
        capacity = 10;
        size = 0;
 
        for(int i = 0;i<capacity;i++){
            storage.add(null);
        }
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return getSize()==0;
    }
    public int getIndex(String key){
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }
    public Integer get(String key){
        int index = getIndex(key);
        HashNode<String,Integer> head = storage.get(index);
        while(head != null){
            if (head.key.equals(key)) return head.value;
            head= head.next;
        }
        return null;
    }
    public void add(String key, Integer value){
        int index = getIndex(key);
        HashNode<String,Integer> head = storage.get(index);
 
        while(head != null){
          //Tulis kode untuk menambahkan data
          if (head.key.equals(key)){
              head.value = value;
              return;
          }
          head = head.next;
        }
 
        size++;
        head = storage.get(index); 
        HashNode<String,Integer> newNode = new HashNode<String,Integer>(key,value);
        newNode.next = head;
        storage.set(index, newNode);
      
        if((1.0*size)/capacity >= 0.7){
          //Tulis kode untuk menambahkan data
          ArrayList<HashNode<String, Integer>> curr = storage;
          storage = new ArrayList<>();
          capacity = 2*capacity;
          size=0;
          for (int i =0; i<capacity;i++){
              storage.add(null);
          }
          
          for (HashNode<String, Integer> Node : curr){
              while (Node != null){
                  add (Node.key,Node.value);
                  Node = Node.next;
              }
          }
        }
    }

 
    }
