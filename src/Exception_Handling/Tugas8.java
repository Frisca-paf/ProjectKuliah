/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception_Handling;

import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Tugas8 {
    public static void main(String[] args) {
    Random randomNum = new Random();
     Scanner input = new Scanner(System.in);
     int pilih = 0;
     int i=0;
     boolean lanjutkanInput = true;
      System.out.println("Selamat datang di game Defend FILKOM !");
      System.out.print("Silahkan masukkan nama player :"); String nama = input.next();
    do{
        try{
        System.out.println("Silahkan pilih karakter yang anda inginkan :");
        System.out.println("1. Magician"+"\n2. Healer"+"\n3. Warrior");
        pilih = input.nextInt();
        lanjutkanInput = false;
        }catch(Exception e){
          System.out.println("Tolong masukkan angka !");
          input.nextLine();
        }
    }while(lanjutkanInput);
    
    Titan ttn = new Titan(200,45,0);
    Magician mg = new Magician(100,60,10);
    Healer hl = new Healer(70,10,10);
    Warior wr = new Warior(150,30,15);
   System.out.println("Selamat datang, " + nama +" !");
   
        switch(pilih){
            case 1 :
            mg.info();
            while (mg.getHP()!= 0 || ttn.getHP()!= 0){
                 ttn.randomVal = randomNum.nextInt(11);
                 mg.randomVal = randomNum.nextInt(11);
               mg.attack();
               ttn.attack();
              
               if (mg.attack()== true){
                ttn.receiveDemage(mg.attack);
               }else{
                   ttn.getHP();
               }if(ttn.attack()==true){
                   mg.receiveDemage(ttn.attack);
               }else{
                   mg.getHP();
               }
            System.out.printf("================ TURN %d ====================\n", i+1);
            System.out.println("Enemy's HP  : " + ttn.getHP());
            System.out.println(nama+ "'s" + " HP : " + mg.getHP());
            if(mg.getHP()== 0){
             System.out.println("=============================================");
             System.out.println("Titan Menang") ;
             break;} 
            if(ttn.getHP()== 0){
            System.out.println("=============================================");
            System.out.println(nama+ " Menang");
            break;}
            i++;
            }
            System.out.println("\n================ PLAYER =====================");
            mg.info();
            System.out.println("\n================= MUSUH =====================");
            ttn.info();
            break;
                
            case 2 :
            hl.info();
            while (hl.getHP()!= 0 || ttn.getHP()!= 0){
                int panggilHeal = (i+1)%2;
                 ttn.randomVal = randomNum.nextInt(11);
                 hl.randomVal = randomNum.nextInt(11);
               hl.attack();
               ttn.attack();

               if (hl.attack()== true){
                ttn.receiveDemage(hl.attack);
               }else{
                   ttn.getHP();
               }if(ttn.attack()==true){
                   hl.receiveDemage(ttn.attack);
               }else{
                   hl.getHP();
               }

            System.out.printf("================ TURN %d ====================\n", i+1);
            if(panggilHeal==0){
            hl.heal();
            System.out.println("Menggunakan skill heal.");
            }
            System.out.println("Enemy's HP  : " + ttn.getHP());
            System.out.println(nama+ "'s" + " HP : " + hl.getHP());
    
            i++;
            if(hl.getHP()== 0){
             System.out.println("=============================================");
             System.out.println("Titan Menang") ;
             break;} 
            if(ttn.getHP()== 0){
            System.out.println("=============================================");
            System.out.println(nama+ " Menang");
            break;}
            
            }
            System.out.println("\n================ PLAYER =====================");
            hl.info();
            System.out.println("\n================= MUSUH =====================");
            ttn.info();
            break;
            
          case 3 :
            wr.info();
            while (wr.getHP()!= 0 || ttn.getHP()!= 0){
                 ttn.randomVal = randomNum.nextInt(11);
                 wr.randomVal = randomNum.nextInt(11);
               wr.attack();
               ttn.attack();

               if (wr.attack()== true){
                ttn.receiveDemage(wr.attack);
               }else{
                   ttn.getHP();
               }if(ttn.attack()==true){
                   wr.receiveDemage(ttn.attack);
               }else{
                   wr.getHP();
               }

            System.out.printf("================ TURN %d ====================\n", i+1);
            System.out.println("Enemy's HP  : " + ttn.getHP());
            System.out.println(nama+ "'s" + " HP : " + wr.getHP());
            i++;
            if(wr.getHP()== 0){
             System.out.println("=============================================");
             System.out.println("Titan Menang") ;
             break;} 
            if(ttn.getHP()== 0){
            System.out.println("=============================================");
            System.out.println(nama+ " Menang");
            break;}
            
            }
            System.out.println("\n================ PLAYER =====================");
            wr.info();
            System.out.println("\n================= MUSUH =====================");
            ttn.info();
            break;
        }

    }
}
abstract class Character{
    int defense;
    int attack;
    int HP;
    int sisaHP;
    int randomVal;
 public Character(){  
    }
  public Character(int HP, int attack, int defense){
      this.HP = HP;
      this.attack = attack;
      this.defense = defense;
  }
   abstract boolean attack();
   abstract void receiveDemage(int damage);
   abstract void info();
    
