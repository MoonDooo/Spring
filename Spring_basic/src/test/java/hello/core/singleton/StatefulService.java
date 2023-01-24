package hello.core.singleton;

public class StatefulService {

    private int price; //필드 상태를 유지함 -> Error

    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
}
