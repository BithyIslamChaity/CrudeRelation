package org.isdb62.StudentCrudRelation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_StudentClass")
public class StudentClass {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, length = 50, unique = true)
	private String name;

	@OneToOne
	@JoinColumn(name = "class_teacher", referencedColumnName = "id")
	private Teacher classTeacher;

	@Column(name = "room_number", nullable = false, unique = true, length = 50)
	private Integer roomNumber;

}
