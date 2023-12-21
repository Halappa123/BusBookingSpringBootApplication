package com.zkteco.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "bus_table")
public class BusDao {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	@ApiModelProperty(hidden = true,position = 1)
	private String busId;
	
	@ApiModelProperty(position = 2)
	private String busName;
	
	@ApiModelProperty(position = 3)
	private String origin;
	
	
	@ApiModelProperty(position = 4)
	private String destination;
	
	@ApiModelProperty(position = 5)
	private String departureDateTime;
	
	@ApiModelProperty(position = 6)
	private String arrivalDateTime;
	
	@ApiModelProperty(position = 7)
	private int totalSeats;
	
	@ApiModelProperty(position = 8)
	private int  availabeSeats;
	
	@ApiModelProperty(position = 9)
	private String busFair;
	
	

}
