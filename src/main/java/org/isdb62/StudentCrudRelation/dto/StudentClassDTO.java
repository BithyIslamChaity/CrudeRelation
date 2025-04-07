package org.isdb62.StudentCrudRelation.dto;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
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
  @Nonnull
    @Size(min = 3, max = 30, message = "Name must be between 3 to 30 character")
    private String name;
    @Nonnull
    private Integer classTeacherId;
    @Nonnull
    private Integer roomNumber;
}
