package presenter;

import models.Passenger;
import models.Flight;
import models.AirlineManager;
import models.Ticket;
import views.Console;

public class Presenter{

	private AirlineManager airline;
	private Console console;

	public Presenter(){
		airline = new AirlineManager();
		console = new Console();
		showMenu();
	}
	public void showMenu(){
		int option = console.showMenu();
		switch(option){
				case Console.MENU_ONE:
						registerNewPassenger();
				break;
				case Console.MENU_TWO:
						addNewFlight();
				break;
				case Console.MENU_THREE:
						filterFlightByName();
				break;
				case Console.MENU_FOUR:
						countTicketByPassenger();
				break;
				case Console.MENU_FIVE:
						filterFlightByDate();
				break;
				case Console.MENU_SIX:
						filterFlightByPrice();
				break;
				case Console.MENU_SEVEN:
						filterPassengerByAge();
				break;
				case Console.MENU_EIGTH:
						checkPriceOfAFlightAccordingToCategory();
				break;
				case Console.MENU_NINE:
						assignCategoryToPassenger();
				break;
				case Console.MENU_TEN:
						searchPassanger();
				break;
				case Console.MENU_ELEVEN:
						passengersWithTheHighestNumberOfPurchases();
				break;
				case Console.MENU_TWELVE:
						countFlightCategory();
				break;
				case Console.MENU_THIRTEEN:
						filerFlightByCategory();
				break;
				case Console.MENU_FOURTEEN:
						countPassengerCategory();
				break;
				case Console.MENU_FIFTEEN:
						filerPassengerByCategory();
				break;
				case Console.MENU_SIXTEEN:
						searchForAvailableFlightsFromOrigin();
				break;
				case Console.MENU_SEVENTEEN:
						calculateProfitsByFlightCategory();
				break;
				default: 
					System.out.println("SOLO 15 OPCIONES");
					return;
		}
		showMenu();
	}

	public void registerNewPassenger(){
		airline.registerNewPassenger(new Passenger(console.getPassengerName(), console.getPassengerAge(), console.getPassengerCategory()));
		console.showMessagePassenger();
	}

	public void addNewFlight(){
		airline.addNewFlight(new Flight(console.getFlinghtNameOfFlight(), console.getOriginOfFlight(), console.getDestinationOfFlight(), console.getPriceOfFlight(), console.getDateOfFlight(),console.getFlightCategory()));	
		console.showMessageFlight();
	}

	public void filterFlightByName(){
		console.showFlightMessage(airline.filterFlightByName(console.getFilterFlightByName()));
	}

	public void countTicketByPassenger(){
		int tickets = airline.countTicketByPassenger(new Passenger(console.getPassengerName(), console.getPassengerAge(), console.getPassengerCategory()));
		console.showMessageTicketByPassenger(tickets);
	}

	public void filterFlightByDate(){
		console.showFlightDateMessage(airline.filterFlightByDate(console.getFilterFlightByDate()));
	}

	public void filterFlightByPrice(){
		console.showFlightPriceMessage(airline.filterFlightByPrice(console.getFilterFlightByPrice()));
	}

	public void filterPassengerByAge(){
		console.showFilterPassengerByAgeMessage(airline.filterPassengerByAge(console.getFilterPassengerByAge()));
	}

	public void checkPriceOfAFlightAccordingToCategory(){
		double price = airline.checkPriceOfAFlightAccordingToCategory(console.getOrigin(), console.getDestination(), console.getFlightCategory());
		console.showPriceOfAFlightAccordingToCategory(price);
	}

	public void assignCategoryToPassenger(){
		console.showMessageAssignCategoryToPassenger(airline.assignCategoryToPassenger(console.getId(), console.getName()));

	}

	public void searchPassanger(){
		console.showsearchPassanger(airline.searchPassanger(console.getIdForPassenger()));
	}

	public void passengersWithTheHighestNumberOfPurchases(){
		console.showpassengerWithMorePurchase(airline.passengersWithTheHighestNumberOfPurchases(console.getNumberOfTickets()));
	}

	public void countFlightCategory(){
		int count = airline.countFlightCategory(console.getFlightCategory());
		console.showCountFlightCategory(count);
	}

	public void filerFlightByCategory(){
		console.showFilerFlightByCategory(airline.filerFlightByCategory(console.getFlightCategory()));
	}

	public void countPassengerCategory(){
		int count = airline.countPassengerCategory(console.getPassengerCategory());
		console.showCountPassengerCategory(count);
	}

	public void filerPassengerByCategory(){
		console.showFilerPassengerByCategoryPassengeR(airline.filerPassengerByCategory(console.getPassengerCategory()));
	}

	public void searchForAvailableFlightsFromOrigin(){
		console.showFlightByOrigin(airline.searchForAvailableFlightsFromOrigin(console.getFilterFlightByOrigin()));
	}

	public void calculateProfitsByFlightCategory(){
		console.showCalculateProfitsByFlightCategory(airline.calculateProfitsByFlightCategory(console.getFlightCategory()));
	}

	public static void main (String [] list){
		new Presenter();
	}

}