package com.lidong.entity;

/**
 * Lpush entity. @author MyEclipse Persistence Tools
 */

public class Lpush implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String ppic1;
	private String ppic2;
	private String ppic3;
	private String pstring1;
	private String pstring2;
	private String pstring3;

	// Constructors

	/** default constructor */
	public Lpush() {
	}

	/** full constructor */
	public Lpush(String ppic1, String ppic2, String ppic3, String pstring1,
			String pstring2, String pstring3) {
		this.ppic1 = ppic1;
		this.ppic2 = ppic2;
		this.ppic3 = ppic3;
		this.pstring1 = pstring1;
		this.pstring2 = pstring2;
		this.pstring3 = pstring3;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPpic1() {
		return this.ppic1;
	}

	public void setPpic1(String ppic1) {
		this.ppic1 = ppic1;
	}

	public String getPpic2() {
		return this.ppic2;
	}

	public void setPpic2(String ppic2) {
		this.ppic2 = ppic2;
	}

	public String getPpic3() {
		return this.ppic3;
	}

	public void setPpic3(String ppic3) {
		this.ppic3 = ppic3;
	}

	public String getPstring1() {
		return this.pstring1;
	}

	public void setPstring1(String pstring1) {
		this.pstring1 = pstring1;
	}

	public String getPstring2() {
		return this.pstring2;
	}

	public void setPstring2(String pstring2) {
		this.pstring2 = pstring2;
	}

	public String getPstring3() {
		return this.pstring3;
	}

	public void setPstring3(String pstring3) {
		this.pstring3 = pstring3;
	}

}