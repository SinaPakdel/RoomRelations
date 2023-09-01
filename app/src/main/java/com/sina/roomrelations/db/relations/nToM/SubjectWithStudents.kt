package com.sina.roomrelations.db.relations.nToM

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.sina.roomrelations.db.entities.Student
import com.sina.roomrelations.db.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCressRef::class)
    )
    val students: List<Student>
)
