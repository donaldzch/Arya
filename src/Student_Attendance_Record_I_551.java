public class Student_Attendance_Record_I_551 {
    public boolean checkRecord(String s) {
        return !s.matches("(.*)LLL(.*)|(.*)A(.*)A(.*)");
    }

    public boolean checkRecord1(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }
}
