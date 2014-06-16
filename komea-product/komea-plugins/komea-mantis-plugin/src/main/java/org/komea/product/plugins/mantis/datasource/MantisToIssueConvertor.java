/**
 *
 */

package org.komea.product.plugins.mantis.datasource;



import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.komea.product.backend.service.entities.IPersonService;
import org.komea.product.database.model.Person;
import org.komea.product.database.model.Project;
import org.komea.product.plugins.bugtracking.model.IIssue;
import org.komea.product.plugins.mantis.model.MantisServerConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import biz.futureware.mantis.rpc.soap.client.AccountData;
import biz.futureware.mantis.rpc.soap.client.IssueData;

import com.google.common.collect.Lists;



/**
 * @author sleroy
 */
@Service
@Transactional
public class MantisToIssueConvertor
{


    private static final Logger LOGGER = LoggerFactory.getLogger(MantisToIssueConvertor.class);
    @Autowired
    private IPersonService      personService;



    /**
     * Convert a single bug into an issue;
     *
     * @param _bug
     * @return
     */
    public IIssue convert(
            final IssueData _bug,
            final Project _project,
            final MantisServerConfiguration _bzServerConfiguration) {


        LOGGER.trace("Received bug {}", _bug);
        final Person handler = createPersonOrNull(_bug.getHandler());
        final Person creator = createPersonOrNull(_bug.getReporter());
        return new MantisIssueWrapper(_bug, handler, creator, _project, _bzServerConfiguration);


    }


    /**
     * Convert all the issues.
     *
     * @param _bugs
     * @param _serverConfiguration
     * @return
     */
    public Collection<? extends IIssue> convertAll(
            final List<IssueData> _bugs,
            final Project _project,
            final MantisServerConfiguration _serverConfiguration) {


        Validate.notNull(_project);

        final List<IIssue> issues = Lists.newArrayList();
        for (final IssueData bug : _bugs) {
            final IIssue issue = convert(bug, _project, _serverConfiguration);
            if (issue != null) {
                issues.add(issue);
            }
        }

        return issues;
    }


    /**
     * @param _accountData
     * @return
     */
    private Person createPersonOrNull(final AccountData _accountData) {


        if (_accountData == null) {
            return null;
        }

        return personService.findOrCreatePersonByEmail(_accountData.getEmail());
    }

}