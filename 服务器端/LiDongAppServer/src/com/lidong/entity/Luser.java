package com.lidong.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Luser entity. @author MyEclipse Persistence Tools
 */

public class Luser implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String upassword;
	private String uniname;
	private Date ubirthday;
	private String usex;
	private String uicon;
	private String usign;
	private Integer uzan;
	private Set lfriendsForUid1 = new HashSet(0);
	private Set lfriendsForUid2 = new HashSet(0);
	private Set lrundatas = new HashSet(0);
	private Set lmygroups = new HashSet(0);

	// Constructors

	/** default constructor */
	public Luser() {
		this.ubirthday = new Date();
		this.usex = "ÄÐ";
		this.uzan = 0;
	}

	/** minimal constructor */
	public Luser(String uname) {
		this.uname = uname;
	}

	/** full constructor */
	public Luser(String uname, String upassword, String uniname,
			Date ubirthday, String usex, String uicon, String usign,
			Integer uzan, Set lfriendsForUid1, Set lfriendsForUid2,
			Set lrundatas, Set lmygroups) {
		this.uname = uname;
		this.upassword = upassword;
		this.uniname = uniname;
		this.ubirthday = ubirthday;
		this.usex = usex;
		this.uicon = uicon;
		this.usign = usign;
		this.uzan = uzan;
		this.lfriendsForUid1 = lfriendsForUid1;
		this.lfriendsForUid2 = lfriendsForUid2;
		this.lrundatas = lrundatas;
		this.lmygroups = lmygroups;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return this.upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUniname() {
		return this.uniname;
	}

	public void setUniname(String uniname) {
		this.uniname = uniname;
	}

	public Date getUbirthday() {
		return this.ubirthday;
	}

	public void setUbirthday(Date ubirthday) {
		this.ubirthday = ubirthday;
	}

	public String getUsex() {
		return this.usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUicon() {
		return this.uicon;
	}

	public void setUicon(String uicon) {
		this.uicon = uicon;
	}

	public String getUsign() {
		return this.usign;
	}

	public void setUsign(String usign) {
		this.usign = usign;
	}

	public Integer getUzan() {
		return this.uzan;
	}

	public void setUzan(Integer uzan) {
		this.uzan = uzan;
	}

	public Set getLfriendsForUid1() {
		return this.lfriendsForUid1;
	}

	public void setLfriendsForUid1(Set lfriendsForUid1) {
		this.lfriendsForUid1 = lfriendsForUid1;
	}

	public Set getLfriendsForUid2() {
		return this.lfriendsForUid2;
	}

	public void setLfriendsForUid2(Set lfriendsForUid2) {
		this.lfriendsForUid2 = lfriendsForUid2;
	}

	public Set getLrundatas() {
		return this.lrundatas;
	}

	public void setLrundatas(Set lrundatas) {
		this.lrundatas = lrundatas;
	}

	public Set getLmygroups() {
		return this.lmygroups;
	}

	public void setLmygroups(Set lmygroups) {
		this.lmygroups = lmygroups;
	}

	@Override
	public String toString() {
		return "Luser [uid=" + uid + ", uname=" + uname + ", upassword="
				+ upassword + ", uniname=" + uniname + ", ubirthday="
				+ ubirthday + ", usex=" + usex + ", uicon=" + uicon
				+ ", usign=" + usign + ", uzan=" + uzan + "]";
	}

}