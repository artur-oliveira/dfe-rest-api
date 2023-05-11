package com.softart.dferestapi.models.cte.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softart.dfe.util.DateUtils;
import lombok.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
public final class DeliveryReceiptCte {
    @JsonIgnore
    private String chCTe;
    @Size(min = 1)
    private String nSeqEvento;
    @Size(min = 15, max = 15)
    private String nProt;
    private String image;
    @Builder.Default
    private String dhEntrega = DateUtils.nowString();
    @NotNull
    private String nDoc;
    @NotNull
    private String xNome;
    @NotNull
    private String latitude;
    @NotNull
    private String longitude;
    @NotEmpty
    private List<String> nfes;

}
