public class CarEval{
  private String brand;
  private String model;
  private int  kilometers;
  private double gas;
  private double tankCapacity;
  
  public CarEval (String b, String m, double g, double tCap){
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
  
  public String getInfo(){
    return brand + " " +model;
  }
  
  public static void main(String[] args){
    CarEval car1 = new CarEval("tesla", "x", 0.0, 0.0);
    CarEval car2 = new CarEval("honda", "civic", 0.0, 0.0);
    car1.drive(30);
    car1.gasUp();
    System.out.println (car1.getInfo());
  }
}

      
      