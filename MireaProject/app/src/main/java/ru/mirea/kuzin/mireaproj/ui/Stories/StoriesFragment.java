package ru.mirea.kuzin.mireaproj.ui.Stories;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import ru.mirea.kuzin.mireaproj.databinding.FragmentStoriesBinding;


public class StoriesFragment extends Fragment {
    ArrayList<Story> stories = new ArrayList<>();
    private FragmentStoriesBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        setInitialStories();
        binding = FragmentStoriesBinding.inflate(inflater, container, false);
        MyAdapter adapter = new MyAdapter(getActivity(), stories);
        binding.recycler.setAdapter(adapter);

        binding.addStoryButton.setOnClickListener(this::onClickAddStory);
        return binding.getRoot();
    }

    private void setInitialStories(){
        stories.add(new Story("Случай в метро","История была вчера. Едем с другом в метро после универа, ну пивка само собой уже приняли. Народа полный вагон. Товарищ стоит сзади меня за спиной и задает вопрос: Кореш, а что такое ГИТХАБ?. Ну я не задумываясь отвечаю - Коньяк, сто пудов, а че такое? и оборачиваюсь. Смотрю весь народ в вагоне начинает ржать и выпадать в осадок. Потом я начал въезжать, что за мной стоит преподаватель мобильных разработок (фуражка, погоны, папочка кожаная и т д.). Вот про него он и спрашивал..Выходили из вагона под аплодисменты..."));
    }

    private void onClickAddStory(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final EditText storyTitle = new EditText(getContext());
        storyTitle.setSingleLine(true);
        alert.setTitle("Создание истории");
        alert.setMessage("Введите название истории");

        alert.setView(storyTitle);

        alert.setPositiveButton("Далее", (dialogInterface, i) -> {
            String titleValue = storyTitle.getText().toString();
            acceptStoryContent(titleValue);
        });

        alert.setNegativeButton("Отмена", (dialogInterface, i) -> {});

        alert.show();
    }

    private void acceptStoryContent(String storyTitle){
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        final EditText storyContent = new EditText(getContext());
        alert.setTitle("Создание истории");
        alert.setMessage("Введите содержание истории");
        alert.setView(storyContent);

        alert.setPositiveButton("Создать", (dialogInterface, i) -> {
            String storyValue = storyContent.getText().toString();
            stories.add(new Story(storyTitle, storyValue));
        });

        alert.setNegativeButton("Отмена", (dialogInterface, i) -> {});
        alert.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
