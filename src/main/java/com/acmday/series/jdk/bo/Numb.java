package com.acmday.series.jdk.bo;

/**
 * @author acmday.
 * @date 2020/4/4.
 */
public class Numb {
    int id;
    String name;

    public Numb(int id){
        this.id = id;
        this.name = "name:" + id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
