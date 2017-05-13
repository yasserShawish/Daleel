package com.axioms.www.daleel.metadata;

import android.hardware.camera2.CameraManager;
import android.location.Address;

import java.io.Serializable;

/**
 * Created by user on 12/04/2017.
 */
public class AbstractMeta implements Serializable{

    private String name;
    private Long Id;
    private int image;

    public AbstractMeta(){

    }

    public AbstractMeta(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getmId() {
        return Id;
    }

    public void setmId(Long id) {
        this.Id = Id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
