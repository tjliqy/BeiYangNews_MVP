package com.example.dell.beiyangnews_mvp.model;

import java.util.List;

/**
 * Created by dell on 2016/5/21.
 */
public class News {
    /**
     * error_code : -1
     * message :
     * data : [{"index":51885,"subject":"与网红对话 让梦想腾飞","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2016_05_19_15_03_13_cover_242.jpg","visitcount":56,"comments":0,"summary":"\u201c网络红人\u201d是指在现实或者网络生活中因为某个事件或者某个行为而被网民关注从而走红..."},{"index":51884,"subject":"烈日炎炎 素质拓展显真情","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2016_05_19_13_15_06_cover_242.jpg","visitcount":39,"comments":0,"summary":"5月18日下午2时，天津市高校辅导员网络培训班成员在素拓基地进行素质拓展。来自天津各..."},{"index":51883,"subject":"【北洋大讲堂】箜篌的前世辉煌与涅槃今生","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2016_05_19_01_15_23_cover_238.jpg","visitcount":75,"comments":0,"summary":"\u201c昆仑玉碎凤凰叫，芙蓉泣露香兰笑。十二门前融冷光，二十三丝动紫皇。\u201d箜篌，中国古..."},{"index":51873,"subject":"左耳青春 你我同行：饶雪漫做客北洋大讲堂","pic":"http://open.twtstudio.com/imgcache/c2c54c1db823ee750b91e4351e13f7e5.jpg","visitcount":267,"comments":0,"summary":"\u201c没有人永远十七岁，但永远有人十七岁。这部《左耳》献给我们曾如波涛般汹涌的青春和..."},{"index":51871,"subject":"【北洋大讲堂】李玉良院士：走前沿的科研之路","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2016_05_17_21_16_29_cover_233.jpg","visitcount":169,"comments":0,"summary":"5月16日15时30分，由天津大学青年文化促进会主办、李玉良主讲的北洋大讲堂之\u201c分子材料..."},{"index":51854,"subject":"玩味水果嘉年华：弗如特遇上北洋园","pic":"http://open.twtstudio.com/imgcache/b4aaeb3c56025daa094e63b3ee295289.jpg","visitcount":273,"comments":0,"summary":"5月15日下午3时，由水果工程委员会主办的水果文化节在北洋园校区太雷广场举行，活动吸..."},{"index":51853,"subject":"津门笔会：以笔为友 以字言情","pic":"http://open.twtstudio.com/imgcache/61a3c1d8e177d1b89a196afa2a1ee272.jpg","visitcount":66,"comments":0,"summary":"5月15日下午二时，由天津大学新竹书画社主办的第九届津门书会在图书馆一层隆重展开。本..."},{"index":51852,"subject":"十佳歌手大赛决赛：心怀梦想 唱响未来","pic":"http://open.twtstudio.com/imgcache/2fa726f6ab34afaf6df996a33d69c76e.jpg","visitcount":272,"comments":0,"summary":"5月15日晚5时，天津大学第十届校园十佳歌手大赛决赛于大通学生中心报告厅成功举行。本..."},{"index":51845,"subject":"方寸记流年 镜头映时光：第八届\u201c方寸流年\u201d摄影大赛颁奖典礼暨摄影交流沙龙","pic":"http://open.twtstudio.com/imgcache/064ea98f42779ff26f5c603b3d0c09dc.jpg","visitcount":57,"comments":1,"summary":"5月15日下午2时30分，由天津大学天外天新闻中心举办的第八届\u201c方寸流年\u201d摄影大赛颁奖典..."},{"index":51844,"subject":"指尖下的文明：第四届\u201c研途杯\u201d实践活动终评","pic":"http://open.twtstudio.com/imgcache/e700c6a804092739b0bbcf4dd758e359.jpg","visitcount":59,"comments":0,"summary":"5月15日下午3时，由天津大学学工部和天津大学社研会联合举办的第四届\u201c研途杯\u201d之\u201c指..."},{"index":51843,"subject":"【青椒学术沙龙】人工光合成：机遇与挑战","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2016_05_16_00_00_43_cover_262.jpg","visitcount":184,"comments":0,"summary":"当今社会，能源成为我们不得不提的话题。人类发展依仗碳循环来维持，但人类对于矿石燃..."},{"index":51842,"subject":"水果嘉年华：一场游戏与水果的邂逅","pic":"http://news.twt.edu.cn/public/news/wyynews/420_2016_05_15_20_51_37_cover_259.jpg","visitcount":164,"comments":0,"summary":"5月15日中午12时，阳光明媚，水果工程的工作人员们忙碌的身影出现在北洋广场上。布置好..."}]
     */

    private int error_code;
    private String message;
    /**
     * index : 51885
     * subject : 与网红对话 让梦想腾飞
     * pic : http://news.twt.edu.cn/public/news/wyynews/420_2016_05_19_15_03_13_cover_242.jpg
     * visitcount : 56
     * comments : 0
     * summary : “网络红人”是指在现实或者网络生活中因为某个事件或者某个行为而被网民关注从而走红...
     */

    private List<DataBean> data;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int index;
        private String subject;
        private String pic;
        private int visitcount;
        private int comments;
        private String summary;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getVisitcount() {
            return visitcount;
        }

        public void setVisitcount(int visitcount) {
            this.visitcount = visitcount;
        }

        public int getComments() {
            return comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
    }
}
