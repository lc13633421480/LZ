package com.sprout.bean

data class ChannelData(
    val `data`: List<Data>,
    val errmsg: String,
    val errno: Int
)

data class Data(
    val id: Int,
    val name: String,
    val sort: Int,
    val visible: Int
)