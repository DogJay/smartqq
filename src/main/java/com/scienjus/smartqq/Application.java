package com.scienjus.smartqq;

import com.scienjus.smartqq.callback.MessageCallback;
import com.scienjus.smartqq.client.SmartQQClient;
import com.scienjus.smartqq.model.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @author ScienJus
 * @date 2015/12/18.
 */
public class Application {

    public static void main(String[] args) {
        //创建一个新对象时需要扫描二维码登录，并且传一个处理接收到消息的回调，如果你不需要接收消息，可以传null
        SmartQQClient client = new SmartQQClient(new MessageCallback() {
            @Override
            public void onMessage(Message message) {
                System.out.println(message.getContent());
            }

            @Override
            public void onGroupMessage(GroupMessage message) {
                System.out.println(message.getContent());
            }

            @Override
            public void onDiscussMessage(DiscussMessage message) {
                System.out.println(message.getContent());
            }
        });
        //登录成功后便可以编写你自己的业务逻辑了
        Scanner scanner = new Scanner(System.in);
        while (true) {
            client.sendMessageToFriend(Long.parseLong("2657857937"), scanner.nextLine());
        }
//        client.sendMessageToFriend(Long.parseLong("2699094582"),"你好");

//        List<Group> groupList = client.getGroupList();
//        for (Group group : groupList) {
//            System.err.println(group.getId()+"\t\t"+group.getName());
//        }

//        for (int i = 0; i < 1000; i++) {
//            while (true) {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                client.sendMessageToGroup(Long.parseLong("2082950862"), "大家好，我是机器人");
//            }
//        }
//        List<Category> categories = client.getFriendListWithCategory();
//        for (Category category : categories) {
//            System.out.println(category.getName());
//            for (Friend friend : category.getFriends()) {
//                if (friend.getMarkname().equals("文化事业部总经理")) {
//                    System.out.println("————" + friend.getNickname() + "\tfirendID：" + friend.getUserId() + "\tfriendName:" + friend.getMarkname());
//                    client.sendMessageToFriend(Long.parseLong(friend.getUserId() + ""), "我是机器人");
//                }
//            }
//        }

        //使用后调用close方法关闭，你也可以使用try-with-resource创建该对象并自动关闭
//        try {
//            client.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
