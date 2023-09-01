package com.sina.roomrelations.db.relations.onToN

import androidx.room.Embedded
import androidx.room.Relation
import com.sina.roomrelations.db.entities.School
import com.sina.roomrelations.db.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val student: List<Student>
)
