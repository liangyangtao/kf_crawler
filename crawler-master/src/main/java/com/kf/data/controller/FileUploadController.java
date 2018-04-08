package com.kf.data.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/chat")
public class FileUploadController extends CommonController {

	/**
	 * 提取上传方法为公共方法
	 * 
	 * @param uploadDir
	 *            上传文件目录
	 * @param file
	 *            上传对象
	 * @throws Exception
	 */
	private String executeUpload(String uploadDir, MultipartFile file) throws Exception {
		// 文件后缀名
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		// 上传文件名
		String filename = UUID.randomUUID() + suffix;
		// 服务器端保存的文件对象
		File serverFile = new File(uploadDir + filename);
		// 将上传的文件写入到服务器端文件内
		file.transferTo(serverFile);
		return serverFile.getAbsolutePath();
	}

	/**
	 * 上传文件方法
	 * 
	 * @param file
	 *            前台上传的文件对象
	 * @return
	 */
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public void fileUpload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file) {
		Map<String, Object> data = new HashMap<>();
		try {
			// 上传目录地址
			String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
			// 如果目录不存在，自动创建文件夹
			File dir = new File(uploadDir);
			if (!dir.exists()) {
				dir.mkdir();
			}
			// 调用上传方法
			if (file != null) {
				String massage = executeUpload(uploadDir, file);
				data.put("src", massage);
			}
		} catch (Exception e) {
			// 打印错误堆栈信息
			e.printStackTrace();
		}

		Map<String, Object> result = new HashMap<>();

		result.put("code", 0);
		result.put("msg", "");
		result.put("data", data);
		try {
			responseJson(response, result);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
