package com.winorout.zyzhang.mvpdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.winorout.zyzhang.mvpdemo.service.IBookContract;
import com.winorout.zyzhang.mvpdemo.service.entity.Book;
import com.winorout.zyzhang.mvpdemo.service.presenter.BookPresenter;

public class MainActivity extends Activity implements IBookContract.IView {

    private IBookContract.IPresenter iPresenter;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);

        iPresenter = new BookPresenter(this);

        iPresenter.getBookList("金瓶梅", null, 0, 1);
    }

    @Override
    public void onSuccess(Book mBook) {
        text.setText(mBook.toString());
    }
}
