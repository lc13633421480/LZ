package com.sprout.bean

data class TrendsListData(
    val `data`: List<Data>,
    val errmsg: String,
    val errno: Int
)
{
    data class Data(
        val address: String,
        val avater: Any,
        val channelid: Int,
        val date: String,
        val goods: Int,
        val id: Int,
        val lat: Int,
        val lng: Int,
        val mood: String,
        val nickname: String,
        val res: List<String>,
        val themeid: Int,
        val title: String,
        val type: Int,
        val uid: String,
        val url: String
    )
}
