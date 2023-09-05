package com.example.myCore;

/**
 * POJO
 * 为了实现对象的比较，实现 Comparable接口，重写方法compareTo()
 */
public class City implements Comparable<City>{


    private int id;
    private String name;
    private String street;
    private String postcode;

    public City() {
    }

    /**
     * 重写比较器方法
     * 比较者：this
     * 被比较者：o
     * 规则：如果比较者大于被比较者，返回正数；
     * 如果比较者小于被比较者，返回负数；
     * 如果比较者小于被比较者，返回0；
     *
     */
    @Override
    public int compareTo(City o) {

            return this.id - o.id;
    }

    /**
     * 添加toString
     */
    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }

    /**
     * 构造函数
     */
    public City(int id, String name, String street, String postcode) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.postcode = postcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


}
