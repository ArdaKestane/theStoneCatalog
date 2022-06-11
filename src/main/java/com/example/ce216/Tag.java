package com.example.ce216;

import java.util.LinkedList;

public class Tag {

    private String name;
    private LinkedList<Item> attachedItems;

    public Tag(String name) {
        this.name = name;
        attachedItems = new LinkedList<>();
    }


    public void addAttachedItems(Item item) {
        attachedItems.add(item);
    }

    public void removeAttachedItems(Item item) {
        attachedItems.remove(item);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Item> getAttachedItems() {
        return attachedItems;
    }

    public void setAttachedItems(LinkedList<Item> attachedItems) {
        this.attachedItems = attachedItems;
    }

    @Override
    public String toString() {
        return name;
    }
}
