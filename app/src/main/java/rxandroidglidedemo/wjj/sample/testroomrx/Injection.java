/*
 * Copyright (C) 2017 The Android Open Source Project
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

package rxandroidglidedemo.wjj.sample.testroomrx;

import android.content.Context;

import rxandroidglidedemo.wjj.sample.testroomrx.persistence.LocalUserDataSource;
import rxandroidglidedemo.wjj.sample.testroomrx.persistence.UsersDatabase;
import rxandroidglidedemo.wjj.sample.testroomrx.ui.ViewModelFactory;


/**
 * Enables injection of data sources.
 */
public class Injection {

    public static UserDataSource provideUserDataSource(Context context) {
        UsersDatabase database = UsersDatabase.getInstance(context);
        return new LocalUserDataSource(database.userDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        UserDataSource dataSource = provideUserDataSource(context);
        return new ViewModelFactory(dataSource);
    }
}
