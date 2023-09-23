package com.muehlemann.base.hilt

import android.content.Context
import com.muehlemann.base.utils.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PreferencesModule {

  @Provides
  fun providesPreferences(@ApplicationContext context: Context): Preferences {
    return Preferences(context)
  }
}