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
    * */

    ArrayList<String> reviewData = new ArrayList<>();

    public String getClickText() {
        return "Clicked";
    }

    public ArrayList saveReview(String text) {
        if(!text.equals("") && text.length() > 8){
            reviewData.add(text);
            return reviewData;
        }
        else{
            return reviewData;
        }
    }

    public ArrayList updateReview(ArrayList data) {
        //갱신된 data를 보내준다.
        return data;
    }
}
