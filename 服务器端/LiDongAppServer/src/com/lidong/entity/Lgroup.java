package com.lidong.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Lgroup entity. @author MyEclipse Persistence Tools
 */

public class Lgroup implements java.io.Serializable {

	// Fields

	private Integer gid;
	private String gname;
	private String gsign;
	private Date gtime;
	private Integer gcount;
	private Set lmygroups = new HashSet(0);

	// Constructors

	/** default constructor */
	public Lgroup() {
	}

	/** full constructor */
	public Lgroup(String gname, String gsign, Date gtime, Integer gcount,
			Set lmygroups) {
		this.gname = gname;
		this.gsign = gsign;
		this.gtime = gtime;
		this.gcount = gcount;
		this.lmygroups = lmygroups;
	}

	// Property accessors

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGsign() {
		return this.gsign;
	}

	public void setGsign(String gsign) {
		this.gsign = gsign;
	}

	public Date getGtime() {
		return this.gtime;
	}

	public void setGtime(Date gtime) {
		this.gtime = gtime;
	}

	public Integer getGcount() {
		return this.gcount;
	}

	public void setGcount(Integer gcount) {
		this.gcount = gcount;
	}

	public Set getLmygroups() {
		return this.lmygroups;
	}

	public void setLmygroups(Set lmygroups) {
		this.lmygroups = lmygroups;
	}

}