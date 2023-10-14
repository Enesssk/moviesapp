package com.example.movieapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("filmler")
data class Filmler (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") @NotNull var id : Int,

    @ColumnInfo("name_film")  @NotNull var name : String,

    @ColumnInfo("resim")  @NotNull var resim : String,

    @ColumnInfo("fiyat")  @NotNull var fiyat : Int,

    @ColumnInfo("yil")  @NotNull var yıl : Int,

    @ColumnInfo("sure")  @NotNull var süre : String,

    @ColumnInfo("tur")  @NotNull var tür : String,

    @ColumnInfo("metin") @NotNull var metin : String) : java.io.Serializable

