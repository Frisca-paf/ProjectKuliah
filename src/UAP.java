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
import java.util.ArrayList;
import java.util.Scanner;
abstract class Tanaman{
    private int masaHidup, lamaHidup, berbuah, buah;
    private double perkembangan, prosesBerbuah;
    abstract void berkembang();
   
    public Tanaman(int masaHidup, int berbuah, double perkembangan){
        this.masaHidup = masaHidup;
        this.berbuah = berbuah;
        this.perkembangan = perkembangan;
    }
    public String status(){
        if (lamaHidup>=masaHidup){
            return "Mati";
        }else
            return "Hidup";
    }
    public String getStatus(){
        return status();
    }
    public String toString(){
        return "-----------------------------------------"+
               "\nMasa Hidup tanaman   : " + getMasaHidup() +
               "\nLama Hidup tanaman   : " + getLamaHidup()+
               "\nBuah yang dihasilkan : " + buah +
               "\nStatus tanaman       : " + getStatus();
    }

    public int getMasaHidup() {
        return masaHidup;
    }

    public void setMasaHidup(int masaHidup) {
        this.masaHidup = masaHidup;
    }

    public int getLamaHidup() {
        return lamaHidup;
    }

    public void setLamaHidup(int lamaHidup) {
        this.lamaHidup = lamaHidup;
    }

    public int getBerbuah() {
        return berbuah;
    }

    public void setBerbuah(int berbuah) {
        this.berbuah = berbuah;
    }

    public int getBuah() {
        return buah;
    }

    public void setBuah(int buah) {
        this.buah = buah;
    }

    public double getPerkembangan() {
        return perkembangan;
    }

    public void setPerkembangan(double perkembangan) {
        this.perkembangan = perkembangan;
    }

    public double getProsesBerbuah() {
        return prosesBerbuah;
    }

    public void setProsesBerbuah(double prosesBerbuah) {
        this.prosesBerbuah = prosesBerbuah;
    }
    
}

class Stroberi extends Tanaman implements Perawatan{
private double nilaiPerkembangan = 0.35;
int berbuah = 150;
static double proses = 0;
static int buah =0;

    public Stroberi(int masaHidup, int berbuah, double perkembangan) {
        super(masaHidup, berbuah, perkembangan);
    }
    @Override
    void berkembang() {
       if (getProsesBerbuah()== berbuah){
           buah = +1;
           setProsesBerbuah(0);
       } if (getProsesBerbuah()> berbuah){
           buah = +1;
           getProsesBerbuah();
           setProsesBerbuah(getProsesBerbuah()-berbuah);
       }
    }
   public double setProsesBerbuah(int nilaiPerkmbangan){
       proses = nilaiPerkembangan * berbuah;
       return proses;
    }
  public double getProsesBerbuah(){
        return proses;
    }
    @Override
    public void treatment() {
       System.out.println("Perkembangan Tanaman : " + (getPerkembangan()*0.05));
    }
        public String toString(){
        return "-----------------------------------------"+
               "\nMasa Hidup tanaman   : " + getMasaHidup() +
               "\nLama Hidup tanaman   : " + getLamaHidup()+
               "\nBuah yang dihasilkan : " + buah +
               "\nStatus tanaman       : " + getStatus();
    }
}

class Tomat extends Tanaman implements Perawatan{
private double nilaiPerkembangan = 0.25;
int berbuah = 100;
static double proses = 0;
static int buah =0;

    public Tomat(int masaHidup, int berbuah, double perkembangan) {
        super(masaHidup, berbuah, perkembangan);
    }

