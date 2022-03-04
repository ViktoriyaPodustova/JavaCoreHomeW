package Homework4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
private HashMap<String, String> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addNote(String phone, String name) {
        phoneBook.put(phone,name);
    }

    public ArrayList<String> getPhoneByName(String name){
        ArrayList<String> result = new ArrayList<>();
        for(Map.Entry<String,String> entry : phoneBook.entrySet()){
        if(entry.getValue().equals(name)){
            result.add(entry.getKey());
           }
        }
        return result;
    }
    public ArrayList<String> getNamePhone(){
        ArrayList<String> res = new ArrayList<>();
        String semicolon = ";";
        char lineBreak = '\n';
        for(Map.Entry<String,String> entry : phoneBook.entrySet()){

               res.add(lineBreak + entry.getValue()+ semicolon + entry.getKey() + lineBreak) ;

        }

        return res;
    }

}
