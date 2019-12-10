package in.akshit.horizontalcalendar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

class HorizontalCalendarAdapter extends RecyclerView.Adapter<HorizontalCalendarAdapter.MyViewHolder> {
    private ArrayList<HorizontalCalendarModel> list;
    private Context mCtx;
    private HorizontalCalendarView.OnCalendarListener onCalendarListener;

    public void setOnCalendarListener(HorizontalCalendarView.OnCalendarListener onCalendarListener) {
        this.onCalendarListener = onCalendarListener;
    }

    public HorizontalCalendarAdapter(ArrayList<HorizontalCalendarModel> list, Context mCtx) {
        this.list = list;
        this.mCtx = mCtx;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date,month,day;
        LinearLayout parent;

        public MyViewHolder(View view) {
            super(view);
            date = view.findViewById(R.id.date);
            month = view.findViewById(R.id.month);
            parent = view.findViewById(R.id.parent);
            day = view.findViewById(R.id.day);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_calendar_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final HorizontalCalendarModel model = list.get(position);

        Display display = ((Activity)mCtx).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display. getSize(size);
        int width = size. x;

        holder.parent.setMinimumWidth(Math.round(width/7));

        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM EEE");
        final SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        holder.date.setText(sdf.format(model.getTimeinmilli()).split(" ")[0]);
        holder.month.setText(sdf.format(model.getTimeinmilli()).split(" ")[1]);
        holder.day.setText(sdf.format(model.getTimeinmilli()).split(" ")[2]);

        if(model.getStatus()==0){
            holder.date.setTextColor(mCtx.getColor(R.color.grey_600));
            holder.month.setTextColor(mCtx.getColor(R.color.grey_600));
            holder.day.setTextColor(mCtx.getColor(R.color.grey_600));
            holder.parent.setBackgroundColor(Color.TRANSPARENT);
        }else{
            holder.date.setTextColor(mCtx.getColor(R.color.textColorLight));
            holder.month.setTextColor(mCtx.getColor(R.color.textColorLight));
            holder.day.setTextColor(mCtx.getColor(R.color.textColorLight));
            holder.parent.setBackgroundResource(R.drawable.color_status_1);
        }

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCalendarListener.onDateSelected(sdf1.format(model.getTimeinmilli()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}