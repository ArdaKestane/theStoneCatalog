package com.example.ce216;

import java.io.*;
import java.util.ArrayList;

public class Catalog{

    static ArrayList<Type> typeList;
    static ArrayList<Item> itemList;
    static ArrayList<Tag> tagList;



    private static Catalog catalogInstance = null;

    private Catalog() {
        typeList = new ArrayList<>();
        itemList = new ArrayList<>();
        tagList = new ArrayList<>();
        readFromFile(typeList,itemList,tagList);
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

    public void readFromFile(ArrayList<Type> types, ArrayList<Item> items, ArrayList<Tag> tags) {
        File file = new File("src/main/resources/Files/Objects.txt");
        if (file.exists()) {
            ObjectInputStream ois;
            FileInputStream fis;

            try {

                fis = new FileInputStream("src/main/resources/Files/Objects.txt");
                ois = new ObjectInputStream(fis);
                try {
                    while (true) {


                        Type type = (Type) ois.readObject();
                        types.add(type);
                        for (Item item : type.getItems()) {
                            items.add(item);
                            tags.addAll(item.getTags());
                        }
                    }
                } catch (EOFException | ClassNotFoundException ignored) {}
                ois.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }// file not found
        }
    }



    public void writeToFile(ArrayList<Type> arrayList) {
        File file = new File("src/main/resources/Files/Objects.txt");
        if (file.exists()) {
            ObjectOutputStream oos = null;
            try {
                FileOutputStream fos = new FileOutputStream("src/main/resources/Files/Objects.txt");
                oos = new ObjectOutputStream(fos);
                try {
                    for (Object item : arrayList)
                        oos.writeObject(item);
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeToFile(){
        writeToFile(typeList);
    }




}
