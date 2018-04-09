package ManuallyCalculation;

import org.xmlcml.euclid.Point2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CalculateShortestDistanceBetweenPoint {
    
    
    public static void main(String[] args) {
        
        
        Point point1 = new Point(1, 2);
        Point point2 = new Point(6, 7);
        Point point3 = new Point(13, 14);
        Point point4 = new Point(20, 21);
        Point points = new Point(30, 31);
        
      
        
        List<Point> voyageLines = new ArrayList<Point>();
        voyageLines.add(point1);
        voyageLines.add(point2);
        voyageLines.add(point3);
        voyageLines.add(point4);
        voyageLines.add(points);
        
        CalculateShortestDistanceBetweenPoint a = new CalculateShortestDistanceBetweenPoint();
       /* Point coordinate = a.findShortestPathBetweenPoints(voyageLines, new Point(29, 30));
      
        System.out.println("Calculate shortest distance betweenn two points" + "(" + coordinate.getX() + "," + coordinate.getY() + ")");*/
       
       a.getThreeCoardinate(voyageLines, new Point(30,31)).stream().forEach(
               
               b-> System.out.println(b.getX() + "," + b.getY())
               
       );
    
         a.getPerpendicularPoint(new Point(20, 21), new Point(30, 31), new Point(19, 30));
         a.getPerpendicualr(new Point(20, 21), new Point(30, 31), new Point(15, 20));
         
         
        System.out.println( a.caldis(point4.x,point4.y,points.x,points.y));
        
    }
    
    // calculate Distance
    public double caldis(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
    
    
   
    
    //Calculate shortest path
    private Point findShortestPathBetweenPoints(List<Point> voyageLines, Point coordinate) {
        
        Point nearestPoint = new Point();
        nearestPoint.setLocation(voyageLines.get(0).getX(), voyageLines.get(0).getY());
        double shorDistance = caldis(voyageLines.get(0).getX(), voyageLines.get(0).getY(), coordinate.getX(), coordinate.getY());
        for (int i = 1; i < voyageLines.size(); i++) {
            double distance = caldis(voyageLines.get(i).getX(), voyageLines.get(i).getY(), coordinate.getX(), coordinate.getY());
            if (distance < shorDistance) {
                shorDistance = distance;
                nearestPoint.setLocation(voyageLines.get(i).getX(), voyageLines.get(i).getY());
            }
        }
        return nearestPoint;
    }
    
    
    //Calculate shortest path
    private List<Point> getThreeCoardinate(List<Point> voyageLines, Point coordinate) {
        
        
        List<Point> pointList = new ArrayList<>();
    
        Point nearestPoint = new Point();
        Point nearestLeftSidePoint = new Point();
        Point nearestRightSidePoint = new Point();
        
        nearestPoint.setLocation(voyageLines.get(0).getX(), voyageLines.get(0).getY());
        nearestLeftSidePoint.setLocation(0.0,0.0);
        nearestRightSidePoint.setLocation(voyageLines.get(1).getX(), voyageLines.get(1).getY());
    
        
        
        int index = 0;
        double shorDistance = caldis(voyageLines.get(0).getX(), voyageLines.get(0).getY(), coordinate.getX(), coordinate.getY());
        for (int i = 1; i < voyageLines.size(); i++) {
            double distance = caldis(voyageLines.get(i).getX(), voyageLines.get(i).getY(), coordinate.getX(), coordinate.getY());
            if (distance < shorDistance) {
               
                shorDistance = distance;
                nearestPoint.setLocation(voyageLines.get(i).getX(), voyageLines.get(i).getY());
                nearestLeftSidePoint.setLocation(voyageLines.get(i-1).getX(), voyageLines.get(i-1).getY());
                
                if(voyageLines.size() > i+1)
                nearestRightSidePoint.setLocation(voyageLines.get(i + 1).getX(), voyageLines.get(i +1).getY());
                else
                    nearestRightSidePoint.setLocation(0.0,0.0);
            }
        }
    
        pointList.add(nearestLeftSidePoint);
        pointList.add(nearestPoint);
        pointList.add(nearestRightSidePoint);
        
        return pointList;
    }
    
    
    
    private void getPerpendicularPoint(Point point1, Point point2, Point point3) {
    
        double k = ((point2.y-point1.y) * (point3.x-point1.x) - (point2.x-point1.x) * (point3.y-point1.y)) / ((point2.y-point1.y)^2 + (point2.x-point1.x)^2);
        double x4 = point3.x - k * (point2.y-point1.y);
        double y4 = point3.y + k * (point2.x-point1.x);
    
        System.out.println("Point is x coordinate is" + x4 + "  y coordinate is "+y4);
    
    
    }
    
    private void getPerpendicualr(Point point1, Point point2, Point point3) {
        // first convert line to normalized unit vector
        double dx = point2.x - point1.x;
        double dy = point2.y - point1.y;
        double mag = Math.sqrt((dx*dx + dy*dy));
        dx /= mag;
        dy /= mag;

// translate the point and get the dot product
        double lambda = (dx * (point3.x - point1.x)) + (dy * (point3.y - point1.y));
        double x4 = (dx * lambda) + point1.x;
        double y4 = (dy * lambda) + point1.y;
    
        System.out.println("Point is x coordinate is" + x4 + "  y coordinate is "+y4);
    }
    
}


