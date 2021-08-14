package com.mvvmretrofitretromock.network

import co.infinum.retromock.BodyFactory
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream

internal class ResourceBodyFactory : BodyFactory {
    @Throws(IOException::class)
    override fun create(input: String): InputStream {
        // this will throw if input is empty string, regular class loader opens a stream to directory
        return FileInputStream(
            ResourceBodyFactory::class.java.classLoader!!.getResource(input).file
        )
    }
}