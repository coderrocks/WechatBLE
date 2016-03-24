package cn.zeico.air.wechat;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import cn.zeico.air.wechat.view.WeChat;


/**
 * 主程序入口
 *
 */
public class App extends Application
{
	Set<Object> objectSet = new HashSet<Object>();
	
	public App() {
		objectSet.add(new WeChat());
	}
	
	@Override  
    public Set<Object> getSingletons() {
        return objectSet;  
    }
}
