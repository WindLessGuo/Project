package com.wind.project.wind;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.http.POST;

public interface MainAPI {

    @POST("getFavouriteProduct?mallCode=100019&pageIndex=1&pageSize=10&linjia=1527129836661&sign=A1859AE032C0D9CFF5CC04AF4C36D577&v=v1.2.1&os=dml2byBYOQ%3D%3D%0A&userId=WEB170301000163")
    Observable<MainBean> obtainData();


}
