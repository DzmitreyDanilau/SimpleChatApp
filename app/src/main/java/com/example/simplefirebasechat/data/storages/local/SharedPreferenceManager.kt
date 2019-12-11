package com.example.simplefirebasechat.data.storages.local

import android.content.SharedPreferences
import com.example.simplefirebasechat.data.storages.Storage
import javax.inject.Inject

class SharedPreferenceManager @Inject constructor(sharedPreferences: SharedPreferences) : Storage