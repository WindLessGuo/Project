package com.wind.androidplay.net;

import com.wind.androidplay.base.BaseBean;
import com.wind.androidplay.bean.CommonlyUsedWebBean;
import com.wind.androidplay.bean.HomeBannerBean;
import com.wind.androidplay.bean.HomeListDataBean;
import com.wind.androidplay.bean.HotKeyBean;
import com.wind.androidplay.bean.NavigationBean;
import com.wind.androidplay.bean.ProClassifyBean;
import com.wind.androidplay.bean.ProListDataBean;
import com.wind.androidplay.bean.SystemAtricleBean;
import com.wind.androidplay.bean.SystemTreeBean;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.internal.operators.observable.ObservableTake;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author : guo
 * @package : com.wind.androidplay.net
 * @descrip :
 */
public interface Api {

    /**
     * 1.1 首页文章列表
     *
     * @param index 页数
     * @return
     */
    @GET("article/list/{pageNum}/json")
    Observable<BaseBean<List<HomeListDataBean>>> obtainHomeListData(@Path("pageNum") int index);


    /**
     * 1.2 首页banner
     */
    @GET("banner/json")
    Observable<BaseBean<List<HomeBannerBean>>> obtainHomeBannerData();


    /**
     * 1.3 常用网站
     *
     * @return
     */
    @GET("friend/json")
    Observable<CommonlyUsedWebBean> ontainCommonlyUsedWebData();


    /**
     * 1.4 搜索热词
     */
    @GET("hotkey/json")
    Observable<HotKeyBean> obtainHotKey();


    /**
     * 2.1体系数据
     */
    @GET("tree/json")
    Observable<SystemTreeBean> ontainTree();


    /**
     * 2.2知识体系下的文章
     */
    @GET("article/list/{num}/json")
    Observable<SystemAtricleBean> obtainArticle(
            @Path("num") int num, @Query("cid") int cid
    );


    /**
     * 3.1 导航数据
     *
     * @return
     */
    @GET("navi/json")
    Observable<NavigationBean> obtainNavigation();


    /**
     * 4.1 项目分类
     */
    @GET("project/tree/json")
    Observable<ProClassifyBean> obtainClassify();

    /**
     * 4.2 项目列表数据
     *
     * @param num 拼接在链接中，从1开始。
     * @param cid cid 分类的id，上面项目分类接口页码
     * @return
     */
    @GET("project/list/{num}/json")
    Observable<ProListDataBean> obtainProListBean(
            @Path("num") int num, @Query("cid") int cid
    );

    /**
     * 5.1 登录
     *
     * @return
     */
    @GET("user/login")
    Observable<Object> userLogin(
            @Query("username") String username,
            @Query("password") String password
    );


    /**
     * 5.2 注册
     *
     * @return
     */
    @GET("user/register")
    Observable<Object> userRegister(
            @Query("username") String username,
            @Query("password") String password,
            @Query("repassword") String repassword

    );


    /**
     * 6.1 收藏文章列表
     *
     * @param num 页码：拼接在链接中，从0开始。
     * @return
     */
    @GET("lg/collect/list/{num}/json")
    Observable<Object> collectionListData(@Path("num") int num);

    /**
     * 6.2 收藏站内文章
     *
     * @param id 文章id，拼接在链接中。
     * @return
     */
    @GET("lg/collect/{id}/json")
    Observable<Object> collectionArticle(@Path("id") long id);


    /**
     * 6.3 收藏站外文章
     *
     * @param title
     * @param author
     * @param link
     * @return
     */
    @GET("lg/collect/add/json")
    Observable<Object> outCollectionArticle(
            @Query("title") String title,
            @Query("author") String author,
            @Query("link") String link
    );

    /**
     * 6.4.1 在文章列表取消收藏
     *
     * @param id
     * @return
     */
    @GET("lg/uncollect_originId/{id}/json")
    Observable<Object> cancleCollOnArticleList(@Path("id") long id);


    /**
     * 6.4.2 我的收藏页面（该页面包含自己录入的内容）
     *
     * @param id
     * @param originId originId:列表页下发，无则为-1
     * @return
     */
    @GET("lg/uncollect/{id}/json")
    Observable<Object> cancleColl(
            @Path("id") int id,
            @Query("originId") long originId
    );


    /**
     * 6.5 收藏网站列表
     *
     * @return
     */
    @GET("lg/collect/usertools/json")
    Observable<Object> collectionWEBList();

    /**
     * 6.6 收藏网址
     *
     * @param webName
     * @param webLink
     * @return
     */
    @POST("lg/collect/addtool/json")
    Observable<Object> collectionWEB(
            @Query("name") String webName,
            @Query("link") String webLink

    );


    /**
     * 6.7 编辑收藏网站
     *
     * @param id
     * @param name
     * @param link
     * @return
     */
    @POST("lg/collect/updatetool/json")
    Observable<Object> updataWebLink(
            @Query("id") int id,
            @Query("name") String name,
            @Query("link") String link

    );


    /**
     * 6.8 删除收藏网站
     *
     * @param id
     * @return
     */
    @POST("lg/collect/deletetool/json")
    Observable<Object> deleteWebUrl(@Query("id") String id);


    /**
     * 7.1 搜索
     *
     * @param num 页码：拼接在链接上，从0开始。
     * @param k   k ： 搜索关键词
     * @return
     */
    @POST("article/query/{num}/json")
    Observable<Object> search(@Path("num") int num,
                              @Query("k") String k);


}
