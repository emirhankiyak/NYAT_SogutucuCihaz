public class SicaklikAlgilayici {
    private static int sicaklikDegeri;

    public SicaklikAlgilayici() {
        setSicaklikDegeri((int)(Math.random()*51));
    }

    public static int getSicaklikDegeri() {
        return sicaklikDegeri;
    }

    public static void setSicaklikDegeri(int sicaklikDegeri) {
        SicaklikAlgilayici.sicaklikDegeri = sicaklikDegeri;
    }

    public static void sicaklikAlgila(){
        System.out.println("Anlık  Sıcaklık Değeri : " + getSicaklikDegeri());
    }
}
