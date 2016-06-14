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
 * Container structure for TaskTrackerStatus objects
 */
public class ThriftTaskTrackerStatusList implements org.apache.thrift.TBase<ThriftTaskTrackerStatusList, ThriftTaskTrackerStatusList._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftTaskTrackerStatusList");

  private static final org.apache.thrift.protocol.TField TRACKERS_FIELD_DESC = new org.apache.thrift.protocol.TField("trackers", org.apache.thrift.protocol.TType.LIST, (short)1);

  public List<ThriftTaskTrackerStatus> trackers;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TRACKERS((short)1, "trackers");

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
        case 1: // TRACKERS
          return TRACKERS;
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

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TRACKERS, new org.apache.thrift.meta_data.FieldMetaData("trackers", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ThriftTaskTrackerStatus.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftTaskTrackerStatusList.class, metaDataMap);
  }

  public ThriftTaskTrackerStatusList() {
  }

  public ThriftTaskTrackerStatusList(
    List<ThriftTaskTrackerStatus> trackers)
  {
    this();
    this.trackers = trackers;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftTaskTrackerStatusList(ThriftTaskTrackerStatusList other) {
    if (other.isSetTrackers()) {
      List<ThriftTaskTrackerStatus> __this__trackers = new ArrayList<ThriftTaskTrackerStatus>();
      for (ThriftTaskTrackerStatus other_element : other.trackers) {
        __this__trackers.add(new ThriftTaskTrackerStatus(other_element));
      }
      this.trackers = __this__trackers;
    }
  }

  public ThriftTaskTrackerStatusList deepCopy() {
    return new ThriftTaskTrackerStatusList(this);
  }

  @Override
  public void clear() {
    this.trackers = null;
  }

  public int getTrackersSize() {
    return (this.trackers == null) ? 0 : this.trackers.size();
  }

  public java.util.Iterator<ThriftTaskTrackerStatus> getTrackersIterator() {
    return (this.trackers == null) ? null : this.trackers.iterator();
  }

  public void addToTrackers(ThriftTaskTrackerStatus elem) {
    if (this.trackers == null) {
      this.trackers = new ArrayList<ThriftTaskTrackerStatus>();
    }
    this.trackers.add(elem);
  }

  public List<ThriftTaskTrackerStatus> getTrackers() {
    return this.trackers;
  }

  public ThriftTaskTrackerStatusList setTrackers(List<ThriftTaskTrackerStatus> trackers) {
    this.trackers = trackers;
    return this;
  }

  public void unsetTrackers() {
    this.trackers = null;
  }

  /** Returns true if field trackers is set (has been assigned a value) and false otherwise */
  public boolean isSetTrackers() {
    return this.trackers != null;
  }

  public void setTrackersIsSet(boolean value) {
    if (!value) {
      this.trackers = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TRACKERS:
      if (value == null) {
        unsetTrackers();
      } else {
        setTrackers((List<ThriftTaskTrackerStatus>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TRACKERS:
      return getTrackers();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TRACKERS:
      return isSetTrackers();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftTaskTrackerStatusList)
      return this.equals((ThriftTaskTrackerStatusList)that);
    return false;
  }

  public boolean equals(ThriftTaskTrackerStatusList that) {
    if (that == null)
      return false;

    boolean this_present_trackers = true && this.isSetTrackers();
    boolean that_present_trackers = true && that.isSetTrackers();
    if (this_present_trackers || that_present_trackers) {
      if (!(this_present_trackers && that_present_trackers))
        return false;
      if (!this.trackers.equals(that.trackers))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_trackers = true && (isSetTrackers());
    builder.append(present_trackers);
    if (present_trackers)
      builder.append(trackers);

    return builder.toHashCode();
  }

  public int compareTo(ThriftTaskTrackerStatusList other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ThriftTaskTrackerStatusList typedOther = (ThriftTaskTrackerStatusList)other;

    lastComparison = Boolean.valueOf(isSetTrackers()).compareTo(typedOther.isSetTrackers());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTrackers()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.trackers, typedOther.trackers);
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
        case 1: // TRACKERS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list39 = iprot.readListBegin();
              this.trackers = new ArrayList<ThriftTaskTrackerStatus>(_list39.size);
              for (int _i40 = 0; _i40 < _list39.size; ++_i40)
              {
                ThriftTaskTrackerStatus _elem41;
                _elem41 = new ThriftTaskTrackerStatus();
                _elem41.read(iprot);
                this.trackers.add(_elem41);
              }
              iprot.readListEnd();
            }
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
    if (this.trackers != null) {
      oprot.writeFieldBegin(TRACKERS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, this.trackers.size()));
        for (ThriftTaskTrackerStatus _iter42 : this.trackers)
        {
          _iter42.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ThriftTaskTrackerStatusList(");
    boolean first = true;

    sb.append("trackers:");
    if (this.trackers == null) {
      sb.append("null");
    } else {
      sb.append(this.trackers);
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

