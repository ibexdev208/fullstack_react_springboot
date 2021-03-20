package app.mysql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="monitor")
public class Monitor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 40, unique = false, nullable = false)
	private String brand;

	@Column(length = 4, unique = false, nullable = true)
	private int resolution;

	@Column(length = 10, unique = true, nullable = false)
	private String model;
	
	@Column(length = 6, unique = false, nullable = false)
	private float price;

}
