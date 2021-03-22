package app.mysql.entity;

/*
 * The Product is a JPA entity class with field names same as the database’s table it represents.
 * Lombok is used to keep lines of code succinct hence reduce the boilerplate code (Getters & Setters).
 **/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * These annotations allow Lombok to dynamically generate the following respectively.
 * - Getters and Setters methods
 * - A default no-args constructor for the class
 * - An all-args constructor
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //The JPA Entity class
@Table(name="monitor") //The SQL table associated with the class
public class Monitor {

	//The @ID annotation is bind to the primary key column in the table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//The @Column annotation gives additional details about each mapped columns
	@Column(length = 40, unique = false, nullable = false)
	private String brand;

	@Column(length = 4, unique = false, nullable = true)
	private int resolution;

	@Column(length = 10, unique = true, nullable = false)
	private String model;
	
	@Column(length = 6, unique = false, nullable = false)
	private float price;

}
