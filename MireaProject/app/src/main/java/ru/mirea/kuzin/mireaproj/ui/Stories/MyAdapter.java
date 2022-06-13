package ru.mirea.kuzin.mireaproj.ui.Stories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mirea.kuzin.mireaproj.R;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Story> stories;

    MyAdapter(Context context, List<Story> stories) {
        this.stories = stories;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Story story = stories.get(position);
        holder.storyTitle.setText(story.getTitle());
        holder.storyContent.setText(story.getContent());
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView storyTitle, storyContent;
        ViewHolder(View view){
            super(view);
            storyTitle = view.findViewById(R.id.storyTitle);
            storyContent = view.findViewById(R.id.storyContent);
        }
    }
}