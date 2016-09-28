package com.lidong.entity;

/**
 * Lrundata entity. @author MyEclipse Persistence Tools
 */

public class Lrundata implements java.io.Serializable {

	// Fields

	private Integer rid;
	private Luser luser;
	private Double totalDistance;
	private Integer totalFrequency;
	private Integer totalTime;
	private Double bestDistance;
	private Integer bestTime;
	private Double bestPace;
	private Integer best10km;
	private Integer bestHalfma;
	private Integer bestMa;

	// Constructors

	/** default constructor */
	public Lrundata() {
	}

	/** full constructor */
	public Lrundata(Luser luser, Double totalDistance, Integer totalFrequency,
			Integer totalTime, Double bestDistance, Integer bestTime,
			Double bestPace, Integer best10km, Integer bestHalfma,
			Integer bestMa) {
		this.luser = luser;
		this.totalDistance = totalDistance;
		this.totalFrequency = totalFrequency;
		this.totalTime = totalTime;
		this.bestDistance = bestDistance;
		this.bestTime = bestTime;
		this.bestPace = bestPace;
		this.best10km = best10km;
		this.bestHalfma = bestHalfma;
		this.bestMa = bestMa;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Luser getLuser() {
		return this.luser;
	}

	public void setLuser(Luser luser) {
		this.luser = luser;
	}

	public Double getTotalDistance() {
		return this.totalDistance;
	}

	public void setTotalDistance(Double totalDistance) {
		this.totalDistance = totalDistance;
	}

	public Integer getTotalFrequency() {
		return this.totalFrequency;
	}

	public void setTotalFrequency(Integer totalFrequency) {
		this.totalFrequency = totalFrequency;
	}

	public Integer getTotalTime() {
		return this.totalTime;
	}

	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	public Double getBestDistance() {
		return this.bestDistance;
	}

	public void setBestDistance(Double bestDistance) {
		this.bestDistance = bestDistance;
	}

	public Integer getBestTime() {
		return this.bestTime;
	}

	public void setBestTime(Integer bestTime) {
		this.bestTime = bestTime;
	}

	public Double getBestPace() {
		return this.bestPace;
	}

	public void setBestPace(Double bestPace) {
		this.bestPace = bestPace;
	}

	public Integer getBest10km() {
		return this.best10km;
	}

	public void setBest10km(Integer best10km) {
		this.best10km = best10km;
	}

	public Integer getBestHalfma() {
		return this.bestHalfma;
	}

	public void setBestHalfma(Integer bestHalfma) {
		this.bestHalfma = bestHalfma;
	}

	public Integer getBestMa() {
		return this.bestMa;
	}

	public void setBestMa(Integer bestMa) {
		this.bestMa = bestMa;
	}

	@Override
	public String toString() {
		return "Lrundata [rid=" + rid + ", luser.id=" + luser.getUid() + ", totalDistance="
				+ totalDistance + ", totalFrequency=" + totalFrequency
				+ ", totalTime=" + totalTime + ", bestDistance=" + bestDistance
				+ ", bestTime=" + bestTime + ", bestPace=" + bestPace
				+ ", best10km=" + best10km + ", bestHalfma=" + bestHalfma
				+ ", bestMa=" + bestMa + "]";
	}

}