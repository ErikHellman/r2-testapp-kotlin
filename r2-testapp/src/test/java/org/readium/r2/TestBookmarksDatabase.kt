///*
// * Module: r2-testapp-kotlin
// * Developers: Aferdita Muriqi, Mostapha Idoubihi, Paul Stoica
// *
// * Copyright (c) 2018. European Digital Reading Lab. All rights reserved.
// * Licensed to the Readium Foundation under one or more contributor license agreements.
// * Use of this source code is governed by a BSD-style license which is detailed in the
// * LICENSE file present in the project repository where this source code is maintained.
// */
//
//package org.readium.r2
//
//import android.content.Context
//import org.readium.r2.shared.Locator
//import org.readium.r2.testapp.Locator
//import org.readium.r2.testapp.BookmarksDatabase
//
///**
// * Unit tests for the BookmarksDatabase helpers with dummies Bookmarks
// */
//class TestBookmarksDatabase(val context: Context) {
//
//    val bmk_db = BookmarksDatabase(context)
//    val bmk_list = mutableListOf<Locator>()
//    val wrong_bmk_list = mutableListOf<Locator>()
//
//    init {
//        bmk_list.add(Locator(1, 1, "dummy",0.0))
//        bmk_list.add(Locator(2, 3, "dummy",0.5))
//        bmk_list.add(Locator(2, 3, "dummy",0.5))
//        bmk_list.add(Locator(15, 12, "dummy",0.9999))
//
//        wrong_bmk_list.add(Locator(4, 34, "dummy",1.3333))
//        wrong_bmk_list.add(Locator(-4, 34, "dummy",0.3333))
//        wrong_bmk_list.add(Locator(4, -34, "dummy",0.3333))
//    }
//
//    fun test(){
//        println("#####################################")
//        println("#########    Bookmarks    ###########")
//        var i = 0
//        bmk_list.forEach {
//            i++
//            println("Book $i : ")
//            println(" - bookId = ${it.bookID} (${it.bookID.javaClass})")
//            try {
//                val ret = bmk_db.bookmarks.insert(it)
//                if (ret != null) {
//                    println("Success : The Locator was added in the database ! result : $ret")
//                } else {
//                    println("Failed : The Locator couldn't be added, it exist already ! result : $ret")
//                }
//            } catch (e: Exception) {
//                println("Failed : Error while communicating with the database : ${e.message}")
//            }
//
//            try {
//                val ret = bmk_db.bookmarks.has(it)
//                if (ret.isNotEmpty()) {
//                    println("Success : The Locator was found in the database ! result : $ret")
//                } else {
//                    println("Failed : The Locator not found ! result : $ret")
//                }
//                //                bmk_db.bookmarks.delete(ret.first())
//                //                ret = db.bookmarks.has(it)
//                //                if (ret.isNotEmpty()) { println("Delete failed : $ret !") } else { println("Correctly deleted !") }
//            } catch (e: Exception) {
//                println("Failed : Error while communicating with the database : ${e.message}")
//            }
//        }
//        println("List of BookMarks  : ")
//        bmk_db.bookmarks.listAll().forEach { println(it) }
//        println("-------------------------------------")
//        println("--------  Wrong Bookmarks  ----------")
//        wrong_bmk_list.forEach {
//            i++
//            println("Book $i : ")
//            println(" - bookId = ${it.bookID} (${it.bookID.javaClass})")
//            try {
//                try {
//                    val ret = bmk_db.bookmarks.insert(it)
//                    if (ret != null) {
//                        println("Failed : The Locator shouldn't have been added ! result : $ret")
//                    } else {
//                        println("Success : The Locator wasn't added in the database ! result : $ret")
//                    }
//                } catch (e: Exception) {
//                    println("Failed : Error while communicating with the database : ${e.message}")
//                }
//                val ret = bmk_db.bookmarks.has(it)
//                if (ret.isNotEmpty()) {
//                    println("Failed : That Locator wasn't supposed to be founded ! result : $ret")
//                } else {
//                    println("Success : That Locator isn't in the db ! result : $ret")
//                }
//            } catch (e: Exception) {
//                println("Failed : Error while communicating with the database : ${e.message}")
//            }
//        }
//        try {
//            bmk_db.bookmarks.emptyTable()
//            println("Bookmarks cleared with success !")
//        } catch (e: Exception) {
//            println("Failed : Error while communicating with the database : ${e.message}")
//        }
//        println("###########    End     ##############")
//        println("#####################################")
//    }
//}