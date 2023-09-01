package com.sina.roomrelations.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.sina.roomrelations.db.entities.Director
import com.sina.roomrelations.db.entities.School
import com.sina.roomrelations.db.entities.Student
import com.sina.roomrelations.db.entities.Subject
import com.sina.roomrelations.db.relations.nToM.StudentSubjectCressRef
import com.sina.roomrelations.db.relations.nToM.StudentWithSubject
import com.sina.roomrelations.db.relations.nToM.SubjectWithStudents
import com.sina.roomrelations.db.relations.oneToOne.SchoolAndDirector
import com.sina.roomrelations.db.relations.onToN.SchoolWithStudents

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(studentSubjectCressRef: StudentSubjectCressRef)


    @Transaction
    @Query("select * from school where schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("select * from school where schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("select * from subject where subjectName = :subjectName")
    suspend fun getStudentOfSubject(subjectName: String): List<SubjectWithStudents>


    @Transaction
    @Query("select * from student where schoolName = :studentName")
    suspend fun getSubjectOfStudent(studentName:Student): List<StudentWithSubject>
}
