package com.yichen.userhub.config;

import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 事务Helper
 * @author: tyrzhang
 * @date: 2022/7/19 1:23 AM
 * @description:
 */
@Component
public class TxHelper implements ApplicationContextAware {
    private final static Logger LOG = LoggerFactory.getLogger(TxHelper.class);
    private static TransactionTemplate transactionTemplate;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        transactionTemplate = applicationContext.getBean(TransactionTemplate.class);
    }

    public static TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public static <T> T execute(Supplier<T> supplier) {
        return transactionTemplate.execute(new TransactionCallback<T>() {
            @Override
            public T doInTransaction(TransactionStatus transactionStatus) {
                try {
                    return supplier.get();
                } catch (Exception e) {
                    LOG.error("execute sql fail."+e.getMessage(), e);
                    transactionStatus.setRollbackOnly();
                    throw e;
                }
            }
        });
    }
}