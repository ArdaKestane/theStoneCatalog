package com.example.ce216;

import java.util.ArrayList;

public class Type {

    private String name;
    private ArrayList<Item> items;
    private ArrayList<Attribute> defaultAttributes;

    public Type(String name) {
        this.name = name;

        items = new ArrayList<>();
        defaultAttributes = new ArrayList<>();

    }

    public void addAttribute(String name, String value) {
        Attribute attribute = new Attribute(name, value);
        defaultAttributes.add(attribute);
    }

    public void removeAttribute(Attribute attribute){
        ArrayList<Attribute> temp = new ArrayList(defaultAttributes);

        for(Attribute att : temp){
            if(att.equals(attribute)){
                defaultAttributes.remove(attribute);
            }
        }
    }

    public void deleteItem(Item item){
        items.remove(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Attribute> getDefaultAttributes() {
        return defaultAttributes;
    }
    public void addDefaultAttributes(Attribute attribute){
        defaultAttributes.add(attribute);
    }

    public void setDefaultAttributes(ArrayList<Attribute> defaultAttributes) {
        this.defaultAttributes = defaultAttributes;
    }

    @Override
    public String toString() {
        return name;
    }
}
