package com.company;

import java.util.ArrayList;
import java.util.List;

public class Claster {

    public List<Point> points;
    public Point cenrtoid;
    public int number;

    public Claster(int number){
        this.number = number;
        this.points = new ArrayList<>();
        this.cenrtoid = null;
    }

    public int getNumber() {
        return number;
    }

    public Point getCenrtoid() {
        return cenrtoid;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void setCenrtoid(Point cenrtoid) {
        this.cenrtoid = cenrtoid;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void addPoint(Point point){
        this.points.add(point);
    }

    public void clear(){
        this.points.clear();
    }

    public void show() {
        System.out.println("******************************** Cluster: " + number+"*******************************");
        System.out.println("******************************** Centroid: " + cenrtoid + "********************************");
        System.out.println("Points: \n");
        for(Point p : points) {
            System.out.println(p);
        }
        System.out.println();
    }

}
