package com.lz.zknock.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Administrator
 * 序列化工具类
 *
 */
public class SerializeUtil {
      public static byte[] serialize(Object object) {
          System.out.println("session is null:"+(null==object));
          byte[] bytes = null;
          try {
              // object to bytearray
              ByteArrayOutputStream bo = new ByteArrayOutputStream();
              ObjectOutputStream oo = new ObjectOutputStream(bo);
              oo.writeObject(object);

              bytes = bo.toByteArray();

              bo.close();
              oo.close();
          } catch (Exception e) {
              System.out.println("translation" + e.getMessage());
              e.printStackTrace();
          }
          return bytes;
      }

      public static Object unserialize( byte[] bytes) {
          Object obj = null;
          try {
              // bytearray to object
              ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
              ObjectInputStream oi = new ObjectInputStream(bi);

              obj = oi.readObject();
              bi.close();
              oi.close();
          } catch (Exception e) {
              System.out.println("translation" + e.getMessage());
              e.printStackTrace();
          }
          return obj;
      }
}