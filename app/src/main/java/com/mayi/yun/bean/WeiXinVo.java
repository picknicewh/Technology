package com.mayi.yun.bean;

import java.util.List;

/**
 * 作者： wh
 * 时间：  2018/3/12
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class WeiXinVo {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-03-12","title":"捷豹路虎2月在华售8798辆，捷豹同比增28%路虎小幅下滑",
     * "description":"汽车头条","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62836291.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5MDE1MTUxOA==&idx=2&mid=2649884993&sn=515b8430781e6f33677c2c4e7bf4cc00"},{"ctime":"2018-03-12","title":"18座热门城市房价地图（2月版）︱德科地产频道","description":"吴晓波频道","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62836289.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MzA3OTM5NTkxNA==&idx=3&mid=2652445246&sn=37c452b6f61941f5cb0792645083d0dc"},{"ctime":"2018-03-12","title":"开车不懂\u201c两秒距离\u201d？难怪高速公路事故70%是因为追尾！","description":"汽车之家","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62836342.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5MzA0NDM0MA==&idx=7&mid=2660680050&sn=5152c51075f3e2082361b6a84bbf28e4"},{"ctime":"2018-03-12","title":"快速晋升的8个准则，你做到了几条？ |CBNweekly","description":"第一财经周刊","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62241165.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5NDAzMjk2MA==&idx=1&mid=2653529761&sn=5156def47247c5437afa690d7731735e"},{"ctime":"2018-03-12","title":"唱学古诗词 | 芙蓉楼送辛浙","description":"常青藤爸爸","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62808458.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MzA3NzkxNDg2OA==&idx=2&mid=2651702354&sn=fa37ce0ae5404962ce3c2628b026669d"},{"ctime":"2018-03-12","title":"服气，路上最好开的车，在雪地里竟然也可以随心所欲","description":"车买买","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62829003.static/640","url":"https://mp.weixin.qq.com/s?__biz=MzA5NTU1MjEwNA==&idx=7&mid=2668672714&sn=8f2a91d10c31a9f5ffd621821bf0eeb2"},{"ctime":"2018-03-12","title":"林语堂：幸福无非四件事","description":"慈怀读书会","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62805608.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5NzMyODA2MQ==&idx=7&mid=2651720300&sn=5accd4434463bb6587c4ad62cc938fbd"},{"ctime":"2018-03-12","title":"关于2018楼市，两会上的这7句话值得关注","description":"腾讯财经","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62836159.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5OTA0Mzc2MA==&idx=2&mid=2651326163&sn=54860f41886414248b5e8413439fa977"},{"ctime":"2018-03-12","title":"为什么火箭要冲，勇士不冲？","description":"杨毅侃球","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62836152.jpg/640","url":"https://mp.weixin.qq.com/s?__biz=MjM5NTAzMjY2NQ==&idx=1&mid=2656114268&sn=1852f8cd18a99010bd6f82be1de2075b"},{"ctime":"2018-03-12","title":"动力不错的自动挡SUV，这3款10万就能落地","description":"车买买","picUrl":"https://zxpic.gtimg.com/infonew/0/wechat_pics_-62829003.static/640","url":"https://mp.weixin.qq.com/s?__biz=MzA5NTU1MjEwNA==&idx=8&mid=2668672714&sn=a3f64f17e49e032badcc544273e2599b"}]
     */

    private int code;
    private String msg;
    private List<NewsVo> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewsVo> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewsVo> newslist) {
        this.newslist = newslist;
    }

    public static class NewsVo {
        /**
         * ctime : 2018-03-12
         * title : 捷豹路虎2月在华售8798辆，捷豹同比增28%路虎小幅下滑
         * description : 汽车头条
         * picUrl : https://zxpic.gtimg.com/infonew/0/wechat_pics_-62836291.jpg/640
         * url : https://mp.weixin.qq.com/s?__biz=MjM5MDE1MTUxOA==&idx=2&mid=2649884993&sn=515b8430781e6f33677c2c4e7bf4cc00
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
