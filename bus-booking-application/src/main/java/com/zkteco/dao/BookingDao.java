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
@Table(name = "booking_table")
public class BookingDao {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	@ApiModelProperty(hidden = true)
	private String bookingId;
	private String userId;
	private String busId;
	private int seatNo;
	private String BookingTime;
	private String status;
	

}
