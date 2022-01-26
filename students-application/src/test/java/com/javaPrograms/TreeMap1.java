package com.javaPrograms;
import java.util.*;  

class TreeMap1{  
 public static void main(String args[]){  
   TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
      map.put(100,"Amit");    
      map.put(102,"Ravi");    
      map.put(101,"Vijay");
      map.put(105, "Rahul");
      map.put(103,"Rahul");    
      
      //Printing all keys
      System.out.println("All keys :"+map.keySet());
      
      //Printing all values
      System.out.println("All values :"+map.values());
        
      for(Map.Entry m:map.entrySet()){    
       System.out.println(m.getKey()+" "+m.getValue());    
      }    
      
      //Output :
      /*100 Amit
      101 Vijay
      102 Ravi
      103 Rahul*/
      
      System.out.println("Before invoking remove() method");  
      for(Map.Entry m:map.entrySet())  
      {  
          System.out.println(m.getKey()+" "+m.getValue());      
      }  
      
      //Output :
      /*Before invoking remove() method
      100 Amit
      101 Vijay
      102 Ravi
      103 Rahul
      105 Rahul*/
      
      map.remove(102);      
      System.out.println("After invoking remove() method");  
      for(Map.Entry m:map.entrySet())  
      {  
          System.out.println(m.getKey()+" "+m.getValue());      
      }  
      
      //Output :
      /*After invoking remove() method
      100 Amit
      101 Vijay
      103 Rahul
      105 Rahul*/
      
      //Maintains descending order  
      System.out.println("descendingMap: "+map.descendingMap()); 
      //Output :
      //descendingMap: {105=Rahul, 103=Rahul, 101=Vijay, 100=Amit}
      
      //Returns key-value pairs whose keys are less than the specified key.  
      System.out.println("headMap: "+map.headMap(102)); 
      //Output :
      //headMap: {100=Amit, 101=Vijay}
      
      //Returns key-value pairs whose keys are less than or equal to the specified key.  
      System.out.println("headMap: "+map.headMap(102,true));  
      //Output :
      //headMap: {100=Amit, 101=Vijay}
      
      //Returns key-value pairs whose keys are greater than or equal to the specified key.  
      System.out.println("tailMap: "+map.tailMap(102));
      //Output :
      //tailMap: {103=Rahul, 105=Rahul}
      
      //Returns key-value pairs whose keys are greater than or equal to the specified key.  
      System.out.println("tailMap: "+map.tailMap(102,true));  
      //Output :
      //tailMap: {103=Rahul, 105=Rahul}
      
      //Returns key-value pairs exists in between the specified key.  
      System.out.println("subMap: "+map.subMap(100, 102));  
      //Output :
      //subMap: {100=Amit, 101=Vijay}
      
      //Returns key-value pairs exists in between the specified key.  
      System.out.println("subMap: "+map.subMap(100, false, 102, true)); 
      //Output :
      //subMap: {101=Vijay}
      
      
 }  
}  