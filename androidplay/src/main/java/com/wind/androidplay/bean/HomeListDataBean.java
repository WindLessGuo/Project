package com.wind.androidplay.bean;

import java.util.List;

/**
 * @author : guo
 * @package : com.wind.androidplay.bean
 * @descrip : 首页列表 http://www.wanandroid.com/article/list/0/json
 */
public class HomeListDataBean {


    /**
     * curPage : 2
     * datas : [{"apkLink":"","author":"Gracker_Gao","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2962,"link":"http://www.androidperformance.com/2018/05/20/zhihu-startingwindow.html","niceDate":"2018-05-30","origin":"","projectLink":"","publishTime":1527656671000,"superChapterId":168,"superChapterName":"基础知识","tags":[],"title":"知乎 救救你的 StartingWindow","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Tamic","chapterId":185,"chapterName":"组件化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2961,"link":"https://juejin.im/post/5ad2de7c5188255c620f855f","niceDate":"2018-05-30","origin":"","projectLink":"","publishTime":1527651401000,"superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"Android 基于注解IOC组件化/模块化的架构实践","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"DingMouRen","chapterId":314,"chapterName":"RV列表动效","collect":false,"courseId":13,"desc":"自定义LayoutManager，炫酷列表\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/fed9800b-3c6b-49b8-91bf-4ff48755425a.gif","fresh":false,"id":2959,"link":"http://www.wanandroid.com/blog/show/2143","niceDate":"2018-05-29","origin":"","projectLink":"https://github.com/DingMouRen/LayoutManagerGroup","publishTime":1527603664000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=314"}],"title":"炫酷列表 LayoutManagerGroup","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"寻梦-finddreams...","chapterId":364,"chapterName":"模块化","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2958,"link":"https://blog.csdn.net/finddreams/article/details/78339809","niceDate":"2018-05-29","origin":"","projectLink":"","publishTime":1527585723000,"superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"我所理解的Android模块化（一）&mdash;&mdash;模块化概念和路由","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"wangshub","chapterId":363,"chapterName":"创意汇","collect":false,"courseId":13,"desc":"Python 抖音机器人，论如何在抖音上找到漂亮小姐姐？\r\n","envelopePic":"http://www.wanandroid.com/blogimgs/2316d9df-158d-4afb-9e15-39ca36e428ff.png","fresh":false,"id":2957,"link":"http://www.wanandroid.com/blog/show/2142","niceDate":"2018-05-29","origin":"","projectLink":"https://github.com/wangshub/Douyin-Bot","publishTime":1527570400000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=363"}],"title":"Python 抖音机器人 Douyin-Bot","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"小编","chapterId":274,"chapterName":"个人博客","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2956,"link":"http://prototypez.github.io/","niceDate":"2018-05-29","origin":"","projectLink":"","publishTime":1527559418000,"superChapterId":272,"superChapterName":"导航主Tab","tags":[{"name":"导航","url":"/navi#274"}],"title":"prototypez","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"电点mxn","chapterId":249,"chapterName":"干货资源","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2955,"link":"https://www.jianshu.com/p/be12524418a4","niceDate":"2018-05-29","origin":"","projectLink":"","publishTime":1527558651000,"superChapterId":249,"superChapterName":"干货资源","tags":[],"title":"勇敢跨越，从0到1开发一个属于自己的App","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"albon","chapterId":362,"chapterName":"泛型","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2954,"link":"https://www.jianshu.com/p/ca12115bf92c","niceDate":"2018-05-28","origin":"","projectLink":"","publishTime":1527508459000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"深入理解 Java 泛型","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"中国大学MOOC","chapterId":361,"chapterName":"课程推荐","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2953,"link":"http://www.icourse163.org/learn/ZJU-93001?tid=1002654021#/learn/content","niceDate":"2018-05-28","origin":"","projectLink":"","publishTime":1527476390000,"superChapterId":249,"superChapterName":"干货资源","tags":[],"title":"浙江大学-数据结构课程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"MrTangFB ","chapterId":140,"chapterName":"dagger2","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2951,"link":"https://www.jianshu.com/p/b989e2cb88f6","niceDate":"2018-05-26","origin":"","projectLink":"","publishTime":1527306361000,"superChapterId":193,"superChapterName":"5.+高新技术","tags":[],"title":"Android Dagger2 从零单排(四) Dependencies与SubComponent","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"goldze","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"基于DataBinding框架，MVVM设计模式的一套快速开发库，整合Okhttp+RxJava+Retrofit+Glide等主流库，满足日常开发需求。使用该框架可以快速开发一个Android应用。\r\n","envelopePic":"http://www.wanandroid.comresources/image/pc/default_project_img.jpg","fresh":false,"id":2950,"link":"http://www.wanandroid.com/blog/show/2141","niceDate":"2018-05-26","origin":"","projectLink":"https://github.com/goldze/MVVMHabit","publishTime":1527299243000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"MVVM设计模式的一套快速开发库 MVVMHabit","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"zj565061763","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"一个控制控件单选、多选状态的库 ~","envelopePic":"http://www.wanandroid.com/blogimgs/0a915128-b38d-4452-b6cc-1554f9f26c97.gif","fresh":false,"id":2949,"link":"http://www.wanandroid.com/blog/show/2140","niceDate":"2018-05-26","origin":"","projectLink":"https://github.com/zj565061763/selectmanager","publishTime":1527298668000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"一个控制控件单选、多选状态的库  selectmanager","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"编走编想","chapterId":245,"chapterName":"集合相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2948,"link":"https://www.jianshu.com/p/b5bc4b7ff236","niceDate":"2018-05-26","origin":"","projectLink":"","publishTime":1527296472000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"Java 的泛型擦除和运行时泛型信息获取","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"邱明成","chapterId":346,"chapterName":"JVM","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2947,"link":"https://www.cnblogs.com/qiumingcheng/p/5398610.html","niceDate":"2018-05-25","origin":"","projectLink":"","publishTime":1527234120000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"Java程序编译和运行的过程","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"HIT-Alibaba","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2945,"link":"https://hit-alibaba.github.io/interview/basic/network/HTTP.html","niceDate":"2018-05-22","origin":"","projectLink":"","publishTime":1526988545000,"superChapterId":191,"superChapterName":"热门专题","tags":[],"title":"笔试面试知识整理","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"RaphetS","chapterId":67,"chapterName":"网络基础","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2944,"link":"https://www.jianshu.com/p/80e25cb1d81a","niceDate":"2018-05-22","origin":"","projectLink":"","publishTime":1526987358000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"关于HTTP协议，一篇就够了","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"张芳涛","chapterId":97,"chapterName":"音视频","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2943,"link":"https://www.jianshu.com/p/5baf47e7c4cb","niceDate":"2018-05-22","origin":"","projectLink":"","publishTime":1526986888000,"superChapterId":97,"superChapterName":"多媒体技术","tags":[],"title":"《FFmpeg Basics》中文版-目录","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋公众号","chapterId":121,"chapterName":"ViewPager","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2942,"link":"https://mp.weixin.qq.com/s/JlKtnVU_DqUwYAlQXXyniQ","niceDate":"2018-05-22","origin":"","projectLink":"","publishTime":1526950846000,"superChapterId":26,"superChapterName":"常用控件","tags":[],"title":"ViewPager 刷新无效?","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"网易杭州前端技术部","chapterId":270,"chapterName":"埋点","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2941,"link":"https://mp.weixin.qq.com/s/0dHKu5QIBL_4S7Tum-qW2Q","niceDate":"2018-05-21","origin":"","projectLink":"","publishTime":1526910498000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"网易HubbleData之Android无埋点实践","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"leowudev","chapterId":245,"chapterName":"集合相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2940,"link":"https://www.jianshu.com/p/e23e3fb2d326","niceDate":"2018-05-21","origin":"","projectLink":"","publishTime":1526901349000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"高手不得不知的Java集合List的细节","type":0,"userId":-1,"visible":1,"zan":0}]
     * offset : 20
     * over : false
     * pageCount : 67
     * size : 20
     * total : 1332
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * apkLink :
         * author : Gracker_Gao
         * chapterId : 198
         * chapterName : 基础概念
         * collect : false
         * courseId : 13
         * desc :
         * envelopePic :
         * fresh : false
         * id : 2962
         * link : http://www.androidperformance.com/2018/05/20/zhihu-startingwindow.html
         * niceDate : 2018-05-30
         * origin :
         * projectLink :
         * publishTime : 1527656671000
         * superChapterId : 168
         * superChapterName : 基础知识
         * tags : []
         * title : 知乎 救救你的 StartingWindow
         * type : 0
         * userId : -1
         * visible : 1
         * zan : 0
         */

        private String apkLink;
        private String author;
        private int chapterId;
        private String chapterName;
        private boolean collect;
        private int courseId;
        private String desc;
        private String envelopePic;
        private boolean fresh;
        private int id;
        private String link;
        private String niceDate;
        private String origin;
        private String projectLink;
        private long publishTime;
        private int superChapterId;
        private String superChapterName;// 一级分类的名称
        private String title;
        private int type;
        private int userId;
        private int visible;
        private int zan;
        private List<?> tags;

        private String headPic;

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public boolean isFresh() {
            return fresh;
        }

        public void setFresh(boolean fresh) {
            this.fresh = fresh;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getSuperChapterId() {
            return superChapterId;
        }

        public void setSuperChapterId(int superChapterId) {
            this.superChapterId = superChapterId;
        }

        public String getSuperChapterName() {
            return superChapterName;
        }

        public void setSuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }
    }
}

