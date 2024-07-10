package CreateDatabase

import java.io.File
import java.util.Scanner

public class UseFile{
    fun CreateDataTable(fileName: String, columns: List<String>) {
        try {
            val file = File(fileName)
            if (!file.exists()) {
                file.createNewFile()
            }

            file.writeText(columns.joinToString(",") + "\n")
            println("Created table $fileName with columns: ${columns.joinToString(", ")}")
        } catch (e: Exception) {
            println("Error creating table: ${e.message}")
        }
    }

    // Đọc dữ liệu từ file và trả về danh sách các mảng chuỗi (List<String[]>)
    fun readTableFromFile(fileName: String): List<Array<String>> {
        return try {
            val file = File(fileName)
            if (!file.exists()) {
                throw IllegalArgumentException("File $fileName does not exist.")
            }

            val lines = file.readLines()
            val tableData = mutableListOf<Array<String>>()

            for (line in lines) {
                val row = line.split(",").toTypedArray()
                tableData.add(row)
            }

            tableData
        } catch (e: Exception) {
            println("Error reading file: ${e.message}")
            emptyList() // Trả về danh sách rỗng nếu có lỗi
        }
    }

    // Ghi dữ liệu từ danh sách các mảng chuỗi (List<String[]>) vào file .txt
    fun writeTableToFile(fileName: String, tableData: List<Array<String>>) {
        try {
            File(fileName).printWriter().use { out ->
                tableData.forEach { row ->
                    val line = row.joinToString(",")
                    out.println(line)
                }
            }
            println("Data has been written to $fileName.")
        } catch (e: Exception) {
            println("Error writing file: ${e.message}")
        }
    }

    // Thêm dữ liệu (mảng chuỗi) vào file .txt
    fun addRowsToFile(fileName: String, newRows: MutableList<Array<String>>) {
        try {
            val file = File(fileName)
            if (!file.exists()) {
                println("File không tồn tại. Tạo file mới.")
                file.createNewFile()
            }

            // Thêm các hàng mới vào file
            newRows.forEach { row ->
                file.appendText(row.joinToString(",") + "\n")
            }

            println("Đã thêm các hàng vào $fileName.")
        } catch (e: Exception) {
            println("Lỗi thêm hàng vào file: ${e.message}")
        }
    }
    // Xóa một hàng dữ liệu từ file .txt dựa vào chỉ số hàng
    // Xóa các hàng dữ liệu từ file .txt dựa trên giá trị của cột tương ứng
    fun Deleterows(fileName: String, columnName: String, columnValue: String) {
        try {
            val tableData = readTableFromFile(fileName).toMutableList()

            // Tìm chỉ số của cột cần xóa dựa trên tên cột
            val columnIndex = tableData.firstOrNull()?.indexOf(columnName) ?: -1
            if (columnIndex == -1) {
                throw IllegalArgumentException("Column '$columnName' not found in the file.")
            }

            // Lặp qua danh sách và xóa các hàng có giá trị cột tương ứng là columnValue
            val iterator = tableData.iterator()
            while (iterator.hasNext()) {
                val row = iterator.next()
                if (row[columnIndex] == columnValue) {
                    iterator.remove()
                }
            }

            writeTableToFile(fileName, tableData)
            println("Rows with $columnName='$columnValue' deleted from $fileName.")
        } catch (e: Exception) {
            println("Error removing rows from file: ${e.message}")
        }
    }

}

