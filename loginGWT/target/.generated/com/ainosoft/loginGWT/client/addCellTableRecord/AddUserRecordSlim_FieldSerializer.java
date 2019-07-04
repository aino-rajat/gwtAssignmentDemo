package com.ainosoft.loginGWT.client.addCellTableRecord;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AddUserRecordSlim_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim instance) throws SerializationException {
    instance.city = streamReader.readString();
    instance.country = streamReader.readString();
    instance.id = streamReader.readInt();
    instance.name = streamReader.readString();
    instance.surname = streamReader.readString();
    
  }
  
  public static com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim instance) throws SerializationException {
    streamWriter.writeString(instance.city);
    streamWriter.writeString(instance.country);
    streamWriter.writeInt(instance.id);
    streamWriter.writeString(instance.name);
    streamWriter.writeString(instance.surname);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim_FieldSerializer.deserialize(reader, (com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim_FieldSerializer.serialize(writer, (com.ainosoft.loginGWT.client.addCellTableRecord.AddUserRecordSlim)object);
  }
  
}
