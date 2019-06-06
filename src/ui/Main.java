package ui;

import java.util.*;
import model.*;

public class Main {

	private Holding myHolding;
	private Scanner input;

	public Main() {
		init();
		input = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.showMenu();
	}

	public void showMenu() {
		int option = 0;

		while (option != 20) {

			showOptions();
			option = input.nextInt();
			input.nextLine();
			if (option == 1) {

				System.out.println("Enter the company's name");
				String cn = input.nextLine();
				System.out.println("Enter the company's nit");
				String cnit = input.nextLine();
				System.out.println("Enter the company's address");
				String ca = input.nextLine();
				System.out.println("Enter the company's phone");
				String cp = input.nextLine();
				System.out.println("Enter the company's amount of employees");
				int ce = Integer.parseInt(input.nextLine());
				System.out.println("Enter the company's asset value");
				double cav = Double.parseDouble(input.nextLine());
				System.out.println("Enter the company's constitutation day");
				int cd = Integer.parseInt(input.nextLine());
				System.out.println("Enter the company's constitutation month");
				int cm = Integer.parseInt(input.nextLine());
				System.out.println("Enter the company's constitutation year");
				int cy = Integer.parseInt(input.nextLine());
				System.out.println("Wich one of the following is the company's type. Please enter the number");
				myHolding.showthetypesofcompanies();
				String type = input.nextLine();
				String typeF = myHolding.showTcompany(type);
				System.out.println("Enter the name of the legal representative");
				String lrc = input.nextLine();
				System.out.println("What kind of company is the company goint to be?");
				myHolding.showTypeOfCompanies();
				String option2 = input.nextLine();
				if (option2.equals("1")) {
					ManufacturingCompany m = new ManufacturingCompany(cn, cnit, ca, cp, ce, cav, cd, cm, cy, typeF,
							lrc);
					myHolding.addCompany(m);
					myHolding.getCompanies().add(m);
					System.out.println("Congrats. The company has been created");
				} else if (option2.equals("2")) {
					System.out.println("Enter the sanitary registration");
					String sr = input.nextLine();
					System.out.println("Enter the status");
					String st = input.nextLine();
					System.out.println("Enter the expiration month");
					int em = Integer.parseInt(input.nextLine());
					System.out.println("Enter the expiration year");
					int ey = Integer.parseInt(input.nextLine());
					System.out.println("Wich of the following is the company's modality");
					myHolding.showModalityMedicineCompany();
					String opp = input.nextLine();
					String modality = myHolding.modalityMedicineCompany(opp);
					MedicineManufacturingCompany m = new MedicineManufacturingCompany(cn, cnit, ca, cp, ce, cav, cd, cm,
							cy, typeF, lrc, sr, st, em, ey, modality);
					myHolding.addCompany(m);
					myHolding.getCompanies().add(m);
					System.out.println("Congrats. The company has been created");
				} else if (option2.equals("3")) {
					ServiceCompany m = new ServiceCompany(cn, cnit, ca, cp, ce, cav, cd, cm, cy, typeF, lrc);
					myHolding.addCompany(m);
					myHolding.getCompanies().add(m);
					System.out.println("Congrats. The company has been created");
				} else if (option2.equals("4")) {
					System.out.println("Which of the following is the company's type of service");
					myHolding.showtypeOfServicePSC();
					String opp = input.nextLine();
					String typeOfService = myHolding.typeOfServicePSC(opp);
					System.out.println("Enter the number of the total of suscribers");
					int suscribersT = Integer.parseInt(input.nextLine());
					System.out.println("Enter the number of the suscribers stratum 1 and 2");
					int suscribers1and2 = input.nextInt();
					PublicServiceCompany m = new PublicServiceCompany(cn, cnit, ca, cp, ce, cav, cd, cm, cy, typeF, lrc,
							typeOfService, suscribersT, suscribers1and2);
					myHolding.addCompany(m);
					myHolding.getCompanies().add(m);
					System.out.println("Congrats. The company has been created");
				} else if (option2.equals("5")) {
					System.out.println("Enter registration number");
					int rn = Integer.parseInt(input.nextLine());
					System.out.println("Enter the company's high quality identity years");
					int hgy = Integer.parseInt(input.nextLine());
					System.out.println("Enter the company's saber11 national position");
					int s11 = Integer.parseInt(input.nextLine());
					System.out.println("Enter the company's saberPro national position");
					int spro = Integer.parseInt(input.nextLine());
					System.out.println("Enter company's rector name");
					String rectorn = input.nextLine();
					System.out.println("Enter the company's education sector");
					String es = input.nextLine();
					System.out.println("Enter the company's stratum");
					int stratum = Integer.parseInt(input.nextLine());
					System.out.println("Enter the company's active students of stratum 1 and 2 ");
					int s1and2 = Integer.parseInt(input.nextLine());
					System.out.println("Enter the company's total active students");
					int st = input.nextInt();
					EducationCompany m = new EducationCompany(cn, cnit, ca, cp, ce, cav, cd, cm, cy, typeF, lrc, rn,
							hgy, s11, spro, rectorn, es, stratum, s1and2, st);

					myHolding.addCompany(m);
					myHolding.getCompanies().add(m);
					System.out.println("Congrats. The company has been created");
				} else if (option2.equals("6")) {
					System.out.println("Enter the amount of energy used in the company");
					double amountOfEnergyUsed = input.nextDouble();
					TechnologicalCompany m = new TechnologicalCompany(cn, cnit, ca, cp, ce, cav, cd, cm, cy, typeF, lrc,
							amountOfEnergyUsed);
					myHolding.addCompany(m);
					myHolding.getCompanies().add(m);
					System.out.println("Congrats. The company has been created");

				} else {
					System.out.println("Wrong option");
				}

			} else if (option == 2) {
				System.out.println("Wich one of the following companies you'd like to add a building. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				System.out.println(
						"How many floor do you want the building to have? Please, enter a number between 3 and 7");
				int numberOfFloors = input.nextInt();
				myHolding.addBuildingToACompany2(nameOfCompany, numberOfFloors);
			} else if (option == 3) {
				System.out.println("Wich one of the following companies you'd like to add a product. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				System.out.println("Enter the name of the product");
				String np = input.nextLine();
				System.out.println("Enter the code of the product");
				String cp = input.nextLine();
				System.out.println("Enter the amount of water used in the product");
				double wp = Double.parseDouble(input.nextLine());
				System.out.println("Enter the number of units in inventory of the product");
				int ip = input.nextInt();
				myHolding.addProductsToACompany(nameOfCompany, np, cp, wp, ip);
			} else if (option == 4) {
				System.out.println(
						"Wich one of the following companies you'd like to calculate proculture tax. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				myHolding.calculateProcultureTax(nameOfCompany);
			} else if (option == 5) {
				System.out.println(
						"Wich one of the following companies you'd like to calculate the trees it has to plant. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				myHolding.calculateNaturalResource(nameOfCompany);
			} else if (option == 6) {
				System.out
						.println("Wich one of the following companies you'd like to register its poll. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				System.out.println(
						"1.On a scale of 1 to 5 where 1 is not satisfied and 5 is very satisfied how satisfied you are with the service provided");
				int a1 = Integer.parseInt(input.nextLine());
				System.out.println(
						"2.On a scale of 1 to 5 where 1 is not satisfied and 5 is very satisfied how satisfied you are with the response time given");
				int a2 = Integer.parseInt(input.nextLine());
				System.out.println(
						"3.On a scale of 1 to 5 where 1 is not satisfied and 5 is very satisfied how satisfied you are with the cost "
								+ "/ benefit ratio of the service purchased");
				int a3 = input.nextInt();

				myHolding.realizePoll(nameOfCompany, a1, a2, a3);
			} else if (option == 7) {
				System.out
						.println("Wich one of the following companies you'd like to register its poll. Enter the name");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				myHolding.calculateSatisfactionClients(nameOfCompany);
			}else if(option ==8) {
				System.out.println("Wich one of the following companies you'd like to add a employee to its building");
				System.out.println(myHolding.showActualCompanies());
				String nameOfCompany = input.nextLine();
				System.out.println("Enter the employee's name");
				String en=input.nextLine();
				System.out.println("Enter the employee's charge");
				String ec=input.nextLine();
				System.out.println("Enter the employee's email");
				String ee=input.nextLine();
				myHolding.addEmployeToACubicle(en, ee, ec);
				System.out.println(myHolding.getCompanies().get(0).getBuilding().getCublicles()[0][0].getEmployeeName());
			}
		}

	}

	public void showOptions() {
		System.out.println("WELCOME TO THE HOLDING. WHAT WOULD YOU LIKE TO DO?");
		System.out.println("1.To register a company");
		System.out.println("2.To add a building to a company");
		System.out.println("3.To add products to a company");
		System.out.println("4.To calculate the proculture tax of a company");
		System.out.println(
				"5.To calculate how many trees a company has to plant based on the amount of the natural resource used");
		System.out.println("6.To register a poll for a company");
		System.out.println("7.To calculate the satisfaction of the clients for a company");
		System.out.println("8.To add an employee to a cubicle in a company's building");

		
//		System.out.println("1. jajan't");
//		System.out.println(myHolding.getBuilding().getCublicles()[0][0].getExtension());
//		System.out.println(myHolding.getBuilding().getNumberOfFloors());
//		System.out.println(myHolding.getCompanies().get(5).getPhone());
//		MedicineManufacturingCompany med = (MedicineManufacturingCompany) myHolding.getCompanies().get(5);
//		System.out.println(med.getProducts().get(0).getName());
//		System.out.println(med.naturalResourceXTree());
//		System.out.println(med.getProducts().get(0).getAmountOfWater());
//		EducationCompany ed= (EducationCompany) myHolding.getCompanies().get(2);
//		System.out.println(ed.procultureTax());
	}

	public void init() {
		myHolding = new Holding("Holding S.A");

		ServiceCompany sc1 = new ServiceCompany("PINIVA SERVICES", "1010138801", "Kra9 Av 9", "2670039", 2, 5000000, 3,
				6, 2019, Company.TSC, "Andrea Nunez");
		TechnologicalCompany tc1 = new TechnologicalCompany("Fever Technological SAS", "1010138803", "kra3", "333", 2,
				2000000, 3, 6, 2019, Company.CS, "Armin", 20);
		EducationCompany edc1 = new EducationCompany("Tio Conejo", "1010138804", "kra3", "444", 2, 50000000, 3, 6, 2019,
				Company.FS, "Eren", 0001, 5, 4, 2, "Levi", "UpLevel", 5, 200, 400);
		PublicServiceCompany psc1 = new PublicServiceCompany("Acuavalle SA", "1010138805", "Kra5", "555", 2, 7000000, 3,
				3, 2019, Company.EGS, "Erwin", PublicServiceCompany.AQUEDUCT, 1000, 500);

		ManufacturingCompany mn1 = new ManufacturingCompany("The Middle SAS", "1010138802", "Kra2", "2222", 2, 10000000,
				3, 6, 2019, Company.MI, "Beck");
		MedicineManufacturingCompany mc1 = new MedicineManufacturingCompany("San Roque", "1010138806", "Kra6", "6666",
				2, 3000000, 3, 6, 2019, Company.FS, "Mikasa", "222", "Uplevel", 6, 2019,
				MedicineManufacturingCompany.MANUFACTURE_AND_EXPORT);

		myHolding.addCompany(sc1);
		myHolding.addCompany(tc1);
		myHolding.addCompany(edc1);
		myHolding.addCompany(psc1);
		myHolding.addCompany(mn1);
		myHolding.addCompany(mc1);
//		myHolding.getCompanies().add(sc1);
//		myHolding.getCompanies().add(tc1);
//		myHolding.getCompanies().add(edc1);
//		myHolding.getCompanies().add(psc1);
//		myHolding.getCompanies().add(mn1);
//		myHolding.getCompanies().add(mc1);
//		
//		Building buildingHolding=new Building(4);
//		myHolding.setBuilding(buildingHolding);
//		//myHolding.getBuilding().getCublicles()[0][0].setTheBuilding(buildingHolding);
//		
//		
//		Building buildingService=new Building(5);
//		sc1.setBuilding(buildingService);
//		
//		Building buildingTechnology = new Building(6);
//		tc1.setBuilding(buildingTechnology);
//		
//		Building buildingEducation = new Building(7);
//		edc1.setBuilding(buildingEducation);
//		
//		Building buildingPservice = new Building(5);
//		psc1.setBuilding(buildingPservice);
//		
//		Building buildingMCompany=new Building(6);
//		mn1.setBuilding(buildingMCompany);
//		
//		Building buildingMedicineC=new Building(4);
//		mc1.setBuilding(buildingMedicineC);
//		
//		Product mc = new Product("Televisor", "000", 50, 10);
//		mn1.addProducts(mc);
//		mn1.getProducts().add(mc);
//		
//		Product md =new Product("Acetaminofen", "001", 500, 500);
//		mc1.addProducts(md);
//		mc1.getProducts().add(md);
//		

	}

}
