package com.example.ce216;

import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {

    private String name;
    private ArrayList<Tag> tags;
    private Type type;
    private ArrayList<Attribute> attributes;

    public Item(String name, Type type) {
        this.name = name;
        this.type = type;

        tags = new ArrayList<>();
        attributes = new ArrayList<>();
    }

    public void addTag(Tag tag) {
        tags.add(tag);

    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
    }

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public void removeAttribute(Attribute attribute){
        ArrayList<Attribute> temp = new ArrayList(attributes);

        for(Attribute att : temp){
            if(att.equals(attribute)){
                attributes.remove(attribute);
            }
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return name;
    }
}
