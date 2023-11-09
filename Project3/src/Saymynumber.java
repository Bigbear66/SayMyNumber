// Saymynumber.java
// CSCI1302
// Project 3
// 04/12/2020
// by Eldin Pita

import java.math.BigInteger;

import java.util.Scanner;

public class Saymynumber {



    final static String[] OnesWords = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",

            "nine" };

    final static String[] Bet10n19 = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",

            "seventeen", "eighteen", "nineteen" };

    final static String[] TensWords = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    final static String Thousand = "thousand";

    final static String Hundred = "hundred";

    final static String Million = "million";

    final static String Billion = "billion";

    // create constants to help in method

    final static int BillionVal = 1000000000;

    final static int MillionVal = 1000000;

    final static int ThousandVal = 1000;

    final static int HundredVal = 100;



    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);

        try {



            System.out.println("Please enter a number between 1 and 9.2 Quintillion: ");

            String s = sc.nextLine();

            BigInteger integer=new BigInteger(s);

            BigInteger comp=new BigInteger("9223372036854775807");

            sc.close();

            if(integer.compareTo(comp)==1){

                System.out.println("Number greater than 9.2 quintillion");

                throw new Exception("Large input");

            }


            Saynumber(Long.parseLong(s));

        } catch (Exception problem) {

            System.out.println("Error with input: " + problem.getMessage());

        }



        sc.close();

    }

    private static void Saynumber(long n) throws Exception {



        if (n <= 0) {



            throw new Exception("Please enter a number between 1 and 2.1 billion");

        }



        System.out.println(Say(n));

    }


    private static String Say(long n) {

        if (n == 0) {



            return "";

        }



        if (n < 10 && n > 0) {

            return OnesWords[(int)n];

        }



        else if (n < 20) {

            return Bet10n19[(int)(n - 10)];

        }

        else if (n >= 1000000000000000000L)

            return Say(n / 1000000000000000000L)+" quintillion "+Say(n % 1000000000000000000L);



        else if (n >= 1000000000000000L)

            return Say(n / 1000000000000000L)+" quadrillion "+Say(n % 1000000000000000L);



        else if (n >= 1000000000000L)

            return Say(n / 1000000000000L)+" trillion "+Say(n % 1000000000000L);



        else if (n >= BillionVal) {



            final int val = (int) Math.floor(n / BillionVal);



            return Say(val) + " " + Billion + " " + Say(n % BillionVal);

        }



        else if (n >= MillionVal) {



            final int val = (int) Math.floor(n / MillionVal);



            return Say(val) + " " + Million + " " + Say(n % MillionVal);

        }



        else if (n >= ThousandVal) {



            final int val = (int) Math.floor(n / ThousandVal);



            return Say(val) + " " + Thousand + " " + Say(n % ThousandVal);

        }



        else if (n >= HundredVal) {



            final int val = (int) Math.floor(n / HundredVal);



            return Say(val) + " " + Hundred + " " + Say(n % HundredVal);

        }



        else {



            final int val = ((int) Math.floor(n / 10)) - 2;



            return TensWords[val] + " " + Say(n % 10);

        }

    }

}