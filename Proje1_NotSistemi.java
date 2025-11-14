//Adı Soyadı : Muhammed Metin Kızıl
//Öğrenci no : 250541038

package NotSistemi;
import java.util.Scanner;

public class NotSistemi {

    public static double calculateAverage(int vize_notu, int final_notu, int odev_notu) {
        double ortalama = vize_notu * 0.3 + final_notu * 0.4 + odev_notu * 0.3;
        return ortalama;
    }

    public static boolean isPassingGrade(double ortalama) {
        if (ortalama >= 50) {
            return true;
        } else {
            return false;
        }
    }

    public static String gerLetterGrade( double ortalama) {
        String harf_notu = "GEÇERSİZ";

        if (ortalama >= 90 && ortalama <= 100) {
            harf_notu = "A";
        } else if (ortalama >= 80 && ortalama < 90) {
            harf_notu = "B";
        } else if (ortalama >= 70 && ortalama < 80) {
            harf_notu = "C";
        } else if (ortalama >= 60 && ortalama < 70) {
            harf_notu = "D";
        } else {
            harf_notu = "F";
        }
        return harf_notu;

    }
    public static boolean isHonorList(double ortalama, int odev_notu, int vize_notu, int final_notu) {
        if (ortalama >= 85 && final_notu >= 70 && vize_notu >= 70 && odev_notu >= 70 ) {
            return true;
        }else  {
            return false;
        }
    }
    public static boolean hasRetakeRight(double ortalama) {
        if (40<=ortalama && ortalama < 50 ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int vize_notu, final_notu, odev_notu;

        System.out.print("Vize notunu girin: ");
        vize_notu = new Scanner(System.in).nextInt();
        System.out.print("Final notunu girin: ");
        final_notu = new  Scanner(System.in).nextInt();
        System.out.print("Ödev notunu girin: ");
        odev_notu = new  Scanner(System.in).nextInt();

        System.out.print("=== OGRENCİ NOT RAPORU ===");
        System.out.println("Vize Notu:" + vize_notu);
        System.out.println("Final Notu:" + final_notu);
        System.out.println("Ödev NOtu:" + odev_notu);
        System.out.println("---------------------");
        double ortalama = calculateAverage(vize_notu, final_notu, odev_notu);
        System.out.println("Ortalama: " + ortalama);
        System.out.println("Harf Notu: "+ gerLetterGrade(ortalama));
        if(isPassingGrade(ortalama)){
            System.out.println("Durum: GEÇTİ");
        }
        else{
            System.out.println("Durum: KALDI");
        }
        System.out.println("Onur Listesi: " + (isHonorList(ortalama, vize_notu, final_notu, odev_notu)== true ? "EVET" : "HAYIR"));
    }
}
