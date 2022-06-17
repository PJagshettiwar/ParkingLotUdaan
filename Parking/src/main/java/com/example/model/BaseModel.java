package com.example.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {

	Integer id;
	Date createDate;
	Date updateDate;

}
