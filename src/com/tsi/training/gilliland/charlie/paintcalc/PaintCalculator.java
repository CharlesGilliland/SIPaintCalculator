package com.tsi.training.gilliland.charlie.paintcalc;

import java.util.Scanner;

public class PaintCalculator {
    public static void main(String[] args){
        // Setting up scanner to get input from the user
        Scanner input = new Scanner(System.in);

        // Getting the number of walls
        System.out.print("Enter the number of walls:");
        int noOfWalls = input.nextInt();

        // Getting how many coats need to be done
        System.out.println("Enter the number of coats required:");
        int noOfCoats = input.nextInt();

        // Getting the total surface area to be painted
        float totalArea = GetTotalArea(input, noOfWalls, noOfCoats);

        // Getting how large the tins of paint are
        System.out.println("Enter the size of your paint tin in litres");
        float sizeOfCan = input.nextFloat();
        float paintCoverageInMSq = 6;

        // Getting any areas not covered
        System.out.println("Are their any areas not covered? If so, enter \"y\"");
        String answer = input.nextLine();
        // CARRY ON FROM HERE


        // Getting how many tins needed
        int totalNoOfTins = GetTotalTins(totalArea, sizeOfCan, paintCoverageInMSq);
        System.out.println("For a room with a surface area of " + (totalArea/noOfCoats) + " meters.");
        System.out.println("With a total of " + noOfCoats + " coats, totalling " + totalArea + "m squared.");
        System.out.println("The total number of paint tins needed is: " + totalNoOfTins);
        System.out.println("** This is based upon 1 litre of paint covering 6m squared ** ");
    }

    public static float GetTotalArea(Scanner input, int noOfWalls, int noOfCoats){
        float[] wallSurfaceAreas = new float[noOfWalls];
        float totalArea = 0;

        for(int i = 0; i < noOfWalls; i++){
            float heightInMeters;
            float widthInMeters;

            System.out.println("Enter the height of wall " + (i+1) + " in meters: ");
            heightInMeters = input.nextFloat();
            System.out.println("Enter the width of wall " + (i+1) + " in meters: ");
            widthInMeters = input.nextFloat();
            wallSurfaceAreas[i] = heightInMeters * widthInMeters;
        }

        for(float area : wallSurfaceAreas) {
            totalArea += area;
        }

        return totalArea * noOfCoats;
    }

    public static int GetTotalTins(float area, float sizeOfTin, float paintCoverageByMSq){
        // Area covered by paint is estimated at 6m squared per 1 litre of paint
        float areaCovered = paintCoverageByMSq * sizeOfTin;
        float exactAmountOfTins = area/areaCovered;
        int totalNoTins = (int)(Math.ceil(exactAmountOfTins));
        return totalNoTins;
    }
}