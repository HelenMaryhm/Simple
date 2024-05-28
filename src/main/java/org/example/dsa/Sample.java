package org.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sample {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int noOfTestCases;
        int P; // Paul distance
        int N; // Nimmy distance
        int X; // Paul velocity
        int Y; // Nimmy velocity
        int R1; // Paul's repair time
        int R2; // Nimmy's repair time


            List<String> input = new ArrayList<>();
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
            scanner.close();

            if(!input.isEmpty()){
                noOfTestCases = Integer.parseInt(input.get(0));

                for (int i = 1; i < input.size(); i+=2) {
                    String[] paul = input.get(i).split(" ");
                    String[] nimmy = input.get(i+1).split(" ");

                    if(paul.length != 3 || nimmy.length != 3){
                        System.out.println("Invalid input");
                        return;
                    }
                    P = Integer.parseInt(paul[0]);
                    X = Integer.parseInt(paul[1]);
                    R1 = Integer.parseInt(paul[2]);

                    N = Integer.parseInt(nimmy[0]);
                    Y = Integer.parseInt(nimmy[1]);
                    R2 = Integer.parseInt(nimmy[2]);
                    timeTakenByPaulAndNimmy(P, N, X, Y, R1, R2);
                }

            }
    }

    public static void timeTakenByPaulAndNimmy(double P, double N, double X, double Y, double R1, double R2) {
        double paulTime = (P/X)+(R1*1);
        double nimmyTime = (N/Y)+(R2*1);
        //velocity = distance/time
        //time = distance/velocity

        if(paulTime < nimmyTime){
            System.out.println("PAUL");
            System.out.println((int)(paulTime));
        } else if(paulTime > nimmyTime){
            System.out.println("NIMMY");
            System.out.println((int)(nimmyTime));
        } else {
            System.out.println("BOTH");
            System.out.println((int)(paulTime));
        }
    }
}
