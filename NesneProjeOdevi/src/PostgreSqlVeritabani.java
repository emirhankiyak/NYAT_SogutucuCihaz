import java.sql.*;
import java.util.Scanner;

public class PostgreSqlVeritabani implements IVeritabaniServisi{
    private final String url = "jdbc:postgresql://localhost:5432/kullanicilar";
    private static Connection connection;

    @Override
    public void baglan() {
        try {
            connection = DriverManager.getConnection(url,"postgres","123456");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void baglantiyiSonlandir() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean kullaniciSorgula(String kullaniciAdi, String sifre) {
        String sorgu = "select *from kullanici where kullaniciadi ='" + kullaniciAdi + "'" + " and sifre='" + sifre + "'";
        String yedekKullanici="";
        String yedekSifre="";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sorgu);
            while (rs.next()){
                yedekKullanici = rs.getString("kullaniciadi");
                yedekSifre = rs.getString("sifre");
            }
            if(kullaniciAdi.equals(yedekKullanici) && sifre.equals(yedekSifre)) return true;
            else return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }
    public static void kullaniciKaydet(){
        String isim;
        String soyisim;
        int yas;
        String eposta;
        String kullaniciAdi;
        String sifre;
        String okul;
        String meslek;
        Kullanici kullanici;
        boolean kontrol=false;

        Scanner input = new Scanner(System.in);

        System.out.print("[Zorunlu] İsim : ");
        isim = input.nextLine();
        System.out.print("[Zorunlu] Soyisim : ");
        soyisim = input.nextLine();
        System.out.print("[Zorunlu] E-posta : ");
        eposta = input.nextLine();
        System.out.print("[Zorunlu] Kullanıcı adı : ");
        kullaniciAdi=input.nextLine();
        System.out.print("Zorunlu] Şifre : ");
        sifre = input.nextLine();
        System.out.print("[Opsiyonel] Okul : ");
        okul = input.nextLine();
        System.out.print("[Opsiyonel] Meslek : ");
        meslek = input.nextLine();
        System.out.print("[Opsiyonel] Yaş : ");
        yas = input.nextInt();
        kullanici = KullaniciBuilder.startBuild()
                .setIsim(isim)
                .setSoyisim(soyisim)
                .setYas(yas)
                .setEposta(eposta)
                .setKullaniciAdi(kullaniciAdi)
                .setSifre(sifre)
                .setOkul(okul)
                .setMeslek(meslek)
                .build();

        String eklemeSorgu = "insert into kullanici(isim,soyisim,yas,eposta,kullaniciadi,sifre,okul,meslek) values('"+kullanici.getIsim() + "','"
                + kullanici.getSoyisim() + "'," + kullanici.getYas() + ",'" + kullanici.getEposta() + "','" + kullanici.getKullaniciAdi()
                +"','"+kullanici.getSifre()+"','"+kullanici.getOkul()+"','"+kullanici.getMeslek()+"')";
        try {
            Statement statement = connection.createStatement();
            statement.execute(eklemeSorgu);
            System.out.println("Kayıt işlemi başarıyla tamamlandı");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Kayıt işlemi gerçekleştirilemedi");
        }
    }
    public static Kullanici verileriIsle(String kullaniciAdi, String sifre){
        String sorgu = "select *from kullanici where kullaniciadi ='" + kullaniciAdi + "'" + " and sifre='" + sifre + "'";
        String yedekKullanici="";
        String yedekSifre="";
        String yedekIsim="";
        String yedekSoyisim="";
        int yedekYas=0;
        String yedekEposta="";
        String yedekOkul="";
        String yedekMeslek="";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sorgu);
            while (rs.next()){
                yedekKullanici = rs.getString("kullaniciadi");
                yedekSifre = rs.getString("sifre");
                yedekIsim = rs.getString("isim");
                yedekSoyisim = rs.getString("soyisim");
                yedekYas = rs.getInt("yas");
                yedekEposta = rs.getString("eposta");
                yedekOkul = rs.getString("okul");
                yedekMeslek = rs.getString("meslek");

            }
            if(kullaniciAdi.equals(yedekKullanici) && sifre.equals(yedekSifre)){
                Kullanici kullanici = new Kullanici(yedekIsim,yedekSoyisim,yedekYas,yedekEposta,yedekKullanici,yedekSifre,yedekOkul,yedekMeslek);
                return kullanici;
            }
            else return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
