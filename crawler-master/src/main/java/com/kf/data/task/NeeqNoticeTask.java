package com.kf.data.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kf.data.fetcher.Fetcher;
import com.kf.data.mybatis.entity.NeeqCompanyNoticeCrawler;
import com.kf.data.service.crawler.NeeqCompanyNoticeCrawlerService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//@Component
//@EnableScheduling
public class NeeqNoticeTask {

	String url = "http://www.neeq.com.cn/disclosureInfoController/infoResult.do?";

	@Autowired
	NeeqCompanyNoticeCrawlerService neeqCompanyNoticeCrawlerService;

	Fetcher fetcher = Fetcher.getInstance();

	@Scheduled(fixedDelay = 60 * 60 * 1000)
	public void neeqNoticeEveryTask() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String startTime = formatter.format(getMyDate(date, -3));
		String endTime = formatter.format(date);
		Map<String, String> params = new HashMap<>();
		params.put("disclosureType", "5");
		params.put("isNewThree", "1");
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		int pageNum = 0;
		while (true) {
			try {
				System.out.println(pageNum);
				params.put("page", pageNum + "");
				Map<String, String> headers = new HashMap<>();
				String html = fetcher.post(url, params, headers, "utf-8");
				int totalPages = parserInfo(html);
				if (pageNum < totalPages) {
					pageNum++;
				} else {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}

	}

	public int parserInfo(String html) {
		String json = null;
		int beginIndex = html.indexOf("([");
		int endIndex = html.lastIndexOf("])");
		json = html.substring(beginIndex + 2, endIndex);
		JSONObject jsonObject = JSONObject.fromObject(json);
		JSONObject listInfo = jsonObject.getJSONObject("listInfo");
		JSONArray contentArray = listInfo.getJSONArray("content");
		for (int i = 0; i < contentArray.size(); i++) {
			// System.out.println(contentArray.get(i));
			JSONObject content = contentArray.getJSONObject(i);
			NeeqCompanyNoticeCrawler neeqCompanyNoticeCrawler = new NeeqCompanyNoticeCrawler();
			neeqCompanyNoticeCrawler.setCompanycd(content.getString("companyCd"));
			neeqCompanyNoticeCrawler.setCompanyname(content.getString("companyName"));
			neeqCompanyNoticeCrawler.setCreatetime(new Date());
			neeqCompanyNoticeCrawler.setDestfilepath("http://www.neeq.com.cn" + content.getString("destFilePath"));
			neeqCompanyNoticeCrawler.setDisclosurecode(content.getString("disclosureCode"));
			neeqCompanyNoticeCrawler.setDisclosuretitle(content.getString("disclosureTitle"));
			neeqCompanyNoticeCrawler.setDisclosuretype(content.getString("disclosureType"));
			neeqCompanyNoticeCrawler.setDisclosureyear(content.getString("disclosureYear"));
			// neeqCompanyNoticeCrawler.setEtltime(null);
			neeqCompanyNoticeCrawler.setFileext(content.getString("fileExt"));
			neeqCompanyNoticeCrawler.setIsemergency(content.getString("isEmergency"));
			neeqCompanyNoticeCrawler.setIsnewthree("1");
			// neeqCompanyNoticeCrawler.setPagenum(content.getString(""));
			neeqCompanyNoticeCrawler.setPublishdate(content.getString("publishDate"));
			neeqCompanyNoticeCrawler.setPublishorg(content.getString("publishOrg"));
			// neeqCompanyNoticeCrawler.setReportDate(content.getString(""));
			neeqCompanyNoticeCrawler.setState(content.getString("state"));
			neeqCompanyNoticeCrawler.setXxfcbj(content.getString("xxfcbj"));
			neeqCompanyNoticeCrawlerService.saveNeeqCompanyNoticeCrawler(neeqCompanyNoticeCrawler);
		}

		int totalPages = listInfo.getInt("totalPages");
		return totalPages;
	}

	public static Date getMyDate(Date date, int num) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.DATE, num);
		date = calendar.getTime();
		return date;
	}

}
