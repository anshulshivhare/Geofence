package com.knoldus;

import org.xmlcml.euclid.Line2;
import org.xmlcml.euclid.Real2;

import java.util.ArrayList;
import java.util.List;

public class CalculatePoint {
    
    
    
    
    public static void main(String[] args) {
    
        Real2 point1 = new Real2(1, 2);
        Real2 point2 = new Real2(6, 7);
        Real2 point3 = new Real2(13, 14);
        Real2 point4 = new Real2(20, 21);
        Real2 points = new Real2(30, 31);
    
    
        CalculatePoint calculatePoint = new CalculatePoint();
    
        List<Real2> voyageLines = new ArrayList<>();
    
        voyageLines.add(point1);
        voyageLines.add(point2);
        voyageLines.add(point3);
        voyageLines.add(point4);
        voyageLines.add(points);
        
        
     /*   System.out.println("start");
    Real2 a = new Real2();
    
        Point2 p1 = new Point2(20, 21);
        Point2 p2 = new Point2(30, 31);
        Point2 p3 = new Point2(15, 20);
        Line2 line = new Line2(p1, p2);
        Real2 p4 = line.getNearestPointOnLine(p3);
       // System.out.println(a.getAngle(p1,p2,p3));
        
        Real2 real2 = new Real2(20,21);
        System.out.println(real2.getDistance(new Real2(30,31)));
        
        
        System.out.println(p4);*/
    List<Real2> coardinates = calculatePoint.getThreeCordinates(voyageLines, new Real2(10.5,9.5));
    coardinates.forEach(a-> System.out.println(a));
    
        Real2 leftPoint = coardinates.get(0);
        Real2 middlePoint = coardinates.get(1);
        Real2 rightPoint = coardinates.get(2);
        
        Real2 perpendicalPoint1 = calculatePoint.getPerpendicalarPoint(leftPoint, middlePoint, new Real2(10.5,9.5));
        Real2 perpendicalPoint2 = calculatePoint.getPerpendicalarPoint(middlePoint, rightPoint, new Real2(10.5,9.5));
        
        
        if(perpendicalPoint1.getDistance(new Real2(10.5,9.5)) < perpendicalPoint2.getDistance(new Real2(10.5, 9.5))) {
    
            System.out.println("point on line*****" + perpendicalPoint1);
        } else {
            System.out.println("point on line*****" +perpendicalPoint2);
        }
    
    }
    
    private List<Real2> getThreeCordinates(List<Real2> voyageLines, Real2 point) {
    
    
        List<Real2> pointList = new ArrayList<>();
    
        Real2 nearestPoint = new Real2();
        Real2 nearestLeftSidePoint = new Real2(0.0,0.0);
        Real2 nearestRightSidePoint = new Real2();
    
       // nearestPoint.setLocation(voyageLines.get(0).getX(), voyageLines.get(0).getY());
    
        nearestPoint.setX(voyageLines.get(0).getX());
        nearestPoint.setY(voyageLines.get(0).getY());
        
      //  nearestLeftSidePoint.setLocation(0.0,0.0);
       // nearestRightSidePoint.setLocation(voyageLines.get(1).getX(), voyageLines.get(1).getY());
        nearestRightSidePoint.setX(voyageLines.get(1).getX());
        nearestRightSidePoint.setY(voyageLines.get(1).getY());
        
    
    
        int index = 0;
      //  double shorDistance = caldis(voyageLines.get(0).getX(), voyageLines.get(0).getY(), coordinate.getX(), coordinate.getY());
    
        double shorDistance = new Real2(voyageLines.get(0).getX(), voyageLines.get(0).getY()).getDistance(new Real2(point.getX(),point.getY()));
        
        for (int i = 1; i < voyageLines.size(); i++) {
            double distance = new Real2(voyageLines.get(i).getX(), voyageLines.get(i).getY()).getDistance(new Real2(point.getX(), point.getY()));
            if (distance < shorDistance) {
            
                shorDistance = distance;
               // nearestPoint.setLocation(voyageLines.get(i).getX(), voyageLines.get(i).getY());
                
                nearestPoint.setX(voyageLines.get(i).getX());
                nearestPoint.setY(voyageLines.get(i).getY());
                //nearestLeftSidePoint.setLocation(voyageLines.get(i-1).getX(), voyageLines.get(i-1).getY());
            
                nearestLeftSidePoint.setX(voyageLines.get(i-1).getX());
                nearestLeftSidePoint.setY(voyageLines.get(i-1).getY());
                
                if(voyageLines.size() > i+1) {
                    //nearestRightSidePoint.setLocation(voyageLines.get(i + 1).getX(), voyageLines.get(i + 1).getY());
    
                    nearestRightSidePoint.setX(voyageLines.get(i + 1).getX());
                    nearestRightSidePoint.setY(voyageLines.get(i + 1).getY());
                    
                }else {
                    
                  //  nearestRightSidePoint.setLocation(0.0, 0.0);
                    
                    nearestRightSidePoint.setX(0.0);
                    nearestRightSidePoint.setY(0.0);
                }
            }
        }
    
        pointList.add(nearestLeftSidePoint);
        pointList.add(nearestPoint);
        pointList.add(nearestRightSidePoint);
    
        return pointList;
    
    
    }
    
    
    private Real2 getPerpendicalarPoint(Real2 point1, Real2 point2, Real2 point3) {
    
        Line2 line = new Line2(point1, point2);
        Real2 p4 = line.getNearestPointOnLine(point3);
        
        return p4;
        
    }
    
    
    
}
