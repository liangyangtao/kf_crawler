package com.kf.data.service.crawler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf.data.mybatis.entity.NeeqCompanyNoticeCrawler;
import com.kf.data.mybatis.entity.NeeqCompanyNoticeCrawlerExample;
import com.kf.data.mybatis.mapper.NeeqCompanyNoticeCrawlerMapper;
import com.kf.data.service.crawler.NeeqCompanyNoticeCrawlerService;

@Service
public class NeeqCompanyNoticeCrawlerServiceImpl implements NeeqCompanyNoticeCrawlerService {

	@Autowired
	NeeqCompanyNoticeCrawlerMapper neeqCompanyNoticeCrawlerMapper;

	@Override
	public void saveNeeqCompanyNoticeCrawler(NeeqCompanyNoticeCrawler neeqCompanyNoticeCrawler) {
		NeeqCompanyNoticeCrawlerExample example = new NeeqCompanyNoticeCrawlerExample();
		example.or().andDestfilepathEqualTo(neeqCompanyNoticeCrawler.getDestfilepath());
		if (neeqCompanyNoticeCrawlerMapper.countByExample(example) > 0) {
		} else {
			neeqCompanyNoticeCrawlerMapper.insertSelective(neeqCompanyNoticeCrawler);
		}
	}

}
