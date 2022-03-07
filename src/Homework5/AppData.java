package Homework5;

import java.util.Scanner;

public class AppData {
    private String[] header;
    private int[][] data;
    public static Scanner scanner = new Scanner(System.in);

    public void setData(String[] header){
        this.header=header;
        data = new int[header.length][header.length];

        for (int i=0; i< header.length;i++){
            System.out.println("Заполнение " + (i+1)+ " строки");
            for(int j=0; j<header.length;j++){
            data[i][j] = inputValue("Введите целочисленное значение");
            }
        }

    }
    public int inputValue(String msgv){
        System.out.println(msgv + " >");
        return scanner.nextInt();
    }

    @Override
    public String toString() {
        String result = "";

        for (String word : header) {
            result += word + ";";
        }

        result += "\n";

        for (int row = 0; row < data.length; row++) {
            for (int column = 0; column < data[row].length; column++) {
                result += data[row][column] + ";";
            }
            result += "\n";
        }
        return result;
    }
}
