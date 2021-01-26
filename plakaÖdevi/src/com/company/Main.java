package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.print("Plaka giriniz : ");
        Scanner scan = new Scanner(System.in);
        int ilKodu = 0;
        String plakaOrtasi = "";
        int plakaSonu = 0;
        String[] plaka = scan.nextLine().split(" ");


        /**
         * Plaka icin gerekli olan seyler:
         * Plaka ayristirdigimizda 3 parca olacak
         * ilk parca 2 basamakli olacak ve kesinlikle sayi olacak
         * ikinci sadece harf olacak en fazla 3 basamakli olacak, i ö ü ğ bu karakterler icinde olmayacak.
         * ucuncu parca sadece sayi olacak en fazla 4 basamakli olacak
         */


        /**
         0 -> Bu bir plaka degil.
         1 -> Il kodu hatali.
         2 -> Plaka ortasi hatali
         3 -> Plaka sonu hatali
         */


        //Plaka 3 parca olacak
        if (plaka.length != 3){
            hataKoduYazdir(0);
        } else{
            // ilk parca 2 basamakli olacak ve kesinlikle sayi olacak
            String ilkParca = plaka[0];
            if(ilkParca.length() == 2 && isInt(ilkParca)){
                ilKodu = Integer.parseInt(ilkParca);
                //il kodu 01 ile 81 arasinda olmak zorundadir
                if(ilKodu > 0 && ilKodu < 82){
                    //ikinci sadece harf olacak en fazla 3 basamakli olacak, i ö ü ğ bu karakterler icinde olmayacak.
                    String ikinciParca = plaka[1];
                    if(isPlakaOrtasi(ikinciParca)){
                        plakaOrtasi = ikinciParca;
                        //ucuncu parca sadece sayi olacak en fazla 4 basamakli olacak
                        String ucuncuParca = plaka[2];
                        if(isInt(ucuncuParca) && ucuncuParca.length() <= 4){
                            plakaSonu = Integer.parseInt(ucuncuParca);
                            plakaYazdir(ilKodu, plakaOrtasi, plakaSonu);
                        }else {
                            hataKoduYazdir(3);
                        }
                    }else {
                        hataKoduYazdir(2);
                    }
                }
            }else{
                hataKoduYazdir(1);
            }
        }
    }


    public static void hataKoduYazdir(int hataKodu){
        switch (hataKodu){
            case 0:
                System.out.println("Bu bir plaka degil.");
                break;
            case 1:
                System.out.println("Il kodu hatali.");
                break;
            case 2:
                System.out.println("Plaka ortasi hatali");
                break;
            case 3:
                System.out.println("Plaka sonu hatali");
                break;
            default:
                System.out.println("Bu bir plaka degil.");
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

    public static boolean isPlakaOrtasi(String s){
        if(s.length() > 3)
            return false;
        String yasak = "İÖÜĞ";
        for (int i = 0; i < s.length(); i++) {
            if(!Character.isAlphabetic(s.charAt(i)) || yasak.indexOf(s.charAt(i)) != -1){
                return false;
            }
        }
        return true;
    }

    public static void plakaYazdir(int ilKodu, String plakaOrtasi, int plakaSonu){
        String[] iller = {
                "Adana", "Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin", "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "İçel (Mersin)", "İstanbul", "İzmir", "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "K.maraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize", "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Şanlıurfa", "Uşak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale", "Batman", "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye", "Düzce"
        };
        // il dizisinden il ismini cek

        System.out.println("Bu plaka " + iller[ilKodu-1] + " iline aittir, plakamiz: " + ilKodu + " " + plakaOrtasi + " " + plakaSonu);
    }
}

