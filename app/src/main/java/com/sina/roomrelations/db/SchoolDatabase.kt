package com.sina.roomrelations.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sina.roomrelations.db.dao.SchoolDao
import com.sina.roomrelations.db.entities.Director
import com.sina.roomrelations.db.entities.School
import com.sina.roomrelations.db.entities.Student
import com.sina.roomrelations.db.entities.Subject
import com.sina.roomrelations.db.relations.nToM.StudentSubjectCressRef

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCressRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {
    abstract fun dao(): SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}