package com.auth.model.dto;

import java.util.List;

/**
 * 删除项目的dto
 * Description
 * Author ayt  on
 */
public class DelProjectDTO {

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
