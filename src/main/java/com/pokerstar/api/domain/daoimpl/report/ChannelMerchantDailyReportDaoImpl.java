package com.pokerstar.api.domain.daoimpl.report;

import com.pokerstar.api.domain.dao.report.IChannelMerchantDailyReportDao;
import com.pokerstar.api.domain.entity.report.ChannelMerchantDailyReport;
import com.pokerstar.api.domain.mapper.report.ChannelMerchantDailyReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelMerchantDailyReportDaoImpl implements IChannelMerchantDailyReportDao {
    @Autowired
    private ChannelMerchantDailyReportMapper channelMerchantDailyReportMapper;

    @Override
    public boolean addChannelMerchantDailyReport(ChannelMerchantDailyReport entity) {
        return channelMerchantDailyReportMapper.addChannelMerchantDailyReport(entity);
    }

    @Override
    public int updateChannelMerchantDailyReport(ChannelMerchantDailyReport param) {
        return channelMerchantDailyReportMapper.updateChannelMerchantDailyReport(param);
    }

    @Override
    public List<ChannelMerchantDailyReport> getAllChannelMerchantDailyReport() {
        return channelMerchantDailyReportMapper.getAllChannelMerchantDailyReport();
    }
}
