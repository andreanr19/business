package model;

public abstract class Company implements HaulBuilding {
	
	public final static String AHFF= "AGRICULTURE, HUNTING, FORESTRY AND FISHING";
	public final static String EMQ="EXPLOTATION, MINES AND QUARRIES";
	public final static String MI="MANUFACTURING INDUSTRY";
	public final static String EGS="ELECTRICITY, GAS AND STEAM";
	public final static String B="BUILDING";
	public final static String WR="WHOLESALE AND RETAIL";
	public final static String TSC="TRANSPORTATION STORAGE COMMUNICATIONS";
	public final static String FS="FINANCIAL STATEMENT";
	public final static String CS="COMUNAL AND SOCIAL";
	
	//ATRIBUTTES
	private String name;
	private String nit;
	private String address;
	private String phone;
	private int amountOfEmployees;
	private double assetValue;
	private int constitutionDay;
	private int constitutionMonth;
	private int constitutionYear;
	private String type;
	private String legalRepresentative;
	
	private Building building;
	
	public Company(String name, String nit, String address, String phone, int amountOfEmployees, double assetValue,
			int constitutionDay, int constitutionMonth, int constitutionYear, String type, String legalRepresentative) {
		this.name = name;
		this.nit = nit;
		this.address = address;
		this.phone = phone;
		this.amountOfEmployees = amountOfEmployees;
		this.assetValue = assetValue;
		this.constitutionDay = constitutionDay;
		this.constitutionMonth = constitutionMonth;
		this.constitutionYear = constitutionYear;
		this.type = type;
		this.legalRepresentative = legalRepresentative;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAmountOfEmployees() {
		return amountOfEmployees;
	}
	public void setAmountOfEmployees(int amountOfEmployees) {
		this.amountOfEmployees = amountOfEmployees;
	}
	public double getAssetValue() {
		return assetValue;
	}
	public void setAssetValue(double assetValue) {
		this.assetValue = assetValue;
	}
	public int getConstitutionDay() {
		return constitutionDay;
	}
	public void setConstitutionDay(int constitutionDay) {
		this.constitutionDay = constitutionDay;
	}
	public int getConstitutionMonth() {
		return constitutionMonth;
	}
	public void setConstitutionMonth(int constitutionMonth) {
		this.constitutionMonth = constitutionMonth;
	}
	public int getConstitutionYear() {
		return constitutionYear;
	}
	public void setConstitutionYear(int constitutionYear) {
		this.constitutionYear = constitutionYear;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	
	
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	public String haulEmail(String chargeEmployeed){

		int filas = 0;
		int columnas = 0;
		int numCeldas = 0;
		int totalCeldas = (building.getCublicles().length * building.getCublicles()[0].length);
		int minY = 0;
		int minX = 0;
		int maxY = building.getCublicles().length-1;
		int maxX = building.getCublicles()[0].length-1;
		int direccion = HaulBuilding.ABAJO;
		String msg = "";

		while (numCeldas < totalCeldas){

			switch (direccion){

				case ABAJO:

					filas++;
					if(filas == maxY){
						direccion = HaulBuilding.DERECHA;
						minX++;
					}

					msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

				case DERECHA:

					columnas++;
					if (columnas == maxX){
						direccion = HaulBuilding.ARRIBA;
						maxY--;
					}

					msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

				case ARRIBA:
					filas--;
					if (filas == minY){
						direccion = HaulBuilding.IZQUIERDA;
						maxX--;
					}

					msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

				case IZQUIERDA:
					columnas--;
					if (columnas == minX){
						direccion = HaulBuilding.ABAJO;
						minY++;
					}

					msg += building.getCublicles()[filas][columnas].haulEmailEmployeed(chargeEmployeed) + "\n";

				break;

			}
		}

		return msg;

	}
	

	
}