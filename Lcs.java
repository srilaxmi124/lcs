import java.util.Scanner;

import java.io.*;
import java.util.*;
 
class Lcs {
    public static String findstem(String arr[])
    {
        int n = arr.length;
        String s = arr[0];
        int len = s.length();
 
        String res = "";
 
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String stem = s.substring(i, j);
                int k = 1;
                for (k = 1; k < n; k++)
                    if (!arr[k].contains(stem))
                        break;
                if (k == n && res.length() < stem.length())
                    res = stem;
            }
        }
 
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings: ");
        int numStrings = scanner.nextInt();
        scanner.nextLine();

        String[] stringArray = new String[numStrings];
        for (int i = 0; i < numStrings; i++) {
            System.out.print("Enter string #" + (i + 1) + ": ");
            stringArray[i] = scanner.nextLine();
        }

        String result = findstem(stringArray);
        System.out.println("Longest common substring: " + result);

        scanner.close();
    }
}
