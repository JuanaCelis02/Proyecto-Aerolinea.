package models;

public class Ticket{

	private Passenger passenger;
	private Flight flight;
	private int numberOfTickets;
	private int profits;
	private static int count;

	public Ticket(Passenger passenger, Flight flight, int numberOfTickets){
		this.passenger = passenger;
		this.flight = flight;
		this.profits = ++count;
	}

	public Passenger getPassager(){
		return passenger;
	}

	public Flight getFlight(){
		return flight;
	}

	public int getNumberOfTickets(){
		return numberOfTickets;
	}
	public int getFlightProfits(){
		return profits;
	}

	@Override
	public String toString(){
		return passenger + " -> " + flight + " -> " + numberOfTickets;
	}

}