package com.tamboot.cloud.microservice.mybatis;

import com.tamboot.cloud.microservice.core.CloudApiContextHolder;
import com.tamboot.mybatis.annotation.UpdateConfig;
import com.tamboot.mybatis.strategy.VersionLockUpdateStrategy;
import net.sf.jsqlparser.expression.Expression;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ModifyInfoUpdateStrategy extends VersionLockUpdateStrategy {
    @Override
    public Map<String, Expression> generateExtraUpdateColumns(UpdateConfig versionConfig) {
        Map<String, Expression> extraColumns = new HashMap<String, Expression>();
        extraColumns.put("modify_time", this.createTimestamp(new Date()));
        Long userId = CloudApiContextHolder.getUserId();
        if (userId != null) {
            extraColumns.put("modifier", this.createLongValue(userId));
        }
        return extraColumns;
    }
}
