package com.sina.roomrelations.db.relations.oneToOne

import androidx.room.Embedded
import androidx.room.Relation
import com.sina.roomrelations.db.entities.Director
import com.sina.roomrelations.db.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName", entityColumn = "schoolName"
    )
    val director: Director
)