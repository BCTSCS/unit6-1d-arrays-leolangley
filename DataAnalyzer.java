import java.util.Arrays;

public class DataAnalyzer {
    
    public static int linearSearch(int[] arr, int number){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == number){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int number){
        int leftSide = 0;
        int rightSide = arr.length - 1;
        while (leftSide <= rightSide){
            int middle = leftSide + (rightSide - leftSide) / 2;
            if (arr[middle] == number){
                return middle;
            }
            else if (arr[middle] < number){
                leftSide = middle + 1;
            }
            else {
                rightSide = middle - 1;
            }
        }
        return -1;
    }

    public static void reverseList(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end++;
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 2, 5, 4, 7, 6, 9, 8, 11, 10};
        int number = 7;
        
        int linearOutcome = linearSearch(data, number);
        System.out.println("Linear Search Result: " + linearOutcome);

        Arrays.sort(data);
        int binaryOutcome = binarySearch(data, number);
        System.out.println("Binary Search Outcome: " + binaryOutcome);

        reverseList(data);
        System.out.println("Reversed List: ");
        for (int i = 0; i < data.length; i++){
            System.out.print(i + " ");
        }
    }

}