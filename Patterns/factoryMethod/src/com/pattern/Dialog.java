package com.pattern;

public abstract class Dialog {
    public String name;
    public int width;
    public int height;

    public void render(){
        // should create button
        Button ok = createButton();
        ok.onClick();
        ok.render();
    }

    public abstract Button createButton();
}
