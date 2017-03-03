/*
 * Copyright (C) 2009 Teleca Poland Sp. z o.o. <android@teleca.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.guosun.meichat;

import android.app.Application;
import android.content.SharedPreferences;

import com.utilcommonlib.log.ULog;


public class MCApplication extends Application {

    private final String PREFERENCES_NAME = "mei_chat_preferences";
    private static MCApplication instance;
    private final boolean isShowLog = true;//显示log 开关

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        ULog.init(isShowLog);
    }

    public static MCApplication getInstance() {
        return instance;
    }


    public String getSharedPreferences(String key) {
        try {
            SharedPreferences sp = this.getSharedPreferences(PREFERENCES_NAME, 0);
            return sp.getString(key, "");
        } catch (Exception e) {
             ULog.e(e.toString());
        }
        return "";
    }

    public void removeSharedPreferences(String key) {
        try {
            SharedPreferences sp = this.getSharedPreferences(PREFERENCES_NAME, 0);
            SharedPreferences.Editor editor = sp.edit();
            editor.remove(key);
            editor.commit();
        } catch (Exception e) {
            ULog.e(e.toString());
        }
    }

    public void setSharedPreferences(String key, String value) {
        try {
            SharedPreferences sp = this.getSharedPreferences(PREFERENCES_NAME, 0);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(key, value);
            editor.commit();
        } catch (Exception e) {
             ULog.e(e.toString());
        }
    }

}
