package com.practice.abc.lazyPop.strategy;

import com.practice.abc.lazyPop.annotation.ShardAwareId;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: EricChen
 * Date: 9/8/15
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class IdStrategy extends AbstractShardingStrategy {
    private final static int MOD = 100000;
    @Override
    public StrategyResult resolve(String logcailDbName, Object arg) {
        if (!arg.getClass().isPrimitive()) {
            for(Method m : arg.getClass().getMethods()) {
                if (m.getReturnType().equals(Void.TYPE)) {
                    continue;
                }
                ShardAwareId shardAwareId = m.getAnnotation(ShardAwareId.class);
                if (shardAwareId != null) {
                    try {
                        arg = m.invoke(arg);
                        break;
                    } catch (Exception e) {
                        throw new IllegalStateException();
                    }
                }
            }
        }

        if (arg instanceof Long) {
           return new StrategyResult((int)((Long) arg).longValue() % MOD, null);
        } else if (arg instanceof Integer) {
            return new StrategyResult( ((Integer) arg).intValue() % MOD, null);
        } else {
            throw new IllegalStateException();
        }
    }
}