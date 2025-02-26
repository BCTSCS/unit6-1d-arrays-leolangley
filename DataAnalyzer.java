import java.util.*;
import java.io.*;

public class DataAnalyzer {

    private String[] countries;
    private int[] populations;
    private String[] incomes;
    private double[] unemploymentRates;

    public DataAnalyzer(String countriesFile, String populationsFile, String incomesFile, String unemploymentFile) {
        countries = readStringArray(countriesFile);
        populations = readIntArray(populationsFile);
        incomes = readIncomeCategoryArray(incomesFile);
        unemploymentRates = readDoubleArray(unemploymentFile);
    }

    private String[] readStringArray(String filename) {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
        return list.isEmpty() ? new String[0] : list.toArray(new String[0]);
    }

    private int[] readIntArray(String filename) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
            br.close();
        } catch (IOException | NumberFormatException e) {

            System.out.println("Error reading file: " + filename);

        }
        return list.isEmpty() ? new int[0] : list.stream().mapToInt(i -> i).toArray();
    }

    private double[] readDoubleArray(String filename) {
        ArrayList<Double> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Double.parseDouble(line));
            }
            br.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file: " + filename);
        }
        return list.isEmpty() ? new double[0] : list.stream().mapToDouble(d -> d).toArray();
    }

    private String[] readIncomeCategoryArray(String filename) {

        return readStringArray(filename);

    }

    public void identifyHighRiskCommunities(String incomeCategory, double unemploymentThreshold) {

        if (countries.length == 0 || incomes.length == 0 || unemploymentRates.length == 0) {

            System.out.println("Error: One or more datasets are empty. Cannot analyze high-risk communities.");

            return;

        }

        System.out.println("High-risk communities with " + incomeCategory + " and unemployment rate above " + unemploymentThreshold + "%:");

        for (int i = 0; i < Math.min(countries.length, Math.min(incomes.length, unemploymentRates.length)); i++) {

            if (incomes[i].equalsIgnoreCase(incomeCategory) && unemploymentRates[i] > unemploymentThreshold) {

                System.out.println(countries[i]);

            }
        }
    }

    public void displayInfo() {
        System.out.println("Total communities analyzed: " + Math.min(countries.length, Math.min(incomes.length, unemploymentRates.length)));
    }

    // public static int linearSearch(int[] arr, int number) {
    //     for (int i = 0; i < arr.length; i++) {
    //         if (arr[i] == number) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    // public static int binarySearch(int[] arr, int number) {
    //     int leftSide = 0;
    //     int rightSide = arr.length - 1;
    //     while (leftSide <= rightSide) {
    //         int middle = leftSide + (rightSide - leftSide) / 2;
    //         if (arr[middle] == number) {
    //             return middle;
    //         } else if (arr[middle] < number) {
    //             leftSide = middle + 1;
    //         } else {
    //             rightSide = middle - 1;
    //         }
    //     }
    //     return -1; 
    // }

    // public static void reverseList(int[] arr) {
    //     int start = 0;
    //     int end = arr.length - 1;
    //     while (start < end) {
    //         int temp = arr[start];
    //         arr[start] = arr[end];
    //         arr[end] = temp;
    //         start++;
    //         end--; 
    //     }
    // }

    // public static void main(String[] args) {
    //     int[] arr = new int[100];

    //     try {
    //         File f = new File("numbers.txt");
    //         Scanner input = new Scanner(f);

    //         for (int i = 0; i < 100; i++) {
    //             arr[i] = input.nextInt();
    //         }
    //         input.close(); 
    //     } catch (IOException e) {
    //         System.out.println("File not found!");
    //         return;
    //     }

    //     int number = 7;

    //     int linearOutcome = linearSearch(arr, number);
    //     System.out.println("Linear Search Result: " + linearOutcome);

    //     Arrays.sort(arr);
    //     int binaryOutcome = binarySearch(arr, number);
    //     System.out.println("Binary Search Outcome: " + binaryOutcome);

    //     reverseList(arr);
    //     System.out.println("Reversed List: ");
    //     for (int i = 0; i < arr.length; i++) {
    //         System.out.print(arr[i] + " ");
    //     }
    //     System.out.println();
    // }
   
}