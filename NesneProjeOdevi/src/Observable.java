import java.util.ArrayList;

public abstract class Observable {
    private static ArrayList<Observer> observerList;
    public Observable(){
        observerList = new ArrayList<Observer>();
    }
    public static void ekle(Observer observer){
        observerList.add(observer);
    }
    public static void cikar(Observer observer){
        observerList.remove(observer);
    }
    public void haberVer(){
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }
}
