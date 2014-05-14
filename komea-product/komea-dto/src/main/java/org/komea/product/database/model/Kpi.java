package org.komea.product.database.model;

import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.Validate;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.komea.product.database.api.IHasKey;
import org.komea.product.database.api.IKeyVisitor;
import org.komea.product.database.enums.BackupDelay;
import org.komea.product.database.enums.EntityType;
import org.komea.product.database.enums.ProviderType;
import org.komea.product.database.enums.ValueDirection;
import org.komea.product.database.enums.ValueType;

public class Kpi implements IHasKey {

	public static final String	AVERAGE_KEY	     = "_average_";

	public static final String	SUM_KEY	         = "_sum_";

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table kom_kpi
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	private static final long	serialVersionUID	= 1L;

	@JsonIgnore
	public static Kpi copy(final Kpi kpi) {

		return new Kpi(kpi.getId(), kpi.getKpiKey(), kpi.getName(), kpi.getDescription(), kpi.getValueMin(),
		        kpi.getValueMax(), kpi.getValueDirection(), kpi.getValueType(), kpi.getEntityType(),
		        kpi.getCronExpression(), kpi.getProviderType(), kpi.getEsperRequest());
	}

	@JsonIgnore
	public static String getBaseKey(final String kpiKey) {

		int end = kpiKey.length();
		if (isAverage(kpiKey)) {
			end -= Kpi.AVERAGE_KEY.length();
		} else if (isSum(kpiKey)) {
			end -= Kpi.SUM_KEY.length();
		}
		return kpiKey.substring(0, end);
	}

	public static Collection<? extends Kpi> getKpisForGroups(final Kpi _kpi) {

		// TODO Auto-generated method stub
		return null;
	}

	@JsonIgnore
	public static boolean isAverage(final String kpiKey) {

		return kpiKey.endsWith(AVERAGE_KEY);
	}

