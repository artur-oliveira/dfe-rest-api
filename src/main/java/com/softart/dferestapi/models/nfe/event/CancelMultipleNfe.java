package com.softart.dferestapi.models.nfe.event;

import com.softart.dfe.enums.nf.NFEvent;
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
public final class CancelMultipleNfe {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static final class CancelNfeData {
        @Size(min = 44, max = 44)
        @NotBlank
        private String chNFe;

        @Size(min = 15)
        @NotBlank
        @Builder.Default
        private String xJust = NFEvent.CANCEL.getDefaultMessage();

        @Size(min = 15)
        private String nProt;
    }

    @NotEmpty
    @Valid
    private List<CancelNfeData> data;
}
