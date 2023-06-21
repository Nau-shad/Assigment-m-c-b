/*
input: C04.557.470.615.305
output: C04.77.6.5555.4.3.1.00
*/

import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input= sc.nextLine(); // taking input from user



        int i=0;
        StringBuilder mainStr = new StringBuilder(""); // ** using string builder for fast operation

        //I used while loop to store the above mainStr bcz maybe  in different length will be change .
       while(input.charAt(i)!='.'){
           mainStr.append(input.charAt(i));
           i++;

       }
       // System.out.println(mainStr); this is for checking mainString

        int mainStrLength=i;

        String remainingStr = input.substring(mainStrLength); // fetching remaining String

      //  System.out.println(remainingStr);



        TreeMap<Character, Integer> freq= new TreeMap<>(Collections.reverseOrder());
        char[] remain=remainingStr.toCharArray();

        for(char c  : remain){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
       // System.out.println(freq);

        StringBuilder ans= new StringBuilder(mainStr.append('.'));

        for (Map.Entry entry : freq.entrySet()) {
           int charFreq= (int) entry.getValue();
           if(entry.getKey().equals('.')){
               continue;
           }
           else{
               for(int j=0;j<charFreq;j++){
                   ans.append(entry.getKey());
               }

           }
           ans.append('.');
        }

        /* converting String builder into String bcz here ans=C04.77.6.5555.4.3.1.00. */

        String finalAns=ans.substring(0,ans.length()-1); // length()-1 bcz we don't want . (dot) at end.

        System.out.println(finalAns);






    }
}