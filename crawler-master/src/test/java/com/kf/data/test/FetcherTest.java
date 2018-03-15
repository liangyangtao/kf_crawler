package com.kf.data.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kf.data.fetcher.Fetcher;
import com.kf.data.mybatis.entity.NeeqCompanyNoticeCrawler;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FetcherTest {

	public static void main(String[] args) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String startTime = "2018-01-01";
		String endTime = formatter.format(new Date());
		String url = "http://www.neeq.com.cn/disclosureInfoController/infoResult.do";
		Fetcher fetcher = Fetcher.getInstance();
		Map<String, String> params = new HashMap<>();
		params.put("disclosureType", "5");
		params.put("isNewThree", "1");
//		params.put("startTime", startTime);
//		params.put("endTime", endTime);
		params.put("page", "0");
		Map<String, String> headers = new HashMap<>();
		String html = fetcher.post(url, params, headers, "utf-8");
		String json = null;
		int beginIndex = html.indexOf("([");
		int endIndex = html.lastIndexOf("])");
		json = html.substring(beginIndex + 2, endIndex);
		JSONObject jsonObject = JSONObject.fromObject(json);
		JSONObject listInfo = jsonObject.getJSONObject("listInfo");
		JSONArray contentArray = listInfo.getJSONArray("content");
		for (int i = 0; i < contentArray.size(); i++) {
			System.out.println(contentArray.get(i));
			JSONObject  content = contentArray.getJSONObject(i);
			NeeqCompanyNoticeCrawler neeqCompanyNoticeCrawler = new NeeqCompanyNoticeCrawler();
			neeqCompanyNoticeCrawler.setCompanycd(content.getString("companyCd"));
			neeqCompanyNoticeCrawler.setCompanyname(content.getString("companyName"));
			neeqCompanyNoticeCrawler.setCreatetime(new Date());
			neeqCompanyNoticeCrawler.setDestfilepath("http://www.neeq.com.cn"+ content.getString("destFilePath"));
			neeqCompanyNoticeCrawler.setDisclosurecode(content.getString("disclosureCode"));
			neeqCompanyNoticeCrawler.setDisclosuretitle(content.getString("disclosureTitle"));
			neeqCompanyNoticeCrawler.setDisclosuretype(content.getString("disclosureType"));
			neeqCompanyNoticeCrawler.setDisclosureyear(content.getString("disclosureYear"));
//			neeqCompanyNoticeCrawler.setEtltime(null);
			neeqCompanyNoticeCrawler.setFileext(content.getString("fileExt"));
			neeqCompanyNoticeCrawler.setIsemergency(content.getString("isEmergency"));
			neeqCompanyNoticeCrawler.setIsnewthree(content.getString(""));
			neeqCompanyNoticeCrawler.setPagenum(content.getString(""));
			neeqCompanyNoticeCrawler.setPublishdate(content.getString("publishDate"));
			neeqCompanyNoticeCrawler.setPublishorg(content.getString("publishOrg"));
//			neeqCompanyNoticeCrawler.setReportDate(content.getString(""));
			neeqCompanyNoticeCrawler.setState(content.getString("state"));
			neeqCompanyNoticeCrawler.setXxfcbj(content.getString("xxfcbj"));
			
			
			
			
		}

	}
}
