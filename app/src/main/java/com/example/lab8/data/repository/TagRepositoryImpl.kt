package com.example.lab8.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.lab8.data.db.CardDatabase
import com.example.lab8.data.db.Tag
import com.example.lab8.data.db.TagDao
import com.example.lab8.domain.repository.TagRepository

class TagRepositoryImpl private constructor(private val tagDao: TagDao) : TagRepository {
    override fun findAll(): LiveData<List<Tag>> =
        tagDao.getAll()

    override fun delete(tag: Tag) =
        tagDao.delete(tag)


    override fun findByTagName(tagName: String): Tag =
        tagDao.findByTagName(tagName)


    override suspend fun insert(tag: Tag) =
        tagDao.insert(tag)


    override suspend fun insert(tags: List<Tag>) {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): LiveData<Tag> {
        TODO("Not yet implemented")
    }

    override suspend fun update(tag: Tag): Int {
        TODO("Not yet implemented")
    }

    companion object {

        @Volatile
        private var instance: TagRepositoryImpl? = null
        fun getInstance(application: Application) =
            instance ?: synchronized(this) {
                instance ?: TagRepositoryImpl(
                    CardDatabase.getInstance(application).tagDao()
                )
                    .also {
                        instance = it
                    }
            }
    }

}