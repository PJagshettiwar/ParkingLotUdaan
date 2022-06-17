package com.example.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket extends BaseModel{
	
	Spot spot;
	LocalDateTime inTime;
	LocalDateTime outTime;
	Integer charges;
}
