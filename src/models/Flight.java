package models;

public class Flight{

	private String nameOfFlight;
	private String origin;
	private String destination;
	private double priceFlight;
	private String date;
	private FlightCategory categoryFlight;
	private int counterFlightsSold;

	public Flight(String nameOfFlight, String origin, String destination, double price, String date, FlightCategory category){
		this.nameOfFlight = nameOfFlight;
		this.origin = origin;
		this.destination = destination;
		this.priceFlight = price;
		this.date = date;
		this.categoryFlight = FlightCategory.PRIMERA;
		this.counterFlightsSold = 0;
	}

	public String getNameOfFlight(){
		return nameOfFlight;
	}

	public String getOriginOfFlight(){
		return origin;
	}

	public String getDestinationOfFlight(){
		return destination;
	}

	public double getPriceOfFlight(){
		return priceFlight;
	}

	public String getDateOfFlight(){
		return date;
	}

	public FlightCategory getCategoryFlight(){
		return categoryFlight;
	}

	public void setCategoryFlight(FlightCategory categoryFlight){
		this.categoryFlight = categoryFlight;
	}

	@Override
	public String toString(){
		return "\n" + " -> Nombre de vuelo: "+ nameOfFlight + "\n" + " -> Origen: " + origin + "\n" + " -> Con destino a: " 
		+ destination + "\n" + " -> Valor: " + priceFlight + "\n" + " -> Fecha de vuelo: " + date + "\n" + "_____________________________";
	}

}