package test;
import java.io.*;
@SuppressWarnings("serial")
public class StudentBean implements Serializable
{
private String rollNo,name,course;
private int totMarks;
private float per;
private String result;
private MarksBean mk = new MarksBean();
public StudentBean() {}
public String getRollNo() {
return rollNo;
}
public void setRollNo(String rollNo) {
this.rollNo = rollNo;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getCourse() {
return course;
}
public void setCourse(String course) {
this.course = course;
}
public int getTotMarks() {
return totMarks;
}
public void setTotMarks(int totMarks) {
this.totMarks = totMarks;
}
public float getPer() {
return per;
}
public void setPer(float per) {
this.per = per;
}
public String getResult() {

return result;
}
public void setResult(String result) {
this.result = result;
}
public MarksBean getMk() {
return mk;
}
public void setMk(MarksBean mk) {
this.mk = mk;
}
}