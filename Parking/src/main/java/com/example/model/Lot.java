package com.example.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import service.EntryGate;
import service.ExitGate;

@Getter
@Setter
public class Lot extends BaseModel{
	
	String address;
	List<Floor> floors;
	List<EntryGate> entryGate;
	List<ExitGate> exitGate;
	
	
	public static class Builder{
		List<Floor> floors;
		List<EntryGate> entryGate;
		List<ExitGate> exitGate;
		Lot lot;
		public Builder setFloors(List<Floor> floors){
			this.floors = floors;
			return this;
		}
		
		public Builder setEntryGate(List<EntryGate> entryGate){
			this.entryGate=entryGate;
			return this;
		}

		public Builder setExitGate(List<ExitGate> exitGate){
			this.exitGate=exitGate;
			return this;
		}
		
		public Lot build() {
			lot = new Lot();
			lot.floors = this.floors;
			lot.exitGate=this.exitGate;
			lot.entryGate = this.entryGate;
			return lot;
		}
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "floors: "+floors;
	}
}
