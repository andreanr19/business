package model;

import java.util.*;

public class Holding implements HaulBuilding {

	private String name;
	// Relaciones

	private ArrayList<Company> companies;
	private Building building;

	// Constructor

	public Holding(String name) {

		companies = new ArrayList<Company>();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addCompany(Company newCompany) {
		companies.add(newCompany);
	}

	public ArrayList<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	// Metodos

	public String haulEmail(String chargeEmployeed) {

		int filas = 0;
		int columnas = 0;
		int numCeldas = 0;
		int totalCeldas = (building.getCublicles().length * building.getCublicles()[0].length);
		int minY = 0;
		int minX = 0;
		int maxY = building.getCublicles().length - 1;
		int maxX = building.getCublicles()[0].length - 1;
		int direccion = HaulBuilding.ABAJO;
		String msg = "";

		while (numCeldas < totalCeldas) {

			switch (direccion) {

			case ABAJO:

				filas++;
				if (filas == maxY) {
					direccion = HaulBuilding.DERECHA;
					minX++;
				}

				msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

			case DERECHA:

				columnas++;
				if (columnas == maxX) {
					direccion = HaulBuilding.ARRIBA;
					maxY--;
				}

				msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

			case ARRIBA:
				filas--;
				if (filas == minY) {
					direccion = HaulBuilding.IZQUIERDA;
					maxX--;
				}

				msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

			case IZQUIERDA:
				columnas--;
				if (columnas == minX) {
					direccion = HaulBuilding.ABAJO;
					minY++;
				}

				msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

			}
		}

		return msg;

	}
	
	//RECORRIDO EN X
	public String haulExtensionX(String nameEmployeed) {
		String msg ="";
		
		for(int i=0;i<building.getCublicles().length;i++) {
			msg+= building.getCublicles()[i][i].haulExtensionEmployee(nameEmployeed)+"\n";
		}
		for(int k=0;k<building.getCublicles().length;k++) {
			if((building.getCublicles().length%2==0) || (building.getCublicles().length%2!=0 && k!=building.getCublicles().length/2)){
				msg+=building.getCublicles()[k][building.getCublicles().length-1-k].haulExtensionEmployee(nameEmployeed);
			}
		}return msg;
	}

	public void showTypeOfCompanies() {
		System.out.println("1.Manufacturing Company \n" + "2.Medicine Manufacturing Company \n" + "3.Service Company \n"
				+ "4.Public Service Company \n" + "5.Education Company \n" + "6.Technological Company");
	}

	public String showTcompany(String option) {
		String typeCompany = "";
		String AGFF = "1";
		String EMQ = "2";
		String MI = "3";
		String EGS = "4";
		String B = "5";
		String WR = "6";
		String TSC = "7";
		String FS = "8";
		String CS = "9";

		if (option.equals(AGFF)) {
			typeCompany = Company.AHFF;
		} else if (option.equals(EMQ)) {
			typeCompany = Company.EMQ;
		} else if (option.equals(MI)) {
			typeCompany = Company.MI;
		} else if (option.equals(EGS)) {
			typeCompany = Company.EGS;
		} else if (option.equals(B)) {
			typeCompany = Company.B;
		} else if (option.equals(WR)) {
			typeCompany = Company.WR;
		} else if (option.equals(TSC)) {
			typeCompany = Company.TSC;
		} else if (option.equals(FS)) {
			typeCompany = Company.FS;
		} else {
			typeCompany = Company.CS;
		}
		return typeCompany;
	}

	public void showthetypesofcompanies() {
		System.out.println("1.AGRICULTURE, HUNTING, FORESTRY AND FISHING\n" + "2.EXPLOTATION, MINES AND QUARRIES\n"
				+ "3.MANUFACTURING INDUSTRY\n" + "4.ELECTRICITY, GAS AND STEAM\n" + "5.BUILDING\n"
				+ "6.WHOLESALE AND RETAIL\n" + "7.TRANSPORTATION STORAGE COMMUNICATIONS\n" + "8.FINANCIAL STATEMENT\n"
				+ "9.COMUNAL AND SOCIAL");

	}

	public void showOptionsCreateCompany(String option, String name, String nit, String address, String phone,
			int amountOfEmployees, double assetValue, int constitutionDay, int constitutionMonth, int constitutionYear,
			String type, String legalRepresentative) {
		String ManufacturingCompany = "1";
		String MedicineManufacturingCompany = "2";
		String ServiceCompany = "3";
		String PublicServiceCompany = "4";
		String EducationCompany = "5";
		String TechnologicalCompany = "6";

		if (option.equals(ManufacturingCompany) || option.equals(MedicineManufacturingCompany)) {
			Company m = new ManufacturingCompany(name, nit, address, phone, amountOfEmployees, assetValue,
					constitutionDay, constitutionMonth, constitutionYear, type, legalRepresentative);
			addCompany(m);
			getCompanies().add(m);
			System.out.println("Your company has been sucessfully created");

		} else if (option.equals(ServiceCompany) || option.equals(PublicServiceCompany)
				|| option.equals(EducationCompany) || option.equals(TechnologicalCompany)) {
			Company m = new ServiceCompany(name, nit, address, phone, amountOfEmployees, assetValue, constitutionDay,
					constitutionMonth, constitutionYear, type, legalRepresentative);
			addCompany(m);
			getCompanies().add(m);
			System.out.println("Your company has been sucessfully created");

		}
	}

	public void verifyInstanceOfACompany(Company c, String sanitaryRegistration, String status, int expirationMonth,
			int expirationYear, String modality) {
		if (c instanceof ManufacturingCompany) {
			MedicineManufacturingCompany med = (MedicineManufacturingCompany) c;
			med.setSanitaryRegistration(sanitaryRegistration);
			med.setStatus(status);
			med.setExpirationMonth(expirationMonth);
			med.setExpirationYear(expirationYear);
			med.setModality(modality);
		}
	}

	public void showModalityMedicineCompany() {
		System.out.println("1.Manufacture and export\n" + "2.Manufacture and sell\n" + "3.Import and sell");
	}

	public String modalityMedicineCompany(String option) {
		String modalityCompany = "";
		String MAE = "1";
		String MAS = "2";
		String IAS = "3";
		if (option.equals(MAE)) {
			modalityCompany = MedicineManufacturingCompany.MANUFACTURE_AND_EXPORT;
		} else if (option.equals(MAS)) {
			modalityCompany = MedicineManufacturingCompany.MANUFACTURE_AND_SELL;
		} else {
			modalityCompany = MedicineManufacturingCompany.IMPORT_AND_SELL;
		}
		return modalityCompany;
	}

	public void showtypeOfServicePSC() {
		System.out.println("1.Sewerage\n" + "2.Energy\n" + "3.Aqueduct");
	}

	public String typeOfServicePSC(String option) {
		String type = "";
		String S = "1";
		String E = "2";
		String A = "3";
		if (option.equals(S)) {
			type = PublicServiceCompany.SEWERAGE;
		} else if (option.equals(E)) {
			type = PublicServiceCompany.ENERGY;
		} else {
			type = PublicServiceCompany.AQUEDUCT;
		}
		return type;
	}

	public String showActualCompanies() {
		String companiesNames = "";
		if (companies.size() != 0) {

			for (int i = 0; i < companies.size(); i++) {
				companiesNames += i + 1 + "." + companies.get(i).getName() + "\n";
			}
		} else {
			companiesNames += "There's no companies in the holding yet.";
		}
		return companiesNames;
	}

	public void addBuildingtoACompany(String nameOfCompany, int numberOfFloors) {

		boolean stop = false;
		for (int i = 0; i < companies.size() && !stop; i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (numberOfFloors >= 3 && numberOfFloors <= 7) {

					Building b = new Building(numberOfFloors);
					companies.get(i).setBuilding(b);
					System.out.println("The building has been added to the company " + companies.get(i).getName());
					stop = true;
					break;
				} else if (numberOfFloors > 7) {
					System.out.println("A company can't have a building of more than 7 floors");
				} else {
					System.out.println("A company can't have a building of less than 3 floors");
				}
				break;

			} else {
				System.out.println("The company " + nameOfCompany + " doesn't exist");

			}
		}
	}

