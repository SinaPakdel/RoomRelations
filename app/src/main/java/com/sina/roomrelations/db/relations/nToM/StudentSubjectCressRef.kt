package com.sina.roomrelations.db.relations.nToM

import androidx.room.Entity


@Entity(primaryKeys = ["studentName", "subjectName"])
data class StudentSubjectCressRef(
    val studentName: String,
    val subjectName: String
)
