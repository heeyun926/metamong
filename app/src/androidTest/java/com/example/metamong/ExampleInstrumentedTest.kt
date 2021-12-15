package com.example.metamong

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException
import java.lang.Exception
import kotlin.jvm.Throws

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {


    private lateinit var memoDb : MemoDB
    private lateinit var memoDao : MemoDao

    @Before
    fun createDatabase(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        memoDao = Room.inMemoryDatabaseBuilder(context, memoDb::class.java)
            .allowMainThreadQueries()
            .build()
        memoDao = memoDb.memoDao()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.firstapp", appContext.packageName)
    }

    @Test
    @Throws(Exception::class)
    fun insertMemo(){
        val memo = Memo()
        memoDao.insert(memo)
        val memoAll = memoDao.getAll()
        assertEquals(memoAll," ")
    }
    @After
    @Throws(IOException::class)
    fun closeDatabase(){
        memoDb.close()
    }
}