package com.pokerstar.api.domain.dao.report;

import com.pokerstar.api.domain.entity.report.ChannelMerchantDailyReport;

import java.util.List;

public interface IChannelMerchantDailyReportDao {
    boolean addChannelMerchantDailyReport(ChannelMerchantDailyReport entity);

    int updateChannelMerchantDailyReport(ChannelMerchantDailyReport param);

    List<ChannelMerchantDailyReport> getAllChannelMerchantDailyReport();
}
