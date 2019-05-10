public class House{
  private int  street_num;
  private String street;
  private String city;
  private String province;
  private String postal_code;
  private double size;
  private boolean detached;
  private int stories;
  
  public House (int n, String s, String  c, String pv ,String p,double si, boolean d, int l ){
    street_num = n;
    street =s;
    city = c;
    province = pv;
    postal_code = p;
    size = si;
    detached = d;
    stories = l;
  }
  
  public void displayAddress(){
    //displays the address, street num, street, city, province, and postal code.
    System.out.println(street_num + " " + street);
    System.out.println(city + " " + province);
    System.out.println(postal_code);
  }
    public static void main(String[] args){
    House house1 = new House(1, "yonge", "toronto", "Ontario" ,"a2e2t5",100.0, true, 2);
    House house2 = new House(2, "yonge", "toronto", "Ontario" ,"a3e4t6",200.0, true, 3);
    House house3 = new House(3, "yonge", "toronto", "Ontario" ,"a4e3t1",300.0, true, 2);
    House house4 = new House(4, "yonge", "toronto", "Ontario" ,"a5e2t8",400.0, true, 1);
    House house5 = new House(5, "yonge", "toronto", "Ontario" ,"a6e2t2",500.0, true, 3); 
    house1.displayAddress();
  }
}
      