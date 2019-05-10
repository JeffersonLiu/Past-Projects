public class itemSearcher
{
  
   static boolean searchItem(Comparable[] array, int cursor) {
        if (cursor == array.length - 1)
            return false;
        if (array[cursor].compareTo(array[array.length - 1]) == 0)//searches for the last index
            return true;
        return searchItem(array, cursor + 1);
    }
      
    
    
    
    public static void main (String[] main)
  {
      String [] example = {"1","2","1"};
    System.out.println(searchItem(example,0));
  }
}