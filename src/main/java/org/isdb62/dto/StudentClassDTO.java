package org.isdb62.dto;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentClassDTO {
@NonNull
@Size(min = 1, max = 50, message = "Thik thak nam de")

private String name;
@NonNull
private Integer classTeacherId;
@NonNull                                                                                                                                                                                                   
private Integer roomNumber;

}
