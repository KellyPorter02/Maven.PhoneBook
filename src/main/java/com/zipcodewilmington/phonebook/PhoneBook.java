package com.zipcodewilmington.phonebook;



import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private Map<String, List<String>> phonebook;
    private List<String> telephoneNumbers = new ArrayList<>();

    public PhoneBook(Map<String, List<String>> phonebookMap) {

        this.phonebook = phonebookMap;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        telephoneNumbers.add(phoneNumber);
        phonebook.put(name, telephoneNumbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        telephoneNumbers.addAll(Arrays.asList(phoneNumbers));
//        assert phonebook != null;
        phonebook.put(name, telephoneNumbers);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }
    public Boolean hasEntry(String name, String phoneNumber) {
        return (phonebook.containsKey(name) || phonebook.containsValue(phoneNumber));
    }

    public List<String> lookup(String name) {

        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        List<String> allThemNames = this.getAllContactNames();
        List<String> numbersAtThisName = new ArrayList<>();
        for (String name : allThemNames) {
            numbersAtThisName = phonebook.get(name);
            for (String number : numbersAtThisName) {
                if (number.equals(phoneNumber)) {
                    return name;
                }
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> contactNames = new ArrayList<>();
//        for (String key : phonebook.keySet()) {
//            contactNames.add(key);
//        }
        Set<String> names = phonebook.keySet();
        for (String key : names) {
            contactNames.add(key);
        }
        return contactNames;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
