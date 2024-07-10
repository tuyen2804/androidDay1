package CreateDatabase

class CreateData (){
    var useFile = UseFile()
    fun CreateAccount(){
        var columns:List<String> = listOf("MSSV", "password")
        useFile.CreateDataTable("Account", columns)

    }
    fun CreateStudent(){
        var columns:List<String> = listOf("MSSV", "Name", "Id_Class")
        useFile.CreateDataTable("Student", columns)
    }
    fun CreateScores(){
        var columns:List<String> = listOf("MSSV", "Id_Subject", "Scores")
        useFile.CreateDataTable("Scores", columns)
    }
    fun CreateClass(){
        var columns:List<String> = listOf("Id_Class", "Name")
        useFile.CreateDataTable("Class", columns)
    }
    fun CreateSubject(){
        var columns:List<String> = listOf("Id_Subject", "Name")
        useFile.CreateDataTable("Subject", columns)
    }
    fun AddData() {
        val accountData = mutableListOf(
            arrayOf("ACC001", "password1"),
            arrayOf("ACC002", "password2"),
            arrayOf("ACC003", "password3"),
            arrayOf("ACC004", "password4"),
            arrayOf("ACC005", "password5"),
            arrayOf("ACC006", "password6"),
            arrayOf("ACC007", "password7"),
            arrayOf("ACC008", "password8"),
            arrayOf("ACC009", "password9"),
            arrayOf("ACC010", "password10"),
            arrayOf("ACC011", "password11"),
            arrayOf("ACC012", "password12")
        )
        useFile.addRowsToFile("Account", accountData)

        val studentData = mutableListOf(
            arrayOf("STU001", "Alice", "CLS001"),
            arrayOf("STU002", "Bob", "CLS001"),
            arrayOf("STU003", "Charlie", "CLS002"),
            arrayOf("STU004", "David", "CLS002"),
            arrayOf("STU005", "Eva", "CLS003"),
            arrayOf("STU006", "Fiona", "CLS003"),
            arrayOf("STU007", "George", "CLS001"),
            arrayOf("STU008", "Hannah", "CLS002"),
            arrayOf("STU009", "Ivan", "CLS003"),
            arrayOf("STU010", "Jack", "CLS001"),
            arrayOf("STU011", "Karen", "CLS002"),
            arrayOf("STU012", "Liam", "CLS003")
        )
        useFile.addRowsToFile("Student", studentData)

        val scoresData = mutableListOf(
            arrayOf("STU001", "SUB001", "0.5"),
            arrayOf("STU002", "SUB001", "1"),
            arrayOf("STU003", "SUB001", "3"),
            arrayOf("STU004", "SUB002", "5"),
            arrayOf("STU005", "SUB002", "7"),
            arrayOf("STU006", "SUB002", "8"),
            arrayOf("STU007", "SUB001", "9.5"),
            arrayOf("STU008", "SUB001", "9"),
            arrayOf("STU009", "SUB002", "8.5"),
            arrayOf("STU010", "SUB002", "9.5"),
            arrayOf("STU011", "SUB001", "10"),
            arrayOf("STU012", "SUB002", "8"),
            arrayOf("STU001", "SUB003", "0.5"),
            arrayOf("STU002", "SUB003", "4"),
            arrayOf("STU003", "SUB003", "5"),
            arrayOf("STU004", "SUB003", "4.5"),
            arrayOf("STU005", "SUB003", "7"),
            arrayOf("STU006", "SUB003", "8.5"),
            arrayOf("STU007", "SUB003", "2"),
            arrayOf("STU008", "SUB003", "2.5"),
            arrayOf("STU009", "SUB003", "3"),
            arrayOf("STU010", "SUB003", "6"),
            arrayOf("STU011", "SUB003", "0.5"),
            arrayOf("STU012", "SUB003", "9"),
            arrayOf("STU001", "SUB004", "5.5"),
            arrayOf("STU002", "SUB004", "6.5"),
            arrayOf("STU003", "SUB004", "9.5"),
            arrayOf("STU004", "SUB004", "10"),
            arrayOf("STU005", "SUB004", "7"),
            arrayOf("STU006", "SUB004", "6"),
            arrayOf("STU007", "SUB004", "5"),
            arrayOf("STU008", "SUB004", "9"),
            arrayOf("STU009", "SUB004", "3"),
            arrayOf("STU010", "SUB004", "2"),
            arrayOf("STU011", "SUB004", "4"),
            arrayOf("STU012", "SUB004", "1")

        )
        useFile.addRowsToFile("Scores", scoresData)

        val classData = mutableListOf(
            arrayOf("CLS001", "Class A"),
            arrayOf("CLS002", "Class B"),
            arrayOf("CLS003", "Class C"),
            arrayOf("CLS004", "Class D"),
            arrayOf("CLS005", "Class E"),
            arrayOf("CLS006", "Class F"),
            arrayOf("CLS007", "Class G"),
            arrayOf("CLS008", "Class H"),
            arrayOf("CLS009", "Class I"),
            arrayOf("CLS010", "Class J"),
            arrayOf("CLS011", "Class K"),
            arrayOf("CLS012", "Class L")
        )
        useFile.addRowsToFile("Class", classData)

        val subjectData = mutableListOf(
            arrayOf("SUB001", "Mathematics"),
            arrayOf("SUB002", "Science"),
            arrayOf("SUB003", "History"),
            arrayOf("SUB004", "Geography"),
            arrayOf("SUB005", "Literature"),
            arrayOf("SUB006", "Physics"),
            arrayOf("SUB007", "Chemistry"),
            arrayOf("SUB008", "Biology"),
            arrayOf("SUB009", "Art"),
            arrayOf("SUB010", "Music"),
            arrayOf("SUB011", "Physical Education"),
            arrayOf("SUB012", "Computer Science")
        )
        useFile.addRowsToFile("Subject", subjectData)
    }
}