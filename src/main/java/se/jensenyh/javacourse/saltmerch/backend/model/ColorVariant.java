package se.jensenyh.javacourse.saltmerch.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorVariant
{
// todo: needs fields: String colorName, List of String images, List of SizeContainer sizes

    // todo: all fields should be public and annotated with @JsonProperty

    // todo: needs 2 constructors:
    //  1. empty constructor: this one needs to initialize images and sizes as new ArrayList<>()
    //  2. constructor with colorName, sizes, and images
    @JsonProperty
    public String colorName;

    @JsonProperty
    public ArrayList<String> images;

    @JsonProperty
    public ArrayList<String> sizesContainer;
    @JsonProperty
    public ArrayList<SizeContainer> sizes;

    public ColorVariant() {
        this.sizes= new ArrayList<SizeContainer>();
        this.images= new ArrayList<String>();

    }

    public ColorVariant(String colorName,
                        ArrayList<String> sizesContainer,
                        ArrayList<String> images) {


        this.colorName = colorName;
        this.sizes = sizes;
        this.images = images;

    }

    

    // NOTE: you can leave this method as it is; it's used in ProductRepository.java
    public void setImagesFromCSV(String csv) throws Exception
    {
        images = new ArrayList<>(Arrays.asList(csv.split(",")));
    }
}
