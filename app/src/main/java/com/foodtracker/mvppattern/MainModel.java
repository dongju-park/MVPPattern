package com.foodtracker.mvppattern;

import java.util.ArrayList;

/**
 * Created by parkdongju on 2016-11-26.
 */

public class MainModel {

    /*
    * 만약에 현재 개발할려는 기능이 리뷰기능이다라고 생각해보자
    * 여기 model에서는 text와 리뷰를 쓸 때 필요한 정보를 받아와서 서버와 통신을 한 후
    * 그 결과 성공적인지, 혹은 실패인지 presenter에게 전달을 해준다. 순수한 기능을 구현을 하면 된다.
    * 앱에서 중요한 것은 서버와의 통신이다
    * 여기 모델에서 데이터를 관리한다
    * 리뷰에 관련된 모델이라면... 리뷰데이터들을 관리하고 한다.
    * */

    //간단한 ReviewData
    ArrayList<String> reviewData = new ArrayList<>();

    //모델에서 애초에 이렇게 listener를 받아야 한다. 모델을 설계할때 주의 할점이다.
    //presenter에서 비동기 결과를 받아오기 위해선 이게 최선의 방책... final로 잡아준다.
    public void saveReview(String text, final MainPresenter.networkCallbackListener listener) {
        if(!text.equals("") && text.length() > 8){
            listener.success();
            addData(text);
        }
    }

    public ArrayList getData(){
        return reviewData;
    }

    public void addData(String text){
        reviewData.add(text);
    }
}
