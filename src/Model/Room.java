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
    Time StartTime;
    Time EndTime;



    //Main constructor
    public Room(String roomNo, String type, int size, String status, String reason, Date fromDate, Date toDate, Time startTime, Time endTime) {
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

    public Time getStartTime() {
        return StartTime;
    }

    public void setStartTime(Time startTime) {
        StartTime = startTime;
    }

    public Time getEndTime() {
        return EndTime;
    }

    public void setEndTime(Time endTime) {
        EndTime = endTime;
    }
}
