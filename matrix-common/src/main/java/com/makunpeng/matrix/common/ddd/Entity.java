package com.makunpeng.matrix.common.ddd;

/**
 * 领域实体
 * @param <ID>
 * @author MaKunPeng
 */
public interface Entity<ID> {
    ID getId();
    EntityState getState();
    void setState(EntityState state);
}
