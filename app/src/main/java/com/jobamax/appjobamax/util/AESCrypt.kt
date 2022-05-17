package com.jobamax.appjobamax.util

import android.util.Base64
import java.lang.Exception
import java.nio.charset.Charset
import java.security.Key
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

object AESCrypt {


    @Throws(Exception::class)
    fun encrypt(value: String): String {
        val key: Key = generateKey()
        val cipher: Cipher = Cipher.getInstance(getPasswordEncryptionTransformation())
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val encryptedByteValue: ByteArray = cipher.doFinal(value.toByteArray(charset("utf-8")))
        return Base64.encodeToString(encryptedByteValue, Base64.DEFAULT).trim()
    }

    @Throws(Exception::class)
    fun decrypt(value: String?): String {
        val key: Key = generateKey()
        val cipher: Cipher = Cipher.getInstance(getPasswordEncryptionTransformation())
        cipher.init(Cipher.DECRYPT_MODE, key)
        val decryptedValue64: ByteArray = Base64.decode(value, Base64.DEFAULT)
        val decryptedByteValue: ByteArray = cipher.doFinal(decryptedValue64)
        return String(decryptedByteValue, Charset.forName("utf-8") )
    }

    @Throws(Exception::class)
    private fun generateKey(): Key {
        return SecretKeySpec(getPasswordEncryptionKey().toByteArray(), ALGORITHM)
    }
}