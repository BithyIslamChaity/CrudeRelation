package org.isdb62.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentClassDTO {
private Integer id;
private String name;
private Integer classTeacherId;
private Integer roomNumber;

}
