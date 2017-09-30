package com.scienjus.smartqq.listener;

import com.scienjus.smartqq.model.DiscussMessage;
import com.scienjus.smartqq.model.GroupMessage;
import com.scienjus.smartqq.model.Message;

/**
 * Smart QQ的监听器
 * 
 * @author ScienJus
 * @author <a href="mailto:xianguang.zhou@outlook.com">Xianguang Zhou</a>
 * @since 2015/12/18.
 */
public interface SmartqqListener {

	/**
	 * 收到私聊消息后的回调
	 * 
	 * @param message
	 *            好友消息
	 */
	void onMessage(Message message);

	/**
	 * 收到群消息后的回调
	 * 
	 * @param message
	 *            群消息
	 */
	void onGroupMessage(GroupMessage message);

	/**
	 * 收到讨论组消息后的回调
	 * 
	 * @param message
	 *            讨论组消息
	 */
	void onDiscussMessage(DiscussMessage message);

    void onException(Throwable exception, ExceptionThreadType exceptionThreadType);
}