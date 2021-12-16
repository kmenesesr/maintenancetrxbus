package com.mycompany.maintenancetrxbus.rest.utils;

import java.util.ArrayList;
import java.util.List;

public final class LocalPaginator<T> {

    public List<T> getSubList(List<T> list, Integer firstResult, Integer maxResults) {
        if (valid(list, firstResult, maxResults)) {
            Integer size = list.size();
            Integer fromIndex = (firstResult - 1) * maxResults;
            Integer toIndex = fromIndex + maxResults;

            if (fromIndex >= 0 && fromIndex < size) {
                return list.subList(fromIndex, toIndex > size ? size : toIndex);
            } else {
                return new ArrayList<>();
            }
        } else {
            return new ArrayList<>();
        }
    }

    private boolean valid(List<T> list, Integer firstResult, Integer maxResults) {
        return list != null && !list.isEmpty() && firstResult > 0 && maxResults > 0;
    }

}