	public void addBuildingToACompany2(String nameOfCompany, int numberOfFloors) {
		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (companies.get(i).getBuilding() == null) {
					if (numberOfFloors >= 3 && numberOfFloors <= 7) {
						Building b = new Building(numberOfFloors);
						companies.get(i).setBuilding(b);
						System.out.println("The building has been added to the company " + companies.get(i).getName());
					} else if (numberOfFloors > 7) {
						System.out.println("A company can't have a building of more than 7 floors");
					} else {
						System.out.println("A company can't have a building of less than 3 floors");
					}
				} else {
					System.out.println("The company " + companies.get(i).getName() + " has a building already");
				}
			}
		}
	}

	public void addProductsToACompany(String nameOfCompany, String nameOfProduct, String codeOfProduct,
			double amountOfWater, int unitsInInventory) {

		boolean stop = false;
		for (int i = 0; i < companies.size() && !stop; i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (companies.get(i) instanceof ManufacturingCompany
						&& companies.get(i) instanceof MedicineManufacturingCompany) {

					MedicineManufacturingCompany m = (MedicineManufacturingCompany) companies.get(i);
					Product p = new Product(nameOfProduct, codeOfProduct, amountOfWater, unitsInInventory);
					m.addProducts(p);
					stop = true;
					System.out
							.println("The product " + nameOfProduct + " has been added to the company " + m.getName());
				} else {
					System.out.println(
							"The company " + companies.get(i).getName() + " doesn't need products to be added");
					break;
				}

			}
		}
	}

	public void calculateProcultureTax(String nameOfCompany) {

		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {

				if (companies.get(i) instanceof EducationCompany) {

					EducationCompany m = (EducationCompany) companies.get(i);
					System.out.println(m.procultureTax());
				} else if (companies.get(i) instanceof PublicServiceCompany) {
					PublicServiceCompany m = (PublicServiceCompany) companies.get(i);
					System.out.println(m.procultureTax());
				} else {
					System.out.println("The company " + companies.get(i).getName() + " doesn't pay the proculture tax");
					break;
				}

			}
		}
	}

	public void calculateNaturalResource(String nameOfCompany) {
		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (companies.get(i) instanceof MedicineManufacturingCompany) {
					MedicineManufacturingCompany m = (MedicineManufacturingCompany) companies.get(i);
					System.out.println(m.naturalResourceXTree());
				} else if (companies.get(i) instanceof TechnologicalCompany) {
					TechnologicalCompany m = (TechnologicalCompany) companies.get(i);
					System.out.println(m.naturalResourceXTree());
				} else {
					System.out.println("The company " + companies.get(i).getName()
							+ " doesn't have to plant trees because it doesn't implement the method");
				}
			}
		}
	}

	public void realizePoll(String nameOfCompany, int a1, int a2, int a3) {
		for (int i = 0; i < companies.size(); i++) {
			if (companies.get(i).getName().equals(nameOfCompany)) {
				if (companies.get(i) instanceof ServiceCompany) {
					if (a1 >= 1 && a1 <= 5 && a2 >= 1 && a2 <= 5 && a3 >= 1 && a3 <= 5) {
						ServiceCompany m = (ServiceCompany) companies.get(i);

						Poll p = new Poll(a1, a2, a3);
						m.addPoll(p);
						p.setAnswer1(a1);
						p.setAnswer2(a2);
						p.setAnswer3(a3);
						System.out.println("The poll has been registered to the company " + companies.get(i).getName());
					} else {
						System.out.println("The scale is between 1 and 5. Register the poll again");
					}
				} else {
					System.out.println("The company " + companies.get(i) + " doesn't have to make polls");
				}
			}
		}
	}
	
	public void calculateSatisfactionClients(String nameOfCompany) {
		for(int i=0; i<companies.size(); i++) {
			if(companies.get(i).getName().equals(nameOfCompany)) {
				if(companies.get(i) instanceof ServiceCompany) {
					ServiceCompany m= (ServiceCompany) companies.get(i);
					if(m.getPolls().size()>10 && m.getPolls().size()<50) {
						m.calculateSatisfationClient();
					}else if(m.getPolls().size()<10) {
						System.out.println("It's necessary that the company has at least 10 polls");
					}else {
						System.out.println("It's necessary that the company only have 50 polls");
					}
				}else {
					System.out.println("The company " + companies.get(i).getName() + " doesn't realize polls");
				}
			}
		}
	}
	public void addEmployeToACubicle(String employeeName, String employeeEmail, String employeeCharge) {
		for(int i=0; i<companies.size();i++) {
			if(companies.get(i).getBuilding()!=null) {
				companies.get(i).getBuilding().assignCublicleEmployeeName(employeeName);
				companies.get(i).getBuilding().assignCublicleEmployeeCharge(employeeCharge);
				companies.get(i).getBuilding().assignCublicleEmployeeEmail(employeeEmail);
				System.out.println("The employee " + employeeName + " has been assigned to the building of the company " + companies.get(i).getName());
				break;
			}else {
				System.out.println("The company doesn't have a building yet.");
				break;
			}
		}
	}

} // cierra la clase
