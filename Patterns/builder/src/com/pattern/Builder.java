package com.pattern;

public interface Builder {
    public void setName(String Name);

    public void setAge(int age);

    public void setHeight(int height);

    public Human build();
}
