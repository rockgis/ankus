/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.openflamingo.remote.thrift.thriftfs.jobtracker.api;

import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Status of a job
 */
public class ThriftJobStatus implements org.apache.thrift.TBase<ThriftJobStatus, ThriftJobStatus._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftJobStatus");

  private static final org.apache.thrift.protocol.TField JOB_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("jobID", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField MAP_PROGRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("mapProgress", org.apache.thrift.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.thrift.protocol.TField REDUCE_PROGRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("reduceProgress", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField CLEANUP_PROGRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("cleanupProgress", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField SETUP_PROGRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("setupProgress", org.apache.thrift.protocol.TType.DOUBLE, (short)5);
  private static final org.apache.thrift.protocol.TField RUN_STATE_FIELD_DESC = new org.apache.thrift.protocol.TField("runState", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField START_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("startTime", org.apache.thrift.protocol.TType.I64, (short)7);
  private static final org.apache.thrift.protocol.TField USER_FIELD_DESC = new org.apache.thrift.protocol.TField("user", org.apache.thrift.protocol.TType.STRING, (short)8);
  private static final org.apache.thrift.protocol.TField PRIORITY_FIELD_DESC = new org.apache.thrift.protocol.TField("priority", org.apache.thrift.protocol.TType.I32, (short)9);
  private static final org.apache.thrift.protocol.TField SCHEDULING_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("schedulingInfo", org.apache.thrift.protocol.TType.STRING, (short)10);

  public ThriftJobID jobID;
  public double mapProgress;
  public double reduceProgress;
  public double cleanupProgress;
  public double setupProgress;
  /**
   * 
   * @see ThriftJobState
   */
  public ThriftJobState runState;
  public long startTime;
  public String user;
  /**
   * 
   * @see ThriftJobPriority
   */
  public ThriftJobPriority priority;
  public String schedulingInfo;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    JOB_ID((short)1, "jobID"),
    MAP_PROGRESS((short)2, "mapProgress"),
    REDUCE_PROGRESS((short)3, "reduceProgress"),
    CLEANUP_PROGRESS((short)4, "cleanupProgress"),
    SETUP_PROGRESS((short)5, "setupProgress"),
    /**
     * 
     * @see ThriftJobState
     */
    RUN_STATE((short)6, "runState"),
    START_TIME((short)7, "startTime"),
    USER((short)8, "user"),
    /**
     * 
     * @see ThriftJobPriority
     */
    PRIORITY((short)9, "priority"),
    SCHEDULING_INFO((short)10, "schedulingInfo");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // JOB_ID
          return JOB_ID;
        case 2: // MAP_PROGRESS
          return MAP_PROGRESS;
        case 3: // REDUCE_PROGRESS
          return REDUCE_PROGRESS;
        case 4: // CLEANUP_PROGRESS
          return CLEANUP_PROGRESS;
        case 5: // SETUP_PROGRESS
          return SETUP_PROGRESS;
        case 6: // RUN_STATE
          return RUN_STATE;
        case 7: // START_TIME
          return START_TIME;
        case 8: // USER
          return USER;
        case 9: // PRIORITY
          return PRIORITY;
        case 10: // SCHEDULING_INFO
          return SCHEDULING_INFO;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __MAPPROGRESS_ISSET_ID = 0;
  private static final int __REDUCEPROGRESS_ISSET_ID = 1;
  private static final int __CLEANUPPROGRESS_ISSET_ID = 2;
  private static final int __SETUPPROGRESS_ISSET_ID = 3;
  private static final int __STARTTIME_ISSET_ID = 4;
  private BitSet __isset_bit_vector = new BitSet(5);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.JOB_ID, new org.apache.thrift.meta_data.FieldMetaData("jobID", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ThriftJobID.class)));
    tmpMap.put(_Fields.MAP_PROGRESS, new org.apache.thrift.meta_data.FieldMetaData("mapProgress", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.REDUCE_PROGRESS, new org.apache.thrift.meta_data.FieldMetaData("reduceProgress", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.CLEANUP_PROGRESS, new org.apache.thrift.meta_data.FieldMetaData("cleanupProgress", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.SETUP_PROGRESS, new org.apache.thrift.meta_data.FieldMetaData("setupProgress", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.RUN_STATE, new org.apache.thrift.meta_data.FieldMetaData("runState", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ThriftJobState.class)));
    tmpMap.put(_Fields.START_TIME, new org.apache.thrift.meta_data.FieldMetaData("startTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.USER, new org.apache.thrift.meta_data.FieldMetaData("user", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PRIORITY, new org.apache.thrift.meta_data.FieldMetaData("priority", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ThriftJobPriority.class)));
    tmpMap.put(_Fields.SCHEDULING_INFO, new org.apache.thrift.meta_data.FieldMetaData("schedulingInfo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftJobStatus.class, metaDataMap);
  }

  public ThriftJobStatus() {
  }

  public ThriftJobStatus(
    ThriftJobID jobID,
    double mapProgress,
    double reduceProgress,
    double cleanupProgress,
    double setupProgress,
    ThriftJobState runState,
    long startTime,
    String user,
    ThriftJobPriority priority,
    String schedulingInfo)
  {
    this();
    this.jobID = jobID;
    this.mapProgress = mapProgress;
    setMapProgressIsSet(true);
    this.reduceProgress = reduceProgress;
    setReduceProgressIsSet(true);
    this.cleanupProgress = cleanupProgress;
    setCleanupProgressIsSet(true);
    this.setupProgress = setupProgress;
    setSetupProgressIsSet(true);
    this.runState = runState;
    this.startTime = startTime;
    setStartTimeIsSet(true);
    this.user = user;
    this.priority = priority;
    this.schedulingInfo = schedulingInfo;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftJobStatus(ThriftJobStatus other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    if (other.isSetJobID()) {
      this.jobID = new ThriftJobID(other.jobID);
    }
    this.mapProgress = other.mapProgress;
    this.reduceProgress = other.reduceProgress;
    this.cleanupProgress = other.cleanupProgress;
    this.setupProgress = other.setupProgress;
    if (other.isSetRunState()) {
      this.runState = other.runState;
    }
    this.startTime = other.startTime;
    if (other.isSetUser()) {
      this.user = other.user;
    }
    if (other.isSetPriority()) {
      this.priority = other.priority;
    }
    if (other.isSetSchedulingInfo()) {
      this.schedulingInfo = other.schedulingInfo;
    }
  }

  public ThriftJobStatus deepCopy() {
    return new ThriftJobStatus(this);
  }

  @Override
  public void clear() {
    this.jobID = null;
    setMapProgressIsSet(false);
    this.mapProgress = 0.0;
    setReduceProgressIsSet(false);
    this.reduceProgress = 0.0;
    setCleanupProgressIsSet(false);
    this.cleanupProgress = 0.0;
    setSetupProgressIsSet(false);
    this.setupProgress = 0.0;
    this.runState = null;
    setStartTimeIsSet(false);
    this.startTime = 0;
    this.user = null;
    this.priority = null;
    this.schedulingInfo = null;
  }

  public ThriftJobID getJobID() {
    return this.jobID;
  }

  public ThriftJobStatus setJobID(ThriftJobID jobID) {
    this.jobID = jobID;
    return this;
  }

  public void unsetJobID() {
    this.jobID = null;
  }

  /** Returns true if field jobID is set (has been assigned a value) and false otherwise */
  public boolean isSetJobID() {
    return this.jobID != null;
  }

  public void setJobIDIsSet(boolean value) {
    if (!value) {
      this.jobID = null;
    }
  }

  public double getMapProgress() {
    return this.mapProgress;
  }

  public ThriftJobStatus setMapProgress(double mapProgress) {
    this.mapProgress = mapProgress;
    setMapProgressIsSet(true);
    return this;
  }

  public void unsetMapProgress() {
    __isset_bit_vector.clear(__MAPPROGRESS_ISSET_ID);
  }

  /** Returns true if field mapProgress is set (has been assigned a value) and false otherwise */
  public boolean isSetMapProgress() {
    return __isset_bit_vector.get(__MAPPROGRESS_ISSET_ID);
  }

  public void setMapProgressIsSet(boolean value) {
    __isset_bit_vector.set(__MAPPROGRESS_ISSET_ID, value);
  }

  public double getReduceProgress() {
    return this.reduceProgress;
  }

  public ThriftJobStatus setReduceProgress(double reduceProgress) {
    this.reduceProgress = reduceProgress;
    setReduceProgressIsSet(true);
    return this;
  }

  public void unsetReduceProgress() {
    __isset_bit_vector.clear(__REDUCEPROGRESS_ISSET_ID);
  }

  /** Returns true if field reduceProgress is set (has been assigned a value) and false otherwise */
  public boolean isSetReduceProgress() {
    return __isset_bit_vector.get(__REDUCEPROGRESS_ISSET_ID);
  }

  public void setReduceProgressIsSet(boolean value) {
    __isset_bit_vector.set(__REDUCEPROGRESS_ISSET_ID, value);
  }

  public double getCleanupProgress() {
    return this.cleanupProgress;
  }

  public ThriftJobStatus setCleanupProgress(double cleanupProgress) {
    this.cleanupProgress = cleanupProgress;
    setCleanupProgressIsSet(true);
    return this;
  }

  public void unsetCleanupProgress() {
    __isset_bit_vector.clear(__CLEANUPPROGRESS_ISSET_ID);
  }

  /** Returns true if field cleanupProgress is set (has been assigned a value) and false otherwise */
  public boolean isSetCleanupProgress() {
    return __isset_bit_vector.get(__CLEANUPPROGRESS_ISSET_ID);
  }

  public void setCleanupProgressIsSet(boolean value) {
    __isset_bit_vector.set(__CLEANUPPROGRESS_ISSET_ID, value);
  }

  public double getSetupProgress() {
    return this.setupProgress;
  }

  public ThriftJobStatus setSetupProgress(double setupProgress) {
    this.setupProgress = setupProgress;
    setSetupProgressIsSet(true);
    return this;
  }

  public void unsetSetupProgress() {
    __isset_bit_vector.clear(__SETUPPROGRESS_ISSET_ID);
  }

  /** Returns true if field setupProgress is set (has been assigned a value) and false otherwise */
  public boolean isSetSetupProgress() {
    return __isset_bit_vector.get(__SETUPPROGRESS_ISSET_ID);
  }

  public void setSetupProgressIsSet(boolean value) {
    __isset_bit_vector.set(__SETUPPROGRESS_ISSET_ID, value);
  }

  /**
   * 
   * @see ThriftJobState
   */
  public ThriftJobState getRunState() {
    return this.runState;
  }

  /**
   * 
   * @see ThriftJobState
   */
  public ThriftJobStatus setRunState(ThriftJobState runState) {
    this.runState = runState;
    return this;
  }

  public void unsetRunState() {
    this.runState = null;
  }

  /** Returns true if field runState is set (has been assigned a value) and false otherwise */
  public boolean isSetRunState() {
    return this.runState != null;
  }

  public void setRunStateIsSet(boolean value) {
    if (!value) {
      this.runState = null;
    }
  }

  public long getStartTime() {
    return this.startTime;
  }

  public ThriftJobStatus setStartTime(long startTime) {
    this.startTime = startTime;
    setStartTimeIsSet(true);
    return this;
  }

  public void unsetStartTime() {
    __isset_bit_vector.clear(__STARTTIME_ISSET_ID);
  }

  /** Returns true if field startTime is set (has been assigned a value) and false otherwise */
  public boolean isSetStartTime() {
    return __isset_bit_vector.get(__STARTTIME_ISSET_ID);
  }

  public void setStartTimeIsSet(boolean value) {
    __isset_bit_vector.set(__STARTTIME_ISSET_ID, value);
  }

  public String getUser() {
    return this.user;
  }

  public ThriftJobStatus setUser(String user) {
    this.user = user;
    return this;
  }

  public void unsetUser() {
    this.user = null;
  }

  /** Returns true if field user is set (has been assigned a value) and false otherwise */
  public boolean isSetUser() {
    return this.user != null;
  }

  public void setUserIsSet(boolean value) {
    if (!value) {
      this.user = null;
    }
  }

  /**
   * 
   * @see ThriftJobPriority
   */
  public ThriftJobPriority getPriority() {
    return this.priority;
  }

  /**
   * 
   * @see ThriftJobPriority
   */
  public ThriftJobStatus setPriority(ThriftJobPriority priority) {
    this.priority = priority;
    return this;
  }

  public void unsetPriority() {
    this.priority = null;
  }

  /** Returns true if field priority is set (has been assigned a value) and false otherwise */
  public boolean isSetPriority() {
    return this.priority != null;
  }

  public void setPriorityIsSet(boolean value) {
    if (!value) {
      this.priority = null;
    }
  }

  public String getSchedulingInfo() {
    return this.schedulingInfo;
  }

  public ThriftJobStatus setSchedulingInfo(String schedulingInfo) {
    this.schedulingInfo = schedulingInfo;
    return this;
  }

  public void unsetSchedulingInfo() {
    this.schedulingInfo = null;
  }

  /** Returns true if field schedulingInfo is set (has been assigned a value) and false otherwise */
  public boolean isSetSchedulingInfo() {
    return this.schedulingInfo != null;
  }

  public void setSchedulingInfoIsSet(boolean value) {
    if (!value) {
      this.schedulingInfo = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case JOB_ID:
      if (value == null) {
        unsetJobID();
      } else {
        setJobID((ThriftJobID)value);
      }
      break;

    case MAP_PROGRESS:
      if (value == null) {
        unsetMapProgress();
      } else {
        setMapProgress((Double)value);
      }
      break;

    case REDUCE_PROGRESS:
      if (value == null) {
        unsetReduceProgress();
      } else {
        setReduceProgress((Double)value);
      }
      break;

    case CLEANUP_PROGRESS:
      if (value == null) {
        unsetCleanupProgress();
      } else {
        setCleanupProgress((Double)value);
      }
      break;

    case SETUP_PROGRESS:
      if (value == null) {
        unsetSetupProgress();
      } else {
        setSetupProgress((Double)value);
      }
      break;

    case RUN_STATE:
      if (value == null) {
        unsetRunState();
      } else {
        setRunState((ThriftJobState)value);
      }
      break;

    case START_TIME:
      if (value == null) {
        unsetStartTime();
      } else {
        setStartTime((Long)value);
      }
      break;

    case USER:
      if (value == null) {
        unsetUser();
      } else {
        setUser((String)value);
      }
      break;

    case PRIORITY:
      if (value == null) {
        unsetPriority();
      } else {
        setPriority((ThriftJobPriority)value);
      }
      break;

    case SCHEDULING_INFO:
      if (value == null) {
        unsetSchedulingInfo();
      } else {
        setSchedulingInfo((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case JOB_ID:
      return getJobID();

    case MAP_PROGRESS:
      return new Double(getMapProgress());

    case REDUCE_PROGRESS:
      return new Double(getReduceProgress());

    case CLEANUP_PROGRESS:
      return new Double(getCleanupProgress());

    case SETUP_PROGRESS:
      return new Double(getSetupProgress());

    case RUN_STATE:
      return getRunState();

    case START_TIME:
      return new Long(getStartTime());

    case USER:
      return getUser();

    case PRIORITY:
      return getPriority();

    case SCHEDULING_INFO:
      return getSchedulingInfo();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case JOB_ID:
      return isSetJobID();
    case MAP_PROGRESS:
      return isSetMapProgress();
    case REDUCE_PROGRESS:
      return isSetReduceProgress();
    case CLEANUP_PROGRESS:
      return isSetCleanupProgress();
    case SETUP_PROGRESS:
      return isSetSetupProgress();
    case RUN_STATE:
      return isSetRunState();
    case START_TIME:
      return isSetStartTime();
    case USER:
      return isSetUser();
    case PRIORITY:
      return isSetPriority();
    case SCHEDULING_INFO:
      return isSetSchedulingInfo();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftJobStatus)
      return this.equals((ThriftJobStatus)that);
    return false;
  }

  public boolean equals(ThriftJobStatus that) {
    if (that == null)
      return false;

    boolean this_present_jobID = true && this.isSetJobID();
    boolean that_present_jobID = true && that.isSetJobID();
    if (this_present_jobID || that_present_jobID) {
      if (!(this_present_jobID && that_present_jobID))
        return false;
      if (!this.jobID.equals(that.jobID))
        return false;
    }

    boolean this_present_mapProgress = true;
    boolean that_present_mapProgress = true;
    if (this_present_mapProgress || that_present_mapProgress) {
      if (!(this_present_mapProgress && that_present_mapProgress))
        return false;
      if (this.mapProgress != that.mapProgress)
        return false;
    }

    boolean this_present_reduceProgress = true;
    boolean that_present_reduceProgress = true;
    if (this_present_reduceProgress || that_present_reduceProgress) {
      if (!(this_present_reduceProgress && that_present_reduceProgress))
        return false;
      if (this.reduceProgress != that.reduceProgress)
        return false;
    }

    boolean this_present_cleanupProgress = true;
    boolean that_present_cleanupProgress = true;
    if (this_present_cleanupProgress || that_present_cleanupProgress) {
      if (!(this_present_cleanupProgress && that_present_cleanupProgress))
        return false;
      if (this.cleanupProgress != that.cleanupProgress)
        return false;
    }

    boolean this_present_setupProgress = true;
    boolean that_present_setupProgress = true;
    if (this_present_setupProgress || that_present_setupProgress) {
      if (!(this_present_setupProgress && that_present_setupProgress))
        return false;
      if (this.setupProgress != that.setupProgress)
        return false;
    }

    boolean this_present_runState = true && this.isSetRunState();
    boolean that_present_runState = true && that.isSetRunState();
    if (this_present_runState || that_present_runState) {
      if (!(this_present_runState && that_present_runState))
        return false;
      if (!this.runState.equals(that.runState))
        return false;
    }

    boolean this_present_startTime = true;
    boolean that_present_startTime = true;
    if (this_present_startTime || that_present_startTime) {
      if (!(this_present_startTime && that_present_startTime))
        return false;
      if (this.startTime != that.startTime)
        return false;
    }

    boolean this_present_user = true && this.isSetUser();
    boolean that_present_user = true && that.isSetUser();
    if (this_present_user || that_present_user) {
      if (!(this_present_user && that_present_user))
        return false;
      if (!this.user.equals(that.user))
        return false;
    }

    boolean this_present_priority = true && this.isSetPriority();
    boolean that_present_priority = true && that.isSetPriority();
    if (this_present_priority || that_present_priority) {
      if (!(this_present_priority && that_present_priority))
        return false;
      if (!this.priority.equals(that.priority))
        return false;
    }

    boolean this_present_schedulingInfo = true && this.isSetSchedulingInfo();
    boolean that_present_schedulingInfo = true && that.isSetSchedulingInfo();
    if (this_present_schedulingInfo || that_present_schedulingInfo) {
      if (!(this_present_schedulingInfo && that_present_schedulingInfo))
        return false;
      if (!this.schedulingInfo.equals(that.schedulingInfo))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_jobID = true && (isSetJobID());
    builder.append(present_jobID);
    if (present_jobID)
      builder.append(jobID);

    boolean present_mapProgress = true;
    builder.append(present_mapProgress);
    if (present_mapProgress)
      builder.append(mapProgress);

    boolean present_reduceProgress = true;
    builder.append(present_reduceProgress);
    if (present_reduceProgress)
      builder.append(reduceProgress);

    boolean present_cleanupProgress = true;
    builder.append(present_cleanupProgress);
    if (present_cleanupProgress)
      builder.append(cleanupProgress);

    boolean present_setupProgress = true;
    builder.append(present_setupProgress);
    if (present_setupProgress)
      builder.append(setupProgress);

    boolean present_runState = true && (isSetRunState());
    builder.append(present_runState);
    if (present_runState)
      builder.append(runState.getValue());

    boolean present_startTime = true;
    builder.append(present_startTime);
    if (present_startTime)
      builder.append(startTime);

    boolean present_user = true && (isSetUser());
    builder.append(present_user);
    if (present_user)
      builder.append(user);

    boolean present_priority = true && (isSetPriority());
    builder.append(present_priority);
    if (present_priority)
      builder.append(priority.getValue());

    boolean present_schedulingInfo = true && (isSetSchedulingInfo());
    builder.append(present_schedulingInfo);
    if (present_schedulingInfo)
      builder.append(schedulingInfo);

    return builder.toHashCode();
  }

  public int compareTo(ThriftJobStatus other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ThriftJobStatus typedOther = (ThriftJobStatus)other;

    lastComparison = Boolean.valueOf(isSetJobID()).compareTo(typedOther.isSetJobID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJobID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jobID, typedOther.jobID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMapProgress()).compareTo(typedOther.isSetMapProgress());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMapProgress()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mapProgress, typedOther.mapProgress);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetReduceProgress()).compareTo(typedOther.isSetReduceProgress());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReduceProgress()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reduceProgress, typedOther.reduceProgress);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCleanupProgress()).compareTo(typedOther.isSetCleanupProgress());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCleanupProgress()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cleanupProgress, typedOther.cleanupProgress);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSetupProgress()).compareTo(typedOther.isSetSetupProgress());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSetupProgress()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.setupProgress, typedOther.setupProgress);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRunState()).compareTo(typedOther.isSetRunState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRunState()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.runState, typedOther.runState);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStartTime()).compareTo(typedOther.isSetStartTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStartTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.startTime, typedOther.startTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUser()).compareTo(typedOther.isSetUser());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user, typedOther.user);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPriority()).compareTo(typedOther.isSetPriority());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPriority()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.priority, typedOther.priority);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSchedulingInfo()).compareTo(typedOther.isSetSchedulingInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSchedulingInfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.schedulingInfo, typedOther.schedulingInfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // JOB_ID
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.jobID = new ThriftJobID();
            this.jobID.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // MAP_PROGRESS
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.mapProgress = iprot.readDouble();
            setMapProgressIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // REDUCE_PROGRESS
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.reduceProgress = iprot.readDouble();
            setReduceProgressIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // CLEANUP_PROGRESS
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.cleanupProgress = iprot.readDouble();
            setCleanupProgressIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // SETUP_PROGRESS
          if (field.type == org.apache.thrift.protocol.TType.DOUBLE) {
            this.setupProgress = iprot.readDouble();
            setSetupProgressIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // RUN_STATE
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.runState = ThriftJobState.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // START_TIME
          if (field.type == org.apache.thrift.protocol.TType.I64) {
            this.startTime = iprot.readI64();
            setStartTimeIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 8: // USER
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.user = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 9: // PRIORITY
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.priority = ThriftJobPriority.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 10: // SCHEDULING_INFO
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.schedulingInfo = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.jobID != null) {
      oprot.writeFieldBegin(JOB_ID_FIELD_DESC);
      this.jobID.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(MAP_PROGRESS_FIELD_DESC);
    oprot.writeDouble(this.mapProgress);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(REDUCE_PROGRESS_FIELD_DESC);
    oprot.writeDouble(this.reduceProgress);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(CLEANUP_PROGRESS_FIELD_DESC);
    oprot.writeDouble(this.cleanupProgress);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(SETUP_PROGRESS_FIELD_DESC);
    oprot.writeDouble(this.setupProgress);
    oprot.writeFieldEnd();
    if (this.runState != null) {
      oprot.writeFieldBegin(RUN_STATE_FIELD_DESC);
      oprot.writeI32(this.runState.getValue());
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(START_TIME_FIELD_DESC);
    oprot.writeI64(this.startTime);
    oprot.writeFieldEnd();
    if (this.user != null) {
      oprot.writeFieldBegin(USER_FIELD_DESC);
      oprot.writeString(this.user);
      oprot.writeFieldEnd();
    }
    if (this.priority != null) {
      oprot.writeFieldBegin(PRIORITY_FIELD_DESC);
      oprot.writeI32(this.priority.getValue());
      oprot.writeFieldEnd();
    }
    if (this.schedulingInfo != null) {
      oprot.writeFieldBegin(SCHEDULING_INFO_FIELD_DESC);
      oprot.writeString(this.schedulingInfo);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ThriftJobStatus(");
    boolean first = true;

    sb.append("jobID:");
    if (this.jobID == null) {
      sb.append("null");
    } else {
      sb.append(this.jobID);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("mapProgress:");
    sb.append(this.mapProgress);
    first = false;
    if (!first) sb.append(", ");
    sb.append("reduceProgress:");
    sb.append(this.reduceProgress);
    first = false;
    if (!first) sb.append(", ");
    sb.append("cleanupProgress:");
    sb.append(this.cleanupProgress);
    first = false;
    if (!first) sb.append(", ");
    sb.append("setupProgress:");
    sb.append(this.setupProgress);
    first = false;
    if (!first) sb.append(", ");
    sb.append("runState:");
    if (this.runState == null) {
      sb.append("null");
    } else {
      sb.append(this.runState);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("startTime:");
    sb.append(this.startTime);
    first = false;
    if (!first) sb.append(", ");
    sb.append("user:");
    if (this.user == null) {
      sb.append("null");
    } else {
      sb.append(this.user);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("priority:");
    if (this.priority == null) {
      sb.append("null");
    } else {
      sb.append(this.priority);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("schedulingInfo:");
    if (this.schedulingInfo == null) {
      sb.append("null");
    } else {
      sb.append(this.schedulingInfo);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

