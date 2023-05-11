package com.softart.dferestapi.models.mdfe.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class DriverInclusionMdfe {
    @JsonIgnore
    private String chMDFe;
    @NotNull
    private String xNome;
    @Size(min = 1)
    private String nSeqEvento;
    @NotNull
    private String cpf;

}
