import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class AgArayuzu {
    public static Kullanici kullanici;
    public static void hosgeldinEkrani(){
        Scanner input = new Scanner(System.in);
        int secim;
        do{
            System.out.println("----------------------------------------");
            System.out.println("   Akıllı Cihaz Arayüzüne Hoşgeldiniz");
            System.out.println("----------------------------------------");
            System.out.println("[1] -> Giriş Yap");
            System.out.println("[2] -> Kayıt ol");
            System.out.println("[3] -> Cihazı kapat");
            System.out.println("----------------------------------------");
            System.out.print("Lütfen bir seçim yapınız:");
            secim = input.nextInt();
            switch (secim){
                case 1:
                    kullaniciGirisi();
                    break;
                case 2:
                    PostgreSqlVeritabani.kullaniciKaydet();
                    hosgeldinEkrani();
                    break;
                case 3:
                    try {
                        System.out.println("Cihaz kapanıyor...");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Cihaz kapandı.");
                        System.exit(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Yanlış seçim!");
                    break;
            }
        }while(secim != 3);
    }
    private static void kullaniciGirisi(){
        Scanner input = new Scanner(System.in);
        String kullaniciAdi = "";
        String sifre = "";
        boolean varMi = false;
        System.out.print("Kullanıcı adı:");
        kullaniciAdi = input.nextLine();
        System.out.print("Şifre:");
        sifre = input.nextLine();
        varMi=PostgreSqlVeritabani.kullaniciSorgula(kullaniciAdi,sifre);
        if(varMi) {
            try {
                kullanici = PostgreSqlVeritabani.verileriIsle(kullaniciAdi,sifre);
                System.out.println("Giriş yapılıyor...");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Hoşgeldiniz : " + kullanici.getIsim() + " " + kullanici.getSoyisim());
                menuGoster();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Kullanıcı adı veya parola hatalı! Lütfen tekrar giriş yapınız.");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            kullaniciGirisi();
        }
    }
    private static void menuGoster() throws InterruptedException {
        int secim;
        String devamMi="";
        Scanner input = new Scanner(System.in);
        Eyleyici eyleyici = new Eyleyici();
        do{
            System.out.println("------------------------------------");
            System.out.println("       AKILLI CİHAZ MENÜSÜ");
            System.out.println("------------------------------------");
            SicaklikAlgilayici.sicaklikAlgila();
            System.out.println("[1] -> Soğutucu aç");
            System.out.println("[2] -> Soğutucu kapat");
            System.out.println("[3] -> Çıkış yap");
            System.out.println("[4] -> Cihazı kapat");
            System.out.println("------------------------------------");
            System.out.print("Menüden bir seçim yapınız:");
            secim = input.nextInt();
            switch (secim){
                case 1:
                    eyleyici.sogutucuAc();
                    System.out.print("Akıllı cihaz menüsüne dönmek istiyor musunuz? [E/H] -->");
                    devamMi = input.next();
                    devamMi = devamMi.toLowerCase();
                    break;
                case 2:
                    eyleyici.sogutucuKapat();
                    System.out.print("Akıllı cihaz menüsüne dönmek istiyor musunuz? [E/H] -->");
                    devamMi = input.next();
                    devamMi = devamMi.toLowerCase();
                    break;
                case 3:
                    System.out.println("Çıkış yapılıyor...");
                    TimeUnit.SECONDS.sleep(1);
                    break;
                case 4:
                    System.out.println("Cihaz kapanıyor...");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Cihaz kapandı.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print("Akıllı cihaz menüsüne dönmek istiyor musunuz? [E/H] -->");
                    devamMi = input.next();
                    devamMi = devamMi.toLowerCase();
                    break;
            }
        }while(devamMi.equals("e"));
    }
}
