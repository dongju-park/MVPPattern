package com.foodtracker.mvppattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    private MainPresenter mainPresenter;

    private Button confirmButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenterImpl(this);
        mainPresenter.setView(this);

        confirmButton = (Button) findViewById(R.id.confirmBtn);
        editText = (EditText) findViewById(R.id.editText);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                 * mainPresenter에 구현된 saveReview라는 메소드를 부른다.
                 * 여기에선 음... View가 Presenter에게 야 사용자놈이 뭔가 변화를 원한다. model한테 알려줘서 작업 처리하고 결과 알려줘
                 * 이렇게 요청한다고 생각하면 될려나???
                * */
                mainPresenter.saveReview(editText.getText().toString());
            }
        });
    }


    /*
    * MainPresenter의 View interface에 선언된 메소드들을 구현한다.
    * presenter에서는 view.setConfirmText같이 이 메소드들을 호출하는데
    * 자 작업 끝났으니까 View야 변한거 있으니까 화면 새로 갱신해, 혹은 이게이게 바꼈으니까 사용자한테 알려줘
    * 이런작업들을 표현한다. 가장 많이 사용하는 showToast같은것? 즉 사용자 interaction의 결과 마지막엔 이 메소드들이 호출이 된다.
    * */
    @Override
    public void setConfirmText(String text) {
        confirmButton.setText(text);
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateReview(String text) {
        confirmButton.setText(text);
    }
}
