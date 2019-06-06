package model;

import java.util.*;

public class Building {

	// Constantes

	public final static int NUMBER_CUBICLE = 40;

	// Atributos

	private int numberOfFloors;

	// Relaciones

	private Cubicle[][] cublicles;

	// Metodos

	public void cubiclesInitilized() {
		for (int f = 0; f < cublicles.length; f++) {
			for (int c = 0; c < cublicles[0].length; c++) {

				cublicles[f][c] = new Cubicle("80" + f + c, false);
			}
		}
	}

	// Constructor

	public Building(int numberOfFloors) {

		this.numberOfFloors = numberOfFloors;
		cublicles = new Cubicle[numberOfFloors][NUMBER_CUBICLE];
		cubiclesInitilized();
	}

	public Cubicle[][] getCublicles() {
		return cublicles;
	}

	public void setCublicles(Cubicle[][] cublicles) {
		this.cublicles = cublicles;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public String haulEmailEmployeed(String employeeCharge) {
		String msg = "";

		for (int i = 0; i < cublicles.length; i++) {
			for (int j = 0; j < cublicles[i].length; j++) {
				if (cublicles[i][j].getAvailableCubicle() == true) {
					msg += cublicles[i][j].getEmployeeCharge() + "\n";
				}
			}
		}
		return msg;
	}

	public void assignCublicleEmployeeName(String employeeName) {
		for (int i = 0; i < cublicles.length; i++) {
			for (int j = 0; j < cublicles[i].length; j++) {
				if (cublicles[i][j].getAvailableCubicle() == false) {
					cublicles[i][j].setEmployeeName(employeeName);
					cublicles[i][j].setAvailableCubicle(true);
				}
			}
		}
	}

	public void assignCublicleEmployeeCharge(String employeeCharge) {
		for (int i = 0; i < cublicles.length; i++) {
			for (int j = 0; j < cublicles[i].length; j++) {
				if (cublicles[i][j].getAvailableCubicle() == false) {
					cublicles[i][j].setEmployeeCharge(employeeCharge);
				}
			}
		}
	}

	public void assignCublicleEmployeeEmail(String employeeEmail) {
		for (int i = 0; i < cublicles.length; i++) {
			for (int j = 0; j < cublicles[i].length; j++) {
				if (cublicles[i][j].getAvailableCubicle() == false) {
					cublicles[i][j].setEmployeeEmail(employeeEmail);
				}
			}
		}
	}
}
