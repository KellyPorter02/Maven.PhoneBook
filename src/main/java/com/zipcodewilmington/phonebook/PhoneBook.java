package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private Map<String, List<String>> phonebook;
    private List<String> teleNumbers = new ArrayList<>();

    public PhoneBook(Map<String, List<String>> phonebookMap) {

        this.phonebook = phonebookMap;
    }

    public PhoneBook() {
        this(new HashMap<>());

    }

    public void add(String name, String phoneNumber) {
        teleNumbers.add(phoneNumber);
        phonebook.put(name, teleNumbers);
    }

    public void addAll(String name, String... phoneNumbers) {
        teleNumbers.addAll(Arrays.asList(phoneNumbers));
        assert phonebook != null;
        phonebook.put(name, teleNumbers);
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
        return null;
    }

    public List<String> getAllContactNames() {
        return phonebook.;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
