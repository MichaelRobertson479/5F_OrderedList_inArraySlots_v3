/**
  OrderedList_inArraySlots, holding Integers
  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */

import java.util.*;

public class OrderedList_inArraySlots
    implements OrderedList {

    private ArrayList<Integer> list_iAS;


    /**
      @return the index of the first occurrence of
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
     public int indexOf( Integer findMe) {

       return indexOf(findMe,list_iAS.size() - 1);

     }

    public int indexOf( Integer findMe, int high) {

      int index = b(list_iAS,findMe,0,high);

      if (b(list_iAS,findMe,0,index-1) == -1)
      return index;

      else
      return indexOf(findMe,index-1);

    }


    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.
      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).
      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }

    public int b (ArrayList<Integer> list, int find) {
      return b(list,find,0,list.size()-1);
    }

    public int b (ArrayList<Integer> list, int find, int low, int high) {

      int mid = (low+high)/2;

      if (low > high)
      return -1;

      else if (list.get(mid) == find)
      return mid;

      else if (list.get(mid) > find)
      return b(list,find,low,mid-1);

      else
      return b(list,find,mid+1,high);

    }

    public int bwhile (ArrayList<Integer> list, int find) {
      int low = 0;
      int high = list.size() - 1;

      while (low <= high) {
        int pageToCheck = (high + low)/2;
        if (list.get(pageToCheck) == find)
        return pageToCheck;

        else if (list.get(pageToCheck) > find)
        high = pageToCheck - 1;

        else
        low = pageToCheck + 1;
      }

      return -1;
    }
}
