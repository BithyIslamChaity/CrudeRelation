package org.isdb62.StudentCrudRelation.model;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false, length = 100)
	private String email;

	@OneToOne
	@JoinColumn(name = "student_class", referencedColumnName = "id", nullable = false)
	private Class studentClass;

	@Column(nullable = false, unique = true)
	private int roll;

	@OneToMany(mappedBy = "student")
	private List<Book> books; // Renamed to plural for clarity

	@Column(nullable = false, length = 100)
	private String phone;

	@Column(length = 100)
	private String address;

	@Column(nullable = false, length = 100)
	private String gender;

	@Column(nullable = false)
	private Instant dob;
}
