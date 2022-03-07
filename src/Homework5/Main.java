package Homework5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main (String[] args){
        try(FileOutputStream fileOutputStream = new FileOutputStream("table.csv");){
        byte[] csvData= newData().toString().getBytes(StandardCharsets.UTF_8);
        fileOutputStream.write(csvData);
        }catch (Exception ex){
            ex.getMessage();
        }

        try(FileInputStream fileInputStream = new FileInputStream("table.csv");){
        byte[] csvData= new byte[fileInputStream.available()];
        fileInputStream.read(csvData);
        String table = new String(csvData);
            System.out.println(table);
        } catch (Exception e){
            e.getMessage();
        }

    }

    public static AppData newData (){
        AppData appData = new AppData();
        String[] headers = new String[] {"title 1 ","title 2","title 3"};
        appData.setData(headers);
        return appData;
    }
}
