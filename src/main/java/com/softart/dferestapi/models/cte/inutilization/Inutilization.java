package com.softart.dferestapi.models.cte.inutilization;

import com.softart.dfe.enums.cte.CteEvent;
import com.softart.dfe.enums.internal.Environment;
import com.softart.dfe.enums.internal.Model;
import lombok.*;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Year;
import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
@Builder
public final class Inutilization {

    @NotNull
    @Builder.Default
    private Integer ano = Year.now().getValue();
    @Min(0)
    @NotNull
    private Integer serie;
    @NotNull
    @Min(0)
    private Integer nctIni;
    @NotNull
    @Min(0)
    private Integer nctFin;
    @Builder.Default
    @NotNull
    @Size(min = 15, max = 255)
    private String xJust = CteEvent.INUTILIZATION.getDefaultMessage();
    @Builder.Default
    @NotNull
    private Model model = Model.CTE;
    private Environment tpAmb;

    @AssertTrue(message = "model must be CTE or CTE_OS")
    public boolean isCteOrCteOs() {
        return Arrays.asList(Model.CTE, Model.CTE_OS).contains(getModel());
    }
}
