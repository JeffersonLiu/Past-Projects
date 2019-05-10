public class Animal{
  private String name;
  private boolean tired;
  private boolean hungry;
  private double weight;
  
  public Animal (String n,double w){
    name = n;
    tired = true;
    hungry = true;
    weight  = w;
  }
  
  public void feed(String v){
    hungry = false;
    if (v.equals ("vegetables")){
      weight += 2;
    }
    if (v.equals ("meat")){
      weight+= 4;
    }
    else{
      weight += 1;
    }
  }
  
  public void sleep(){
    tired = false;
    weight -= 3;
  }
  
    public static void main(String[] args){
      Animal dog = new Animal("doge", 10.0);
      Animal cat = new Animal("cate", 10.0);
      Animal gerbil = new Animal("gerb", 10.0);
      Animal bird = new Animal("birb", 10.0);
      Animal hamster = new Animal("ham", 10.0);
      dog.feed("meat");
      dog.sleep();
      System.out.println(dog.weight);
  }
}
  
  