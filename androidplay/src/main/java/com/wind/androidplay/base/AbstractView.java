package com.wind.androidplay.base;

import com.wind.baselibrary.base.AbstractContract;
import com.wind.baselibrary.base.BaseView;

/**
 * @author: GBX
 * @time: 10:32
 * @descrip:
 */
public interface AbstractView<T extends AbstractContract> extends BaseView{
  //  void setPresenter(T contract);

    void empty();
}
