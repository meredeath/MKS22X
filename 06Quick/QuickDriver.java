import java.util.*;
public class QuickDriver{
    public static void main(String[] args){
	int[] a = {3, 2, 7, 8, 9, 4, 5, 0, 6, 1};
	//System.out.println(Arrays.toString(a));
	//Quick.swap(a,0,1);
	//System.out.println(Arrays.toString(a));
	//System.out.println(Quick.partition(a,0,a.length-1));
	//System.out.println(Arrays.toString(a));
	//System.out.println(Quick.partition(a,0,7));
	/*
	for(int i=0;i<a.length;i++){
	    System.out.println(Quick.quickselect(a,i));
	}
	*/
	Quick.quicksort(a);
	System.out.println(Arrays.toString(a));

	//thanks Crystal!
 //-----------SORTING POSITIVES-----------
    System.out.println("TESTING ON POSITIVE INTEGERS ONLY:");
    int[] correctData = new int[100];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 100; i++){
      int temp = (int)(Math.random() * 100);
      correctData[i] = temp;
    }

    //Sorts data and times the sort
    long end,start = System.currentTimeMillis();
    Quick.quicksort(correctData);
    end = System.currentTimeMillis();
    System.out.println("time: "+end);

    if(Quick.isSorted(correctData)){
	System.out.println("awesome your sort works!");
    }else{
	System.out.println("wow u suck go learn how to code");
    }
    System.out.println("\n");


    //-----------SORTING NEGATIVES-----------
    System.out.println("TESTING ON NEGATIVE INTEGERS ONLY:");
    correctData = new int[100];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 100; i++){
      int temp = (int)(Math.random() * 100);
      temp *= -1;
      correctData[i] = temp;
    }

    //Sorts data and times the sort
    start = System.currentTimeMillis();
    Quick.quicksort(correctData);
    end = System.currentTimeMillis();
    System.out.println("time: "+end);

    if(Quick.isSorted(correctData)){
	System.out.println("awesome your sort works!");
    }else{
	System.out.println("wow u suck go learn how to code");
    }
    System.out.println("\n");

    /*
    //-----------SORTING POSITIVES AND NEGATIVES-----------
    System.out.println("TESTING ON POSITIVE AND NEGATIVE INTEGERS:");
    data.clear();
    correctData = new int[1000];

    //Create MyLinkedListImproved and array with random integers
    for(int i = 0; i < 1000; i++){
      int temp = (int)(Math.random() * 1000);
      if((int)(Math.random() * 1000) % 2 == 0){
        temp *= -1;
      }
      data.add(temp);
      correctData[i] = temp;
    }

    //Sorts data and times the sort
    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with positive and negative integers is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING EMPTY LISTS-----------
    System.out.println("SORTING ON EMPTY LISTS");
    data.clear();
    correctData = new int[0];

    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your empty LinkedList is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING POSITIVE ONE-ELEMENT LISTS-----------
    System.out.println("SORTING POSITIVE ONE-ELEMENT LISTS");
    data.clear();
    correctData = new int[1];

    int temp = (int)(Math.random() * 1000);
    data.add(temp);
    correctData[0] = temp;

    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with one positive element is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    System.out.println("\n");


    //-----------SORTING NEGATIVE ONE-ELEMENT LISTS-----------
    System.out.println("SORTING NEGATIVE ONE-ELEMENT LISTS");
    data.clear();
    correctData = new int[1];

    temp = (int)(Math.random() * 1000) * -1;
    data.add(temp);
    correctData[0] = temp;

    start = System.currentTimeMillis();
    radixsort(data);
    end = System.currentTimeMillis();

    //Sorts the array
    Arrays.sort(correctData);
    System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
    hasError = false;
    index = 0;
    for(Integer x: data){
      if(!(x.equals(correctData[index]))){
        System.out.println("THERE IS AN ERROR");
        System.out.println("Index of error: " + index);
        hasError = true;
      }
      index++;
    }

    if(!(hasError)){
      System.out.println("Your LinkedList with one negative element is properly sorted.");
    }
    else{
      System.out.println(data);
    }
    */
    }
}
