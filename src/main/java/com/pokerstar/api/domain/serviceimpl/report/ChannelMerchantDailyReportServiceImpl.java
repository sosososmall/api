package com.pokerstar.api.domain.serviceimpl.report;

import com.pokerstar.api.domain.dao.report.IChannelMerchantDailyReportDao;
import com.pokerstar.api.domain.entity.report.ChannelMerchantDailyReport;
import com.pokerstar.api.domain.service.report.IChannelMerchantDailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelMerchantDailyReportServiceImpl implements IChannelMerchantDailyReportService {
    @Autowired
    private IChannelMerchantDailyReportDao channelMerchantDailyReportDao;

    @Override
    public boolean addChannelMerchantDailyReport(ChannelMerchantDailyReport entity) {
        return channelMerchantDailyReportDao.addChannelMerchantDailyReport(entity);
    }

    @Override
    public int updateChannelMerchantDailyReport(ChannelMerchantDailyReport param) {
        return channelMerchantDailyReportDao.updateChannelMerchantDailyReport(param);
    }

    @Override
    public List<ChannelMerchantDailyReport> getAllChannelMerchantDailyReport() {
        return channelMerchantDailyReportDao.getAllChannelMerchantDailyReport();
    }
}
