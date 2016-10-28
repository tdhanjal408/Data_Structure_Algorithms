package Advanced;

import java.util.ArrayList;
import java.util.List;

public class Traingle {
	
	// Point class to hold X and Y
	class Point{
		double  pointX;
		double  pointY;
		 
		 public Point(double  pointX,double  pointY){
			 this.pointX= pointX;
			 this.pointY= pointY;
			 
		 }
	}
	
	// Method to check traingle type using points
	public String checkTraingleWithPoints(List<Point> list){
		if(list == null || list.size()!= 3 )
		return "Invalid Traingle";
		
		double side1 = getLengthOfSide(list.get(0) , list.get(1));
		double side2 = getLengthOfSide(list.get(1) , list.get(2));
		double side3 = getLengthOfSide(list.get(2) , list.get(0));
		
		if(side1%side2 ==0 && side3%side2 ==0){
			return "Equilateral Traingle";	
		}else if(side1%side2 ==0 || side3%side2 == 0){
			return "Issoceles Traingle";
		}else{
			return "Scalene Traingle";
		}
	}
	
	// Method to check traingle using sides
	public String checkTraingleWithSides(List<Integer> list){
		if(list == null || list.size() != 3 )
		return "Invalid Traingle";
		
		int side1 = list.get(0);
		int side2 = list.get(1);
		int side3 = list.get(2);

		if(side1%side2 ==0 && side3%side2 ==0){
			return "Equilateral Traingle";	
		}else if(side1%side2 ==0 || side3%side2 == 0){
			return "Issoceles Traingle";
		}else{
			return "Scalene Traingle";
		}
	}
	
	public double getLengthOfSide(Point a , Point b ){
		return Math.sqrt(Math.pow(Math.abs((b.pointX-a.pointX)),2)+Math.pow(Math.abs((b.pointY-a.pointY)),2));
	}
	
	public static void main(String[] args) {
		Traingle t = new Traingle();
		List<Point> points = new ArrayList<Point>();
		// Test Case 1
		points.add(t.new Point(0,0));
		points.add(t.new Point(2,3));
		points.add(t.new Point(4,0));
		System.out.println("Test case 1 result: " + t.checkTraingleWithPoints(points));
		
		// Test Case 2
		List<Integer> sides = new ArrayList<Integer>();
		sides.add(3);
		sides.add(3);
		sides.add(3);
		System.out.println("Test case 2 result: " + t.checkTraingleWithSides(sides));
		
	}

}