	@JsonIgnore
	public static boolean isSum(final String kpiKey) {

		return kpiKey.endsWith(SUM_KEY);
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_kpi.cronExpression
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	@NotNull
	@Size(min = 0, max = 60)
	private String	       cronExpression;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_kpi.description
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	@NotNull
	@Size(min = 0, max = 2048)
	private String	       description;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_kpi.entityType
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	@NotNull
	private EntityType	   entityType;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_kpi.esperRequest
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	@NotNull
	@Size(min = 0, max = 16777215)
	private String	       esperRequest;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_kpi.id
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	private Integer	       id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_kpi.kpiKey
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	@NotNull
	@Size(min = 0, max = 255)
	private String	       kpiKey;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_kpi.name
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	@NotNull
	@Size(min = 0, max = 255)
	private String	       name;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_kpi.providerType
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	@NotNull
	private ProviderType	providerType;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_kpi.valueDirection
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	@NotNull
	private ValueDirection	valueDirection;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_kpi.valueMax
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	private Double	       valueMax;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_kpi.valueMin
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	private Double	       valueMin;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column kom_kpi.valueType
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	@NotNull
	private ValueType	   valueType;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table kom_kpi
	 * 
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public Kpi() {

		super();
	}

	public Kpi(final Integer _id, final String _kpiKey, final String _name, final String _description,
	        final Double _valueMin, final Double _valueMax, final ValueDirection _valueDirection,
	        final ValueType _valueType, final EntityType _entityType, final String _cronExpression,
	        final ProviderType _providerType) {

		id = _id;
		kpiKey = _kpiKey;
		name = _name;
		description = _description;
		valueMin = _valueMin;
		valueMax = _valueMax;
		valueDirection = _valueDirection;
		valueType = _valueType;
		entityType = _entityType;
		cronExpression = _cronExpression;
		providerType = _providerType;
		esperRequest = "";
	}

	public Kpi(final Integer _id, final String _kpiKey, final String _name, final String _description,
	        final Double _valueMin, final Double _valueMax, final ValueDirection _valueDirection,
	        final ValueType _valueType, final EntityType _entityType, final String _cronExpression,
	        final ProviderType _providerType, final String _esperRequest) {

		id = _id;
		kpiKey = _kpiKey;
		name = _name;
		description = _description;
		valueMin = _valueMin;
		valueMax = _valueMax;
		valueDirection = _valueDirection;
		valueType = _valueType;
		entityType = _entityType;
		cronExpression = _cronExpression;
		providerType = _providerType;
		esperRequest = _esperRequest;
	}

	@JsonIgnore
	@Override
	public void accept(final IKeyVisitor _visitor) {

		_visitor.visit(this);

	}

	@JsonIgnore
	public String computeKPIEsperKey() {

		final StringBuilder sb = new StringBuilder();
		sb.append("KPI_");
		sb.append(kpiKey);
		if (getEntityType() != null) {
			sb.append("_T_").append(getEntityType().name());
		}

		return sb.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kom_kpi.cronExpression
	 * 
	 * @return the value of kom_kpi.cronExpression
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public String getCronExpression() {

		return cronExpression;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kom_kpi.description
	 * 
	 * @return the value of kom_kpi.description
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public String getDescription() {

		return description;
	}

	@Override
	@JsonIgnore
	public String getDisplayName() {

		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kom_kpi.entityType
	 * 
	 * @return the value of kom_kpi.entityType
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public EntityType getEntityType() {

		return entityType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kom_kpi.esperRequest
	 * 
	 * @return the value of kom_kpi.esperRequest
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public String getEsperRequest() {

		return esperRequest;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kom_kpi.id
	 * 
	 * @return the value of kom_kpi.id
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	@Override
	public Integer getId() {

		return id;
	}

	@Override
	@JsonIgnore
	public String getKey() {

		return kpiKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kom_kpi.kpiKey
	 * 
	 * @return the value of kom_kpi.kpiKey
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public String getKpiKey() {

		return kpiKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kom_kpi.name
	 * 
	 * @return the value of kom_kpi.name
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public String getName() {

		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kom_kpi.providerType
	 * 
	 * @return the value of kom_kpi.providerType
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public ProviderType getProviderType() {

		return providerType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kom_kpi.valueDirection
	 * 
	 * @return the value of kom_kpi.valueDirection
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public ValueDirection getValueDirection() {

		return valueDirection;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kom_kpi.valueMax
	 * 
	 * @return the value of kom_kpi.valueMax
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public Double getValueMax() {

		return valueMax;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kom_kpi.valueMin
	 * 
	 * @return the value of kom_kpi.valueMin
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public Double getValueMin() {

		return valueMin;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column kom_kpi.valueType
	 * 
	 * @return the value of kom_kpi.valueType
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public ValueType getValueType() {

		return valueType;
	}

	@JsonIgnore
	public void setAverageKpi(final boolean nameAndDesc) {

		setKpiKey(getKpiKey() + AVERAGE_KEY);
		if (nameAndDesc) {
			setName(getName() + " (average)");
			setDescription(getDescription() + " (average)");
		}
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kom_kpi.cronExpression
	 * 
	 * @param cronExpression
	 *            the value for kom_kpi.cronExpression
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public void setCronExpression(final String cronExpression) {

		this.cronExpression = cronExpression;
	}

	public void setDelayForBackup(final BackupDelay _backupDelay) {
		Validate.notNull(_backupDelay);
		cronExpression = _backupDelay.name();
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kom_kpi.description
	 * 
	 * @param description
	 *            the value for kom_kpi.description
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public void setDescription(final String description) {

		this.description = description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kom_kpi.entityType
	 * 
	 * @param entityType
	 *            the value for kom_kpi.entityType
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public void setEntityType(final EntityType entityType) {

		this.entityType = entityType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kom_kpi.esperRequest
	 * 
	 * @param esperRequest
	 *            the value for kom_kpi.esperRequest
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public void setEsperRequest(final String esperRequest) {

		this.esperRequest = esperRequest;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kom_kpi.id
	 * 
	 * @param id
	 *            the value for kom_kpi.id
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	@Override
	public void setId(final Integer id) {

		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kom_kpi.kpiKey
	 * 
	 * @param kpiKey
	 *            the value for kom_kpi.kpiKey
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public void setKpiKey(final String kpiKey) {

		this.kpiKey = kpiKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kom_kpi.name
	 * 
	 * @param name
	 *            the value for kom_kpi.name
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public void setName(final String name) {

		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kom_kpi.providerType
	 * 
	 * @param providerType
	 *            the value for kom_kpi.providerType
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public void setProviderType(final ProviderType providerType) {

		this.providerType = providerType;
	}

	@JsonIgnore
	public void setSumKpi() {

		setKpiKey(getKpiKey() + SUM_KEY);
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kom_kpi.valueDirection
	 * 
	 * @param valueDirection
	 *            the value for kom_kpi.valueDirection
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public void setValueDirection(final ValueDirection valueDirection) {

		this.valueDirection = valueDirection;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kom_kpi.valueMax
	 * 
	 * @param valueMax
	 *            the value for kom_kpi.valueMax
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public void setValueMax(final Double valueMax) {

		this.valueMax = valueMax;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kom_kpi.valueMin
	 * 
	 * @param valueMin
	 *            the value for kom_kpi.valueMin
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public void setValueMin(final Double valueMin) {

		this.valueMin = valueMin;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column kom_kpi.valueType
	 * 
	 * @param valueType
	 *            the value for kom_kpi.valueType
	 * @mbggenerated Thu May 08 16:31:55 CEST 2014
	 */
	public void setValueType(final ValueType valueType) {

		this.valueType = valueType;
	}

	@Override
	public String toString() {

		return "Kpi [cronExpression=" + cronExpression + ", description=" + description + ", entityType=" + entityType
		        + ", esperRequest=" + esperRequest + ", id=" + id + ", kpiKey=" + kpiKey + ", name=" + name
		        + ", providerType=" + providerType + ", valueDirection=" + valueDirection + ", valueMax=" + valueMax
		        + ", valueMin=" + valueMin + ", valueType=" + valueType + "]";
	}

}
