
package org.komea.product.wicket.kpiviewer;



import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.komea.product.backend.api.IMeasureHistoryService;
import org.komea.product.backend.service.entities.IEntityService;
import org.komea.product.backend.service.history.HistoryKey;
import org.komea.product.backend.service.kpi.IKPIService;
import org.komea.product.backend.service.kpi.IKpiValueService;
import org.komea.product.database.model.Kpi;
import org.komea.product.database.model.Measure;
import org.komea.product.service.dto.EntityKey;
import org.komea.product.wicket.LayoutPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.wickedcharts.highcharts.options.Axis;
import com.googlecode.wickedcharts.highcharts.options.AxisType;
import com.googlecode.wickedcharts.highcharts.options.ChartOptions;
import com.googlecode.wickedcharts.highcharts.options.DateTimeLabelFormat;
import com.googlecode.wickedcharts.highcharts.options.DateTimeLabelFormat.DateTimeProperties;
import com.googlecode.wickedcharts.highcharts.options.Function;
import com.googlecode.wickedcharts.highcharts.options.Options;
import com.googlecode.wickedcharts.highcharts.options.SeriesType;
import com.googlecode.wickedcharts.highcharts.options.Title;
import com.googlecode.wickedcharts.highcharts.options.Tooltip;
import com.googlecode.wickedcharts.highcharts.options.series.Coordinate;
import com.googlecode.wickedcharts.highcharts.options.series.CustomCoordinatesSeries;
import com.googlecode.wickedcharts.wicket6.highcharts.Chart;



/**
 * Person admin page
 * 
 * @author sleroy
 */
public class KpiViewerPage extends LayoutPage
{
    
    
    /**
     * @author sleroy
     */
    private final class ChartsList extends ListView<Kpi>
    {
        
        
        /**
         * @param _id
         */
        public ChartsList(final String _id, final List<Kpi> _kpis) {
        
        
            super(_id, _kpis);
            
        }
        
        
        @Override
        protected void populateItem(final ListItem<Kpi> _item) {
        
        
            final ChartOptions chartOptions = new ChartOptions();
            
            chartOptions.setSpacingRight(20);
            chartOptions.setType(SeriesType.BAR);
            chartOptions.setBorderRadius(1);
            chartOptions.setBorderColor(Color.GRAY);
            
            final Options options = new Options();
            options.setChartOptions(chartOptions);
            final String kpiname = _item.getModel().getObject().getName();
            options.setTitle(new Title("KPI " + kpiname));
            
            final Axis xAxis = new Axis();
            xAxis.setType(AxisType.DATETIME);
            
            final DateTimeLabelFormat dateTimeLabelFormat = new DateTimeLabelFormat();
            dateTimeLabelFormat.setProperty(DateTimeProperties.MONTH, "%e. %b").setProperty(
                    DateTimeProperties.YEAR, "%b");
            xAxis.setDateTimeLabelFormats(dateTimeLabelFormat);
            options.setxAxis(xAxis);
            
            final Axis yAxis = new Axis();
            yAxis.setTitle(new Title(kpiname));
            yAxis.setMin(0);
            options.setyAxis(yAxis);
            
            final Tooltip tooltip = new Tooltip();
            tooltip.setFormatter(new Function(
                    "return '<b>'+ this.series.name +'</b><br/>'+Highcharts.dateFormat('%e. %b', this.x) +': '+ this.y +' alerts';"));
            options.setTooltip(tooltip);
            
            _item.add(buildGraphic(options, "chart", _item.getModelObject()));
            
            
        }
    }
    
    
    
    private static final Logger    LOGGER           = LoggerFactory.getLogger(KpiViewerPage.class);
    
    /**
     * 
     */
    private static final long      serialVersionUID = 825152658028992367L;
    @Autowired
    private IEntityService         entityService;
    
    @SpringBean
    private IKPIService            kpiService;
    
    @SpringBean
    private IKpiValueService       kpiValueService;
    
    
    @SpringBean
    private IMeasureHistoryService measureHistoryService;
    
    
    
    public KpiViewerPage(final PageParameters _parameters) {
    
    
        super(_parameters);
        
        final List<Kpi> selectAll = kpiService.selectAll();
        final ListView<Kpi> listView = new ChartsList("charts", selectAll);
        
        add(listView);
        
        
    }
    
    
    public IKpiValueService getKpiValueService() {
    
    
        return kpiValueService;
    }
    
    
    public void setKpiValueService(final IKpiValueService _kpiValueService) {
    
    
        kpiValueService = _kpiValueService;
    }
    
    
    private Chart buildGraphic(final Options options, final String _chartID, final Kpi _kpi) {
    
    
        // Define the data points. All series have a dummy year
        // of 1970/71 in order to be compared on the same x axis. Note
        // that in JavaScript, months start at 0 for January, 1 for February etc.
        
        final Map<EntityKey, List<Coordinate<Long, Integer>>> series =
                new HashMap<EntityKey, List<Coordinate<Long, Integer>>>();
        
        
        final List<Measure> history = measureHistoryService.getHistory(HistoryKey.of(_kpi));
        Collections.sort(history, Measure.DATE_MEASURE);
        
        for (final Measure measure : history) {
            
            final EntityKey entityKeyOfMeasure =
                    EntityKey.of(_kpi.getEntityType(), measure.getEntityID());
            if (entityKeyOfMeasure == null) {
                continue;
            }
            List<Coordinate<Long, Integer>> list = series.get(entityKeyOfMeasure);
            if (list == null) {
                series.put(entityKeyOfMeasure, list = new ArrayList<Coordinate<Long, Integer>>());
            }
            
            list.add(new Coordinate<Long, Integer>(measure.getDate().getTime(), measure.getValue()
                    .intValue()));
        }
        
        for (final Entry<EntityKey, List<Coordinate<Long, Integer>>> serieValue : series.entrySet()) {
            
            final CustomCoordinatesSeries<Long, Integer> oneChartSerie =
                    new CustomCoordinatesSeries<Long, Integer>();
            oneChartSerie.setName(entityService.getEntityOrFail(serieValue.getKey())
                    .getDisplayName());
            oneChartSerie.setData(serieValue.getValue());
            options.addSeries(oneChartSerie);
        }
        
        
        return new Chart(_chartID, options);
    }
}