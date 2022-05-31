package ru.mirea.kuzin.mireaproj.ui.Stories;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.kuzin.mireaproj.R;

public class StoriesFragment extends Fragment {

    RecyclerView rv;
    String strCatName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_stories, null);
        FloatingActionButton fab1 = v.findViewById(R.id.fab_action1);

        final EditText editText = v.findViewById(R.id.editText);

        rv = v.findViewById(R.id.rv);
        List<String> name = new ArrayList<>();
        name.add("Bob Stafford");
        name.add("Tailer Mosley");
        name.add("Sam Daniel");
        name.add("Jack Doyle");
        name.add("Odd Brooks");

        editText.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    strCatName = editText.getText().toString();
                    return true;
                }
                return false;
            }
        });
        ((FloatingActionButton)v.findViewById(R.id.fab_action1)).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                if(editText.getText().toString().length() != 0)
                {
                    name.add(strCatName);
                }
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                MyAdapter adapter = new MyAdapter(getActivity(),name);
                rv.setAdapter(adapter);
            }
        });



        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyAdapter adapter = new MyAdapter(getActivity(),name);
        rv.setAdapter(adapter);
        return v;
    }
}
