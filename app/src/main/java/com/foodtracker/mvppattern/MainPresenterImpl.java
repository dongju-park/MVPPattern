package com.foodtracker.mvppattern;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by parkdongju on 2016-11-26.
 */

public class MainPresenterImpl implements MainPresenter {

    private Activity activity;
    private MainPresenter.View view;
    private MainModel mainModel;

    public MainPresenterImpl(Activity activity) {
        this.activity = activity;
        this.mainModel = new MainModel();
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    /*
    * 아래의 메소드들은 음...
    * View가 Presenter를 부르면 처리하는 작업이다. View가 Presenter에게 야 처리해줘 빨랑 현기증난단 말야
    * 요청이 들어오면 mainModel에 야 View놈이 또 뭐 보냈다 요거 보고 처리하고 결과 알려줘
    * 이런식으로 model에게 요청을 보낸다. 그러면 model은 처리를 하고 결과를 알려준다 혹은 결과를 알려주지 않고 그냥 쭉 처리할 수도 있다.
    * model이 일을 마치면 View에게 야 이거이거 했으니까 화면 갱신하든가 사용자한테 바꼈다고 알려주던가
    * 처리를 하게 된다.
    * */

    @Override
    public void onConfirm() {
        if(view != null) {
            view.setConfirmText(mainModel.getClickText());
            view.showToast("button is clicked");
        }
    }

    @Override
    public void saveReview(String text) {
        if(view != null) {
            if(mainModel.saveReview(text)){
                view.updateReview(text);
                view.showToast("review is saved");
            }
            else {
                view.showToast("review is not in order");
            }
        }
    }

    @Override
    public void updateReview(ArrayList data) {
        mainModel.updateReview(data);
    }

}
