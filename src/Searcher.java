//********************************************************************************************************
// CLASS: Searcher.java
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall-B, 2018
// Project Number: Project #3
//
// AUTHOR
// Esteban Trevino, ECTREVIN, sttrevino2@gmail.com //
// ********************************************************************************************************

import java.util.ArrayList;

public class Searcher {
    /**
     *Search method finds student from Arraylist based on last name passed in as pKey
     * returns index of student or -1 if not found
     */
    public static int search(ArrayList<Student> pList, String pKey){

        int low = 0, high = pList.size() - 1;

        while(low <= high){

            int middle = (low + high) / 2;

            if(pKey.compareTo(pList.get(middle).getLastName()) == 0){
                return middle;
            } else if(pKey.compareTo(pList.get(middle).getLastName()) < 0){
                high = middle - 1;
            } else {
                low = middle + 1;
            }

        }
        return -1;
    }

}
