package com.example.project;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyHolder> {

    public ChatAdapter(List<Message> messageList) {
        message.addAll(messageList);
    }

    public interface ItemSelected{
        public void onItemClicked(int index);
    }
    List<Message> message;
    ItemSelected itemSelected;
    ArrayList<ChatTitle> chats;
    public ChatAdapter(Context context, ArrayList<ChatTitle> list) {
        itemSelected = (ItemSelected) context;
        chats = list;
    }
    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView dp;
        TextView name,text,time;
        LinearLayout firstHalf, secondHalf;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            dp = itemView.findViewById(R.id.displayPic);
            name = itemView.findViewById(R.id.chatName);
            text = itemView.findViewById(R.id.chatText);
            firstHalf = itemView.findViewById(R.id.nameHalf);
            secondHalf = itemView.findViewById(R.id.timeHalf);
            firstHalf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemSelected.onItemClicked(chats.indexOf((ChatTitle) itemView.getTag()));
                }
            });
            secondHalf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemSelected.onItemClicked(chats.indexOf((ChatTitle) itemView.getTag()));
                }
            });
            dp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemSelected.onItemClicked(chats.indexOf((ChatTitle) itemView.getTag()));
                }
            });
        }
    }
    @NonNull
    @Override
    public ChatAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_card,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.MyHolder holder, int position) {
        holder.itemView.setTag(chats.get(position));
        holder.name.setText(chats.get(position).getName());
        holder.text.setText(chats.get(position).getLastMessage());
        //holder.dp.setImageResource(chats.get(position).getDp());

    }

    @Override
    public int getItemCount() {
        return chats.size();
    }
}
