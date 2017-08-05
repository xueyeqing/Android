package com.winorout.zyzhang.customcontentprovide;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @Description:
 * @Author: zyzhang
 * @Date: 17/8/3 下午11:44
 */
public class BookContract {

    // AUTHORITY： 标准的构成是应用的包名+自定义Provider名字
    public static final String AUTHORITY = "com.winorout.zyzhang.customcontentprovide.bookprovider";

    public static final class ITBook implements BaseColumns {
        public static final String ID = BaseColumns._ID;
        public static final String TITLE = "_title";
        public static final String AUTHOR = "_author";

        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/itbook");

        /**
         * 定义一下我们的mime类型 注意一下mime类型的写法
         * <p>
         * 一般都是后面vnd.应用程序的包名.表名
         */
        // 多行的mime类型
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.com.winorout.zyzhang.customcontentprovide.itbook";
        // 单行的mime类型
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.com.winorout.zyzhang.customcontentprovide.itbook";

        public static final String DEFAULT_SORT = TITLE + " asc";
    }
}
