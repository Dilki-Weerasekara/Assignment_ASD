package Model;
import java.sql.Time;
import java.util.Date;


public class Booking {

    //define variables
    int Booking_id;
    Date FromDate;
    Date ToDate;
    Time StartTime;
    Time EndTime;
    String Occasion;
    String Period;
    String Client;
    int ContactNo;
    String Notes;
    String RoomNo;

    //add Main Constructor

    public Booking(int booking_id, Date fromDate, Date toDate, Time startTime, Time endTime, String occasion, String period, String client, int contactNo, String notes, String roomNo) {
        Booking_id = booking_id;
        FromDate = fromDate;
        ToDate = toDate;
        StartTime = startTime;
        EndTime = endTime;
        Occasion = occasion;
        Period = period;
        Client = client;
        ContactNo = contactNo;
        Notes = notes;
        RoomNo = roomNo;
    }

    //add setters and getters

    public int getBooking_id() {
        return Booking_id;
    }

    public void setBooking_id(int booking_id) {
        Booking_id = booking_id;
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

    public String getOccasion() {
        return Occasion;
    }

    public void setOccasion(String occasion) {
        Occasion = occasion;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        Client = client;
    }

    public int getContactNo() {
        return ContactNo;
    }

    public void setContactNo(int contactNo) {
        ContactNo = contactNo;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }
}
