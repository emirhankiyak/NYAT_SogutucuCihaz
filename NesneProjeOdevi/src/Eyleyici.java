import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Eyleyici extends Observable{
    private static boolean acikKapali=false;
    private static void setAcikKapali(boolean acikKapali) {
        Eyleyici.acikKapali = acikKapali;
    }
    public void sogutucuAc(){
        if(acikKapali){
            System.out.println("Soğutucu zaten açık!");
        }else{
            Scanner input = new Scanner(System.in);
            int kullaniciSicaklik;
            System.out.print("Kaç dereceye getirmek istiyorsunuz?");
            kullaniciSicaklik = input.nextInt();
            if(kullaniciSicaklik>SicaklikAlgilayici.getSicaklikDegeri()){
                System.out.println("Sıcaklık, girdiğiniz değerin altında!");
            }else{
                System.out.println("Soğutucu çalışıyor...");
                setAcikKapali(true);
                while(kullaniciSicaklik != SicaklikAlgilayici.getSicaklikDegeri()){
                    SicaklikAlgilayici.setSicaklikDegeri(SicaklikAlgilayici.getSicaklikDegeri()-1);
                    SicaklikAlgilayici.sicaklikAlgila();
                    if(kullaniciSicaklik == SicaklikAlgilayici.getSicaklikDegeri()){
                        Eyleyici.ekle(AgArayuzu.kullanici);
                        haberVer();
                        System.out.println("Soğutucu otomatik olarak kapatılacak!");
                        sogutucuKapat();
                        break;
                    }
                }
            }

        }
    }
    public void sogutucuKapat(){
        if(acikKapali){
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Soğutucu kapandı");
                setAcikKapali(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Soğutucu zaten kapalı!");
        }
    }
}
