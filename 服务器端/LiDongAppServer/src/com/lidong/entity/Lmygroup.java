package com.lidong.entity;

/**
 * Lmygroup entity. @author MyEclipse Persistence Tools
 */

public class Lmygroup implements java.io.Serializable {

	// Fields

	private Integer mid;
	private Lgroup lgroup;
	private Luser luser;

	// Constructors

	/** default constructor */
	public Lmygroup() {
	}

	/** full constructor */
	public Lmygroup(Lgroup lgroup, Luser luser) {
		this.lgroup = lgroup;
		this.luser = luser;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Lgroup getLgroup() {
		return this.lgroup;
	}

	public void setLgroup(Lgroup lgroup) {
		this.lgroup = lgroup;
	}

	public Luser getLuser() {
		return this.luser;
	}

	public void setLuser(Luser luser) {
		this.luser = luser;
	}

}