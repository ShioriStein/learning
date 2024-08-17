package core;


class WaterJug {
    private int waterQuantity = 500;
    private WaterJug(){}
    private static WaterJug object = null;

    // Method to provide the service of Giving Water.
    public int getWater(int quantity){
        waterQuantity -= quantity;
        return quantity;
    }
    // Method to return the object to the user.
    public static WaterJug getInstance(){
        // Will Create a new object if the object is not already created and return the object.
        if(object == null){
            object = new WaterJug();
        }
        return object;
    }
}

public class SingletonEx {
    public static void main(String[] args) {
        WaterJug glass1 = WaterJug.getInstance();
        System.out.println(glass1.getWater(1));
    }
}
