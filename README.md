# MyBasePackageKT

#
#### BaseDao

You can use this `Base` if you using [Room](https://developer.android.com/training/data-storage/room?hl=id) as your local database.

- Make Base Class
```kotlin
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T) : Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertIgnore(obj: T) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(objs: List<T>): List<Long>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertIgnoreAll(objs: List<T>): List<Long>

    @Update
    fun update(obj: T)

    @Update
    fun updateAll(objs: List<T>): Int

    @Delete
    fun delete(obj: T)

    @Delete
    fun deleteAll(objs: List<T>): Int

}
```

- Entity Class
```kotlin
@Entity(tableName = "dummy")
data class DummyTable(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "field1")
    val field1: String? = null
)
```

- Use Base Class
```kotlin
@Dao
abstract class DummyDao: BaseDao<DummyTable> {

    @Query("SELECT * FROM dummy")
    abstract fun getAll(): List<DummyTable>

    @Query("DELETE FROM dummy")
    abstract fun truncateData()

    @Query("SELECT COUNT(id) FROM dummy")
    abstract fun getRowCount(): Int
}
```

#
#### BaseListResponse
You cal use this `Base` if you using [Retrofit](https://square.github.io/retrofit/) on your project as your `Http Client`.

- Make Base Class
```kotlin
data class BaseListResponse<T>(@SerializedName("status") @Expose val status: String,
                               @SerializedName("message") @Expose val message: String?,
                               @SerializedName("total") @Expose val total: Int?,
                               @SerializedName("data") @Expose val data: List<T>?)
```

- Make Model Class
```kotlin
data class DataItem(@SerializedName("id") @Expose val id: int ,
                    @SerializedName("name") @Expose val name: String)
```

- Use Base Class
```kotlin
interface ApiService {
    @GET("/users/{id}")
    fun getUserCall(@Body dataItem: DataItem): Call<BaseListResponse<DataItem>>
}
```

#
#### BaseObjectResponse
You can use this `Base` if you using [Retrofit](https://square.github.io/retrofit/) on your project as your `Http Client`.

- Make Base Class
```kotlin
data class BaseObjectResponse<T>(@SerializedName("status") @Expose val status: String,
                                 @SerializedName("message") @Expose val message: String?,
                                 @SerializedName("data") @Expose val data: T?)
```

- Make Model Class
```kotlin
data class DataItem(@SerializedName("id") @Expose val id: int ,
                    @SerializedName("name") @Expose val name: String)
```

- Use Base Class
```kotlin
interface ApiService {
    @GET("/users/{id}")
    fun getUserCall(@Body dataItem: DataItem): Call<BaseObjectResponse<DataItem>>
}
```

---

```
Copyright 2020 M. Fadli Zein
```