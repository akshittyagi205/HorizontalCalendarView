package in.akshit.horizontalcalendar;

public class HorizontalCalendarModel {
    long timeinmilli;
    int status=0; //0->no color, 1->green, 2-> yellow

    public HorizontalCalendarModel(long timeinmilli) {
        this.timeinmilli = timeinmilli;
    }

    public long getTimeinmilli() {
        return timeinmilli;
    }

    public void setTimeinmilli(long timeinmilli) {
        this.timeinmilli = timeinmilli;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
