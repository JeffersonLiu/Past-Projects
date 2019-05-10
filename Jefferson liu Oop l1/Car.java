public class Car{
  private String brand;
  private String model;
  private int  kilometers;
  private double gas;
  private double tankCapacity;
  
  public Car (String b, String m, double g, double tCap){
    brand = b;
    model =m;
    kilometers = 0;
    gas = g;
    tankCapacity = tCap;
  }
  
  public void drive(double distance){
    kilometers += distance;
    gas -= distance/5;
  }
  
  public void gasUp(){
    gas = tankCapacity;
  }
  
  public static void main(String[] args){
    Car car1 = new Car("tesla", "x", 0.0, 0.0);
    Car car2 = new Car("honda", "civic", 0.0, 0.0);
    Car car3 = new Car("acura", "tlx", 0.0, 0.0);
    Car car4 = new Car("mercedes", "glc", 0.0, 0.0);
    Car car5 = new Car("tesla", "s", 0.0, 0.0);
    car1.drive(30);
    car1.gasUp();
  }
}

      
      
      