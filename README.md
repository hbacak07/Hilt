# Hilt

## implementation

1. build.gradle(app)
```java
plugins {
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'
}
```
```java
dependencies {
    implementation "com.google.dagger:hilt-android:$hilt_version"
    kapt "com.google.dagger:hilt-android-compiler:$hilt_version"
}
```

2. build.gradle()
```java
buildscript {
    ext.hilt_version = '2.40'
    dependencies {
        classpath "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
    }
}
```

3. Application class

```java
@HiltAndroidApp
class App : Application() {

}
```

4. AndroidEntryPoint class

```java
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var preferenceManager: PreferenceManager
    
}
```

5. Class

```java

class PreferenceManager /*@Inject constructor*/(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("name", Context.MODE_PRIVATE)

    fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, "")
    }

    fun putInteger(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun getInteger(key: String, defaultValue: Int = 0): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun putFloat(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    fun getFloat(key: String): Float {
        return sharedPreferences.getFloat(key, 0f)
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}
```


6. Module

```java
@Module
@InstallIn(SingletonComponent::class)
class LocalDatabaseModule {
    @Provides
    @Singleton
    fun providerPreferenceManager(@ApplicationContext context: Context) = PreferenceManager(context)
}
```



