public class KullaniciBuilder {
    private String isim;
    private String soyisim;
    private int yas;
    private String eposta;
    private String kullaniciAdi;
    private String sifre;
    private String okul;
    private String meslek;

    public static KullaniciBuilder startBuild(){
        return new KullaniciBuilder();
    }
    public Kullanici build(){
        Kullanici kullanici = new Kullanici();
        kullanici.setIsim(isim);
        kullanici.setSoyisim(soyisim);
        kullanici.setYas(yas);
        kullanici.setEposta(eposta);
        kullanici.setKullaniciAdi(kullaniciAdi);
        kullanici.setSifre(sifre);
        kullanici.setOkul(okul);
        kullanici.setMeslek(meslek);
        return kullanici;
    }

    public KullaniciBuilder setIsim(String isim) {
        this.isim = isim;
        return this;
    }

    public KullaniciBuilder setSoyisim(String soyisim) {
        this.soyisim = soyisim;
        return this;
    }

    public KullaniciBuilder setYas(int yas) {
        this.yas = yas;
        return this;
    }

    public KullaniciBuilder setEposta(String eposta) {
        this.eposta = eposta;
        return this;
    }

    public KullaniciBuilder setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
        return this;
    }

    public KullaniciBuilder setSifre(String sifre) {
        this.sifre = sifre;
        return this;
    }

    public KullaniciBuilder setOkul(String okul) {
        this.okul = okul;
        return this;
    }

    public KullaniciBuilder setMeslek(String meslek) {
        this.meslek = meslek;
        return this;
    }
}
