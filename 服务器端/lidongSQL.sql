USE lidong;

CREATE TABLE luser(
	uid INT AUTO_INCREMENT PRIMARY KEY,
	uname VARCHAR(30) NOT NULL UNIQUE,
	upassword VARCHAR(30),
	uniname VARCHAR(20),
	ubirthday DATE,
	usex VARCHAR(4),
	uicon VARCHAR(80),
	usign VARCHAR(80),
	uzan INT
);

CREATE TABLE lfriend(
	fid INT AUTO_INCREMENT PRIMARY KEY,
	uid1 INT,
	uid2 INT,
	ftime  DATE,

	FOREIGN KEY(uid1) REFERENCES luser(uid),
	FOREIGN KEY(uid2) REFERENCES luser(uid)
);
CREATE TABLE lgroup(
	gid  INT AUTO_INCREMENT PRIMARY KEY,
	gname VARCHAR(30),
	gsign VARCHAR(80),
	gtime DATE,
	gcount INT
)

CREATE TABLE lmygroup(
	mid INT AUTO_INCREMENT PRIMARY KEY,
	uid INT,
	gid INT,

	FOREIGN KEY(uid) REFERENCES luser(uid),
	FOREIGN KEY(gid) REFERENCES lgroup(gid)
)

CREATE TABLE lrundata(
	rid INT AUTO_INCREMENT PRIMARY KEY,
	uid INT,
	total_distance DOUBLE,
	total_frequency INT,
	total_time INT,

	best_distance DOUBLE,
	best_time INT,
	best_pace DOUBLE,
	best_10km INT,
	best_halfma INT,
	best_ma INT,

	FOREIGN KEY(uid) REFERENCES luser(uid)
);

CREATE TABLE lpm25(
	pid INT AUTO_INCREMENT PRIMARY KEY,
	parea VARCHAR(10),
	ppm_value INT,
	pquality VARCHAR(10),
	ptime DATE
)

CREATE TABLE lpush(
	pid INT AUTO_INCREMENT PRIMARY KEY,
	ppic1 VARCHAR(80),
	ppic2 VARCHAR(80),
	ppic3 VARCHAR(80),
	pstring1  VARCHAR(80),
	pstring2 VARCHAR(80),
	pstring3 VARCHAR(80)
)