import java.util.*;
/** 
 *
 * @author Collin Ennis
 * @version 5/6/2021
 */
public class LevenshteinFinder {
   private String start;
   private String end;
   private int size;
   private Set<String> mySet = new TreeSet<>();
   private Set<String> neighbors = new TreeSet<>();
   private Map<String, Set<String>> myMap = new TreeMap<>();
   private int distance = -1;
   private List<String> path = new ArrayList<>();
   /** This method is the constructor that takes in 3 parameters and sets the appropriate values using those parameters, 
    *
    *@param x A string that is the starting word
    *@param y A string that is the ending word
    *@param z A set of strings that will most likely be a dictionary 
    *@throws IllegalArgumentException when the length of x and y is not equal
    */
   public LevenshteinFinder(String x, String y, Set<String> z) {
      this.start = x;
      this.end = y;
      if (x.length() != y.length()) {
         throw new IllegalArgumentException();
      }
      else {
         this.size = x.length();
      }
      for (String s : z) {
         if (s.length() == this.size) {
         Set<String> temp = new TreeSet<>();
            mySet.add(s);
            myMap.put(s, temp);
         }
      }
      for (String c : mySet) {
         for (String v: mySet)
            if (differentLetters(c,v) == 1) {
               myMap.get(c).add(v);
               myMap.get(v).add(c);
            }
         } 
         this.distance = getDistance();      
      }
   // Private method
   // This method is used to count how many letters are different between two strings of the same size
   // It returns the number of different letters.
   private int differentLetters(String a, String b) {
      int count = 0;
      for (int i = 0; i < a.length(); i++) {
         if (a.charAt(i) != b.charAt(i)) {
            count++;
         }
      }
      return count;
   }
   /** This method will use the findDistance() method to find the distance between the starting and ending word
    *
    *@return The distance between the strings as an Int
    */
   public int getDistance() {
      return findDistance(this.start, this.end);
   }
   /** This method will use the findPath() method to find the path in between 2 strings, and it will then return the Path array as a string
    *
    *@return The path as a string
    */
   public String getPath() {
      findPath(this.start, this.end);
      return path.toString();
   }
   // Private method
   // This method takes in two strings and counts how many possible changes have to be made to change the first string into the second string
   // It returns the count
   private int findDistance(String a, String b) {
      Set<String> tempSet1 = new TreeSet<>();
      Set<String> tempSet2 = new TreeSet<>();
      Set<String> tempSet3 = new TreeSet<>();
      tempSet2.add(a);
      int count = 0;
      while (tempSet1.size() != tempSet2.size() && !tempSet2.contains(b)) {
         tempSet1.addAll(tempSet2);
         tempSet2.clear();
         tempSet2.addAll(tempSet1);
         
         for (String s : tempSet1) {
            tempSet3.addAll(myMap.get(s));
         }
         tempSet2.addAll(tempSet3);
         count++;
      }
      if (tempSet2.contains(this.end)) {
         return count;
      }
      else {
         return -1;
      }
   }
   // Private method
   // This string takes two strings and uses data found in other methods to save each of the words that string A must change in to before becoming string B
   // Note: This is a void method meaning you have to call getPath() to get the changed data
   private void findPath(String a, String b) {
      if (distance < 0) {
         path.add("There is no path");
      }
      else {
         path.add(a);
         
         int count;
         Set<String> temp = new TreeSet<>();
         for (int i = this.distance-1; i >= 1; i--) {;
            count = 1;
            temp.clear();
            temp.addAll(myMap.get(path.get(path.size()-1)));
               for (String s : temp) {
                  if (findDistance(s, this.end) == i && count < 2) {
                     path.add(s);
                     count++;
                  }
               }
            
         }
        
         path.add(b);
      }
   }
}