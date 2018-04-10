package com.wbinarytree.github.kotlinutils

import android.annotation.SuppressLint
import android.app.Application
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.util.Base64
import android.util.Log
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Get facebook hash-key. execute only once and remove it after get the key.
 * Get the hash-key via log with tag "hash key" or exceptions
 *
 */
@SuppressLint("PackageManagerGetSignatures")
fun Application.getHashKey(packageName: String) {
    val info: PackageInfo
    try {
        info = packageManager.getPackageInfo(packageName,
            PackageManager.GET_SIGNATURES)
        for (signature in info.signatures) {
            val md: MessageDigest = MessageDigest.getInstance("SHA")
            md.update(signature.toByteArray())
            val something = String(Base64.encode(md.digest(), 0))
            Log.e("hash key", something)
        }
    } catch (e1: PackageManager.NameNotFoundException) {
        Log.e("name not found", e1.toString())
    } catch (e: NoSuchAlgorithmException) {
        Log.e("no such an algorithm", e.toString())
    } catch (e: Exception) {
        Log.e("exception", e.toString())
    }
}
