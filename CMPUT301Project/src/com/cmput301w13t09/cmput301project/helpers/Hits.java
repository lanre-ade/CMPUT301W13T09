package com.cmput301w13t09.cmput301project.helpers;

import java.util.Collection;

/**
 * 
 * @author Code Originally by Abram Hindle and Chenlei Zhang used by
 *         Kyle,Marcus, and Lanre https://github.com/rayzhangcl/ESDemo Hit is a
 *         class used to store and find the amount of hits in
 *         ElasticSearchResponse
 * @param <T>
 */
public class Hits<T> {
	int total;
	double max_score;
	Collection<ElasticSearchResponse<T>> hits;

	public Collection<ElasticSearchResponse<T>> getHits() {
		return hits;
	}

	public String toString() {
		return (super.toString() + "," + total + "," + max_score + "," + hits);
	}
}