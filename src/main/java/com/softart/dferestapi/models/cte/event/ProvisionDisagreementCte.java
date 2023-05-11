package com.softart.dferestapi.models.cte.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class ProvisionDisagreementCte {
    @JsonIgnore
    private String chCTe;
    @NotNull
    @Size(min = 15, max = 255)
    private String xObs;
}
