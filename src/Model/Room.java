package Model;
import java.sql.Time;
import java.util.Date;


public class Room {
    //define the variables
    String RoomNo;
    String Type;
    int Size;
    String Status;
    String Reason;
    Date FromDate;
    Date ToDate;
    String StartTime;
    String EndTime;

    //Add Main constructor
    public Room(){

    }


    public Room(String roomNo, String type, int size, String status, String reason, Date fromDate, Date toDate, String startTime, String endTime) {
        RoomNo = roomNo;
        Type = type;
        Size = size;
        Status = status;
        Reason = reason;
        FromDate = fromDate;
        ToDate = toDate;
        StartTime = startTime;
        EndTime = endTime;
    }

    public Room(String roomNo) {
        RoomNo = roomNo;
    }

    public Room(String roomNo, String type, int size, String status, String reason, String startTime, String endTime) {
        RoomNo = roomNo;
        Type = type;
        Size = size;
        Status = status;
        Reason = reason;
        StartTime = startTime;
        EndTime = endTime;
    }

    //set getters and setters
    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public Date getFromDate() {
        return FromDate;
    }

    public void setFromDate(Date fromDate) {
        FromDate = fromDate;
    }

    public Date getToDate() {
        return ToDate;
    }

    public void setToDate(Date toDate) {
        ToDate = toDate;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }
}