    @Override
    void berkembang() {
       if (getProsesBerbuah()== this.berbuah){
         buah = +1;
         setProsesBerbuah(0);
       } if (getProsesBerbuah()> this.berbuah){
           buah = +1;
           getProsesBerbuah();
           setProsesBerbuah(getProsesBerbuah()-this.berbuah);
       }
    }
   public double setProsesBerbuah(int nilaiPerkmbangan){
       proses = nilaiPerkembangan * berbuah;
       return proses;
    }
  public double getProsesBerbuah(){
        return proses;
    }
    @Override
    public void treatment() {
      double nilai = getPerkembangan()*0.05;
       System.out.println("Perkembangan Tanaman : " + nilai);
    }
        public String toString(){
        return "-----------------------------------------"+
               "\nMasa Hidup tanaman   : " + getMasaHidup() +
               "\nLama Hidup tanaman   : " + getLamaHidup()+
               "\nBuah yang dihasilkan : " + buah +
               "\nStatus tanaman       : " + getStatus();
    }
}

class Persik extends Tanaman implements Perawatan{
private double nilaiPerkembangan = 0.15;
int berbuah = 250;
static double proses = 0;
static int buah =0;
    public Persik(int masaHidup, int berbuah, double perkembangan) {
        super(masaHidup, berbuah, perkembangan);
    }
    @Override
    void berkembang() {
       if (getProsesBerbuah()== berbuah){
           buah = +1;
           setProsesBerbuah(0);
       } if (getProsesBerbuah()> berbuah){
           buah = +1;
           getProsesBerbuah();
           setProsesBerbuah(getProsesBerbuah()-berbuah);
       }
    }
   public double setProsesBerbuah(int nilaiPerkmbangan){
       proses = nilaiPerkembangan * berbuah;
       return proses;
    }
  public double getProsesBerbuah(){
        return proses;
    }
    @Override
    public void treatment() {
        double nilai = getPerkembangan()*0.025;
       System.out.println("Perkembangan Tanaman : " + nilai);
    }
    
}

class Data extends Tanaman implements Perawatan{
 public static ArrayList <Tanaman> tanaman = new ArrayList<>();
 public static ArrayList <Integer> lokasi = new ArrayList<>();
 public static Scanner input = new Scanner (System.in);
    
 public Data(int masaHidup, int berbuah, double perkembangan) {
        super(masaHidup, berbuah, perkembangan);
    }

   static void mulai(){
        System.out.println("Lama waktu masa tanam (bulan) : ");
        int nilaiInput = input.nextInt();
        int hasil = nilaiInput*30;
        
        for (int i=0; i<3;i++){
            menanam();
        }
         System.out.println("Proses Perkembangan Tanaman");
         
         for (int i=0; i<3; i++){
             if (Data.tanaman.get(i).getStatus().equalsIgnoreCase("Hidup")){
                 Data.tanaman.get(i).berkembang();
             } else if (Data.lokasi.contains(i)){
             continue;
              } else{
                 Class tanamanMati = Data.tanaman.get(i).getClass();
                 String nama = tanamanMati.getSimpleName();
                 System.out.println("Tanaman " + nama + " sudah mati");
                 Data.lokasi.add(i);
                 menanam();
             } 
    } 
   }
        
    static void menanam(){
        System.out.println("Silahkan memilih tanaman yang akan ditanam : ");
        System.out.println("1. Tomat" + "\n2. Stroberi" + "\n3. Persik");
        int tanam = input.nextInt();
        switch (tanam){
            case 1:
                tanaman.add(new Tomat(100,100,0.25));
                System.out.println("Berhasil menanam Tomat");
                
                break;
            case 2:
                tanaman.add(new Stroberi(60,150,0.35));
                System.out.println("Berhasil menanam Stroberi");
                break;
            case 3 :
                tanaman.add(new Persik(180,250,0.15));
                System.out.println("Berhasil menanam Persik");
                break;
            
        }
    }
        @Override
  public void berkembang() {
        berkembang();
    }
   static void info(){
        for(int i =0; i<Data.tanaman.size();i++){
            System.out.println("Tanaman " + i+1 + " ");
            System.out.println(Data.tanaman.get(i).toString());
        }
    }

    @Override
 public void treatment() {
     treatment();
    }
}
interface Perawatan{
  void treatment();
}

public class UAP {
    public static void main(String[] args) {
       Data.mulai();
       Data.info();  
    }
 
}
