package com.winorout.zyzhang.customcontentprovide;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.HashMap;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/8/3 下午11:08
 */
public class BookProvider extends ContentProvider {

    private ContentResolver mContentResolver;
    private DBHelper mDBHelper;
    private SQLiteDatabase mDatabase;
    private static final UriMatcher mUriMatcher;
    private static HashMap<String, String> mProjectionMap;
    // 匹配成功的返回值 这里代表多行匹配成功
    private static final int ITBOOK_LIST = 0;
    // 匹配成功的返回值 这里代表多单行匹配成功
    private static final int ITBOOK_ITEM = 1;

    // 静态代码块执行
    static {
        // 先构造urimatcher
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        // #代表任意数字 *一般代表任意文本
        mUriMatcher.addURI(BookContract.AUTHORITY, "itbook", ITBOOK_LIST);
        mUriMatcher.addURI(BookContract.AUTHORITY, "itbook/#", ITBOOK_ITEM);

        mProjectionMap = new HashMap<String, String>();
        mProjectionMap.put(BookContract.ITBook.ID, BookContract.ITBook.ID);
        mProjectionMap.put(BookContract.ITBook.TITLE, BookContract.ITBook.TITLE);
        mProjectionMap.put(BookContract.ITBook.AUTHOR, BookContract.ITBook.AUTHOR);

    }

    public BookProvider() {
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        mContentResolver = context.getContentResolver();
        mDBHelper = new DBHelper(context, DB_NAME, null, 1);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        mDatabase = mDBHelper.getReadableDatabase();
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        switch (mUriMatcher.match(uri)) {
            case ITBOOK_ITEM:
                long id = ContentUris.parseId(uri);
                builder.setTables(DB_TABLE);
                builder.setProjectionMap(mProjectionMap);
                builder.appendWhere(BookContract.ITBook.ID + " = " + id);
                break;

            case ITBOOK_LIST:
                builder.setTables(DB_TABLE);
                builder.setProjectionMap(mProjectionMap);
                break;

            default:
                throw new UnsupportedOperationException("Not yet implemented");
        }
        Cursor cursor = builder.query(mDatabase, projection, selection, selectionArgs, null, null, BookContract.ITBook.DEFAULT_SORT);
        //data change ,notify uri
        cursor.setNotificationUri(mContentResolver, uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (mUriMatcher.match(uri)) {
            case ITBOOK_ITEM:
                return BookContract.ITBook.CONTENT_TYPE;

            case ITBOOK_LIST:
                return BookContract.ITBook.CONTENT_ITEM_TYPE;

            default:
                throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Log.e("zyzhang", contentValues + "");
        mDatabase = mDBHelper.getReadableDatabase();
        Uri mNewUri = null;
        long id = 0;
        switch (mUriMatcher.match(uri)) {
            case ITBOOK_ITEM:
                throw new IllegalArgumentException("Error Uri: " + uri);

            case ITBOOK_LIST:
                id = mDatabase.insert(DB_TABLE, null, contentValues);
                break;

            default:
                throw new UnsupportedOperationException("Not yet implemented");
        }

        //if successfully
        if (id > 0) {
            mNewUri = ContentUris.withAppendedId(uri, id);
        }
        //if error occurs
        else {
            throw new SQLiteException("Unable to insert");
        }
        //notify
        mContentResolver.notifyChange(uri, null);
        return mNewUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }


    private static String DB_NAME = "book.db";
    private static String DB_TABLE = "itbook";

    private static final String SQL_CREATE = "create table " +
            DB_TABLE +
            " ( " +
            BookContract.ITBook.ID + " integer primary key, " +
            BookContract.ITBook.TITLE + " text not null, " +
            BookContract.ITBook.AUTHOR + " text not null)";

    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(SQL_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("drop table if exists " + DB_TABLE);
            onCreate(sqLiteDatabase);
        }

    }

}
