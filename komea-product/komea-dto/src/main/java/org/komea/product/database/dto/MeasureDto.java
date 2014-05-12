
package org.komea.product.database.dto;


import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.komea.product.database.model.Measure;

import com.google.common.collect.Lists;

public class MeasureDto extends Measure {
    
    private static final long serialVersionUID = 1L;
    
    @JsonIgnore
    public static List<MeasureDto> convert(final List<Measure> measures, final String kpiKey) {
    
        final List<MeasureDto> measureDtos = Lists.newArrayList();
        for (final Measure measure : measures) {
            measureDtos.add(new MeasureDto(measure, kpiKey));
        }
        return measureDtos;
    }
    
    private String kpiKey;
    
    public MeasureDto() {
    
    }
    
    public MeasureDto(final Measure measure, final String kpiKey) {
    
        super(measure.getId(), measure.getIdKpi(), measure.getDate(), measure.getIdPersonGroup(), measure.getIdPerson(), measure
                .getIdProject(), measure.getValue(), measure.getStep(), measure.getFormula());
        this.kpiKey = kpiKey;
    }
    
    public MeasureDto(final String kpiKey, final Integer id, final Integer idKpi, final Date date, final Integer idPersonGroup,
            final Integer idPerson, final Integer idProject, final Double value, final String _step, final String _formula) {
    
        super(id, idKpi, date, idPersonGroup, idPerson, idProject, value, _step, _formula);
        this.kpiKey = kpiKey;
    }
    
    public String getKpiKey() {
    
        return kpiKey;
    }
    
    public void setKpiKey(final String kpiKey) {
    
        this.kpiKey = kpiKey;
    }
    
    @Override
    public String toString() {
    
        return "MeasureDto{" + super.toString() + ", kpiKey=" + kpiKey + '}';
    }
    
}
