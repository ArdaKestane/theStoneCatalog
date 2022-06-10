package com.example.ce216;

import java.util.ArrayList;

public class Catalog {

    static ArrayList<Type> typeList;
    static ArrayList<Item> itemList;
    static ArrayList<Tag> tagList;



    private static Catalog catalogInstance = null;

    private Catalog() {
        typeList = new ArrayList<>();
        itemList = new ArrayList<>();
        tagList = new ArrayList<>();
    }

    public static Catalog getCatalogInstance() {
        if (catalogInstance == null)
            catalogInstance = new Catalog();

        return catalogInstance;
    }

    public void createType(Type type){
        if(!typeList.contains(type)){
            typeList.add(type);
        }
    }

    public void createItem(Item item){
        if(!itemList.contains(item)){
            itemList.add(item);
        }
    }

    public void createTag(Tag tag){
        if(!tagList.contains(tag)){
            tagList.add(tag);
        }
    }



}
