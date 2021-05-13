public class Cihaz {
    public static void main(String[] args) throws InterruptedException {
        basla();
    }
    public static void basla(){
        IVeritabaniServisi veritabani = new PostgreSqlVeritabani();
        veritabani.baglan();
        SicaklikAlgilayici algilayici = new SicaklikAlgilayici();
        AgArayuzu.hosgeldinEkrani();
        veritabani.baglantiyiSonlandir();
    }
}
