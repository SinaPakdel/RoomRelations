package com.sina.roomrelations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.sina.roomrelations.db.SchoolDatabase
import com.sina.roomrelations.db.entities.Director
import com.sina.roomrelations.db.entities.School
import com.sina.roomrelations.db.entities.Student
import com.sina.roomrelations.db.entities.Subject
import com.sina.roomrelations.db.relations.nToM.StudentSubjectCressRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dao = SchoolDatabase.getInstance(this).dao()


        val directors = listOf(
            Director("Mask", "Java School"),
            Director("Jobs", "Microsoft School"),
            Director("Mode", "Kotlin School"),
        )

        val schools = listOf(
            School("Java School"),
            School("Microsoft School"),
            School("Kotlin School")
        )


        val subjects = listOf(
            Subject("Clean Code"),
            Subject("Gang of Four"),
            Subject("Clean Architecture"),
            Subject("Java Learning"),
            Subject("Kotlin Advanced"),
            Subject("Logcat newbies"),
        )

        val students = listOf(
            Student("Sina", 2, "Java School"),
            Student("Dina", 1, "Microsoft School"),
            Student("Shima", 5, "Kotlin School ")
        )


        val studentSubjectCressRef = listOf(
            StudentSubjectCressRef("Sina", "Clean Code"),
            StudentSubjectCressRef("Sina", "Gang of Four"),
            StudentSubjectCressRef("Sina", "Clean Architecture"),
            StudentSubjectCressRef("Dina", "Kotlin Advanced"),
            StudentSubjectCressRef("Shima", "Logcat newbies"),
            StudentSubjectCressRef("Shima", "Java Learning"),
        )


        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            students.forEach { dao.insertStudent(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            studentSubjectCressRef.forEach { dao.insertStudentSubjectCrossRef(it) }


            val schoolAndDirectorWithSchoolName =
                dao.getSchoolAndDirectorWithSchoolName("Kotlin School")



        }

    }
}