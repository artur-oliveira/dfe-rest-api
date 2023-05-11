package com.softart.dferestapi.models.nfe.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class CorrectionNfe {
    @JsonIgnore
    private String chNFe;

    @Size(min = 15)
    @NotBlank
    private String xCorrecao;

    @NotBlank
    @Size(min = 1)
    private String nSeqEvento;
}
