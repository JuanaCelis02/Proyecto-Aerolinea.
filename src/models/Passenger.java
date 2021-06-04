package models;

public class Passenger{

	private String name;
	private int age;
	private int id;
	private PassengerCategory categoryPassenger;
	private double value;
	private static int count;
	public static final double INITIAL_VALUE_CATEGORYS = 10.000;
	public static final double INCREMENT_CHILDREN = 0.05;
	public static final double INCREMENT_YOUNG = 0.1;
	public static final double INCREMENT_ADULTS = 0.15;
	
	public Passenger(String name, int age, PassengerCategory category){
		this.name = name;
		this.age = age;
		this.id = ++count;
		this.categoryPassenger = category;
		this.value = INITIAL_VALUE_CATEGORYS;
		
	}

	public void setIncrementValue(){
		switch (categoryPassenger) {
			case NINIO:
				value += value * INCREMENT_CHILDREN; 
			break;
			case JOVEN:
				value += value * INCREMENT_YOUNG; 
			break;
			case ADULTO:
				value += value * INCREMENT_ADULTS; 
			break;
		}
	}

	public String getPassengerName(){
		return name;
	}

	public int getPassengerAge(){
		return age;
	}

	public int getPassengerId(){
		return id;
	}

	public PassengerCategory getCategory(){
		return categoryPassenger;
	}

	public void setPassengerCategory(PassengerCategory categoryPassenger){
		this.categoryPassenger = categoryPassenger;
	}

	@Override
	public String toString(){
		return name + ": " + categoryPassenger + "\n" ;
	}
}