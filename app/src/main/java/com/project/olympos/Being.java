package com.project.olympos;

import android.graphics.drawable.Drawable;

public class Being {
    private Drawable image;
    private String name;

    public Being(Drawable image, String name) {
        this.image = image;
        this.name = name;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
