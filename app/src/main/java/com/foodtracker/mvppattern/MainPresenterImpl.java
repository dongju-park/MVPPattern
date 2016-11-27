package com.foodtracker.mvppattern;

import android.app.Activity;

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
    public void saveReview(String text) {
        if(view != null) {
            //networkCallbackListener 라는 인터페이스를 만들어서 네트워크의 결과가 필요한 메소드들은 이 interface를 갖는다.
            //네트워크의 결과로 해당 결과가 오면 그 다음 작업을 수행하게 한다.
            //결과적으로는 retrofit을 사용하는 모든 함수가 이런 형식을 띄지 않을까 생각한다...
            mainModel.saveReview(text, new networkCallbackListener() {
                @Override
                public void success() {
                    //비동기 처리시에 이 방법을 사용한다. 거의 대부분 이렇게 사용하게 될 듯 하다.
                    view.updateReview(mainModel.getData()); //리뷰가 작성이 되면 view에 리뷰가 작성이 됬으니 갱신하라는 함수를 호출
                    view.showToast("review is saved"); // 토스트 메세지 송출
                }

                @Override
                public void fail() {
                    //fail 시에 처리
                    view.showToast("review is not saved");
                }
            });
        }
    }

}
