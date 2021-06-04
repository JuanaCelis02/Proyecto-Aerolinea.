package views;

import models.PassengerCategory;
import models.FlightCategory;
import models.Passenger;
import java.util.Scanner;
import java.util.Arrays;

public class Console{

	private Scanner scanner;

	public static final int MENU_ONE = 1;
	public static final int MENU_TWO = 2;
	public static final int MENU_THREE = 3;
	public static final int MENU_FOUR = 4;
	public static final int MENU_FIVE = 5;
	public static final int MENU_SIX = 6;
	public static final int MENU_SEVEN = 7;
	public static final int MENU_EIGTH = 8;
	public static final int MENU_NINE = 9;
	public static final int MENU_TEN = 10;
	public static final int MENU_ELEVEN = 11;
	public static final int MENU_TWELVE = 12;
	public static final int MENU_THIRTEEN = 13;
	public static final int MENU_FOURTEEN = 14;
	public static final int MENU_FIFTEEN = 15;
	public static final int MENU_SIXTEEN = 16;
	public static final int MENU_SEVENTEEN = 17;
	
	
	public Console(){
		scanner = new Scanner(System.in);
	}

	public String getPassengerName(){
		System.out.println("Ingrese su nombre");
		return scanner.nextLine().trim();
	}

	public int getPassengerAge(){
		System.out.println("Ingrese su edad");
		return Integer.parseInt(scanner.nextLine());
	}

	public PassengerCategory getPassengerCategory(){
		String categoryPassenger = "";
		System.out.println("Ingrese la categoria segun la edad: \n BEBE (2 ANIOS O MENOS) \n NINIO (2 - 12 ANIOS) \n JOVEN (12 - 17 ANIOS) \n ADULTO (18 O MAS)");
		categoryPassenger = scanner.nextLine().toUpperCase().trim();
		return PassengerCategory.valueOf(categoryPassenger);

	}

	public void showMessagePassenger(){
		System.out.println("Pasajero registrado correctamente");
	}

	public String getFlinghtNameOfFlight(){
		System.out.println("Ingrese el nombre del nuevo vuelo");
		return scanner.nextLine().trim();
	}

	public String getOriginOfFlight(){
		System.out.println("Ingrese el origen de este nuevo vuelo");
		return scanner.nextLine().trim();
	}

	public String getDestinationOfFlight(){
		System.out.println("Ingrese el destino de este nuevo vuelo");
		return scanner.nextLine().trim();
	}

	public double getPriceOfFlight(){
		System.out.println("Ingrese el precio de este nuevo vuelo");
		return Double.parseDouble(scanner.nextLine());
	}

	public String getDateOfFlight(){
		System.out.println("Ingrese la fecha de este nuevo vuelo");
		return scanner.nextLine().trim();
	}

	public void showMessageFlight(){
		System.out.println("Vuelo registrado correctamente");
	}

	public void showMessageTicketByPassenger(int count){
		System.out.println("El numero de ticketes es: " + count);
	}

	public String getFilterFlightByName(){
		System.out.println("Ingrese el nombre del vuelo");
		return scanner.nextLine().trim();
	}

	public void showFlightMessage(String flights){
		System.out.println(flights);
	}

	public String getFilterFlightByDate(){
		System.out.println("Ingrese la fecha en la que busca su vuelo");
		return scanner.nextLine().trim();
	}

	public void showFlightDateMessage(String flights){
		System.out.println(flights);
	}

	public double getFilterFlightByPrice(){
		System.out.println("Ingrese el precio en el que busca su vuelo");
		return Double.parseDouble(scanner.nextLine());
	}

	public void showFlightPriceMessage(String flights){
		System.out.println(flights);
	}

	public int getFilterPassengerByAge(){
		System.out.println("Ingrese la edad que desea buscar");
		return Integer.parseInt(scanner.nextLine());
	}

