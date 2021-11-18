package com.tsi.training.gilliland_charlie.paintcalc;

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

        // nextLine added to move on from nextFloat
        input.nextLine();

        // Getting any areas not covered
        boolean areasStillMissing = true;
        float areaNotCoveredInMetersSq = 0;
        System.out.println("Are their any areas not being painted? Enter y/n");
        String answer = input.nextLine();
        while(areasStillMissing){
            switch(answer){
                case "y":
                    float area = GetAreaOfSurface(input);
                    areaNotCoveredInMetersSq += area;

                    System.out.println("Are there any more? Enter y/n");
                    input.nextLine();
                    String result = input.nextLine();
                    if(result.equals("n")){
                        areasStillMissing = false;
                    }
                    break;
                case "n":
                    areasStillMissing = false;
                    break;
                default:
                    System.out.println("Enter either y or n");
                    answer = input.nextLine();
            }
        }
        totalArea -= areaNotCoveredInMetersSq;

        // Getting how many tins needed
        int totalNoOfTins = GetTotalTins(totalArea, sizeOfCan, paintCoverageInMSq);
        System.out.println("For a room with a surface area of " + (totalArea/noOfCoats) + " meters.");
        System.out.println("With a total of " + noOfCoats + " coats, totalling " + totalArea + "m squared.");
        System.out.println("The total number of " + sizeOfCan + " litre paint tins needed is: " + totalNoOfTins);
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
        // Area covered by paint is estimated at 6 m squared per 1 litre of paint
        float areaCovered = paintCoverageByMSq * sizeOfTin;
        float exactAmountOfTins = area/areaCovered;
        return (int)(Math.ceil(exactAmountOfTins));
    }

    public static float GetAreaOfSurface(Scanner input){
        System.out.println("Enter the height of the surface in meters: ");
        float heightInMeters = input.nextFloat();

        System.out.println("Enter the width of the surface in meters: ");
        float widthInMeters = input.nextFloat();

        return heightInMeters * widthInMeters;
    }
}
