package Homework4;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
    String[] arr= {"Шар", "Рама", "Шар", "Суп", "Поле", "Шар", "Солнце", "Суп", "Шар", "Луг"};

        uniqueWordCount(arr);
        System.out.println("_______________________");
        System.out.println("Телефонная книга: ");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addNote("+7(913)-555-12-55","Petrov");
        phoneBook.addNote("+7(913)-666-66-55","Sidorov");
        phoneBook.addNote("+7(913)-777-77-77","Zaicev");
        phoneBook.addNote("+7(913)-111-13-15","Petrov");
        phoneBook.addNote("+7(913)-444-44-64","Metelkin");
        phoneBook.addNote("+7(913)-154-56-57","Bobrov");
        phoneBook.addNote("+7(913)-222-22-26","Petrov");
        phoneBook.addNote("+7(913)-333-33-44","Zaicev");



        try(FileOutputStream fileOutputStream = new FileOutputStream("new.csv");){

            byte[] dataBase = phoneBook.getNamePhone().toString().replace("[","").replace("]", "").replace("," , "").getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(dataBase);
        } catch (Exception ex){
            ex.getMessage();
        }

        System.out.println("Petrov: " + phoneBook.getPhoneByName("Petrov"));
        System.out.println("Sidorov: " + phoneBook.getPhoneByName("Sidorov"));
        System.out.println("Zaicev: " + phoneBook.getPhoneByName("Zaicev"));
        System.out.println("Metelkin: " + phoneBook.getPhoneByName("Metelkin"));
        System.out.println("Bobrov: " + phoneBook.getPhoneByName("Bobrov"));


    }

    public static void uniqueWordCount(String[] array){
        HashMap<String,Integer> wordCount= new HashMap<>();
        final int one=1;
        for (String word: array) {
            if (wordCount.containsKey(word)){
            int count = wordCount.get(word);
            wordCount.put(word, count+1);
            } else {
                wordCount.put(word, one);
            }
            
        }
        System.out.println("Список уникальных слов: ");
        for(Map.Entry<String, Integer> entryWords : wordCount.entrySet()){

            if(entryWords.getValue()==one){
                System.out.println(entryWords.getKey());
            }
        }
        System.out.println("Повтор слов в массиве: ");
        for (Map.Entry<String,Integer> entryWord : wordCount.entrySet()){
            System.out.println(entryWord.getKey() + ":" + entryWord.getValue());
        }


        
    }
}