	public void showFilterPassengerByAgeMessage(String flights){
		System.out.println(flights);
	}

	public String getOrigin(){
		System.out.println("Ingrese el lugar donde se encuentra");
		return scanner.nextLine().trim();
	}

	public String getDestination(){
		System.out.println("Ingrese el lugar de su destino");
		return scanner.nextLine().trim();
	}

	public FlightCategory getFlightCategory(){
		String categoryFlight = "";
		System.out.println("Ingrese la categoria de viaje: \n CLASE ECONOMICA = ECONOMICA \n CLASE EJECUTIVA = EJECUTIVA \n PRIMERA CLASE = PRIMERA ");
		categoryFlight = scanner.nextLine().toUpperCase().trim();
		return FlightCategory.valueOf(categoryFlight);

	}

	public void showPriceOfAFlightAccordingToCategory(double price){
		System.out.println("El valor de su vuelo seria de: " + price);
	}

	public int getId(){
		System.out.println("Ingrese su I.D");
		return Integer.parseInt(scanner.nextLine());
	}

	public String getName(){
		System.out.println("Ingrese su nombre");
		return scanner.nextLine().trim();
	}

	public void showMessageAssignCategoryToPassenger(String categoryToPassenger){
		System.out.println(categoryToPassenger);
	}

	public int getIdForPassenger(){
		System.out.println("Ingrese I.D");
		return Integer.parseInt(scanner.nextLine());
	}

	public void showsearchPassanger(Passenger passenger){
		System.out.println(passenger);
	}

	public int getNumberOfTickets(){
		System.out.println("Ingrese numero de tiquetes");
		return Integer.parseInt(scanner.nextLine());
	}

	public void showpassengerWithMorePurchase(String passengerWithMorePurchase){
		System.out.println("El numero de tiquetes mayor es: " + passengerWithMorePurchase);
	}

	public void showCountFlightCategory(int count){
		System.out.println("El numero de personas en esta categoria es de: " + count);

	}

	public void showFilerFlightByCategory(String flights){
		System.out.println(flights);
	}

	public void showCountPassengerCategory(int count){
		System.out.println("El numero de personas en esta categoria es de: " + count);

	}

	public void showFilerPassengerByCategoryPassengeR(String passenger){
		System.out.println(passenger);
	}

	public String getFilterFlightByOrigin(){
		System.out.println("Ingrese el lugar de donde desea viajar");
		return scanner.nextLine().trim();
	}

	public void showCalculateProfitsByFlightCategory(double profits){
		System.out.println("Las ganancias por categoria son de: " + profits);
	}

	public void showFlightByOrigin(String flights){
		System.out.println(flights);
	}







	public int showMenu(){
		System.out.println(" INGRESE \n 1. Guardar en lista de pasajero un nuevo pasajero. \n 2. Guardar en lista de vuelo un nuevo vuelo. \n 3. Devolver lista de vuelos que tengan el nombre ingresado. \n 4. Ver cantidad de tiquetes comprados por un pasajero (Ingresa informacion del pasajero)  \n 5. Devolver lista de vuelos con una fecha ingresada.  \n 6. Devolver lista de vuelos con un precio ingresado. \n 7. Devolver lista de personas con la edad ingresada \n 8. Calcular el valor de un vuelo segun la categoria de vuelo \n 9. Ingrese  Id y nombre para ver los datos de un pasajero \n 10. Buscar pasajero con I.D \n 11. Consultar pasajeros con mayor numero de ventas. \n 12. Consultar numero de clientes en una categoria de vuelo. \n 13. Devolver lista de vuelos de una categoria especifica. \n 14. Consultar numero de clientes en una categoria de pasajero. \n 15. Devolver lista de pasajeros de una categoria especifica. \n 16. Devolver lista de vuelos disponibles desde un punto de origen \n 17. Calcular ganancia por categorias");
		return Integer.parseInt(scanner.nextLine());
	}

}
