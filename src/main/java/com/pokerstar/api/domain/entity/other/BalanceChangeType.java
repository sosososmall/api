package com.pokerstar.api.domain.entity.other;

import lombok.Data;

import java.io.Serializable;

@Data
public class BalanceChangeType implements Serializable {
    private static final long serialVersionUID = -3563899889257314800L;

    private int balance_change_type_id;

    private String balance_change_type_cn_name;

    private String balance_change_type_eg_name;

    private String balance_change_type_remark;
}
