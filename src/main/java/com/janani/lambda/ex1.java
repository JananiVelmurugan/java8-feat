package com.janani.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.PredicateUtils;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;

public class ex1 {

	public static <A> List<A> cloneWithoutNulls1(final List<A> list) {
		List<A> out = new ArrayList<A>(list);
		while (out.remove(null)) {
		}
		return out;
	}

	public static <A> List<A> cloneWithoutNulls2(final List<A> list) {
		List<A> out = new ArrayList<A>(list.size());
		for (A elt : list) {
			if (elt != null)
				out.add(elt);
		}
		return out;
	}

	public static <A> List<A> cloneWithoutNulls3(final List<A> list) {
		Collection<A> nonNulls = CollectionUtils.select(list, PredicateUtils.notNullPredicate());
		return new ArrayList<>(nonNulls);
	}

	public static <A> List<A> cloneWithoutNulls4(final List<A> list) {
		Collection<A> nonNulls = Collections2.filter(list, Predicates.notNull());
		return new ArrayList<>(nonNulls);
	}

	public static <A> List<A> cloneWithoutNulls5(final List<A> list) {
		List<A> toReturn = new ArrayList<>(list);
		toReturn.removeIf(Predicate.isEqual(null));
		return toReturn;
	}

	public static <A> List<A> cloneWithoutNulls(final List<A> list) {
		List<A> toReturn = new ArrayList<>(list);
		toReturn.removeIf(it -> it == null);
		return toReturn;
	}
}
