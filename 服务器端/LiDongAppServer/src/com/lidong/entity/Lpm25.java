package com.lidong.entity;

import java.util.Date;

/**
 * Lpm25 entity. @author MyEclipse Persistence Tools
 */

public class Lpm25 implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String parea;
	private Integer ppmValue;
	private String pquality;
	private Date ptime;

	// Constructors

	/** default constructor */
	public Lpm25() {
	}

	/** full constructor */
	public Lpm25(String parea, Integer ppmValue, String pquality, Date ptime) {
		this.parea = parea;
		this.ppmValue = ppmValue;
		this.pquality = pquality;
		this.ptime = ptime;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getParea() {
		return this.parea;
	}

	public void setParea(String parea) {
		this.parea = parea;
	}

	public Integer getPpmValue() {
		return this.ppmValue;
	}

	public void setPpmValue(Integer ppmValue) {
		this.ppmValue = ppmValue;
	}

	public String getPquality() {
		return this.pquality;
	}

	public void setPquality(String pquality) {
		this.pquality = pquality;
	}

	public Date getPtime() {
		return this.ptime;
	}

	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}

}