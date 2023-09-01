package com.sina.roomrelations.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.sina.roomrelations.db.Director
import com.sina.roomrelations.db.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName", entityColumn = "schoolName"
    )
    val director: Director
)