package com.lidong.entity;

import java.util.Date;

/**
 * Lfriend entity. @author MyEclipse Persistence Tools
 */

public class Lfriend implements java.io.Serializable {

	// Fields

	private Integer fid;
	private Luser luserByUid2;
	private Luser luserByUid1;
	private Date ftime;

	// Constructors

	/** default constructor */
	public Lfriend() {
	}

	/** full constructor */
	public Lfriend(Luser luserByUid2, Luser luserByUid1, Date ftime) {
		this.luserByUid2 = luserByUid2;
		this.luserByUid1 = luserByUid1;
		this.ftime = ftime;
	}

	// Property accessors

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Luser getLuserByUid2() {
		return this.luserByUid2;
	}

	public void setLuserByUid2(Luser luserByUid2) {
		this.luserByUid2 = luserByUid2;
	}

	public Luser getLuserByUid1() {
		return this.luserByUid1;
	}

	public void setLuserByUid1(Luser luserByUid1) {
		this.luserByUid1 = luserByUid1;
	}

	public Date getFtime() {
		return this.ftime;
	}

	public void setFtime(Date ftime) {
		this.ftime = ftime;
	}

}