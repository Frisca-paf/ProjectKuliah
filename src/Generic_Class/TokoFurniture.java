/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generic_Class;

import java.io.*;
import java.util.*;


public class TokoFurniture {
    public static void main(String[] args) {
    product p1 = new PerabotKayu("Meja","190", "perabot kayu", 300000, 19);
    product p2 = new Elektronik("Lampu", "201", "Elektronik" , 60000, 20);
    product p3 = new PerabotKayu("Kursi", "180", "perabot kayu" , 25000, 7);
    product p4 = new Elektronik("TV", "211", "Elektronik" , 1200000, 5);
    product p5 = new Elektronik("Radio", "212", "Elektronik" , 100000, 4);
    LineFormatter If = new LineFormatter(70);
        If.addLine("TOKO FURNITURE PAK PAIMO", LineFormatter.CENTER_ALIGN);
        If.addLine("REKAPITULASI HASIL PENJUALAN FURNITURE", LineFormatter.CENTER_ALIGN);
        If.addDivider("-");
        If.addLine(
                new LineColumn("Kode",10).addColumn("Nama Barang",20)
                .addColumn("Berat", 10).addColumn("Jenis",20)
                .addColumn("Harga", 7)
                );
            System.out.println( If.render() );
        p1.tampil();
        p2.tampil();
        p3.tampil();
        p4.tampil();
        p5.tampil();
        System.out.println(" ");
        System.out.println("----------------------------------------------------------------------");
 System.out.printf("%-60s","TOTAL");
 System.out.printf("%-15s",product.hargaTotal);
 System.out.println(" ");
 
    
}
}

 class product<T>{

    private T namaBarang;
    private T kode;
    private T jenisBarang;
    private int harga;
    private T beratBarang; 
    static int hargaTotal = 0;
    static int counter = 0;
    
  product (T namaBarang, T kode, T jenisBarang, int harga, T beratBarang){
       this.namaBarang = namaBarang;
       this.kode = kode;
       this.jenisBarang = jenisBarang;
       this.harga = harga;
       this.beratBarang = beratBarang;
       counter++;
       
       for (int i=0;i<counter;i--){
          hargaTotal+=getHarga();
       }
}

    public T getBeratBarang() {
        return beratBarang;
    }

    public void setBeratBarang(T beratBarang) {
        this.beratBarang = beratBarang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public T getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(T jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public T getKode() {
        return kode;
    }

    public void setKode(T kode) {
        this.kode = kode;
    }

    public T getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(T namaBarang) {
        this.namaBarang = namaBarang;
    }
    void tampil(){
  
    }
}
class PerabotKayu<T> extends product{
    
   PerabotKayu(T namaBarang, T kode, T jenisBarang, int harga, T beratBarang){
       super(namaBarang,kode,jenisBarang,harga,beratBarang);
   }

    @Override
    void tampil() {
        System.out.println(" ");
        System.out.printf("%-10s", getKode());
        System.out.printf("%-20s",getNamaBarang());
        System.out.printf("%-10s" , getBeratBarang()+ " kg");
        System.out.printf("%-20s" ,"Perabotan Kayu");
        System.out.printf("%-15s", getHarga());
    }
}
class Elektronik <T> extends product{
    
   Elektronik (T namaBarang, T kode, T jenisBarang, int harga, T beratBarang){
       super(namaBarang,kode,jenisBarang,harga,beratBarang);
   }

    @Override
    void tampil() {
        System.out.println(" ");
        System.out.printf("%-10s", getKode());
        System.out.printf("%-20s",getNamaBarang());
        System.out.printf("%-10s" , getBeratBarang()+ " kg");
        System.out.printf("%-20s" ,"Elektronik");
        System.out.printf("%-15s", getHarga());
    }
}

//KELAS UNTUK FORMAT TABEL DAN KOLOM
class LineFormatter {
    public static final int LEFT_ALIGN = -1;
    public static final int CENTER_ALIGN = 0;
    public static final int RIGHT_ALIGN = 1;
 
    private int lineWidth;
    private List<String> lines;
    private String newLine = System.getProperty("line.separator");
 
    public static String LEFT_MARGIN = ""; // nothing
 
 
    public LineFormatter() {
        init(40);
    }
 
   
    public LineFormatter(int l) {
        init(l);
    }
 
    public LineFormatter setNewLine(String n) {
        this.newLine = n;
        return this;
    }
 
    private void init(int l) {
        this.lineWidth = l;
        lines = new ArrayList<String>();
    }
 

    public LineFormatter addLine(LineColumn cols) {
        return addLine(cols.getLine());
    }
    public LineFormatter addLine(String s) {
        return addLine(s, LEFT_ALIGN);
    }
 
    public LineFormatter addLine(String s, int align) {
        switch (align) {
            case LEFT_ALIGN:
                return saveLine(String.format("%-" + this.lineWidth + "s", s));
            case RIGHT_ALIGN:
                return saveLine(String.format("%" + this.lineWidth + "s", s));
            case CENTER_ALIGN:
                int sw = s.length();
                int pad = (this.lineWidth - sw) / 2;
                String l = String.format("%" + pad + "s%s%" + pad + "s", "", s, "");
                return addLine(l, RIGHT_ALIGN);
        }
        return null;
    }
 
    private LineFormatter saveLine(String s) {
        if (s.length() > this.lineWidth)
            s = s.substring(0, this.lineWidth);
        this.lines.add(LEFT_MARGIN + s);
        return this;
    }
 
    public LineFormatter addDivider() {
        return addLine(" ");
    }
 
    public LineFormatter addDivider(String s) {
        return addLine(
                String.format("%" + lineWidth + "s", s)
                        .replace(' ', s.charAt(0))
        );
    }
 
    public String render() {
        String text = "";
        if (lines.size() > 0) {
            text = lines.get(0);
        }
        for (int i = 1; i < lines.size(); i++) {
            text += this.newLine + lines.get(i);
        }
 
        return text;
    }
 
    public LineFormatter reset() {
        lines.clear();
        return this;
    }
}
 class LineColumn {
 
    private List<String> columns = new ArrayList<String>();
    public LineColumn(){
 
    }
 
    public LineColumn(String s, int width){
        this.addColumn(s, width);
    }
 
    public LineColumn addBlankSpace(int width){
        return this.addColumn(" ", width);
    }
 
    public LineColumn(String s, int width, int align){
        addColumn(s, width, align);
    }
 
    public LineColumn addColumn(String s, int width){
        return addColumn(s, width, LineFormatter.LEFT_ALIGN);
    }
 
    public LineColumn addColumn(String s, int width, int align){
        if(s.length() > width)
            s = s.substring(0, width);
 
        switch (align){
            case LineFormatter.LEFT_ALIGN:
                columns.add(String.format("%-" + width + "s", s));
            break;
            case LineFormatter.RIGHT_ALIGN:
                columns.add(String.format("%" + width + "s", s));
            break;
            case LineFormatter.CENTER_ALIGN:
                int sw = s.length();
                int pad = (width - sw) / 2;
                String l = String.format("%" + pad + "s%s%" + pad + "s", "", s, "");
                return addColumn(l, width, LineFormatter.RIGHT_ALIGN);
        }
 
        return this;
    }
 
    public String getLine(){
        String line = "";
        for(int i = 0; i < columns.size(); i++){
            line += columns.get(i);
        }
 
        return line;
    }
}

