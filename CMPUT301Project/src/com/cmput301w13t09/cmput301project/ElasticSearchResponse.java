package com.cmput301w13t09.cmput301project;

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