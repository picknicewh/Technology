package com.mayi.yun.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * 作者： wh
 * 时间：  2018/3/10
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class AppActivityTaskManager {
    /**
     * 单例
     */
    public static AppActivityTaskManager instance;
    /**
     * 存储activityTask
     */
     private Stack<Activity> activityStack;

     public static AppActivityTaskManager getInstance(){
         if (instance==null){
             synchronized (AppActivityTaskManager.class){
                 if (instance==null){
                     instance = new AppActivityTaskManager();
                 }
             }
         }
         return instance;
     }
    /**
     * 把activity放入栈中
     */
    public void addActivity(Activity activity){
        if (activityStack==null){
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
        G.log("AppActivityTaskManager-->>addActivity"+activity.toString());
    }
    /**
     * 把activity从栈中移除
     */
    public void removeActivity(Activity activity){
        if (activity!=null){
            if (activity.isFinishing()){
                if (activityStack.contains(activity)){
                    activityStack.remove(activity);
                }
            }
        }
        G.log("AppActivityTaskManager-->>removeActivity"+ activity.toString());
    }
    /**
     * 获取当前Act对象
     *
     * @return Activity 当前Act
     */
    public Activity currentActivity() {
        Activity activity = null;
        if (!activityStack.empty()) {
            activity = activityStack.lastElement();
        }
        G.log("AppActivityTaskManager-->>currentActivity"+ activity);
        return activity;
    }

    /**
     * 栈中销毁并移除所有Act对象
     */
    public void removeAllActivity() {
        if (null != activityStack && activityStack.size() > 0) {
            //创建临时集合对象
            Stack<Activity> activityTemp = new Stack<>();
            for (Activity activity : activityStack) {
                if (null != activity) {
                    //添加到临时集合中
                    activityTemp.add(activity);
                    //结束Activity
                    activity.finish();
                }
            }
            activityStack.removeAll(activityTemp);
        }
        G.log("AppActivityTaskManager-->>removeAllActivity"+ "removeAllActivity");
        System.gc();
        System.exit(0);
    }
}
