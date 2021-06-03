/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstract_Interface;

/**
 *
 * @author CLIENT
 */
abstract class BangunDatar {
    private String nama;
    static String ListBangunDatar[] = new String [10];
    static int index = 0;

    public static String[] getListBangunDatar() {
        return ListBangunDatar;
    }

    public static void setListBangunDatar(String[] ListBangunDatar) {
        BangunDatar.ListBangunDatar = ListBangunDatar;
    }
    BangunDatar(){
    }
   BangunDatar(String nama){
       this.nama = nama;
       ListBangunDatar[index] = nama;
       index++;
   }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
void info(){
    System.out.println("Nama bangun datar : " + getNama());
}

public static BangunDatar
getInstanceBangunDatarOf(Hitung bangun){
BangunDatar bangunDatar = null;
if(bangun instanceof Persegi)
bangunDatar = (Persegi)bangun;
else if(bangun instanceof Segitiga)
bangunDatar = (Segitiga) bangun;
else if(bangun instanceof Lingkaran)
bangunDatar = (Lingkaran) bangun;
else if(bangun instanceof Trapesium)
bangunDatar = (Trapesium) bangun;
else if(bangun instanceof Layang)
bangunDatar = (Layang)bangun;
return bangunDatar;
}
}
class fungsiBangunDatar extends BangunDatar{
    fungsiBangunDatar(){
    }
    @Override
    void info() {
      System.out.println("----------INFORMASI BANGUN DATAR----------");
        int i = 0;
        while (i<ListBangunDatar.length && ListBangunDatar[i]!=null){
            System.out.println(i+1+". "+ ListBangunDatar[i]);
        i++;
        }
    }   
 }
class Segitiga extends BangunDatar implements Hitung{
    private double alas;
    private double tinggi;
    
   Segitiga(String nama, double alas, double tinggi){
        super("Segitiga");
       this.alas = alas;
        this.tinggi = tinggi;
    }
    @Override
   public double hitungLuas() {
       return alas*tinggi*0.5;
    }
    @Override
    public double hitungKeliling() {
       double a = 0.5*alas;
       double b = tinggi;
       double sisi = Math.sqrt(Math.pow(a, 2)+Math.pow(b,2));
       return alas+(2*sisi);
    }

    @Override
    public double hitungSpesial() {
       double a = 0.5*alas;
       double b = tinggi;
       double c = Math.sqrt(Math.pow(a, 2)+Math.pow(b,2));
    return c;
    }

    @Override
    void info() {
       System.out.println("Nama bangun datar : " + getNama() + "\nNilai alas : " + this.alas +
               "\nNilai tinggi : "+this.tinggi + "\nNilai luas : "+hitungLuas() + "\nNilai keliling : " + hitungKeliling() +
               "\nNilai sisi miring : " + hitungSpesial());
       System.out.println("===================================================");
    }
}
class Persegi extends BangunDatar implements Hitung{
    private double panjangSisi;

    Persegi(String nama,double panjangSisi){
        super("Persegi");
        this.panjangSisi = panjangSisi;
    }
    @Override
    public double hitungLuas() {
       return Math.pow(panjangSisi,2);
    }

    @Override
    public double hitungKeliling() {
       return panjangSisi*4;
    }

    @Override
    public double hitungSpesial() {
        return Math.sqrt(Math.pow(panjangSisi, 2)+Math.pow(panjangSisi,2));
    }

    @Override
    void info() {
        System.out.println("Nama bangun datar : " + getNama() + "\nNilai panjang sisi : "+ this.panjangSisi + "\nNilai luas : "+hitungLuas() + "\nNilai keliling : " + hitungKeliling() +
               "\nNilai diagonal : " + hitungSpesial());
           System.out.println("===================================================");
    }
}
class Lingkaran extends BangunDatar implements Hitung{
    private double jari;
    private final double pi=3.14;

    Lingkaran(String nama,double jari){
        super("Lingkaran");
        this.jari = jari;
    }
    @Override
    public double hitungLuas() {
        return pi*jari*jari;
    }
    @Override
    public double hitungKeliling() {
       return 2*pi*jari;
    }
    @Override
    public double hitungSpesial() {
       double LuasJuring = (pi*jari*jari)*90/360; 
       double LuasSegitiga = 0.5*jari*jari;
        return LuasJuring - LuasSegitiga;
    }
    @Override
    void info() {
         System.out.println("Nama bangun datar : " + getNama() + "\nNilai jari-jari : " + this.jari +
               "\nNilai luas : "+hitungLuas() + "\nNilai keliling : " + hitungKeliling() +
               "\nNilai tembereng : " + hitungSpesial());
           System.out.println("===================================================");
    }
}

class Trapesium extends BangunDatar implements Hitung{
    private double alasAtas;
    private double alasBawah;
    private double tinggi;

    
    Trapesium(String nama,double alasAtas, double alasBawah, double tinggi){
        super("Trapesium");
        this.alasAtas = alasAtas;
        this.alasBawah = alasBawah;
        this.tinggi = tinggi;
    }
    @Override
    public double hitungLuas() {
     return (alasAtas+alasBawah)*tinggi*0.5;
    }

