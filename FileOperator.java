import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileOperator {
    
    private String fileName;

    public FileOperator(String fileName) {
        this.fileName = fileName;
    }

    public String[] toStringArray(int arraySize) {
        String[] data = new String[arraySize];
        try {
            Scanner input = new Scanner(new File(fileName));
            for (int i = 0; i < arraySize && input.hasNext(); i++) {
                data[i] = input.next();
            }
            input.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return data;
    }

    public int[] toIntArray(int arraySize) {
        int[] data = new int[arraySize];
        try {
            Scanner input = new Scanner(new File(fileName));
            for (int i = 0; i < arraySize; i++) {
                if (input.hasNextInt()) {
                    data[i] = input.nextInt();
                } else {
                    break;
                }
            }
            input.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return data;
    }

    public double[] toDoubleArray(int arraySize) {
        double[] data = new double[arraySize];
        try {
            Scanner input = new Scanner(new File(fileName));
            for (int i = 0; i < arraySize; i++) {
                if (input.hasNextDouble()) {
                    data[i] = input.nextDouble();
                } else {
                    break;
                }
            }
            input.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return data;
    }

    public static void main(String[] args) {
        FileOperator fp = new FileOperator("numbers.txt");

        int[] intData = fp.toIntArray(65);
        System.out.print("Integer Data: ");
        for (int num : intData) {
            System.out.print(num + " ");
        }
        System.out.println();

        double[] doubleData = fp.toDoubleArray(50);
        System.out.print("Double Data: ");
        for (double num : doubleData) {
            System.out.print(num + " ");
        }
        System.out.println();

        String[] stringData = fp.toStringArray(20);
        System.out.print("String Data: ");
        for (String str : stringData) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

}