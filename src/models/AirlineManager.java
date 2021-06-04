package models;

import java.util.Arrays;

public class AirlineManager{

	private Passenger [] passengerList;
	private Ticket [] ticketlist;
	private Flight [] flightList;
	public static final int SIZE_LIST = 15;
	public static final int MIN_TICKETS = 3;
	public static final double INCREMENT_ECONOMIC_CLASS = 1;
	public static final double INCREMENT_EJECUTIV_CLASS = 0.20;
	public static final double INCREMENT_FIRST_CLASS = 0.40;

	public AirlineManager(){
		passengerList = new Passenger[SIZE_LIST];
		passengerList[0] = new Passenger("Juana Celis", 17, PassengerCategory.JOVEN);
		passengerList[1] = new Passenger("David", 21, PassengerCategory.ADULTO);
		passengerList[2] = new Passenger("Gabriela", 18, PassengerCategory.ADULTO);
		passengerList[3] = new Passenger("Nicolas", 12, PassengerCategory.ADULTO);

		flightList = new Flight[SIZE_LIST];
		flightList[0] = new Flight("AB-2505", "BOGOTA","MEDELLIN", 60.000, "30/02/2020", FlightCategory.PRIMERA);
		flightList[1] = new Flight("AB-2355", "BOGOTA", "BARRANQUILLA", 80.000, "30/03/2020",  FlightCategory.ECONOMICA);
		flightList[2] = new Flight("AB-3457", "BOGOTA", "CALI", 70.000, "30/03/2020",  FlightCategory.EJECUTIVA);
		flightList[3] = new Flight("AM-2505", "MEDELLIN", "BOGOTA", 60.000, "30/03/2020",  FlightCategory.PRIMERA);
		flightList[4] = new Flight("AM-2355", "MEDELLIN", "CALI", 50.000, "30/03/2020",  FlightCategory.PRIMERA);
		flightList[5] = new Flight("AM-3457", "MEDELLIN", "BARRANQUILLA", 80.000, "30/03/2020",  FlightCategory.PRIMERA);
		flightList[6] = new Flight("AC-2505", "CALI", "BOGOTA", 70.000, "30/03/2020",  FlightCategory.ECONOMICA);
		flightList[7] = new Flight("AC-2355", "CALI", "MEDELLIN", 70.000, "30/03/2020",  FlightCategory.ECONOMICA);
		flightList[8] = new Flight("AC-3457", "CALI", "BARRANQUILLA", 70.000, "30/03/2020",  FlightCategory.ECONOMICA);
		flightList[9] = new Flight("AQ-2505", "BARRANQUILLA", "BOGOTA", 80.000, "30/03/2020",  FlightCategory.PRIMERA);
		flightList[10] = new Flight("AQ-2355", "BARRANQUILLA", "MEDELLIN", 80.000, "30/03/2020",  FlightCategory.EJECUTIVA);

		ticketlist = new Ticket[SIZE_LIST];
		ticketlist[0] = new Ticket(passengerList[0], flightList[1], 3);
		ticketlist[1] = new Ticket(passengerList[1], flightList[5], 2);
		ticketlist[2] = new Ticket(passengerList[0], flightList[9], 6);

	}
	
	public void registerNewPassenger(Passenger passenger){
		for(int i = 0; i < passengerList.length; i++){
			if(passengerList[i] == null){
				passengerList[i] = passenger;
				System.out.println("Pasajero agregado correctamente: " + passenger);
				return;
			}
		}
	}

	public void addNewFlight(Flight flight){
		for(int i = 0; i < flightList.length; i++){
			if(flightList[i] == null){
				flightList[i] = flight;
				System.out.println("Este nuevo paquete de vuelo se ingreso correctamente: " + flight);
				return;
			}
		}
	}

	public void print(){
		for (Passenger passenger : passengerList) {
			System.out.println(passenger);
		}
	}



	public int countTicketByPassenger(Passenger passenger){
		int count = 0;
		for (Ticket ticket : ticketlist) {
			if (ticket != null && ticket.getPassager().equals(passenger)) {
				count++;
			}
		}
		return count;
	}

	public void incrementValues(){
		for (Passenger passenger : passengerList) {
			if (passenger != null && countTicketByPassenger(passenger) > MIN_TICKETS) {
				passenger.setIncrementValue();
			}
		}
	}

	public String filterFlightByName(String nameOfFlight){
		Flight [] list = new Flight[flightList.length];
		int count = 0;
		for(Flight flight : flightList){
			if(flight != null && flight.getNameOfFlight().contains(nameOfFlight)){
				list[count++] = flight;
			}
		}
		return Arrays.toString(list);
	}

	public String filterFlightByDate(String date){
		Flight [] list = new Flight[flightList.length];
		int count = 0;
		for(Flight flight : flightList){
			if(flight != null && flight.getDateOfFlight().contains(date)){
				list[count++] = flight;
			}
		}
		return  Arrays.toString(list);
	}

	public String filterFlightByPrice(double price){
		Flight [] list = new Flight[flightList.length];
		int count = 0;
		for(Flight flight : flightList){
			if(flight != null && flight.getPriceOfFlight() == (price)){
				list[count++] = flight;
			}
		}
		return Arrays.toString(list);
	}

