package com.example.fuelapp.Database;

import android.provider.BaseColumns;

public class DBMaster {

    public static class Register implements BaseColumns {
        public static final String TABLE_NAME = "user_table";
        public static final String COLUMN_USER_NAME = "user_name";
        public static final String COLUMN_PASSWORD = "user_password";

    }
}
