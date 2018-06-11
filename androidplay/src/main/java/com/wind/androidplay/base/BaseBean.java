package com.wind.androidplay.base;

/**
 * @author: GBX
 * @time: 9:31
 * @descrip:
 */
public class BaseBean<T> {
    public int errorCode;
    public String errorMsg;
    public T data;

    @Override
    public String toString() {
        return "BaseBean{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
