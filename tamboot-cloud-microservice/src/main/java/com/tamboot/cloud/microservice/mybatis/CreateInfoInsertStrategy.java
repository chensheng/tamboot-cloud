package com.tamboot.cloud.microservice.mybatis;

import com.tamboot.cloud.microservice.core.CloudApiContextHolder;
import com.tamboot.mybatis.annotation.InsertConfig;
import com.tamboot.mybatis.id.SnowFlakeIdGeneratorFactory;
import com.tamboot.mybatis.strategy.SnowFlakeIdInsertStrategy;
import net.sf.jsqlparser.expression.Expression;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreateInfoInsertStrategy extends SnowFlakeIdInsertStrategy {

    public CreateInfoInsertStrategy(SnowFlakeIdGeneratorFactory idGeneratorFactory) {
        super(idGeneratorFactory);
    }

    @Override
    public Map<String, Expression> generateExtraInsertColumns(InsertConfig insertConfig) {
        Map<String, Expression> extraColumns = new HashMap<String, Expression>();
        extraColumns.put("create_time", createTimestamp(new Date()));
        extraColumns.put("version", createLongValue(0l));

        Long userId = CloudApiContextHolder.getUserId();
        if (userId != null) {
            extraColumns.put("creator", createLongValue(userId));
        }

        return extraColumns;
    }

}