	public String filterPassengerByAge(int age){
		Passenger [] list = new Passenger[passengerList.length];
		int count = 0;
		for(Passenger passenger : passengerList){
			if(passenger != null && passenger.getPassengerAge() == (age)){
				list[count++] = passenger;
			}
		}
		return Arrays.toString(list);
	}
	public double checkPriceOfAFlightAccordingToCategory(String origin, String destination, FlightCategory category){
		double price = 0;
		for(Flight flight : flightList){
			if(flight != null && flight.getOriginOfFlight().equals(origin) && flight.getDestinationOfFlight().contains(destination) && flight.getCategoryFlight().equals(category)){
				flight.setCategoryFlight(category);

					switch (category) {
					case ECONOMICA:
						price += flight.getPriceOfFlight() + (flight.getPriceOfFlight() * INCREMENT_ECONOMIC_CLASS) ; 
					break;
					case EJECUTIVA:
							price += flight.getPriceOfFlight() + (flight.getPriceOfFlight() * INCREMENT_EJECUTIV_CLASS) ; 
					break;
					case PRIMERA:
						price += flight.getPriceOfFlight() + (flight.getPriceOfFlight() * INCREMENT_FIRST_CLASS) ;
					break;
		
				}
			}
		}
		return price;
	}

	public String assignCategoryToPassenger(int id, String name){
		String infoPassenger = "";
		for (Passenger passenger : passengerList){
			if(passenger != null && passenger.getPassengerId() == id && passenger.getPassengerName().equals(name)){
				infoPassenger = passenger.getPassengerName() +" -> " + passenger.getPassengerAge()+ " -> " + passenger.getPassengerId() + " -> "+ passenger.getCategory();
			}
		}
		return infoPassenger;
	}

	public Passenger searchPassanger(int id){
		for (Passenger passenger : passengerList) {
			if (passenger != null && passenger.getPassengerId() == id) {
				return passenger;
			}
		}
		return null;
	}

	public String passengersWithTheHighestNumberOfPurchases(int numberOfTickets){
		String passengerWithMorePurchase = "";
		for(Ticket ticket : ticketlist){
			if(ticket != null && ticket.getNumberOfTickets() >=  numberOfTickets){
				passengerWithMorePurchase = ticket.getPassager().getPassengerName() + "->" + ticket.getFlight().getNameOfFlight();
			}
		}
		return passengerWithMorePurchase;
	}

	public int countFlightCategory(FlightCategory category){
		int count = 0;
		for(Flight flight : flightList){
			if(flight != null && flight.getCategoryFlight().equals(category)){
				count++;
			}
		}
		return count;
	}

	public String filerFlightByCategory(FlightCategory category){
		Flight [] list = new Flight[countFlightCategory(category)];
		int count = 0;
		for(Flight flight : flightList){
			if(flight != null && flight.getCategoryFlight().equals(category)){
				list[count++] = flight;
			}
		}
		return Arrays.toString(list);
	}

	public int countPassengerCategory(PassengerCategory category){
		int count = 0;
		for(Passenger passenger : passengerList){
			if(passenger != null && passenger.getCategory().equals(category)){
				count++;
			}
		}
		return count;
	}

	public String filerPassengerByCategory(PassengerCategory category){
		Passenger [] listPassengerByCategory = new Passenger[countPassengerCategory(category)];
		int count = 0;
		for(Passenger passenger : passengerList){
			if(passenger != null && passenger.getCategory().equals(category)){
				listPassengerByCategory[count++] = passenger;
			}
		}
		return Arrays.toString(listPassengerByCategory);
	}

	public String  searchForAvailableFlightsFromOrigin(String origin){
		Flight [] list = new Flight[flightList.length];
		int count = 0;
		for(Flight flight : flightList){
			if(flight != null && flight.getOriginOfFlight().contains(origin)){
				list[count++] = flight;
			}
		}
		return Arrays.toString(list);
	}

	public double calculateProfitsByFlightCategory(FlightCategory category){
		double profits = 0;
		for(Ticket ticket : ticketlist){
			if(ticket != null && ticket.getFlight().getCategoryFlight().equals(category)){
				profits += (ticket.getFlight().getPriceOfFlight() * ticket.getFlightProfits());
			}
		}
		return profits;

	}
	
/*
	public static void main(String[] args) {
		AirlineManager avianca = new AirlineManager();
		avianca.registerNewPassenger(new Passenger("Manuel", 21, PassengerCategory.ADULTO));
		avianca.addNewFlight(new Flight("AQ-3457", "BARRANQUILLA", "CALI", 80.000, "30/03/2020"));
		System.out.println(avianca.checkPriceOfAFlightAccordingToCategory("BOGOTA", "MEDELLIN", FlightCategory.EXECUTIVE_CLASS));
		System.out.println(avianca.assignCategoryToPassenger(1, "Juana Celis"));
		System.out.println(avianca.assignCategoryToPassenger(2, "Manuel"));
		System.out.println(avianca.searchPassanger(4));
		System.out.println(Arrays.toString( avianca.searchForAvailableFlightsFromOrigin("BOGOTA")));
		System.out.println(avianca.passengersWithTheHighestNumberOfPurchases(4));
		System.out.println(avianca.countFlightCategory(FlightCategory.EXECUTIVE_CLASS));
		System.out.println(Arrays.toString(avianca.filerFlightByCategory(FlightCategory.EXECUTIVE_CLASS)));
		System.out.println(Arrays.toString(avianca.filerPassengerByCategory(PassengerCategory.ADULTO)));


	}
	*/
}