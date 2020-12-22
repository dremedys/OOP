package lab3;

public class Sort {

	static <E> void swap (E [] array, int i, int j) {
		E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
	}
	
	static <E extends Comparable <E>> void quickSort(E [] array, int left, int right){
        if (array.length == 0)
            return;
 
        if (left >= right)
            return;
 
        int middle = (right + left) / 2;
        E pivot = array[middle];
 
        int i = left, j = right;
        
        while (i < j) {
            while(array[i].compareTo(pivot) < 0) {  //array[i] less than pivot
                i++;
            }
 
            while (array[j].compareTo(pivot) > 0) {
                j--;
            }
 
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
            
        }
        
        if (left < j) {
            quickSort(array, left, j);
        }
        
        if (right > i) {
        	quickSort(array, i, right);
        }
        
	}
	
	static <E extends Comparable <E>> void bubbleSort(E [] array) 
    { 
        int n = array.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (array[j].compareTo(array[j+1]) > 0) //j th>j+1 th
                { 
                	swap(array, j, j+1);
                    
                } 
    } 
	
}
