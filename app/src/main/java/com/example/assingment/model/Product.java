package com.example.assingment.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.parceler.Parcel;
import java.io.Serializable;

@Parcel(Parcel.Serialization.BEAN)
@Entity
public class Product implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "regularPrice")
    private Double  regularPrice;

    @ColumnInfo(name = "salePrice")
    private Double salePrice;

    @ColumnInfo(name = "productPhoto")
    private Integer productPhoto;

   @ColumnInfo(name = "colors")
    private Integer colors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(Double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(Integer productPhoto) {
        this.productPhoto = productPhoto;
    }

    public Integer getColors() {
        return colors;
    }

    public void setColors(Integer colors) {
        this.colors = colors;
    }


}
