package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Kmean {
    private int amountOfClasters = 2;
    private int amountOfPoints = 0;
    private static final int minCoordanate = 0;
    private static final int maxCoordinate = 1;
    private List<Point> points;
    private List<Claster> clasters;

    private static final String separator = ";";
    private static  double array[][];

    public Kmean(){
        this.points = new ArrayList<>();
        this.clasters = new ArrayList<>();
    }

    public void ReadCSV() throws IOException {

        Stream<String> lines2 =
                Files.lines(Paths.get("C:\\Users\\kolma\\Desktop\\java\\Java Project\\JAVA_IT_PARK_4\\Homeworks\\kmeans\\src\\com\\company\\S.csv"));
        amountOfPoints = (int) lines2.count();
        array = new double[amountOfPoints][2];

        String fname = "S.csv";
        File file = new File("C:\\Users\\kolma\\Desktop\\java\\Java Project\\JAVA_IT_PARK_4\\Homeworks\\kmeans\\src\\com\\company\\S.csv");
        try(BufferedReader br =
                    new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));) {
            String line = "";
            int i=0;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                line=line.replace(',', '.');
                String[] elements = line.split(separator);
                array[i][0]=Double.parseDouble(elements[0]);
                array[i][1]=Double.parseDouble(elements[1]);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        points = Point.createListOfPoint(array, amountOfPoints);
    }

    public void readData() throws IOException {
        ReadCSV();
        for (int i=0;i<amountOfClasters; i++){
            Claster claster = new Claster(i);
            Point centroid = Point.randomPoinr(minCoordanate, maxCoordinate);
            claster.setCenrtoid(centroid);
            this.clasters.add(claster);
        }

        show();
    }

    private void show(){
        for (int i=0;i<amountOfClasters;i++){
            clasters.get(i).show();
        }
    }

    private void clearClasters(){
        for (Claster cl:clasters){
            cl.clear();
        }
    }

    private List<Point> getCentroids(){
        List<Point> centroids = new ArrayList<>(amountOfClasters);
        for (Claster claster: clasters){
            Point temp = claster.getCenrtoid();
            Point point = new Point(temp.getX(),temp.getY());
            centroids.add(point);
        }
        return centroids;
    }

    private void assignCluster(){
        double max = Double.MAX_VALUE;
        double min = max;
        int claster = 0;
        double distance = 0;

        for (Point point: points){
            min=max;
            for (int j=0;j<amountOfClasters;j++){
                Claster current = clasters.get(j);
                distance = Point.distance(point, current.getCenrtoid());
                if (distance<min){
                    min = distance;
                    claster = j;
                }
            }
            point.setClusterNumber(claster);
            clasters.get(claster).addPoint(point);
        }
    }

    private void calculateNewCentroids(){
        for(Claster claster: clasters){
            double sumX=0;
            double sumY=0;
            List<Point> pointList = claster.getPoints();
            int amount = pointList.size();

            for(Point point: pointList){
                sumX+= point.getX();
                sumY+= point.getY();
            }

            Point centroid = claster.getCenrtoid();
            if (amount>0){
                double newX = sumX/ amount;
                double newY = sumY/ amount;
                centroid.setX(newX);
                centroid.setY(newY);
            }

        }
    }

    public void calculate(){
        boolean finished = false;
        int iter = 0;

        while (!finished){
            this.clearClasters();
            List<Point> previousCentroids = getCentroids();
            assignCluster();
            calculateNewCentroids();
            iter++;
            List<Point> currentCentroids = getCentroids();

            double distance = 0;
            for(int i=0;i<previousCentroids.size();i++){
                distance+= Point.distance(previousCentroids.get(i),currentCentroids.get(i));
            }
            System.out.println("************************************************************************************************");
            System.out.println("******************************** Iteration: " + iter + "********************************");
            System.out.println("******************************** Centroid distances: " + distance + "********************************");
            show();

            if (distance==0){
                finished =true;
            }
        }
    }
}