   public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
    
    class Titan extends Character{
        static int sisa;
        public Titan(){
        }
    
        public Titan(int HP, int attack, int defense){
            super(HP,attack,defense);

    }
     @Override
        boolean attack() {
           if(randomVal>=1 && randomVal<=4){
               return true;
           }else {
               return false;
           } 
     }
     
    @Override
     void receiveDemage(int damage){
       if(getHP()>=damage){
           if(attack>=defense){
           sisa = getHP() - damage;
           setHP(sisa);
           getHP();
           }else{
           getHP();
         }
    } else{
           setHP(0);
           getHP();  
       }
    
    }
    @Override
    void info(){
System.out.print("----------------- STATUS -----------------\n");
System.out.println("Role    : Titan");
System.out.println("HP      : " + getHP());
System.out.println("Attack  : " + getAttack());
System.out.println("Defense : "+ getDefense());
    }    
    }

    class Magician extends Character{
        static int sisa;
        
    public Magician(){
    }
    
    public Magician(int HP, int attack, int defense){
        super(HP,attack, defense);
    }
     @Override
        boolean attack() {
         if(randomVal>=1 && randomVal<=4){
               return true;
           }else {
               return false;
           } 
     }    
    @Override
     void receiveDemage(int damage){
       if(getHP()>= damage){
           if(damage>=defense){
           sisa = getHP() - (damage-defense);
           setHP(sisa);
           getHP();
           }else{
           getHP();
         }
    } else{
           setHP(0);
           getHP();
           
       }
       }
    @Override
    void info(){
     System.out.print("----------------- STATUS -----------------\n");
System.out.println("Role    : Magician");
System.out.println("HP      : " + getHP());
System.out.println("Attack  : " + getAttack());
System.out.println("Defense : "+ getDefense());   
    }
     } 
    class Healer extends Character{
        static int sisa;
        
  public Healer(){
  }
        
   public Healer(int HP, int attack, int defense){
    super(HP, attack, defense);
    }
     @Override
        boolean attack() {
         if(randomVal>=1 && randomVal<=8){
               return true;
           }else {
               return false;
           } 
        }
   void heal(){  
      Healer hl = new Healer();
      setHP(getHP()+25);
    }
    @Override
         void receiveDemage(int damage){
       if(getHP()>= damage){
           if(damage>=defense){
           sisa = getHP() - (damage-defense);
           setHP(sisa);
           getHP();
           }else{
           getHP();
         }
    } else{
           setHP(0);
           getHP();
           
       }
    }
    @Override
    void info(){
System.out.print("----------------- STATUS -----------------\n");
System.out.println("Role    : Healer");
System.out.println("HP      : " + getHP());
System.out.println("Attack  : " + getAttack());
System.out.println("Defense : "+ getDefense());     
    }
    }
    class Warior extends Character{
       static int sisa;
   
   public Warior(int HP, int attack, int defense){
   super(HP, attack, defense);
    }
     @Override
        boolean attack() {
         if(randomVal>=1 && randomVal<=6){
               return true;
           }else {
               return false;
           } 
        }
    @Override
    void receiveDemage(int damage){
       if(getHP()>= damage){
           if(damage>=defense){
           sisa = getHP() - (damage-defense);
           setHP(sisa);
           getHP();
           }else{
           getHP();
         }
    } else{
           setHP(0);
           getHP();
       }
    }
    @Override
    void info(){
System.out.print("----------------- STATUS -----------------\n");
System.out.println("Role    : Warrior");
System.out.println("HP      : " + getHP());
System.out.println("Attack  : " + getAttack());
System.out.println("Defense : "+ getDefense());    
    }  
    }
