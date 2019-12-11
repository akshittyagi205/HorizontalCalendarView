# Horizontal Calendar View

A simple library to display a horizontal calendar with custom start and end date, and mark events with a background

## Installation

Use Gradle to install the library, just add the following in app level build.gradle file

```bash
implementation 'com.github.akshittyagi205:HorizontalCalendarView:v1.0.0'
```

## Usage

See the sample app to check the implementation of the library

In MainActivity.java
```java
HorizontalCalendarView calendarView = findViewById(R.id.calendar);

Calendar starttime = Calendar.getInstance();
starttime.add(Calendar.MONTH,-6);

Calendar endtime = Calendar.getInstance();
endtime.add(Calendar.MONTH,6);

ArrayList datesToBeColored = new ArrayList();
datesToBeColored.add(Tools.getFormattedDateToday());

calendarView.setUpCalendar(starttime.getTimeInMillis(), 
                endtime.getTimeInMillis(), 
                datesToBeColored, 
                new HorizontalCalendarView.OnCalendarListener() {
            @Override
            public void onDateSelected(String date) {
                Toast.makeText(MainActivity.this,date+" clicked!",Toast.LENGTH_SHORT).show();
            }
        });

```
In activity_main.xml
```java
<in.akshit.horizontalcalendar.HorizontalCalendarView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/calendar"/>

```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
