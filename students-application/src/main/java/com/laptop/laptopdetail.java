package com.laptop;

public class laptopdetail implements Comparable<laptopdetail> {

	private String brand;
	private int ram;
	private int price;
	
	public laptopdetail(String brand, int ram, int price) {
		this.brand = brand;
		this.ram = ram;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "laptopdtls [brand=" + brand + ", ram=" + ram + ", price=" + price + "]";
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int compareTo(laptopdetail lp) {
		
		if(this.getRam()>lp.getRam()){
			return 1;
		}else if(this.getRam()<lp.getRam()){
			return -1;
		}
		return 0;
	}
	
}
