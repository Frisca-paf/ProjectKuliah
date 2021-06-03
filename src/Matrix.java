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

public class Matrix {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner input = new Scanner (System.in);
        int baris1 = input.nextInt();
        int kolom1 = input.nextInt();
        int matriks1 [] []= new int[baris1][kolom1];
        int i = 0;
        int j = 0;
        for (i = 0; i < baris1; i++) {
        for ( j = 0; j < kolom1; j++) {
          matriks1[i][j] = input.nextInt();
        }
      }
        int baris2 = input.nextInt();
        int kolom2 = input.nextInt();
               int matriks2 [] []= new int[baris2][kolom2];
                for ( i = 0; i < baris2; i++) {
        for ( j = 0; j < kolom2; j++) {
          matriks2[i][j] = input.nextInt();
        }
      }
        if(kolom1!=baris2){
            System.out.println("Tidak dapat dikalikan");
        }else{
        int hasil [][] = new int [baris1][kolom2];
        int jumlah = 0;
        for (i = 0; i < baris1; i++) {
        for (j = 0; j < kolom2; j++) {
          for (int k = 0; k < baris2; k++) {
         jumlah = jumlah + matriks1[i][k] * matriks2[k][j];
          }
          hasil[i][j] = jumlah;
          jumlah = 0;
         j++;
        }
       i++;
      }
        System.out.println(i+ " " + (j) );
        for ( i = 0; i < baris1; i++) {
        for ( j = 0; j < kolom2; j++) {
          System.out.print(hasil[i][j] + " ");
        }
        System.out.println();
      }
    }
    }
    }

