package com.winorout.zyzhang.gankdaily.mvprx.entity;

import java.util.List;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/9/12 下午10:34
 */
public class GankData {


    /**
     * category : ["休息视频","福利","前端","Android","拓展资源","iOS"]
     * error : false
     * results : {"Android":[{"_id":"59b667cf421aa9118887ac12","createdAt":"2017-09-11T18:39:11.631Z","desc":"用少量Rxjava代码，为retrofit添加退避重试功能","publishedAt":"2017-09-12T08:15:08.26Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/fca90d0da2b5","used":true,"who":"小鄧子"},{"_id":"59b673ef421aa9118887ac13","createdAt":"2017-09-11T19:30:55.50Z","desc":"Android 端基于 OpenCV 的边框识别功能","publishedAt":"2017-09-12T08:15:08.26Z","source":"web","type":"Android","url":"https://pqpo.me/2017/09/11/opencv-border-recognition/","used":true,"who":"Linmin Qiu"},{"_id":"59b69738421aa9118c8262ad","createdAt":"2017-09-11T22:01:28.352Z","desc":"用ContentProvider初始化你的库","images":["http://img.gank.io/3b0b193d-6abf-4714-9d5a-5508404666f4"],"publishedAt":"2017-09-12T08:15:08.26Z","source":"web","type":"Android","url":"http://zjutkz.net/2017/09/11/%E4%B8%80%E4%B8%AA%E5%B0%8F%E6%8A%80%E5%B7%A7%E2%80%94%E2%80%94%E4%BD%BF%E7%94%A8ContentProvider%E5%88%9D%E5%A7%8B%E5%8C%96%E4%BD%A0%E7%9A%84Library/","used":true,"who":null}],"iOS":[{"_id":"59b7234d421aa911847a038f","createdAt":"2017-09-12T07:59:09.854Z","desc":"一版很 Fancy 的滑动 Cell 遮盖效果。","images":["http://img.gank.io/3025334b-0bc8-4193-bf0d-b88a5e983bb6"],"publishedAt":"2017-09-12T08:15:08.26Z","source":"chrome","type":"iOS","url":"https://github.com/AppliKeySolutions/VegaScroll","used":true,"who":"代码家"},{"_id":"59b723ab421aa911878707da","createdAt":"2017-09-12T08:00:43.136Z","desc":"支持多媒体下，文本链接，@，#，url 以及字体色彩等功能。","images":["http://img.gank.io/76935d0e-b25d-484b-abb1-41b3dc7bd0ae"],"publishedAt":"2017-09-12T08:15:08.26Z","source":"chrome","type":"iOS","url":"https://github.com/pisces/OrangeLabel","used":true,"who":"S"}],"休息视频":[{"_id":"59b2ba20421aa9118887ac02","createdAt":"2017-09-08T23:41:20.423Z","desc":"【敖厂长】世界第一台随身听","publishedAt":"2017-09-12T08:15:08.26Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av14254599/","used":true,"who":"LHF"}],"前端":[{"_id":"59b66097421aa9118c8262a8","createdAt":"2017-09-11T18:08:23.591Z","desc":"前端每周清单第 30 期：WebVR 指南，Vue 代码分割范式，理想的 React 架构特性","publishedAt":"2017-09-12T08:15:08.26Z","source":"web","type":"前端","url":"https://zhuanlan.zhihu.com/p/29246843","used":true,"who":"王下邀月熊(Chevalier)"}],"拓展资源":[{"_id":"59b72186421aa911847a038d","createdAt":"2017-09-12T07:51:34.184Z","desc":"一款做的很漂亮的开源去中心化类似微博系统。","publishedAt":"2017-09-12T08:15:08.26Z","source":"chrome","type":"拓展资源","url":"https://joinmastodon.org/#how-it-works","used":true,"who":"代码家"},{"_id":"59b721bc421aa911878707d7","createdAt":"2017-09-12T07:52:28.25Z","desc":"还记得那个信任小游戏吗？他开源了！","images":["http://img.gank.io/0699bc09-4526-497a-801f-f70bc437d356"],"publishedAt":"2017-09-12T08:15:08.26Z","source":"chrome","type":"拓展资源","url":"https://github.com/ncase/trust","used":true,"who":"代码家"}],"福利":[{"_id":"59b5cfb5421aa9118887ac0b","createdAt":"2017-09-11T07:50:13.510Z","desc":"9-11","publishedAt":"2017-09-12T08:15:08.26Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fjfae1hjslj20u00tyq4x.jpg","used":true,"who":"代码家"}]}
     */

