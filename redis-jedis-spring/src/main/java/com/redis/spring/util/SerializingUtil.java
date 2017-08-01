package com.redis.spring.util;


import java.io.*;

/**
 * 对象 的序列化与反序列化
 */
public class SerializingUtil {

    /**
     * 对实体Bean进行序列化操作
     * @param source 待转换的实体
     * @return 转换之后的字节数组
     * @throws IOException
     */
    public static byte[] serialize(Object source) throws IOException {
        {
            try(ByteArrayOutputStream byteOut = new ByteArrayOutputStream()){
                ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
                objOut.writeObject(source);
                objOut.flush();

                objOut.close();

                return byteOut.toByteArray();
            }
        }
    }

    public static Object deserialize(byte[] source) throws IOException, ClassNotFoundException {
        {
            try (ByteArrayInputStream byteIn = new ByteArrayInputStream(source)) {
                Object retVal = null;

                ObjectInputStream objIn = new ObjectInputStream(byteIn);
                retVal = objIn.readObject();

                objIn.close();

                return retVal;
            }
        }
    }
}
