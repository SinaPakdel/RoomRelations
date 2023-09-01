package com.sina.roomrelations.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.sina.roomrelations.db.School
import com.sina.roomrelations.db.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val student: List<Student>
)
