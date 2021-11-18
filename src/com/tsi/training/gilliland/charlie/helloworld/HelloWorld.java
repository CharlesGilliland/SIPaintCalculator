package com.tsi.training.gilliland.charlie.helloworld;

public class HelloWorld {
    public static void main(String[] args){
        String hi = "Hello World";
        int max = Integer.MAX_VALUE;

        System.out.println(hi + " " + max);

        String[] thoughts = {"I", "cant", "deal", "with", "this", "pace"};

        for(int i = 0; i < thoughts.length; i++){
            if(i == thoughts.length - 1){
                System.out.print(thoughts[i] + ".");
            } else {
                System.out.print(thoughts[i] + " ");
            }
        }
    }
}
