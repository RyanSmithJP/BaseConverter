package com.company;
import java.util.Locale;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        //Input as follows
        //1. The base of the value to convert
        //2. The new base to convert the value to
        //3. The value
        Scanner sc = new Scanner(System.in);
        int oldBase = Integer.parseInt(sc.nextLine());
        int newBase = Integer.parseInt(sc.nextLine());
        //convert string to lower case to reduce if cases
        String num = sc.nextLine().toLowerCase();
        //System.out.println(oldBase+" "+newBase+" "+num);

        long dec = 0;
        String output = "";

        for(int i = num.length()-1; i >=0; i--){
            //taking each character right to left
            //calculating the power by subtracting the index from length
            //original base to this power
            dec += toDec((int)num.charAt(i),(num.length()-1)-i, oldBase);
        }
        //convert dec to newBase
        while(dec>0){
            output += convertNew(dec, newBase);
            //System.out.println(output);
            //System.out.println("New dec: "+dec);
            dec/=newBase;
        }
        if(num.charAt(0)=='-'){
            System.out.println("-"+(rev(output)));
        }
        else{
            System.out.println(rev(output));
        }
    }

    private static double toDec(int c, int power, int base) {
        //read in each char as an ascii value

        //minus case
        if(c==45){
            return 0;
        }
        if(c<58){
            return (c-48)*Math.pow(base,power);
        }
        else{
            return (c-87)*Math.pow(base,power);
        }
    }

    private static String convertNew(long n, int base) {
        //add remainder to string
        //convert to letter if necessary
        return (toLetter(n%base));
    }

    private static String toLetter(long l) {
        if(l<10){
            return (char)(l+48)+"";
        }
        return (char) (l+55)+"";
    }

    private static String rev(String output) {
        String s = "";
        for(int i = output.length()-1; i >=0; i--){
            s+=output.charAt(i);
            //System.out.println("Loop: "+s);
        }
        return s;
    }
}
