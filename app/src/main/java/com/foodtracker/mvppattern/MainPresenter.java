package com.foodtracker.mvppattern;

import java.util.ArrayList;

/**
 * Created by parkdongju on 2016-11-26.
 */

public interface MainPresenter {

    void setView(MainPresenter.View view);

    /*
    view에게 사용자 입력을 받아 들이기 위함
    사용자와의 상호 작용 클릭, 드래그와 같은 이벤트가 일어났을때 아래의 메소드들을
    불러온다.
    일단 구현하면서 필요한 메소드들을 적는다.
    Review 기능을 생각하고 좀더 추가를 해보자면 DeleteReview, updateReview, reportReview, refreshReview
     그려면 음.. 큰 기능당 Presenter interface를 만들어서 재 사용이 가능할 것 같다. 반드시 구현해야 하는 메소드들이니
     다음에 기능을 추가하거나 확장할 때 사용, 수정을 하면 될것 같다.
    */
    void onConfirm();
    void saveReview(String text);
    void updateReview(ArrayList data);

    //View에게 알려주기 위한 interface 선언
    interface View {
        void setConfirmText(String text);
        void showToast(String text);
        void updateReview(ArrayList data);
    }
}
