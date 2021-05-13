public class Kullanici implements Observer{
    private String isim;
    private String soyisim;
    private int yas;
    private String eposta;
    private String kullaniciAdi;
    private String sifre;
    private String okul;
    private String meslek;

    public Kullanici(){

    }

    public Kullanici(String isim, String soyisim, int yas, String eposta, String kullaniciAdi, String sifre, String okul, String meslek) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.yas = yas;
        this.eposta = eposta;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.okul = okul;
        this.meslek = meslek;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getOkul() {
        return okul;
    }

    public void setOkul(String okul) {
        this.okul = okul;
    }

    public String getMeslek() {
        return meslek;
    }

    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }

    @Override
    public void update(Observable observable) {
        System.out.println("["+AgArayuzu.kullanici.getKullaniciAdi()+"]" + " kullanıcısına haber veriliyor: İstenen değere ulaştı.");
    }
}
