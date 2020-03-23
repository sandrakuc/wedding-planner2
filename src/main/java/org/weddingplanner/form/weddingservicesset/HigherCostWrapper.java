package org.weddingplanner.form.weddingservicesset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HigherCostWrapper implements Comparable<HigherCostWrapper>{
    String className;

    int totalAmount;

    @Override
    public int compareTo(HigherCostWrapper o) {
        return Integer.compare(this.totalAmount, o.totalAmount);
    }
}
