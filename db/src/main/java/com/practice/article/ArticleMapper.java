package com.practice.article;

import org.juric.sharding.annotation.LogicalDbName;
import org.juric.sharding.annotation.ShardMethod;
import org.juric.sharding.annotation.ShardParam;
import org.juric.sharding.strategy.IdStrategy;

import java.util.Date;
import java.util.List;

/**
 * Created by Eric on 9/27/2015.
 */
@LogicalDbName("test")
public interface ArticleMapper {
    @ShardMethod(IdStrategy.class)
    ArticleDB selectOne(@ShardParam("articleId") long articleId);

    @ShardMethod(IdStrategy.class)
    List<ArticleDB> selectBySite(@ShardParam("siteId") long siteId, Date lastDate, Long lastId, int pageSize);

    @ShardMethod(IdStrategy.class)
    int insert(@ShardParam("articleDB") ArticleDB articleDB);
}
