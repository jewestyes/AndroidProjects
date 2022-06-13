package ru.mirea.kuzin.mireaproj.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.kuzin.mireaproj.R;
import ru.mirea.kuzin.mireaproj.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    TextView tv;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv = (TextView) getView().findViewById(R.id.textviewTitle);
        Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.myalpha);
        registerForContextMenu(tv);
        tv.startAnimation(anim);

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}