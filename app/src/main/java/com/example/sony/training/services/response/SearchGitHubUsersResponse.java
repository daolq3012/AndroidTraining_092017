package com.example.sony.training.services.response;

import com.example.sony.training.model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by le.quang.dao on 10/03/2017.
 */

public class SearchGitHubUsersResponse {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;

    @SerializedName("items")
    @Expose
    private List<User> items = new ArrayList<>();

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<User> getItems() {
        return items;
    }

    public void setItems(List<User> items) {
        this.items = items;
    }
}
