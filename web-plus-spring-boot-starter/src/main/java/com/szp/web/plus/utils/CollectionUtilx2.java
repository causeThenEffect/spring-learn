package com.szp.web.plus.utils;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

/**
 * @author cause
 * @version 1.0.0 create time 7/5/2020 9:11 PM
 */
public class CollectionUtilx2 {

  public static <K, V, T> Map<K, Set<V>> list2GroupMap(
      List<T> source, Function<T, K> getK, Function<T, V> getV,  Map<K, Set<V>> groupMap){
    if(Objects.isNull(groupMap)){
      groupMap = Maps.newHashMap();
    }
    Map<K, Set<V>> result = groupMap;
    source.forEach(t -> {
      K key = getK.apply(t);
      Set<V> group = result.getOrDefault(key, Sets.newHashSet());
      group.add(getV.apply(t));
      result.put(key, group);
    });
    return result;
  }

  public static <K, V, T> Map<K, Set<V>> list2GroupMap(
      List<T> source, Function<T, K> getK, Function<T, V> getV){
    return list2GroupMap(source, getK, getV, null);
  }
}
