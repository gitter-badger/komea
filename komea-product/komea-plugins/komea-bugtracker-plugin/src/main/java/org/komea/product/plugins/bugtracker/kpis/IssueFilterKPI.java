/**
 *
 */

package org.komea.product.plugins.bugtracker.kpis;



import groovy.lang.Binding;
import groovy.lang.Closure;
import groovy.lang.Script;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.komea.eventory.api.cache.BackupDelay;
import org.komea.product.backend.api.IGroovyEngineService;
import org.komea.product.backend.groovy.AbstractDynamicQuery;
import org.komea.product.backend.groovy.GroovyFilter;
import org.komea.product.backend.service.dataplugin.IDynamicDataSourcePool;
import org.komea.product.backend.utils.CollectionUtil;
import org.komea.product.backend.utils.IFilter;
import org.komea.product.database.api.IEntity;
import org.komea.product.database.dto.KpiResult;
import org.komea.product.plugins.bugtracking.model.IIssue;
import org.komea.product.plugins.bugtracking.model.IIssuePlugin;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;



/**
 * @author sleroy
 */
public final class IssueFilterKPI extends

AbstractDynamicQuery
{


    @Autowired
    private IDynamicDataSourcePool dataSourcePool;


    private IFilter<IIssue>        filter;


    @Autowired
    private IGroovyEngineService   groovyEngineService;
    private Closure<IEntity>       groupFunction;



    public IssueFilterKPI(final BackupDelay _delay) {
    
    
        super(_delay);
        
    }
    
    
    @Override
    public KpiResult evaluateResult() {
    
    
        final KpiResult kpiResult = new KpiResult();
        final ListMultimap<IEntity, IIssue> map = ArrayListMultimap.create();
        for (final IIssuePlugin plugin : dataSourcePool.getDataSourceOfType(IIssuePlugin.class)) {
            groupMap(plugin, map);
        }
        
        LOGGER.info("Applying the filter per handler and obtaining results");
        for (final IEntity person : map.keySet()) {
            final List<IIssue> filteredIssues = CollectionUtil.filter(map.get(person), filter);
            LOGGER.debug("Filter returned {} elements", filteredIssues.size());
            kpiResult.put(person, filteredIssues.size());
        }
        
        
        return kpiResult;
    }
    
    
    public IssueFilterKPI setClosure(final Closure<Boolean> _filter) {
    
    
        filter = new ClosureFilter(_filter);
        return this;
    }
    
    
    /**
     * Sets the field dataSourcePool with the value of _dataSourcePool.
     *
     * @param _dataSourcePool
     *            the dataSourcePool to set
     */
    public void setDataSourcePool(final IDynamicDataSourcePool _dataSourcePool) {
    
    
        dataSourcePool = _dataSourcePool;
    }
    
    
    public IssueFilterKPI setFilter(final IFilter<IIssue> _filter) {
    
    
        filter = _filter;
        return this;
    }
    
    
    /**
     * Sets the field groovyEngineService with the value of _groovyEngineService.
     *
     * @param _groovyEngineService
     *            the groovyEngineService to set
     */
    public void setGroovyEngineService(final IGroovyEngineService _groovyEngineService) {
    
    
        groovyEngineService = _groovyEngineService;
    }
    
    
    public void setGroovyFilter(final String _filter) {
    
    
        final Script initializationToEvaluateResults = initializationToEvaluateResults(_filter);
        
        filter = new GroovyFilter<IIssue>(initializationToEvaluateResults, "issue");
    }
    
    
    public void setGroupFunction(final Closure<IEntity> _groupFunction) {
    
    
        groupFunction = _groupFunction;
    }
    
    
    private void groupMap(final IIssuePlugin _plugin, final ListMultimap<IEntity, IIssue> _map) {
    
    
        Validate.notNull(groupFunction, "A closure must be provided to perform the map grouping.");
        
        LOGGER.info("Obtaining results from the dynamic data source");
        final List<IIssue> listOfIssues = _plugin.getData();
        LOGGER.info("Results obtained : {} elements", listOfIssues.size());
        LOGGER.info("Sorting results per handler");
        for (final IIssue issue : listOfIssues) {
            final IEntity handler = groupFunction.call(issue);
            if (handler == null) {
                continue;
            }
            _map.put(handler, issue);
            
        }
        
    }
    
    
    private Script initializationToEvaluateResults(final String _groovyFilter) {
    
    
        final CompilerConfiguration config = new CompilerConfiguration();
        final Binding binding = new Binding();
        return groovyEngineService.parseScript(_groovyFilter, config, binding);
        
        
    }
}