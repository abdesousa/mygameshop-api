CREATE TABLE IF NOT EXISTS tbl_product(
	product_id INT AUTO_INCREMENT,
	product_name VARCHAR(100) NOT NULL,
	PRIMARY KEY (product_id),
);
CREATE TABLE IF NOT EXISTS tbl_order(
	order_id INT  AUTO_INCREMENT,
	quantity INT NOT NULL,
	product_id INT NOT NULL,
	order_dt DATETIME,
	PRIMARY KEY (order_id),
	FOREIGN KEY (product_id) REFERENCES tbl_product(product_id),
);

INSERT INTO tbl_product (product_name) VALUES('Fifa2019 game');
INSERT INTO tbl_product (product_name) VALUES('BattleField 5 game');
INSERT INTO tbl_product (product_name) VALUES('Minecraft game');
