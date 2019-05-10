class Jacket{
  Student owner;
  Jacket (Student me){
    owner = me;
  }
  String toString(){
    return "The owner of this jacket is "+ owner;
  }
}