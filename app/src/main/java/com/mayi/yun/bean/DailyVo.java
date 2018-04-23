package com.mayi.yun.bean;

import java.util.List;

/**
 * 作者： wh
 * 时间：  2018/3/13
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class DailyVo {

    /**
     * date : 20180313
     * stories : [{"images":["https://pic4.zhimg.com/v2-e76e8b04b710fc574d30c981f456f637.jpg"],"type":0,"id":9673548,"ga_prefix":"031309","title":"米饭被说成是「垃圾食品」，到底对不对？"},{"images":["https://pic3.zhimg.com/v2-6ce4d5584d98ab694cbb4beae90b305e.jpg"],"type":0,"id":9673305,"ga_prefix":"031308","title":"恋爱后，万一对另一个人心动怎么办？"},{"images":["https://pic2.zhimg.com/v2-ef1afbc5a8ff635f9f47c35f80c7e2d9.jpg"],"type":0,"id":9673541,"ga_prefix":"031307","title":"论如何正确地擦屁股"},{"images":["https://pic2.zhimg.com/v2-7c3efa0f85b09577a6ea1f9064894ed5.jpg"],"type":0,"id":9673615,"ga_prefix":"031307","title":"打电话，有哪些你没听出来的弦外之音？"},{"images":["https://pic4.zhimg.com/v2-c719251ed2e1173d29fa9827fa8f83d7.jpg"],"type":0,"id":9673440,"ga_prefix":"031307","title":"微信上聊天，标点符号可不是乱使的"},{"images":["https://pic2.zhimg.com/v2-7a2748b8b3fd3df3d71d87b9d24ef97d.jpg"],"type":0,"id":9673439,"ga_prefix":"031306","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic2.zhimg.com/v2-de7a93cdf9c8fe69faedb9b4875df1a5.jpg","type":0,"id":9673548,"ga_prefix":"031309","title":"米饭被说成是「垃圾食品」，到底对不对？"},{"image":"https://pic1.zhimg.com/v2-c4f848eab4ef7cc97a3f41963e1d75d8.jpg","type":0,"id":9673541,"ga_prefix":"031307","title":"论如何正确地擦屁股"},{"image":"https://pic2.zhimg.com/v2-9ddd8c6d51942bacdc7b41e22e4ead35.jpg","type":0,"id":9673440,"ga_prefix":"031307","title":"微信上聊天，标点符号可不是乱使的"},{"image":"https://pic4.zhimg.com/v2-95798bf2c20451378b719660797a7563.jpg","type":0,"id":9673305,"ga_prefix":"031308","title":"恋爱后，万一对另一个人心动怎么办？"},{"image":"https://pic3.zhimg.com/v2-380b09018cf4baec74056346c58473d2.jpg","type":0,"id":9672407,"ga_prefix":"031219","title":"被说「情商低」，你怎么那么抗拒？"}]
     */

    private String date;
    private List<StoriesVo> stories;
    private List<TopStoriesVo> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesVo> getStories() {
        return stories;
    }

    public void setStories(List<StoriesVo> stories) {
        this.stories = stories;
    }

    public List<TopStoriesVo> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesVo> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesVo {
        /**
         * images : ["https://pic4.zhimg.com/v2-e76e8b04b710fc574d30c981f456f637.jpg"]
         * type : 0
         * id : 9673548
         * ga_prefix : 031309
         * title : 米饭被说成是「垃圾食品」，到底对不对？
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesVo {
        /**
         * image : https://pic2.zhimg.com/v2-de7a93cdf9c8fe69faedb9b4875df1a5.jpg
         * type : 0
         * id : 9673548
         * ga_prefix : 031309
         * title : 米饭被说成是「垃圾食品」，到底对不对？
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
