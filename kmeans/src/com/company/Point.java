package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.company.Main;

public class Point {
    private double x;
    private double y;
    private int clusterNumber;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void setClusterNumber(int clusterNumber) {
        this.clusterNumber = clusterNumber;
    }

    public int getClusterNumber() {
        return clusterNumber;
    }

    protected static Point randomPoinr(int min, int max){
        Random r = new Random();
        double x = min + (max - min) * r.nextDouble();
        double y = min + (max - min) * r.nextDouble();
        return new Point(x, y);
    }

    protected static List<Point> createListOfPoint(double array[][], int amountOfPoints){
        List<Point> points = new ArrayList<>(amountOfPoints);
        for (int i=0;i<amountOfPoints;i++){
            double X = array[i][0];
            double y = array[i][1];
            points.add(new Point(X,y));
        }
        return points;
    }

    protected static double distance(Point point, Point centroid){
        return Math.sqrt(Math.pow((centroid.getY() - point.getY()), 2) + Math.pow((centroid.getX() - point.getX()), 2));
    }

    public String toString() {
        return "{"+Math.round(x*Integer.parseInt(Main.properties.getProperty("maxX")))+", "+Math.round(y*Integer.parseInt(Main.properties.getProperty("maxY")))+"},";
    }

}
