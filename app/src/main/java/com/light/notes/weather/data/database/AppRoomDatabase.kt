package com.light.notes.weather.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.light.notes.weather.data.database.day.DayDao
import com.light.notes.weather.data.database.hours.HoursDao
import com.light.notes.weather.data.database.week.Dao
import com.light.notes.weather.ui.main.hours_adapter.HoursCellModel
import com.light.notes.weather.ui.main.model.DayCellModel
import com.light.notes.weather.ui.main.week_adapter.WeekCellModel

@Database(
    entities = [WeekCellModel::class, HoursCellModel::class, DayCellModel::class],
    version = 1
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getAppRoomDao(): Dao
    abstract fun getAppRoomHoursDao(): HoursDao
    abstract fun getAppRoomDayDao(): DayDao

    companion object {

        private var database: AppRoomDatabase? = null

        fun getInstance(context: Context): AppRoomDatabase {
            return if (database == null) {
                database =
                    Room.databaseBuilder(context, AppRoomDatabase::class.java, "databaseWeek")
                        .build()
                database as AppRoomDatabase
            } else {
                database as AppRoomDatabase
            }
        }
    }
}