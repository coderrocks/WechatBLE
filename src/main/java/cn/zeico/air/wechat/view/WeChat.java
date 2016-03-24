/**
 * Copyright 2016-2018, zeico inc. All right reserved.
 * Project: 	WechatBLE
 * Author:  	zhijiakeji
 * Create date:	2016-3-23
 */
package cn.zeico.air.wechat.view;

import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import cn.zeico.air.utils.CommonMethod;
import cn.zeico.air.utils.Constraint;

/**
 * @author zhijiakeji
 *
 */
@Path(value = "wx")
public class WeChat {
	public WeChat() {
		
	}
	
	@GET
	@Path(value = "/push")
	@Produces({ "application/json; charset=utf-8" })
	public String push(@QueryParam("signature") String signature, @QueryParam("timestamp") String timestamp,
			@QueryParam("nonce") String nonce, @QueryParam("echostr") String echostr) {
		if (signature != null && timestamp != null && nonce != null
				&& echostr != null) {
			if (verifyDeveloper(signature, timestamp, nonce, echostr)) {
				return echostr;
			} else {
				return "error";
			}
			
		}
		return "other";
	}
	
	// 验证微信服务器签名
	private boolean verifyDeveloper(String signature, String timestamp, String nonce, String echostr) {
		StringBuffer sb = new StringBuffer();
		String[] temArr = { Constraint.TOKEN, timestamp, nonce };
		Arrays.sort(temArr);
		for (int i = 0; i < temArr.length; i++) {
			sb.append(temArr[i]);
		}
		String sbs = sb.toString();
		String pwd = CommonMethod.encodeSHA1(sbs);
		if (pwd.equals(signature)) {
			if (!"".equals(echostr) && echostr != null) {
				return true;
			}
		}
		return false;
	}
}