    private boolean error;
    private Gank results;
    private List<String> category;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Gank getResults() {
        return results;
    }

    public void setResults(Gank results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public static class Gank {
        private List<AndroidBean> Android;
        private List<IOSBean> iOS;
        private List<休息视频Bean> 休息视频;
        private List<前端Bean> 前端;
        private List<拓展资源Bean> 拓展资源;
        private List<福利Bean> 福利;

        public List<AndroidBean> getAndroid() {
            return Android;
        }

        public void setAndroid(List<AndroidBean> Android) {
            this.Android = Android;
        }

        public List<IOSBean> getIOS() {
            return iOS;
        }

        public void setIOS(List<IOSBean> iOS) {
            this.iOS = iOS;
        }

        public List<休息视频Bean> get休息视频() {
            return 休息视频;
        }

        public void set休息视频(List<休息视频Bean> 休息视频) {
            this.休息视频 = 休息视频;
        }

        public List<前端Bean> get前端() {
            return 前端;
        }

        public void set前端(List<前端Bean> 前端) {
            this.前端 = 前端;
        }

        public List<拓展资源Bean> get拓展资源() {
            return 拓展资源;
        }

        public void set拓展资源(List<拓展资源Bean> 拓展资源) {
            this.拓展资源 = 拓展资源;
        }

        public List<福利Bean> get福利() {
            return 福利;
        }

        public void set福利(List<福利Bean> 福利) {
            this.福利 = 福利;
        }

        public static class AndroidBean {
            /**
             * _id : 59b667cf421aa9118887ac12
             * createdAt : 2017-09-11T18:39:11.631Z
             * desc : 用少量Rxjava代码，为retrofit添加退避重试功能
             * publishedAt : 2017-09-12T08:15:08.26Z
             * source : web
             * type : Android
             * url : http://www.jianshu.com/p/fca90d0da2b5
             * used : true
             * who : 小鄧子
             * images : ["http://img.gank.io/3b0b193d-6abf-4714-9d5a-5508404666f4"]
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class IOSBean {
            /**
             * _id : 59b7234d421aa911847a038f
             * createdAt : 2017-09-12T07:59:09.854Z
             * desc : 一版很 Fancy 的滑动 Cell 遮盖效果。
             * images : ["http://img.gank.io/3025334b-0bc8-4193-bf0d-b88a5e983bb6"]
             * publishedAt : 2017-09-12T08:15:08.26Z
             * source : chrome
             * type : iOS
             * url : https://github.com/AppliKeySolutions/VegaScroll
             * used : true
             * who : 代码家
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class 休息视频Bean {
            /**
             * _id : 59b2ba20421aa9118887ac02
             * createdAt : 2017-09-08T23:41:20.423Z
             * desc : 【敖厂长】世界第一台随身听
             * publishedAt : 2017-09-12T08:15:08.26Z
             * source : chrome
             * type : 休息视频
             * url : http://www.bilibili.com/video/av14254599/
             * used : true
             * who : LHF
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class 前端Bean {
            /**
             * _id : 59b66097421aa9118c8262a8
             * createdAt : 2017-09-11T18:08:23.591Z
             * desc : 前端每周清单第 30 期：WebVR 指南，Vue 代码分割范式，理想的 React 架构特性
             * publishedAt : 2017-09-12T08:15:08.26Z
             * source : web
             * type : 前端
             * url : https://zhuanlan.zhihu.com/p/29246843
             * used : true
             * who : 王下邀月熊(Chevalier)
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class 拓展资源Bean {
            /**
             * _id : 59b72186421aa911847a038d
             * createdAt : 2017-09-12T07:51:34.184Z
             * desc : 一款做的很漂亮的开源去中心化类似微博系统。
             * publishedAt : 2017-09-12T08:15:08.26Z
             * source : chrome
             * type : 拓展资源
             * url : https://joinmastodon.org/#how-it-works
             * used : true
             * who : 代码家
             * images : ["http://img.gank.io/0699bc09-4526-497a-801f-f70bc437d356"]
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class 福利Bean {
            /**
             * _id : 59b5cfb5421aa9118887ac0b
             * createdAt : 2017-09-11T07:50:13.510Z
             * desc : 9-11
             * publishedAt : 2017-09-12T08:15:08.26Z
             * source : chrome
             * type : 福利
             * url : https://ws1.sinaimg.cn/large/610dc034ly1fjfae1hjslj20u00tyq4x.jpg
             * used : true
             * who : 代码家
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }
    }
}
