package com.sina.roomrelations.db.relations.nToM

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.sina.roomrelations.db.entities.Student
import com.sina.roomrelations.db.entities.Subject

data class StudentWithSubject(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCressRef::class)
    )
    val subjects: List<Subject>
)
