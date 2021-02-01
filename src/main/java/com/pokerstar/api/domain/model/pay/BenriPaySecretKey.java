package com.pokerstar.api.domain.model.pay;

import lombok.Data;

import java.io.Serializable;

@Data
public class BenriPaySecretKey implements Serializable {
    private static final long serialVersionUID = -6234620939870504095L;

    private String plat_public_key;

    private String merchant_public_key;

    private String merchant_private_key;
}
