package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    //use LinkedHashmap to keep the inserted order.
    public PhoneBook() {
        //calls the constructor with the parameter.
        this(new LinkedHashMap<>());
    }

   // Creating a new arraylist and add it as value to the hashmap.
    public void add(String name, String phoneNumber) {
        List<String> list= new ArrayList<>();
        list.add(phoneNumber);
        phonebook.put(name, list);
    }

    //Take all phone numbers and store them in arraylist, and add it as value to the hashmap.
    public void addAll(String name, String... phoneNumbers) {
        List<String> list1 = Arrays.asList(phoneNumbers);
        phonebook.put(name, list1);
    }
     //Removes from hashmap.
    public void remove(String name) {
        phonebook.remove(name);
    }
    //checks if the hashmap contains key.
    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }
    //return a value by key.
    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    //iterate through all entries(key- value pairs)  with for each loop
    // and check if the phone number exist. EntrySet() method returns set of all element of the hashmap.
    public String reverseLookup(String phoneNumber)  {
        for(Map.Entry<String, List<String>> element: phonebook.entrySet()){
            if(element.getValue().contains(phoneNumber)){
                return element.getKey();
            }
        }
        return null;
    }

    //using a hashmap method keySet to return all keys.
    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet());
    }

    //return the phone book.
    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
