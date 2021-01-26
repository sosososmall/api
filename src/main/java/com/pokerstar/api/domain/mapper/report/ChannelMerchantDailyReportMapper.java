package com.pokerstar.api.domain.mapper.report;

import com.pokerstar.api.domain.entity.report.ChannelMerchantDailyReport;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("channelMerchantDailyReportMapper")
public interface ChannelMerchantDailyReportMapper {
    boolean addChannelMerchantDailyReport(ChannelMerchantDailyReport entity);

    int updateChannelMerchantDailyReport(ChannelMerchantDailyReport param);

    List<ChannelMerchantDailyReport> getAllChannelMerchantDailyReport();
}
