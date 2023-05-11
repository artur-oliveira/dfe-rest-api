package com.softart.dferestapi.models.nfe.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class CorrectionMultipleNfe {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class CorrectionData {
        @Size(min = 44, max = 44)
        @NotBlank
        private String chNFe;

        @Size(min = 15)
        @NotBlank
        private String xCorrecao;

        @NotBlank
        @Size(min = 1)
        private String nSeqEvento;
    }


    @NotEmpty
    @Valid
    private List<CorrectionData> data;
}
