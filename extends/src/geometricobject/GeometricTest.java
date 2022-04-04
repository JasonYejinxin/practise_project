package geometricobject;

public class GeometricTest {
	public static void main(String[] args) {
		GeometricTest test1 = new GeometricTest();
		Circle p1 = new Circle(20,"red",20);
		MyRectangle p2 = new MyRectangle(20,20,"red",240);
		
		System.out.println(test1.displayGeometricObject(p1));
		System.out.println(test1.equalsArea(p1, p2));
	}
public boolean equalsArea(GeometricObject p1, GeometricObject p2){
	return (p1 == p2);
}

public double displayGeometricObject(GeometricObject p){
	return p.findArea();
	
}

}
