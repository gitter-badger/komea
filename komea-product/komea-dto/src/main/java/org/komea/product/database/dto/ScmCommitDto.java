
package org.komea.product.database.dto;


/**
 * This class implements a scm commit;
 *
 * @author sleroy
 */
public class ScmCommitDto {
    
    private String id;
    
    private String project               = "";
    
    private String user                  = "";
    
    private String message               = "";
    
    private int    numberOfAddedlines    = 0;
    
    private int    numberofDeletedLines  = 0;
    
    private int    numberOfModifiedFiles = 0;
    
    public String getId() {
    
        return id;
    }
    
    /**
     * Returns the value of the field message.
     *
     * @return the message
     */
    public String getMessage() {
    
        return message;
    }
    
    /**
     * Returns the value of the field numberOfAddedlines.
     *
     * @return the numberOfAddedlines
     */
    public int getNumberOfAddedlines() {
    
        return numberOfAddedlines;
    }
    
    /**
     * Returns the value of the field numberofDeletedLines.
     *
     * @return the numberofDeletedLines
     */
    public int getNumberofDeletedLines() {
    
        return numberofDeletedLines;
    }
    
    /**
     * Returns the value of the field numberOfModifiedFiles.
     *
     * @return the numberOfModifiedFiles
     */
    public int getNumberOfModifiedFiles() {
    
        return numberOfModifiedFiles;
    }
    
    public String getProject() {
    
        return project;
    }
    
    public String getUser() {
    
        return user;
    }
    
    public void setId(final String _id) {
    
        id = _id;
    }
    
    /**
     * Sets the field message with the value of _message.
     *
     * @param _message
     *            the message to set
     */
    public void setMessage(final String _message) {
    
        message = _message;
    }
    
    /**
     * Sets the field numberOfAddedlines with the value of _numberOfAddedlines.
     *
     * @param _numberOfAddedlines
     *            the numberOfAddedlines to set
     */
    public void setNumberOfAddedlines(final int _numberOfAddedlines) {
    
        numberOfAddedlines = _numberOfAddedlines;
    }
    
    /**
     * Sets the field numberofDeletedLines with the value of _numberofDeletedLines.
     *
     * @param _numberofDeletedLines
     *            the numberofDeletedLines to set
     */
    public void setNumberofDeletedLines(final int _numberofDeletedLines) {
    
        numberofDeletedLines = _numberofDeletedLines;
    }
    
    /**
     * Sets the field numberOfModifiedFiles with the value of _numberOfModifiedFiles.
     *
     * @param _numberOfModifiedFiles
     *            the numberOfModifiedFiles to set
     */
    public void setNumberOfModifiedFiles(final int _numberOfModifiedFiles) {
    
        numberOfModifiedFiles = _numberOfModifiedFiles;
    }
    
    public void setProject(final String _project) {
    
        project = _project;
    }
    
    public void setUser(final String _user) {
    
        user = _user;
    }
    
    @Override
    public String toString() {
    
        return "ScmCommitDto [id=" + id + ", project=" + project + ", user=" + user + ", message=" + message + ", numberOfAddedlines="
                + numberOfAddedlines + ", numberofDeletedLines=" + numberofDeletedLines + ", numberOfModifiedFiles="
                + numberOfModifiedFiles + "]";
    }
    
}