package com.github.springbootmiaosha.base;

import com.google.common.collect.Sets;
import org.springframework.data.domain.Sort;

import java.util.Optional;
import java.util.Set;

/**
 * 排序生成器
 *
 * @author lizhangyu
 * @date 2019-08-29
 */
public class HouseSort {

    public static final String DEFAULT_SORT_KEY = "lastUpdateTime";

    public static final String DISTANCE_TO_SUBWAY_KEY = "distanceToSubway";

    public static final Set<String> SORT_KEYS = Sets.newHashSet(
            DEFAULT_SORT_KEY,
            "createTime",
            "price",
            "area",
            DISTANCE_TO_SUBWAY_KEY
    );

    public static Sort generateSort(String key, String directionKey) {
        key = getSortKey(key);

        Optional<Sort.Direction> directionExample = Sort.Direction.fromOptionalString(directionKey);

        Sort.Direction direction;
        if (!directionExample.isPresent()) {
            direction = Sort.Direction.DESC;
        } else {
            direction = directionExample.get();
        }

        return new Sort(direction, key);
    }

    public static String getSortKey(String key){
        if (!SORT_KEYS.contains(key)) {
            key = DEFAULT_SORT_KEY;
        }

        return key;
    }

}
