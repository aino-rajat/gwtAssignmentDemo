package com.ainosoft.loginGWT.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class LoginSlim_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.ainosoft.loginGWT.client.LoginSlim instance) throws SerializationException {
    instance.id = streamReader.readInt();
    instance.password = streamReader.readString();
    instance.username = streamReader.readString();
    
  }
  
  public static com.ainosoft.loginGWT.client.LoginSlim instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.ainosoft.loginGWT.client.LoginSlim();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.ainosoft.loginGWT.client.LoginSlim instance) throws SerializationException {
    streamWriter.writeInt(instance.id);
    streamWriter.writeString(instance.password);
    streamWriter.writeString(instance.username);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.ainosoft.loginGWT.client.LoginSlim_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.ainosoft.loginGWT.client.LoginSlim_FieldSerializer.deserialize(reader, (com.ainosoft.loginGWT.client.LoginSlim)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.ainosoft.loginGWT.client.LoginSlim_FieldSerializer.serialize(writer, (com.ainosoft.loginGWT.client.LoginSlim)object);
  }
  
}
