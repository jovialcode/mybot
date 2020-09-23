package com.jovialcode.service.parser;

/**
 *  T : input Type
 *  R : return Type
 * */
public interface DataParser<T, R> {
    R parse(T t);
}
