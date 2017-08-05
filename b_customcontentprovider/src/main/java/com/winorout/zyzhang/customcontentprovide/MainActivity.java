package com.winorout.zyzhang.customcontentprovide;

import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = "MainActivity";

    private EditText mTitleEt, mAuthorEt;
    private ContentResolver mContentResolver;
    private ListView mListView;
    private SimpleCursorAdapter mAdapter;

    private String[] mProjection = {
            BookContract.ITBook.ID,
            BookContract.ITBook.TITLE,
            BookContract.ITBook.AUTHOR};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mTitleEt = (EditText) findViewById(R.id.title_ed);
        mAuthorEt = (EditText) findViewById(R.id.book_ed);
        mListView = (ListView) findViewById(R.id.listview);
        Button insert = (Button) findViewById(R.id.insert);

        mContentResolver = getContentResolver();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doInsert();
            }
        });

        mAdapter = new SimpleCursorAdapter(
                getApplicationContext(),
                R.layout.simple_item,
                null,
                new String[]{BookContract.ITBook.TITLE, BookContract.ITBook.AUTHOR},
                new int[]{R.id.item_title, R.id.item_author},
                0);
        mListView.setAdapter(mAdapter);

        getLoaderManager().initLoader(0, null, this);
    }

    private void doInsert() {
        String title = mTitleEt.getText().toString();
        String author = mAuthorEt.getText().toString();
        ContentValues mNewValues = new ContentValues();
        mNewValues.put(BookContract.ITBook.TITLE, title);
        mNewValues.put(BookContract.ITBook.AUTHOR, author);
        Log.d(TAG, "title = " + title + " ,author = " + author);
        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(author)) {
            Uri mNewUri = mContentResolver.insert(BookContract.ITBook.CONTENT_URI, mNewValues);
            if (mNewUri != null) {
                String id = mNewUri.getPathSegments().get(1);
                long id1 = ContentUris.parseId(mNewUri);
                Log.d(TAG, "Insert , id = " + id + " ,id1 = " + String.valueOf(id1));
                mTitleEt.setText(null);
                mAuthorEt.setText(null);
            }
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cursorLoader = new CursorLoader(
                getApplicationContext(), BookContract.ITBook.CONTENT_URI,
                mProjection,
                null,
                null,
                BookContract.ITBook.DEFAULT_SORT
        );
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
}
