package com.cmput301w13t09.cmput301project.helpers;
import java.util.ArrayList;
import java.util.Collection;

import com.cmput301w13t09.cmput301project.helpers.ElasticSearchResponse;
import com.cmput301w13t09.cmput301project.helpers.Hits;

/**
 * 
 * @author Code Originally by Abram Hindle and Chenlei Zhang used by
 *         Kyle,Marcus, and Lanre https://github.com/rayzhangcl/ESDemo
 *         ElasticSearchSeacrchResponse is a class used to stores search
 *         responses from _search.
 * @param <T>
 */
public class ElasticSearchSearchResponse<T> {
    int took;
    boolean timed_out;
    transient Object _shards;
    Hits<T> hits;
    boolean exists;    
    public Collection<ElasticSearchResponse<T>> getHits() {
        return hits.getHits();        
    }
    public Collection<T> getSources() {
        Collection<T> out = new ArrayList<T>();
        for (ElasticSearchResponse<T> essrt : getHits()) {
            out.add( essrt.getSource() );
        }
        return out;
    }
    public String toString() {
        return (super.toString() + ":" + took + "," + _shards + "," + exists + ","  + hits);     
    }
}