    @Override
    public double hitungKeliling() {
      double a = alasBawah-alasAtas;
      double c = Math.sqrt(Math.pow(a, 2)+Math.pow(tinggi,2));
      return alasBawah+alasAtas+(2*c);
    }

    @Override
    public double hitungSpesial() {
       return alasAtas*alasAtas;
    }
    @Override
    void info() {
       System.out.println("Nama bangun datar : " + getNama() + "\nNilai alas atas: " + this.alasAtas + "\nNilai alas bawah : " +this.alasBawah+
               "\nNilai tinggi : "+this.tinggi + "\nNilai luas : "+hitungLuas() + "\nNilai keliling : " + hitungKeliling() +
               "\nNilai persegi ABCD : " + hitungSpesial());
           System.out.println("===================================================");
    }
}


class Layang extends BangunDatar implements Hitung{
    private double diagonal1;
    private double diagonal2;
    private double sisiMiring1;
    private double sisiMiring2;

    Layang(String nama,double diagonal1, double diagonal2, double sisiMiring1, double sisiMiring2){
        super("Layang-Layang");
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiMiring1 = sisiMiring1;
        this.sisiMiring2 = sisiMiring2;
    }
    @Override
    public double hitungLuas() {
       return 0.5*diagonal1*diagonal2;
    }

    @Override
    public double hitungKeliling() {
       return (2*sisiMiring1)+(2*sisiMiring2);
    }

    @Override
    public double hitungSpesial() {
     if (sisiMiring1<sisiMiring2){
     double a = 0.5*diagonal1;
     double c = sisiMiring1;
     double b;
      if(sisiMiring1>a){
      b = Math.sqrt(Math.pow(c, 2)-Math.pow(a,2));
        }else{
        b = Math.sqrt(Math.pow(a, 2)-Math.pow(c,2));   
     }
     return a*b;} else{
     double a = 0.5*diagonal2;
     double c = sisiMiring1;
     double b;
      if(sisiMiring1>a){
      b = Math.sqrt(Math.pow(c, 2)-Math.pow(a,2));
      }else{
      b = Math.sqrt(Math.pow(a, 2)-Math.pow(c,2));   
     }
     return a*b;}
    }
    
    @Override
    void info() {
      System.out.println("Nama bangun datar : " + getNama() + "\nNilai diagonal1 : " + this.diagonal1 +
               "\nNilai diagonal2 : "+this.diagonal2 +"\nNilai sisi miring1 : " + this.sisiMiring1+ 
              "\nNilai sisi miring2 : " + this.sisiMiring2+"\nNilai luas : "+hitungLuas() + "\nNilai keliling : " + hitungKeliling() +
               "\nNilai segitiga abd1 : " + hitungSpesial());
           System.out.println("===================================================");
    }
}

interface Hitung{
double hitungLuas();
double hitungKeliling();
double hitungSpesial();
}

class Test{
    public static void main(String[] args) {
//        Hitung[] hitungs = new Hitung[5];
//hitungs[0] = new Persegi("Persegi",4);
//hitungs[1] = new Segitiga("Segitiga",4,3);
//hitungs[2] = new Layang("Layang",5, 3,4,5);
//hitungs[3] = new Trapesium("Trapesium",5,7,3);
//hitungs[4] = new Lingkaran("Lingkaran",7);
//for(Hitung bangun : hitungs){
//BangunDatar bangunDatar =
//BangunDatar.getInstanceBangunDatarOf(bangun);
//bangunDatar.info();
//}
//  BangunDatar bd[] = new BangunDatar[7];
//bd[0] = new Lingkaran("Lingkaran", 37);
//bd[1] = new Trapesium("Trapesium", 24, 77,10);
//bd[2] = new Segitiga("Segitiga", 56, 67);
//bd[3] = new Persegi("Persegi", 33);
//bd[4] = new Layang("Layang", 30, 12, 8, 7);
//bd[5] = new Trapesium("Trapesium", 10, 35, 8);
//bd[6] = new Layang("Layang", 12, 24, 7, 9);
//BangunDatar b = new fungsiBangunDatar();
//b.info();
//for(int i = 0; i < bd.length; i++) {
//System.out.printf("================Bangun Datar %d====================\n", i+1);
//bd[i].info();
//}
//       BangunDatar bd[] = new BangunDatar[3];
//       bd[0] = new Lingkaran("Lingkaran",7);
//       bd[1] = new Persegi("Persegi",10);
//       bd[2] = new Segitiga("Segitiga",5,3);
//       BangunDatar b = new fungsiBangunDatar();
//       b.info();
//       for(int i = 0; i < bd.length; i++) {
//System.out.printf("================Bangun Datar %d====================\n", i+1);
//bd[i].info();
//    }
        double a = (40*(Math.random()*11))/100;
      int convert = (int)a;

            double random = Math.random()*100;
//    int convert = (int) random;
            System.out.print(convert);
}
}
