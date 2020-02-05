package org.weddingplanner.form.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FloristicServicesCriteria {

    private int noteCriteria;

    private int priceCriteria;
}
