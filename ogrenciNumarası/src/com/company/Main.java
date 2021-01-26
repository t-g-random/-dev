package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.print("Ogr Numarasi giriniz : ");
        Scanner scan = new Scanner(System.in);
        String ogrNo = scan.nextLine();
        dogrulama(ogrNo);

        /**
         * ogrenci numarasi 9 hanelidir ona bakilacak ve kesinlikle sayi olacak
         * ogrenci numarasinin ilk iki hanesi yili temsil eder ve suan ki yildan buyuk olamaz
         * ogenci numarasinin 3, hanesi ya 0 ya da 5 olabilir
         * ogrenci numara
         */
    }

    public static boolean dogrulama(String ogrNo){
        if(!isInt(ogrNo)){
            hataKoduYazdir(0);
            return false;
        }else if(ogrNo.length() != 9){
            hataKoduYazdir(1);
            return false;
        }else{
            int yil = Integer.parseInt(ogrNo.substring(0,2));
            int ogretimKodu = Integer.parseInt(ogrNo.substring(2,3));
            int bolumKodu = Integer.parseInt(ogrNo.substring(3,6));
            int siralama = Integer.parseInt(ogrNo.substring(6,9));

            int suankiYil = Calendar.getInstance().get(Calendar.YEAR);
            suankiYil = Integer.parseInt(String.valueOf(suankiYil).substring(2,4));
            if ( yil > suankiYil){
                hataKoduYazdir(2);
                return false;
            }
            //birinci ogretim ve ikinci ogretim kontrolu
            if (ogretimKodu ==5 || ogretimKodu ==0){
                if(bolumBilgisiGetir(String.valueOf(bolumKodu)).equals("-1")){
                    hataKoduYazdir(4);
                    return false;
                }else{
                    // istenilenleri yazdiriyoruz
                    ogrNoBilgileriYazdir(yil,ogretimKodu,bolumKodu,siralama);
                }
            }else {
                hataKoduYazdir(3);
                return false;
            }
        }
        return true;
    }

    public static void ogrNoBilgileriYazdir(int yil,int ogretimKodu, int bolumKodu, int siralama ){
        System.out.println("Ogrenci 20" + yil + " yilinda universiteye girmistir");
        if(ogretimKodu == 0)
            System.out.println("Birinci ogretimdir");
        else
            System.out.println("Ikinci ogretimdir");

        System.out.println("Ogrencinin Bolumu:" + bolumBilgisiGetir(String.valueOf(bolumKodu)));
        System.out.println("Ogrencinin Siralamasi:" + siralama);
    }

    public static void hataKoduYazdir(int hataKodu){
        switch (hataKodu){
            case 0:
                System.out.println("Ogr numarasi karakter iceremez");
                break;
            case 1:
                System.out.println("Ogr numarasi 9 karakter olmalidir");
                break;
            case 2:
                System.out.println("Ogrenci numarasinda yil bilgisi yanlis");
                break;
            case 3:
                System.out.println("Ogr numarasinda ogretim kodu yanlis.");
                break;
            case 4:
                System.out.println("Ogr numarasinda bulunan bolum kodu yanlis");
                break;
            default:
                System.out.println("Bu bir ogr numarasi degil.");
                break;
        }

    }

    public static boolean isInt(String s){
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static String bolumBilgisiGetir(String bolumKodu){
        try{
            //absolute path
            File myObj = new File("C:\\Users\\USER\\İntellıj İde\\ogrenciNumarası\\src\\com\\company\\bolumKodları");
            Scanner reader = new Scanner(myObj);
            while (reader.hasNextLine()){
                String bolumDetayi = reader.nextLine();
                if (bolumDetayi.contains(bolumKodu)){
                    return bolumDetayi.split("=")[1];
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Dosya Okunamadi");
            e.printStackTrace();
        }
        return "-1";
    }


}