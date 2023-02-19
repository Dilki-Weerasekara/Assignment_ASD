package Model;
import java.util.Date;
import java.time.Clock;

public class Room {
    //define the variables
    String RoomNo;
    String Type;
    int Size;
    String Status;
    String Reason;
    java.util.Date FromDate;
    java.util.Date ToDate;
    Clock StartTime;
    Clock EndTime;

    //Main constructor
    public Room(String roomNo, String type, int size, String status, String reason, Date fromDate, Date toDate, Clock startTime, Clock endTime) {
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

    public Clock getStartTime() {
        return StartTime;
    }

    public void setStartTime(Clock startTime) {
        StartTime = startTime;
    }

    public Clock getEndTime() {
        return EndTime;
    }

    public void setEndTime(Clock endTime) {
        EndTime = endTime;
    }
}
