//Adı Soyadı: Muhammed Metin Kızıl
//Öğrenci No : 250541038
//Taih : 15.11.2025


import java.util.Scanner;

public class SinemaBileti {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===================Gün Seçimi===================");
        System.out.println("1=pzt, 2=sal, 3=çar, 4=per, 5=cuma, 6=cmt, 7=pzr");
        System.out.print("Gün Seçimi(1-7): ");
        int gün = scanner.nextInt();

        System.out.println("Saat Giriniz (8-23 arası): ");
        int saat = scanner.nextInt();

        System.out.print("Yaşınızı giriniz: ");
        int yas = scanner.nextInt();

        System.out.println("=========Meslek Seçimi=========");
        System.out.println("1= Öğrenci, 2=Öğretmen, 3=Diğer");
        int meslek = scanner.nextInt();

        System.out.println("=========Film Türü Seçimi===========");
        System.out.println("1=2D, 2=3D, 3=IMAX, 4=4DX");
        int filmTuru = scanner.nextInt();


        //HESAPLAMALAR
        double temelFiyat = calculateBasePrice(gün, saat);

        double indirimMiktarı = calculateDiscount(temelFiyat, yas, meslek, gün);

        double formatEkstra = getFormatExtra(filmTuru);

        double sonFiyat = calculateFinalPrice(temelFiyat, indirimMiktarı, formatEkstra);

        generateTicketInfo(gün, saat, yas, meslek, filmTuru, temelFiyat, indirimMiktarı, formatEkstra, sonFiyat);

        scanner.close();

    }

        public static boolean isWeekend(int gun){
            return (gun == 6 || gun == 7 );
    }

        public static boolean isMatinee(int saat){
            return( saat < 12);
    }
        public static double calculateBasePrice(int gün, int saat){
        boolean haftaSonu = isWeekend(gün);
        boolean matinee = isMatinee(saat);
        if(haftaSonu){
            if(matinee){
                return 55.0;
            }else{
                return 85.0;
            }
        }else{
            if(matinee){
                return 45.0;
            }else
                return 65.0;
        }
    }


    public static double calculateDiscount(double basePrice, int yas, int meslek, int gün){
        double indirimOranı = 0.0;

        if (yas <= 12){
            indirimOranı = Math.max(indirimOranı , 0.25);
        }
        if (yas >= 65 ){
            indirimOranı = Math.max(indirimOranı, 0.30);
        }

        switch (meslek){
            case 1:

                if (isWeekend(gün)){
                    indirimOranı = Math.max(indirimOranı,0.15);
                }else {
                    indirimOranı = Math.max(indirimOranı,0.20);
                }
                break;
            case 2:
                if ( gün==3){
                    indirimOranı = Math.max(indirimOranı,0.35);
                }
                break;
            case 3:
            default:
                break;

        }
        return basePrice * indirimOranı;
    }

    public static double getFormatExtra(int filmTuru){
        switch (filmTuru){
            case 2:
                return 25.0;
            case 3:
                return 35.0;
            case 4:
                return 50.0;
            case 1:
            default:
                return 00.0;
        }
    }


    public static double calculateFinalPrice(double basePrice, double discountAmount, double frmatExtra){
        double indirimliFiyat = basePrice - discountAmount;
        return indirimliFiyat + frmatExtra;
    }


    public static void generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru, double temelFiyat, double indirimMiktari, double formatEkstra, double sonFiyat){
        String gunAdi = getGunAdi(gun);
        String meslekAdi = getMeslekAdi(meslek);
        String filmTuruAdi = getFilmTuruAdi(filmTuru);
        String seansTipi = isMatinee(saat) ? "Matine (12:00 öncesi)" : "Normal";

        System.out.println("\n=====BİLET BİLGİLERİNİZ=====");
        System.out.println("Tarih/Seans: " + gunAdi + ", Saat: " + saat + ":00 (" + seansTipi + ")");
        System.out.println("Kişi Bilgisi: Yaş " + yas + " (" + meslekAdi + ")");
        System.out.println("Film Formatı: " + filmTuruAdi);
        System.out.println("======================");
        System.out.println("Hesaplama Detayları:");
        System.out.println("* Temel Fiyat: " + temelFiyat + " TL (" + (isWeekend(gun) ? "Hafta Sonu" : "Hafta İçi") + " " + seansTipi + ")");

        if(indirimMiktari > 0){
            System.out.println("* Uygulanan İndirim (" + meslekAdi + "/" + "Yaş): -" + indirimMiktari + " TL");
            System.out.println("* İndirimli Fiyat: " + (temelFiyat - indirimMiktari) + " TL");
        } else {
            System.out.println("* İndirim Uygulanmadı.");
        }

        if(formatEkstra > 0){
            System.out.println("* Film Türü Ekstra: +" + formatEkstra + " TL (" + filmTuruAdi + ")");
        }
        System.out.println("---------------------------");
        System.out.println("TOPLAM FİYAT: " + sonFiyat + " TL");
    }

    public static String getGunAdi(int gunAdi){
        switch (gunAdi){
            case 1: return "pazartessi";
            case 2: return "salı";
            case 3: return "çarşamba";
            case 4: return "perşembe";
            case 5: return "cuma";
            case 6: return "cumartesi";
            case 7: return "pazar";
            default: return "Bilinmeyen";
        }
    }

    public static String getMeslekAdi(int meslekAdi){
        switch (meslekAdi){
            case 1: return "öğrenci";
            case 2: return "Öğretmen";
            case 3: return "Diğer";
            default:return "Bilinmeyen";
        }
    }

    public static String getFilmTuruAdi(int filmTuru){
        switch (filmTuru){
            case 1: return "2D";
            case 2: return "3D";
            case 3: return "IMAX";
            case 4: return "4DX";
            default: return "Bilinmeyen";
        }
    }

}

