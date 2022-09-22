package com.example.githubrepos.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GitHubRepositoryEntity::class], version = 1)
abstract class GitHubRoomDatabase : RoomDatabase() {

    abstract fun gitHubDao(): GitHubDao

    companion object {
        @Volatile
        private var INSTANCE: GitHubRoomDatabase? = null

        fun getGitHubRoomDatabase(context: Context): GitHubRoomDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GitHubRoomDatabase::class.java,
                    "github_room_database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}