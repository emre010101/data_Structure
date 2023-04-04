package week8;

public class Car implements Comparable<Car>{
	String brand;
	String color;
	int model;
	int ID;
	
	public Car(String br, String c, int m, int id) {
		this.brand = br;
		this.color = c;
		this.model = m;
		this.ID = id;
	}
	
	public Car(int id) {
		this.ID =  id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", model=" + model + ", ID=" + ID + "]";
	}

	@Override
	public int compareTo(Car o) {
		if(this.ID > o.getID()) {
			return 1;
		}else if(this.ID < o.getID()) {
			return -1;
		}else {
			return 0;
		}
	}
	

}
