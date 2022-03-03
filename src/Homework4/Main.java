package Homework4;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
    String[] arr= {"Шар", "Рама", "Шар", "Суп", "Поле", "Шар", "Солнце", "Суп", "Шар", "Луг"};

        uniqueWordCount(arr);
        System.out.println("_______________________");
        System.out.println("Телефонная книга: ");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addNote("+7(913)-555-12-55","Петров");
        phoneBook.addNote("+7(913)-666-66-55","Сидоров");
        phoneBook.addNote("+7(913)-777-77-77","Зайцев");
        phoneBook.addNote("+7(913)-111-13-15","Петров");
        phoneBook.addNote("+7(913)-444-44-64","Метелкин");
        phoneBook.addNote("+7(913)-154-56-57","Бобров");
        phoneBook.addNote("+7(913)-222-22-26","Петров");
        phoneBook.addNote("+7(913)-333-33-44","Зайцев");


        try(FileOutputStream fileOutputStream = new FileOutputStream("new.csv");){
            byte[] dataBase ="+7(913)-555-12-55;Петров\n+7(913)-666-66-55;Сидоров\n+7(913)-777-77-77;Зайцев\n+7(913)-111-13-15;Петров\n+7(913)-444-44-64;Метелкин\n+7(913)-154-56-57;Бобров\n+7(913)-222-22-26;Петров\n+7(913)-333-33-44;Зайцев".getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(dataBase);
        } catch (Exception ex){
            ex.getMessage();
        }

        System.out.println("Петров: " + phoneBook.getPhoneByName("Петров"));
        System.out.println("Сидоров: " + phoneBook.getPhoneByName("Сидоров"));
        System.out.println("Зайцев: " + phoneBook.getPhoneByName("Зайцев"));
        System.out.println("Метелкин: " + phoneBook.getPhoneByName("Метелкин"));
        System.out.println("Бобров: " + phoneBook.getPhoneByName("Бобров"));


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
