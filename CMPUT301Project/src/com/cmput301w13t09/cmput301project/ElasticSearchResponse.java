package com.cmput301w13t09.cmput301project;

/**
 * 
 * @author Code Originally by Abram Hindle and Chenlei Zhang used by
 *         Kyle,Marcus, and Lanre https://github.com/rayzhangcl/ESDemo
 *         ElasticSearchResponse is a class used to stores search responses
 * @param <T>
 */
public class ElasticSearchResponse<T> {
    String _index;
    String _type;
    String _id;
    int _version;
    boolean exists;
    double max_score;
    T _source;
    public T getSource() {
        return _source;
    }
}