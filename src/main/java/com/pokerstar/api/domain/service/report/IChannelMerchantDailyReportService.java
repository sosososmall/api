package com.pokerstar.api.domain.service.report;

import com.pokerstar.api.domain.entity.report.ChannelMerchantDailyReport;

import java.util.List;

public interface IChannelMerchantDailyReportService {
    boolean addChannelMerchantDailyReport(ChannelMerchantDailyReport entity);

    int updateChannelMerchantDailyReport(ChannelMerchantDailyReport param);

    List<ChannelMerchantDailyReport> getAllChannelMerchantDailyReport();
}
