//********************************************************************************************************
// CLASS: Sorter.java
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Fall-B, 2018
// Project Number: Project #3
//
// AUTHOR
// Esteban Trevino, ECTREVIN, sttrevino2@gmail.com //
// ********************************************************************************************************

import java.util.ArrayList;

public class Sorter {
    /**
     * Swamps student positions in Arraylist
     */
    private static void swap(ArrayList<Student> pList, int pIdx1, int pIdx2){
        Student temp = pList.get(pIdx1);
        pList.set(pIdx1, pList.get(pIdx2));
        pList.set(pIdx2, temp);
    }
    /**
     *partitions list and returns index for use in QuickSort method
     */
    private static int partition(ArrayList<Student> pList, int pFromIdx, int pToIdx){
        //choose first element of pList to be pivot
        Student pivot = pList.get(pFromIdx);
        //these are indices in list that move toward each other as the partitioning proceeds
        int leftIndex = pFromIdx - 1;
        int rightIndex = pToIdx + 1;

        //partitioning ends when leftIndex and rightIndex "cross"
        while(leftIndex < rightIndex){
            //move leftIndex rightward until an element that is greater than or equal to pivot is reached
            leftIndex++;
            while(pList.get(leftIndex).compareTo(pivot) < 0){
                //while element in list at leftIndex is less than pivot, increment leftIndex
                leftIndex++;
            }
            //move rightIndex leftward until an element that is less than or equal to pivot is reached
            rightIndex--;
            while(pList.get(rightIndex).compareTo(pivot) > 0){
                rightIndex--;
            }
            //when the above while loops terminate, if leftIndex and rightIndex have not "crossed"
            //then leftIndex will be the index of an element that belongs in the right half of the partition
            //and rightIndex will be the index of an element that belongs in the left half
            //so we swap the elements
            if(leftIndex < rightIndex){
                swap(pList, leftIndex, rightIndex);
            }
        }
        //when the while loop ends, the elements in the list are partitioned
        //we return the rightIndex which is used in the main quicksort method
        return rightIndex;
    }
    /**
     * sorts student objects in Arraylist
     */
    //since partitioning does all the work, we just recursively call quicksort to partition the sublists
    private static void quickSort(ArrayList<Student> pList, int pFromIdx, int pToIdx){
        //base case is when list has only one element
        //in this case, when fromIndex is greater than or equal to toIndex
        if(pFromIdx >= pToIdx){
            return;
        }
        //otherwise, partition the list into  left half and right half such that
        //all the elements in the left are less than the elements in the right half
        //partitionIndex is whats returned from partition method
        int partitionIndex = partition(pList, pFromIdx, pToIdx);
        quickSort(pList, pFromIdx, partitionIndex);
        quickSort(pList, partitionIndex + 1, pToIdx);
    }

    /**
     * public method for access in other classes in project
     */
    public static void sort( ArrayList<Student> pList){
        quickSort(pList, 0, pList.size() - 1);
    }
}


