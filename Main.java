import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Harshitha Sayini - Project SearchTreeIndex
 * April 14, 2023
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //SimpleMap<Integer, String[]> indexMap = new PlaceholderBinaryTreeSimpleMap<>();
        SimpleMap<Integer, String[]> indexMap = new CustomBinaryTreeSimpleMap<>();

        Scanner input = new Scanner(System.in);

        System.out.println("Enter filepath for txt file you want to use: ");
        String filePath = input.nextLine();
        File file = new File(filePath);
        Scanner sc = new Scanner(file);


        Integer i = 1;
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] words = s.split(" ");
            indexMap.put(i, words);
            i++;
        }
        System.out.println("Please enter a search term (blank to exit): ");
        String userChoice = input.nextLine();
        while(userChoice.length() >= 1) {
            for (int k = 1; k < i; k++) {
                String[] ss = indexMap.get(k);
                for(int j = 0; j < ss.length; j++) {
                    String ss2 = ss[j].replaceAll("[^a-zA-Z]+","");
                    if(ss2.equalsIgnoreCase(userChoice)) {
                        System.out.print(k + " " + Arrays.toString(indexMap.get(k)).replace(",", "")
                                .replace("[", "")
                                .replace("]", "")
                                .trim() + "\n");
                    }
                }
            }
            System.out.println("\nPlease enter a search term (blank to exit):");
            userChoice = input.nextLine();
        }
        input.close();
        sc.close();
        }
    }
