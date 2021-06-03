/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstract_Konret_Kelas;

/**
 *
 * @author CLIENT
 */
class TestPegawai {
    public static void main(String[] args) {
//    Pegawai org1 = new PegawaiTetap("Bayu","2502628191",2000000);
//    Pegawai org2 = new PegawaiHarian("Edo","3061728292",8500,40);
//    Pegawai org3 = new Sales("Tika", "3502838392",50,5000);
//    Pegawai org4 = new PegawaiHarian("Lia","3061723492",9000,44);
//    Pegawai org5 = new Sales("Dion","23247484021",100,10000);
//    Pegawai [] pgw = new Pegawai[5];
//    pgw[0]=org1;
//    pgw[1]=org2;
//    pgw[2]=org3;
//    pgw[3]=org4;
//    pgw[4]=org5;
//    
//   System.out.println("DAFTAR NAMA PEGAWAI :");
//   System.out.println("*********************************");
//
//    for (int i=0;i<pgw.length;i++){
//     System.out.println(pgw[i].toString() +" ");
//     System.out.println("===================================");
//    }
           double b = Math.sqrt(Math.pow(10, 2)-Math.pow(8,2));
           System.out.print(b);
    }
}

public abstract class Pegawai {
    
    private String nama;
    private String noKTP;
    
    public Pegawai(String nama, String noKTP){
        this.nama = nama;
        this.noKTP = noKTP;
    }

    public String getNama() {
        return nama;
    }

    public String getNoKTP() {
        return noKTP;
    }
    
   abstract double gaji();
   
    @Override
    public String toString(){
        return "Nama  : "+nama + "\nNo KTP : "+ noKTP;
    }
     
}
class ListPegawai {
   private Pegawai org [];


public ListPegawai(int jumlahPegawai){
    org = new Pegawai[jumlahPegawai];
}

public boolean setPegawai(Pegawai data){
    int i =0;
    while(i<org.length  && org[i] !=null)
        i++;
    if(i<org.length){
        org[i] = data;
        return true;
    }
    else return false;
}
    @Override
public String toString(){
    String s = "DAFTAR NAMA PEGAWAI:\n";
    int i = 0;
    while(i<org.length && org[i]!=null){
    String.format("%s%2d, %s",s,org[i],toString());
      i++;
    }
    return s;
}
}
 class PegawaiHarian extends Pegawai {
    private double upahPerJam;
    private int totalJam;
    
    public PegawaiHarian(String nama, String noKTP, double upahPerJam,int totalJam ){
        super (nama, noKTP);
        this.upahPerJam = upahPerJam;
        this.totalJam = totalJam;
    }

    public int getTotalJam() {
        return totalJam;
    }

    public double getUpahPerJam() {
        return upahPerJam;
    }

    public void setTotalJam(int totalJam) {
        this.totalJam = totalJam;
    }

    public void setUpahPerJam(double upahPerJam) {
        this.upahPerJam = upahPerJam;
    }
    
    @Override
    double gaji(){
    if (totalJam <= 40){
       return this.upahPerJam*totalJam; 
    } else 
        return (this.upahPerJam*40) + ((this.totalJam-40)*this.upahPerJam*1.5); 
    }
    
    @Override
    public String toString(){
        return "Pegawai Harian  : "+getNama()+"\nNo KTP           : "+
                getNoKTP()+"\nUpah/Jam        : Rp."+ this.upahPerJam+
                "\nTotal jam kerja : "+ this.totalJam+"\nPendapatan      : Rp."
                +gaji();
    }
}

 class PegawaiTetap extends Pegawai{
    private double upah;
    
    public PegawaiTetap(String nama, String noKTP, double upah){
        super(nama, noKTP);
        this.upah = upah;
    }

    public double getUpah() {
        return upah;
    }

    public void setUpah(double upah) {
        this.upah = upah;
    }
    
    @Override
    double gaji(){
      return upah;  
    }
    
    @Override
    public String toString(){
        return "Pegawai Tetap   : "+ getNama()+"\nNo KTP          : "+
                getNoKTP()+"\nUpah            : "+getUpah()+
                "\nPendapatan      : Rp. "+gaji();
    }
}
 class Sales extends Pegawai {
    private int penjualan;
    private double komisi;

    public Sales (String nama, String noKTP, int penjualan, double komisi){
        super(nama,noKTP);
        this.penjualan = penjualan;
        this.komisi =  komisi;
    }

    public double getKomisi() {
        return komisi;
    }

    public int getPenjualan() {
        return penjualan;
    }

    public void setKomisi(double komisi) {
        this.komisi = komisi;
    }

    public void setPenjualan(int penjualan) {
        this.penjualan = penjualan;
    }
        @Override
    double gaji(){
      return getPenjualan()*getKomisi();
    }
        
    @Override
    public String toString(){
    return "Sales           : "+getNama()+"\nNo KTP          : "+getNoKTP()+
            "\nTotal Penjualan : "+getPenjualan()+"\nBesaran Komisi  : "+
            getKomisi()+"\nPendapatan      : Rp."+gaji();
    }

}
